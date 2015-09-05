package com.example.authoricator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.utility.PreferencesUtil;
public class MainActivity extends ActionBarActivity {

	private final static String PREF_KEY_LOGIN_PASSWORD = "PREF_KEY_LOGIN_PASSWORD";

	EditText mEditT1 = (EditText) findViewById(R.id.passcode1);
	EditText mEditT2 = (EditText) findViewById(R.id.passcode2);
	EditText mEditT3 = (EditText) findViewById(R.id.passcode3);
	EditText mEditT4 = (EditText) findViewById(R.id.passcode4);
	TextView mTextV = (TextView) findViewById(R.id.firstmessage);
	TextView mTextVEr = (TextView) findViewById(R.id.errormessage);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);




		Button bt = (Button) findViewById(R.id.regibutton);
		bt.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

				int mCode1;
				int mCode2;
				int mCode3;
				int mCode4;
				boolean errorflag = false;
				try{
					mCode1 = Integer.parseInt(mEditT1.toString());
					mCode2 = Integer.parseInt(mEditT2.toString());
					mCode3 = Integer.parseInt(mEditT3.toString());
					mCode4 = Integer.parseInt(mEditT4.toString());
				}catch(NumberFormatException e){
					mCode1 = 0;
					mCode2 = 0;
					mCode3 = 0;
					mCode4 = 0;
				}

				if(mCode1 == mCode2 && mCode2 == mCode3 && mCode3 == mCode4){
					errorflag = true;
				}
				if((mCode1 + 1) == mCode2 && (mCode2 + 1) == mCode3 && (mCode3 + 1) == mCode4){
					errorflag = true;
				}

				if(errorflag == false){
					String pass = "" + mCode1 + mCode2 + mCode3 + mCode4;
					PutPassword pp = new PutPassword();
					pp.putLoginPassword(MainActivity.this, pass);

				}else{
					mTextVEr.setText("パスコードが不正です");;
				}

			}});

		String savedCode = PreferencesUtil.loadPreference(MainActivity.this, PREF_KEY_LOGIN_PASSWORD, "ERROR");
		if(savedCode != "ERROR"){
			Intent intent = new Intent();
			intent.setClassName("com.example.authoricator", "com.example.authoricator.Enter");
			startActivity(intent);

		}


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onResume(){
		super.onResume();


		//key2を削除
	}

}
