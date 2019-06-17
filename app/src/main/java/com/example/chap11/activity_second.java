package com.example.chap11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_second extends AppCompatActivity {
    TextView textView2;
    EditText editText;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        button2 = findViewById(R.id.button2);

        // 메인액티비티에서 넘어온 intent 받기
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();

        //
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("name", editText.getText().toString());
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }
}
