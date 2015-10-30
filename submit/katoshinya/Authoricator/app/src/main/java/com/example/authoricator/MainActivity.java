package com.example.authoricator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.utility.PasswordUtil;

public class MainActivity extends AppCompatActivity {

    //変数の定義と初期化
    private EditText mEditT1 = null;
    private EditText mEditT2 = null;
    private EditText mEditT3 = null;
    private EditText mEditT4 = null;
    private TextView mTextV = null;
    private TextView mTextVEr = null;
    private PasswordUtil pu = new PasswordUtil();
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //インスタンスの取得
        mEditT1 = (EditText) findViewById(R.id.passcode1);
        mEditT2 = (EditText) findViewById(R.id.passcode2);
        mEditT3 = (EditText) findViewById(R.id.passcode3);
        mEditT4 = (EditText) findViewById(R.id.passcode4);
        //mTextV = (TextView) findViewById(R.id.firstmessage);
        mTextVEr = (TextView) findViewById(R.id.errormessage);

        //Intentの遷移先にEnterActivityを設定
        intent = new Intent(MainActivity.this, EnterActivity.class);

        //ボタンのインスタンスの取得
        Button bt = (Button) findViewById(R.id.regibutton);
        //ApplicationContextを指定してPreferencesUtilからパスコードを取得
        String mPass = pu.getLoginPassword(getApplicationContext());

        //MainActivity起動時にPreferenceにパスコードが保存されていたら、EnterActivityに遷移する
        if(!mPass.equals("") && !mPass.isEmpty()){
            startActivity(intent);
        }


        //ボタンにClickListenerを設定する
        bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO 自動生成されたメソッド・スタブ

                try{
                    int mCode1 = 0;
                    int mCode2 = 0;
                    int mCode3 = 0;
                    int mCode4 = 0;
                    boolean mErrorFlag = false;

                    mCode1 = Integer.parseInt(mEditT1.getText().toString());
                    mCode2 = Integer.parseInt(mEditT2.getText().toString());
                    mCode3 = Integer.parseInt(mEditT3.getText().toString());
                    mCode4 = Integer.parseInt(mEditT4.getText().toString());

                    if(pu.passCodeCheck(mCode1, mCode2, mCode3, mCode4)){
                        String pass = "" + mCode1 + mCode2 + mCode3 + mCode4;

                        pu.putLoginPassword(getApplicationContext(), pass);
                        startActivity(intent);

                    }else{
                        mTextVEr.setText("パスコードが不正です");

                    }

                }catch(NumberFormatException e){
                    //e.printStackTrace();
                }



            }});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
