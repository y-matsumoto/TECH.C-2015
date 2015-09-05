package com.example.dentaku;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//ボタンの取得
		Button button0 = (Button)findViewById(R.id.button0);
		Button button1 = (Button)findViewById(R.id.button1);
		Button button2 = (Button)findViewById(R.id.button2);
		Button button3 = (Button)findViewById(R.id.button3);
		Button button4 = (Button)findViewById(R.id.button4);
		Button button5 = (Button)findViewById(R.id.button5);
		Button button6 = (Button)findViewById(R.id.button6);
		Button button7 = (Button)findViewById(R.id.button7);
		Button button8 = (Button)findViewById(R.id.button8);
		Button button9 = (Button)findViewById(R.id.button9);
		Button button10 = (Button)findViewById(R.id.buttonPlus);
		Button button11 = (Button)findViewById(R.id.buttonMinus);
		Button button12 = (Button)findViewById(R.id.buttonMultiply);
		Button button13 = (Button)findViewById(R.id.buttonDivision);
		Button button14 = (Button)findViewById(R.id.buttonC);
		Button button15 = (Button)findViewById(R.id.buttonBs);
		Button button16 = (Button)findViewById(R.id.buttonAc);
		Button button17 = (Button)findViewById(R.id.buttonCopy);
		Button button18 = (Button)findViewById(R.id.buttonPoint);
		Button button19 = (Button)findViewById(R.id.buttonEqual);

		//リスナーの登録
	    button0.setOnClickListener(this);
	    button1.setOnClickListener(this);
	    button2.setOnClickListener(this);
	    button3.setOnClickListener(this);
	    button4.setOnClickListener(this);
	    button5.setOnClickListener(this);
	    button6.setOnClickListener(this);
	    button7.setOnClickListener(this);
	    button8.setOnClickListener(this);
	    button9.setOnClickListener(this);
	    button10.setOnClickListener(this);
	    button11.setOnClickListener(this);
	    button12.setOnClickListener(this);
	    button13.setOnClickListener(this);
	    button14.setOnClickListener(this);
	    button15.setOnClickListener(this);
	    button16.setOnClickListener(this);
	    button17.setOnClickListener(this);
	    button18.setOnClickListener(this);
	    button19.setOnClickListener(this);

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
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
