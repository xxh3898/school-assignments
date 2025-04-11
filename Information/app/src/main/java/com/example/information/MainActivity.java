package com.example.information;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_INFO = 1;
    TextView tVResult, tVResultLabel;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnReq = (Button) findViewById(R.id.btnRequest);
        Button btnEnd = (Button) findViewById(R.id.btnEnd);
        EditText editTextId = findViewById(R.id.editTextID);
        tVResultLabel = (TextView) findViewById(R.id.tVResultLabel);
        tVResult = (TextView) findViewById(R.id.tVRecsult);
        btnReq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String id = editTextId.getText().toString();
                Intent intent = new Intent(getApplicationContext(), InformationActivity.class);
                intent.putExtra("id", id);
                startActivityForResult(intent, REQUEST_INFO);
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( (requestCode == REQUEST_INFO) && (resultCode==RESULT_OK)) {
            tVResultLabel.setText("전송\n정보\n출력");
            String str = "아이디: " + data.getStringExtra("id");
            str = str + "\n이름: " + data.getStringExtra("name");
            str = str + "\n나이: " + data.getStringExtra("age");
            str = str + "\n성별: " + data.getStringExtra("gender");
            str = str + "\n자격증: " + data.getStringExtra("license");
            tVResult.setText(str);
        }
    }
}