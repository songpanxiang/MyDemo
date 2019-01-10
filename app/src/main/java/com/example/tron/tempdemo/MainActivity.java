package com.example.tron.tempdemo;

import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.tron.tempdemo.view.MyRatingBar;

public class MainActivity extends AppCompatActivity {
    private MyRatingBar appRatingbar;
    private TextView tv;
    private RecyclerView rllist;

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
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });

    }
}
