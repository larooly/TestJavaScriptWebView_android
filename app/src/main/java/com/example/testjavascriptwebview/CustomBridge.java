package com.example.testjavascriptwebview;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomBridge {
    private WebView mWebView;
    private Context mcontext;
    private Handler mHandler;
    private TextView mtextView;


    public CustomBridge(Context context , WebView webView , TextView textView){
        this.mcontext = context;
        this.mWebView = webView;
        this.mtextView = textView;


        mHandler = new Handler();


    }
    @JavascriptInterface
    public void samplefunction(String va){

   //     Toast.makeText(mcontext, "web 에서 호출되었습니다. ", Toast.LENGTH_SHORT).show();

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                try{
                    Log.d("hello",va);
                    mtextView.setText("app get Value : "+va);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
