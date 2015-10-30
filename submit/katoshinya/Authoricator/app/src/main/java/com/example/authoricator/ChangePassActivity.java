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

public class ChangePassActivity extends AppCompatActivity  {

    //変数の定義と初期化
    private EditText mEditTOld1 = null;
    private EditText mEditTOld2 = null;
    private EditText mEditTOld3 = null;
    private EditText mEditTOld4 = null;
    private EditText mEditTNew1 = null;
    private EditText mEditTNew2 = null;
    private EditText mEditTNew3 = null;
    private EditText mEditTNew4 = null;
    private TextView mTextVEr = null;
    private Button bt = null;
    private PasswordUtil pu = new PasswordUtil();
    private String mPass = null;
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
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

        mPass = pu.getLoginPassword(getApplicationContext());

        if(mPass.equals("") || mPass.isEmpty()){
            bt.setEnabled(false);
        }
        //インスタンスの取得
        mEditTOld1 = (EditText) findViewById(R.id.oldpasscode1);
        mEditTOld2 = (EditText) findViewById(R.id.oldpasscode2);
        mEditTOld3 = (EditText) findViewById(R.id.oldpasscode3);
        mEditTOld4 = (EditText) findViewById(R.id.oldpasscode4);
        mEditTNew1 = (EditText) findViewById(R.id.newpasscode1);
        mEditTNew2 = (EditText) findViewById(R.id.newpasscode2);
        mEditTNew3 = (EditText) findViewById(R.id.newpasscode3);
        mEditTNew4 = (EditText) findViewById(R.id.newpasscode4);

        mTextVEr = (TextView) findViewById(R.id.cherrormessage);

        bt = (Button)findViewById(R.id.changebutton);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               String oldCodes =  "" + mEditTOld1.getText().toString() + mEditTOld2.getText().toString() + mEditTOld3.getText().toString() + mEditTOld4.getText().toString();
                String newCodes =  "" + mEditTNew1.getText().toString() + mEditTNew2.getText().toString() + mEditTNew3.getText().toString() + mEditTNew4.getText().toString();
                if(oldCodes.equals(mPass)){

                    int mCode1 = Integer.parseInt(mEditTNew1.getText().toString());
                    int mCode2 = Integer.parseInt(mEditTNew2.getText().toString());
                    int mCode3 = Integer.parseInt(mEditTNew3.getText().toString());
                    int mCode4 = Integer.parseInt(mEditTNew4.getText().toString());

                    if(pu.passCodeCheck(mCode1, mCode2, mCode3, mCode4)){

                        pu.putLoginPassword(getApplicationContext(), newCodes);
                        mTextVEr.setText("パスコードを変更しました");
                        intent = new Intent(ChangePassActivity.this, MainContentActivity.class);
                        startActivity(intent);

                    }else{

                        mTextVEr.setText("新しパスコードが不正です");

                    }

                }else{
                    mTextVEr.setText("入力したパスコードが既存のパスコードと一致しません");
                }
            }
        });
    }

}
