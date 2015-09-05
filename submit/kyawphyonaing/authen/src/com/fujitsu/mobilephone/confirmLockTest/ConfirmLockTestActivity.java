/*
  * Copyright (C) 2013 FUJITSU LIMITED.
  *
  * Licensed under the Apache License, Version 2.0 (the “License”);
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *      http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an “AS IS” BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
package com.fujitsu.mobilephone.confirmLockTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fujitsu.mobilephone.fconfirmlock.ConfirmLock;

public class ConfirmLockTestActivity extends Activity {

    private static final int REQUEST_CODE_A = 0;
    private static final String LOGTAG      = "ConfrimLockTest";
    private TextView mResultview            = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // 戻り値結果出力用テキストビュー
        mResultview = (TextView)this.findViewById(R.id.text);
    }

    // 認証画面起動ボタン
    public void clickButtonA(View v) {
        Intent i = new Intent();
        i.setAction(ConfirmLock.ACTION_CONFIRMLOCK_START);
        startActivityForResult(i,REQUEST_CODE_A);
    }
    
    // 認証画面からの戻り値取得
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        String resultString = "Unknown error";
        
        switch(requestCode) {
        case REQUEST_CODE_A:
            if(resultCode == ConfirmLock.RESULT_CONFIRMLOCK_OK) {
                // 認証成功
                resultString = "SUCCESS";
            } else if(resultCode == ConfirmLock.RESULT_CONFIRMLOCK_CANCELD) {
                // 認証キャンセル
                resultString = "RESULT_CANCELED";
            } else if(resultCode == ConfirmLock.RESULT_CONFIRMLOCK_UNSPECIFIED) {
                // 認証未設定
                resultString = "RESULT_CONFIRMLOCK_UNSPECIFIED";
            } else {
                resultString = (new StringBuffer("Unknown Result Code"))
                                    .append(String.valueOf(resultCode)).toString();
            }
            break;
        default:
            resultString = (new StringBuffer("Unknown Request Code"))
                                .append(String.valueOf(requestCode)).toString();
            break;
        }
        Log.v(LOGTAG, resultString);
        // 戻り値結果出力
        mResultview.setText(resultString);
    }
}
