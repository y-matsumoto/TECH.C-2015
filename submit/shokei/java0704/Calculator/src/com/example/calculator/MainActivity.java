package com.example.calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	String op[] = { "+", "-", "*", "/" };
	int num = 0;
	int sum = 0;
	//ViewのIDの登録
	int Rid[] = { R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four,
			R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.plus,
			R.id.minus, R.id.mult, R.id.divi, R.id.dot, R.id.equal, R.id.Copy,
			R.id.BS, R.id.Clear, R.id.AC };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//解の初期化
		TextView mTextView = (TextView) findViewById(R.id.result);
		mTextView.setText("0");

		//リスナーの登録
		for (int btnId : Rid) {
			Button mBtn = (Button) findViewById(btnId);
			mBtn.setOnClickListener(this);
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

	//click event
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.zero:
			numDisplay(0);
			break;
		case R.id.one:
			numDisplay(1);
			break;
		case R.id.two:
			numDisplay(2);
			break;
		case R.id.three:
			numDisplay(3);
			break;
		case R.id.four:
			numDisplay(4);
			break;
		case R.id.five:
			numDisplay(5);
			break;
		case R.id.six:
			numDisplay(6);
			break;
		case R.id.seven:
			numDisplay(7);
			break;
		case R.id.eight:
			numDisplay(8);
			break;
		case R.id.nine:
			numDisplay(9);
			break;
		case R.id.plus:
			sum = sum(num, 0, sum);
			break;
		case R.id.minus:
			sum = sum(num, 1, sum);
			break;
		case R.id.mult:
			sum = sum(num, 2, sum);
			break;
		case R.id.divi:
			sum = sum(num, 3, sum);
			break;
		case R.id.dot:
		case R.id.equal:
			sumDisplay(sum);
		case R.id.Copy:
		case R.id.BS:
		case R.id.Clear:
		case R.id.AC:
		default:
			break;
		}

	}

	//演算子の計算
	public int sum(int num, int op, int sum) {

		switch (op) {
		case 0:
			sum += num;
			break;
		case 1:
			sum -= num;
			break;
		case 2:
			sum *= num;
			break;
		case 3:
			sum /= num;
			break;
		}

		return sum;
	}

	//入力された数字の表示
	public void numDisplay(int num) {
		TextView text = (TextView) findViewById(R.id.result);
		text.setText(num);
	}

	//計算結果の表示
	public void sumDisplay(int sum){
		TextView text = (TextView) findViewById(R.id.result);
		text.setText(sum);
	}

}
