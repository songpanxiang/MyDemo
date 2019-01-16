package com.example.tron.tempdemo;

import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.tron.tempdemo.view.MyRatingBar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyRatingBar appRatingbar;
    private TextView tv;
    private RecyclerView rllist;
    private Button btGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appRatingbar = findViewById(R.id.app_ratingbar);
        appRatingbar.setClickable(false);

        rllist = findViewById(R.id.rllist);
        // appRatingbar.setStar(0);

        tv = findViewById(R.id.tv);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());

        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });

        btGet = findViewById(R.id.bt_get);
        btGet.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_get:
                getData("https://www.baidu.com");
                break;
        }
    }


    private void getData(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder jsonData = new StringBuilder();
//
                    URL mUrl = new URL(url);

                    BufferedReader reader = new BufferedReader(new InputStreamReader(mUrl.openStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        jsonData.append(line);
                    }
                    reader.close();

                    Log.i("xiangxiang", "获取的网络数据： " + jsonData.toString());


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
