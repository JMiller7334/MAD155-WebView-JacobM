package com.example.mad155_webview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
// when setting up a webpage view make sure to add to the manifest file the permissions needed
// see manifest file -- User Permission.Internet needs to be added under package tag


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O) //needed for safe browsing
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webViewSetup()
    }
    @RequiresApi(Build.VERSION_CODES.O)// needed for safe browsing
    private fun webViewSetup(){
        var myWebView = findViewById<WebView>(R.id.wb_webView)
        myWebView.webViewClient = WebViewClient() //setup the client -- Default browser?
        myWebView.apply {
            loadUrl("https://www.mchenry.edu/") //set the site to load
            settings.javaScriptEnabled = true //enables JavasScript [optional]
            settings.safeBrowsingEnabled = true // also optional
        }
    }

    override fun onBackPressed() { //this function overrides the usage of the back button to go back on webpages.
        var myWebView = findViewById<WebView>(R.id.wb_webView)
        if (myWebView.canGoBack()){
            myWebView.goBack() //if the webview can go back it will
        } else {
            super.onBackPressed() //the defualt function of the button I assume
        }
    }
}