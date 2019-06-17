package com.example.chap11;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        // 이벤트 처리
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 두 번째 액티비티 실행 -> intent
                // 명시적 인텐트
//                Intent intent = new Intent(MainActivity.this, activity_second.class);
                // 암시적 인텐트
                Intent intent = new Intent();
                intent.setAction("com.example.chap11.ACTION_VIEW");
                intent.setData(Uri.parse("https://m.naver.com"));
                intent.putExtra("message", "MainActivity에서 인텐트 보냄");
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == RESULT_OK){
            String name = data.getStringExtra("name");
            textView.setText(name);
        }
    }
}
