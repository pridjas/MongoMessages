package com.example.mangomessages.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mangomessages.MongoDB.MongoStoreText;
import com.example.mangomessages.R;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.submitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputTextEditText = (EditText) findViewById(R.id.inputTextEditText);
                String userInput = inputTextEditText.getText().toString();
                MongoStoreText mongoStoreText = new MongoStoreText();
                boolean isInserted = mongoStoreText.storeTextToDB(userInput);

                if (isInserted == true) {
                    Toast.makeText(MainActivity.this,
                            "Insertion Successful",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Insertion Failture",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
