package com.example.testjavascriptwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    WebView MainWebView;
    CustomBridge customBridge;
    TextView MainLabel;

    Button MainButton;


    WebView secondWeb;
    Button secondBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainButton = findViewById(R.id.Mainbutton);
        MainWebView = findViewById(R.id.MainWebView);
        MainWebView.loadUrl("file:///android_asset/file/test.html");
        MainWebView.getSettings().setJavaScriptEnabled(true);

        MainLabel = findViewById(R.id.ShowMeText);

        customBridge = new CustomBridge(this , MainWebView,MainLabel);
        testWebViewEvent();

        MainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("But","일단 해봐");
               // MainWebView.loadUrl("javascript:testadding('앱에서 왔어')");//->이거 이러면 안되는데;
                MainWebView.evaluateJavascript("javascript:testadding('앱에서 왔어')", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        Log.d("??",value);
                        MainButton.setText(value);
                    }
                });
            }
        });

        // 에 여기서부터는 두번째꺼용
        secondWeb = findViewById(R.id.secondWebView);
        secondBut = findViewById(R.id.secondButton);
        secondWeb.loadUrl("file:///android_asset/seper/kokoko.html");
        secondWeb.getSettings().setJavaScriptEnabled(true);//내가 보기엔 이게 제일 중요

        secondBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondWeb.evaluateJavascript("javascript:getmeNow()", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        secondBut.setText(value);
                    }
                });
            }
        });


    }
    void testWebViewEvent(){
        //MainWebView.loadUrl("javascript:samplefunction()");
        //이거 아닌듯
        MainWebView.addJavascriptInterface(customBridge,"Mobile");
    }



}