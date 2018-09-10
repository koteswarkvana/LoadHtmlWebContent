package com.koti.apple.loadhtmlwebcontent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView loadHtmlContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadHtmlContent=(WebView)findViewById(R.id.webView);
        loadHtmlContent.setWebViewClient(new MyBrowser());
//        String htmlCode = "<p><img src=\"blob:http://localhost:4200/d66785e8-50e5-452b-a542-82d350b17759\" style=\"width: 300px;\" class=\"fr-fic fr-dib\">Second Test,&nbsp;</p>";

        // ================== Load html content by using the below code ====================
        /*String htmlCode = "<p><strong><em><span style=\"font-family: Impact, Charcoal, sans-serif; font-size: 30px; color: rgb(226, 80, 65);\">Today is Sat</span></em></strong></p><p><br></p><p><strong><span style=\"font-family: Impact, Charcoal, sans-serif; font-size: 12px; color: rgb(239, 239, 239);\">kghk jhkjhkjh</span></strong></p>";
        loadHtmlContent.getSettings().setLoadsImagesAutomatically(true);
        loadHtmlContent.getSettings().setJavaScriptEnabled(true);
        loadHtmlContent.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        loadHtmlContent.loadData(htmlCode, "text/html", "UTF-8");*/

        // ============ Scenario to load the .html file which is in assets folder ==================
        loadHtmlContent.getSettings().setLoadsImagesAutomatically(true);
        loadHtmlContent.getSettings().setJavaScriptEnabled(true);
        loadHtmlContent.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        loadHtmlContent.loadUrl("file:///android_asset/unorderlist.html");
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
