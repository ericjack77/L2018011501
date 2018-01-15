package com.example.student.l2018011501;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.imageView);
        pb=findViewById(R.id.progressBar);
    }

    public void click1(View v)
    {
        pb.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        ImageRequest request =new ImageRequest("http://campingouzouni.com/wp-content/uploads/2015/05/beach-volley.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                            img.setImageBitmap(response);
                            pb.setVisibility(View.INVISIBLE);
                            img.setVisibility(View.VISIBLE);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();

    }

    public void click2(View v)
    {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new UTF8StringRequest("https://www.mobile01.com/rss/news.xml", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("net",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();
    }
}
