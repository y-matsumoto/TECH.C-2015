package com.example.authoricator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Enter extends ActionBarActivity{

;

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


		}

	}


