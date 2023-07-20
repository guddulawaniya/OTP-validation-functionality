package com.example.otplayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText text1,text2,text3,text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         text1 = findViewById(R.id.text1);
         text2 = findViewById(R.id.text2);
         text3 = findViewById(R.id.text3);
         text4 = findViewById(R.id.text4);


         text4.clearFocus();


         text2.setOnKeyListener(new View.OnKeyListener() {
             @Override
             public boolean onKey(View view, int i, KeyEvent keyEvent) {


                 return false;
             }
         });
        movefunction(text1,text2);
        movefunction(text2,text3);
        movefunction(text3,text4);

        backspacekey(text2,text1);
        backspacekey(text3,text2);
        backspacekey(text4,text3);
    }

    void backspacekey(EditText currenttext,EditText lastText)
    {
        currenttext.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i == KeyEvent.KEYCODE_DEL) {
                    lastText.setText("");
                    lastText.requestFocus();
                }

                return false;
            }
        });


    }

    void movefunction(EditText text,EditText nexttext)
    {
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (text.getText().toString().length()==1)
                {
                    nexttext.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}