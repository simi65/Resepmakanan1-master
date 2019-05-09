package com.miss.resepmakanan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class DetailmakananActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaililmuan);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("putNama");
        String url  = intent.getStringExtra("putUrl");
        int gambar = intent.getIntExtra("putgambar",0);

        getSupportActionBar().setTitle("Bio "+ nama);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        WebView webView = findViewById(R.id.detailwebview);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        ImageView imageView = findViewById(R.id.gambar);
        imageView.setImageResource(gambar);



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
