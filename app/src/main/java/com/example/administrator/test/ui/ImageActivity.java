package com.example.administrator.test.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.test.R;
import com.example.administrator.test.utils.Utils;

public class ImageActivity extends AppCompatActivity {

    private EditText imageUrl;
    private ImageView imageView;
    private Context context = ImageActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageUrl = (EditText) findViewById(R.id.et_imageurl);
        imageView = (ImageView) findViewById(R.id.imageview);


    }

    //Button点击事件
    public void findImage(View view) {
        String url = imageUrl.getText().toString().trim();
        netImage("http://img2.imgtn.bdimg.com/it/u=4199190811,2680819427&fm=21&gp=0.jpg");
    }

    //访问网络，进行图片搜索
    public void netImage(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        }, 300, 300, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                imageView.setImageResource(R.drawable.ic_launcher);
                Utils.MyToast(context, "访问地址图片出错");
            }
        });
        requestQueue.add(imageRequest);
    }
}
