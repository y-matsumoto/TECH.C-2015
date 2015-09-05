package com.example.calcurator2;

import java.util.ArrayList;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	private TextView mTextView1; //計算の答え表示
	private TextView mTextView2; //計算式の表示

	private Button mBtn[] = new Button[10]; //数字ボタン0～9

	//各種ボタン
	private Button mBtnCopy;
	private Button mBtnAc;
	private Button mBtnBs;
	private Button mBtnC;
	private Button mBtnDiv;
	private Button mBtnMul;
	private Button mBtnMinus;
	private Button mBtnPlus;
	private Button mBtnDot;
	private Button mBtnEqual;

	public static final int plus = 1;
	public static final int minus = 2;
	public static final int div = 3;
	public static final int mul = 4;
	public static final int dot = 5;

	private ArrayList<Integer> mKigouList = new ArrayList<Integer>();
	private ArrayList<Integer> mNumList = new ArrayList<Integer>();
	private ArrayList<Integer> mKetaList = new ArrayList<Integer>();
	private boolean ketaagariflag = false;


	ClipData.Item item;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTextView1 = (TextView)findViewById(R.id.txtEdit1);
		mTextView2 = (TextView)findViewById(R.id.txtEdit2);


		for(int i=0; i<10;i++){
			mBtn[i] = new Button(this);
		}

		//各種ボタンのidを設定
		mBtn[0] = (Button)findViewById(R.id.btn0);
		mBtn[1] = (Button)findViewById(R.id.btn1);
		mBtn[2] = (Button)findViewById(R.id.btn2);
		mBtn[3] = (Button)findViewById(R.id.btn3);
		mBtn[4] = (Button)findViewById(R.id.btn4);
		mBtn[5] = (Button)findViewById(R.id.btn5);
		mBtn[6] = (Button)findViewById(R.id.btn6);
		mBtn[7] = (Button)findViewById(R.id.btn7);
		mBtn[8] = (Button)findViewById(R.id.btn8);
		mBtn[9] = (Button)findViewById(R.id.btn9);

		mBtnCopy = (Button)findViewById(R.id.btnCopy);
		mBtnC = (Button)findViewById(R.id.btnC);
		mBtnBs = (Button)findViewById(R.id.btnBs);
		mBtnAc = (Button)findViewById(R.id.btnAc);
		mBtnMul = (Button)findViewById(R.id.btnMul);
		mBtnDiv = (Button)findViewById(R.id.btnDiv);
		mBtnPlus = (Button)findViewById(R.id.btnPlus);
		mBtnMinus = (Button)findViewById(R.id.btnMinus);
		mBtnDot = (Button)findViewById(R.id.btnDot);
		mBtnEqual = (Button)findViewById(R.id.btnEqual);


		//各種ボタンのクリックリスナー登録

		for(int i=0; i<10; i++){

			mBtn[i].setOnClickListener(this);
		}

		mBtnCopy.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

				item = new ClipData.Item(mTextView1.getText());

				//MIMETYPEの作成
				String[] mimeType = new String[1];
				mimeType[0] = ClipDescription.MIMETYPE_TEXT_URILIST;

				//クリップボードに格納するClipDataオブジェクトの作成
				ClipData cd = new ClipData(new ClipDescription("text_data", mimeType), item);

				//クリップボードにデータを格納
				ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
				cm.setPrimaryClip(cd);
			}


		});

		mBtnC.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

				mTextView1.setText("0");
			}


		});

		mBtnBs.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

			}


		});

		mBtnAc.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

			}


		});

		mBtnMul.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

				mKigouList.add((Integer)mul);
				mTextView2.append("*");
				ketaagariflag = false;
			}


		});

		mBtnDiv.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

				mKigouList.add((Integer)div);
				mTextView2.append("/");
				ketaagariflag = false;
			}


		});

		mBtnPlus.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

				mKigouList.add((Integer)plus);
				mTextView2.append("+");
				ketaagariflag = false;
			}


		});

		mBtnMinus.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

				mKigouList.add((Integer)minus);
				mTextView2.append("-");
				ketaagariflag = false;
			}


		});

		mBtnDot.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

				mTextView2.append(".");
			}


		});

		mBtnEqual.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ



			}


		});
		mTextView1.setText("0");
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


		for(int i=0; i<10; i++){
			if(v == mBtn[i]){
				String str1 = Integer.toString(i);
				mTextView2.append(str1);
				mNumList.add((Integer)i);
			}
		}
		mKetaList.add(1);
		if(ketaagariflag){
			mKetaList.set(, 2);

		}
		ketaagariflag = true;
	}


}
