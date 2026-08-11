package com.earlyedu.kids.ui.components

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.FrameLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

/**
 * Sandboxed In-App Video Player.
 * Strictly prevents opening external apps (YouTube, Chrome, Browser) or popups.
 */
@SuppressLint("SetJavaScriptEnabled")
@Composable
ComposableSafeVideoPlayer(
    youtubeVideoId: String,
    modifier: Modifier = Modifier
) {
    var isLoading by remember { mutableStateOf(true) }
    var hasError by remember { mutableStateOf(false) }

    val htmlContent = remember(youtubeVideoId) {
        """
        <!DOCTYPE html>
        <html>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
            <style>
                * { margin: 0; padding: 0; box-sizing: border-box; }
                body, html { width: 100%; height: 100%; background-color: #000000; overflow: hidden; }
                .video-container { position: relative; width: 100%; height: 100%; }
                iframe { width: 100%; height: 100%; border: none; }
            </style>
        </head>
        <body>
            <div class="video-container">
                <iframe 
                    id="player"
                    src="https://www.youtube-nocookie.com/embed/$youtubeVideoId?enablejsapi=1&autoplay=1&rel=0&modestbranding=1&controls=1&playsinline=1&fs=1" 
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
                    allowfullscreen>
                </iframe>
            </div>
        </body>
        </html>
        """.trimIndent()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )

                    settings.apply {
                        javaScriptEnabled = true
                        domStorageEnabled = true
                        mediaPlaybackRequiresUserGesture = false
                        allowFileAccess = false
                        allowContentAccess = false
                        setSupportMultipleWindows(false) // Block popup windows
                        javaScriptCanOpenWindowsAutomatically = false
                        builtInZoomControls = false
                        displayZoomControls = false
                        useWideViewPort = true
                        loadWithOverviewMode = true
                    }

                    // STRICT WEBVIEW CLIENT: Intercept and BLOCK all external navigations
                    webViewClient = object : WebViewClient() {
                        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                            super.onPageStarted(view, url, favicon)
                            isLoading = true
                            hasError = false
                        }

                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)
                            isLoading = false
                        }

                        override fun onReceivedError(
                            view: WebView?,
                            errorCode: Int,
                            description: String?,
                            failingUrl: String?
                        ) {
                            super.onReceivedError(view, errorCode, description, failingUrl)
                            isLoading = false
                            hasError = true
                        }

                        // Prevent launching YouTube App or External Browser Intent
                        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                            val url = request?.url?.toString() ?: return false
                            return handleUrlIntercept(url)
                        }

                        @Deprecated("For older APIs")
                        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                            if (url == null) return false
                            return handleUrlIntercept(url)
                        }

                        private fun handleUrlIntercept(url: String): Boolean {
                            // Only allow internal data loading or YouTube embed iframe
                            if (url.startsWith("data:") || 
                                url.startsWith("https://www.youtube-nocookie.com/embed/") || 
                                url.contains("youtube-nocookie.com")
                            ) {
                                return false // Allow loading inside this WebView
                            }

                            // BLOCK ALL EXTERNAL LINKS (youtube.com, play store, web links, intent://)
                            // Do NOT open Chrome or YouTube App!
                            return true // Suppress link click completely
                        }
                    }

                    // STRICT WEBCHROME CLIENT: Disable new windows/popups
                    webChromeClient = object : WebChromeClient() {
                        override fun onCreateWindow(
                            view: WebView?,
                            isDialog: Boolean,
                            isUserGesture: Boolean,
                            resultMsg: android.os.Message?
                        ): Boolean {
                            // Block any window creation attempt
                            return false
                        }
                    }

                    // Load sandboxed html iframe content directly
                    loadDataWithBaseURL(
                        "https://www.youtube-nocookie.com",
                        htmlContent,
                        "text/html",
                        "UTF-8",
                        null
                    )
                }
            },
            update = { webView ->
                webView.loadDataWithBaseURL(
                    "https://www.youtube-nocookie.com",
                    htmlContent,
                    "text/html",
                    "UTF-8",
                    null
                )
            },
            modifier = Modifier.fillMaxSize()
        )

        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }

        if (hasError) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Unable to load video. Check internet connection.",
                    color = Color.White
                )
            }
        }
    }
}
