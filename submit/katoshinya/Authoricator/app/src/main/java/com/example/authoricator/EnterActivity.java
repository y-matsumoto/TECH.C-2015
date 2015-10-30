package com.example.authoricator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.utility.PasswordUtil;

public class EnterActivity extends AppCompatActivity {

    private EditText mEditT1 = null;
    private EditText mEditT2 = null;
    private EditText mEditT3 = null;
    private EditText mEditT4 = null;
    private TextView mTextV = null;
    private TextView mTextVEr = null;
    private PasswordUtil pu = new PasswordUtil();
    private Intent intent = null;

    Button bt = null;
    String mPass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mEditT1 = (EditText) findViewById(R.id.enpasscode1);
        mEditT2 = (EditText) findViewById(R.id.enpasscode2);
        mEditT3 = (EditText) findViewById(R.id.enpasscode3);
        mEditT4 = (EditText) findViewById(R.id.enpasscode4);
        mTextVEr = (TextView) findViewById(R.id.enerrormessage);
        intent = new Intent(EnterActivity.this, MainContentActivity.class);
        mPass = pu.getLoginPassword(getApplicationContext());


        bt = (Button)findViewById(R.id.enterbutton);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    int mCode1 = 0;
                    int mCode2 = 0;
                    int mCode3 = 0;
                    int mCode4 = 0;

                    mCode1 = Integer.parseInt(mEditT1.getText().toString());
                    mCode2 = Integer.parseInt(mEditT2.getText().toString());
                    mCode3 = Integer.parseInt(mEditT3.getText().toString());
                    mCode4 = Integer.parseInt(mEditT4.getText().toString());

                    String mCodeStr = "" + mCode1 + mCode2 + mCode3 + mCode4;

                    if (mCodeStr.equals(mPass)) {
                        startActivity(intent);
                    } else {
                        mTextVEr.setText("パスコードが違います");
                    }

                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                }


            }
        });
    }

}
