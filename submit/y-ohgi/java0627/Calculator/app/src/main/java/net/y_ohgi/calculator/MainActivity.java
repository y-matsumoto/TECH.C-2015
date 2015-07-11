package net.y_ohgi.calculator;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends Activity {
    /*
    private String[] btns = {
            "copy", "ac", "bs", "c",
            "dot", "slash", "aster", "minus", "plus", "equal",
            "num0", "num1", "num2", "num3", "num4", "num5", "num6", "num7", "num8", "num9"
    };
    */

    private int btnnum = 20;



    private TextView result_num;
    private TextView result_formula_left;
    private TextView result_formula_mark;
    private TextView result_formula_right;

    //private String[] result_formula = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        result_num = (TextView)this.findViewById(R.id.result_num);
        result_formula_left = (TextView)this.findViewById(R.id.result_formula_left);
        result_formula_mark = (TextView)this.findViewById(R.id.result_formula_mark);
        result_formula_right = (TextView)this.findViewById(R.id.result_formula_right);


        Button[] btns = new Button[btnnum];

        btns[0] = (Button)this.findViewById(R.id.copy);
        btns[1] = (Button)this.findViewById(R.id.ac);
        btns[2] = (Button)this.findViewById(R.id.bs);
        btns[3] = (Button)this.findViewById(R.id.c);

        btns[4] = (Button)this.findViewById(R.id.dot);
        btns[5] = (Button)this.findViewById(R.id.slash);
        btns[6] = (Button)this.findViewById(R.id.aster);
        btns[7] = (Button)this.findViewById(R.id.minus);
        btns[8] = (Button)this.findViewById(R.id.plus);
        btns[9] = (Button)this.findViewById(R.id.equal);

        btns[10] = (Button)this.findViewById(R.id.num9);
        btns[11] = (Button)this.findViewById(R.id.num8);
        btns[12] = (Button)this.findViewById(R.id.num7);
        btns[13] = (Button)this.findViewById(R.id.num6);
        btns[14] = (Button)this.findViewById(R.id.num5);
        btns[15] = (Button)this.findViewById(R.id.num4);
        btns[16] = (Button)this.findViewById(R.id.num3);
        btns[17] = (Button)this.findViewById(R.id.num2);
        btns[18] = (Button)this.findViewById(R.id.num1);
        btns[19] = (Button)this.findViewById(R.id.num0);

        for(int i=0;i<btnnum;i++){
            btns[i].setOnClickListener(new Click());
        }

    }

    class Click implements View.OnClickListener{
        public Click(){

        }

        @Override
        public void onClick(View v) {
            String nowstr = (String) result_num.getText();

            // MEMO: R.id.xxx のtextを取得ができなかったのでswitchにした（酷い
            // XXX: 関数に分けたいけどJavaの構文覚えてない
            switch (v.getId()){
                case R.id.num9:
                    result_num.setText(nowstr+"9");
                    break;
                case R.id.num8:
                    result_num.setText(nowstr+"8");
                    break;
                case R.id.num7:
                    result_num.setText(nowstr+"7");
                    break;
                case R.id.num6:
                    result_num.setText(nowstr+"6");
                    break;
                case R.id.num5:
                    result_num.setText(nowstr+"5");
                    break;
                case R.id.num4:
                    result_num.setText(nowstr+"4");
                    break;
                case R.id.num3:
                    result_num.setText(nowstr+"3");
                    break;
                case R.id.num2:
                    result_num.setText(nowstr+"2");
                    break;
                case R.id.num1:
                    result_num.setText(nowstr+"1");
                    break;
                case R.id.num0:
                    result_num.setText(nowstr+"0");
                    break;

                case R.id.dot:
                    result_num.setText(nowstr+".");
                    break;

                case R.id.slash:
                    // 割る

                    if(null == nowstr){
                        break;
                    }

                    if(null == result_formula_mark) {
                        // 初回記号タップ時
                        result_formula_left.setText(nowstr);
                        result_formula_mark.setText("/");
                    }else if(null != result_formula_right){
                        // 一回計算済み時

                        // 計算する
                        int lnum = Integer.parseInt((String) result_formula_left.getText());
                        int nnum = Integer.parseInt((String) result_formula_right.getText());
                        int res = 0;

                        String mark = (String) result_formula_mark.getText();

                        if(-1 != mark.indexOf('/')){
                            res = lnum/nnum;
                        }else if(-1 != mark.indexOf('*')){
                            res = lnum*nnum;
                        }else if(-1 != mark.indexOf('-')){
                            res = lnum-nnum;
                        }else if(-1 != mark.indexOf('+')){
                            res = lnum+nnum;
                        }else{
                            Toast.makeText(getBaseContext(), "計算できず", Toast.LENGTH_LONG).show();
                        }

                        // 解をleft に入れる
                        result_formula_left.setText(res);
                        result_formula_mark.setText("/");
                        result_formula_right.setText(nowstr);

                        // 計算する
                        lnum = Integer.parseInt((String) result_formula_left.getText());
                        nnum = Integer.parseInt(nowstr);
                        res = 0;
                        if(-1 != mark.indexOf('/')){
                            res = lnum/nnum;
                        }else if(-1 != mark.indexOf('*')){
                            res = lnum*nnum;
                        }else if(-1 != mark.indexOf('-')){
                            res = lnum-nnum;
                        }else if(-1 != mark.indexOf('+')){
                            res = lnum+nnum;
                        }else{
                            Toast.makeText(getBaseContext(), "計算できず", Toast.LENGTH_LONG).show();
                        }

                        result_num.setText(res);
                    }else if(null != result_formula_right){
                        // 初回計算時

                        // 計算する
                        int lnum = Integer.parseInt((String) result_formula_left.getText());
                        int nnum = Integer.parseInt(nowstr);
                        int res = lnum/nnum;

                        result_num.setText(res);
                    }


                    break;
                case R.id.aster:
                    // 掛ける
                    if(null == result_formula_mark) {
                        // 初回記号タップ時
                        result_formula_left.setText(nowstr);
                        result_formula_mark.setText("*");
                    }else if(null != result_formula_right){
                        // 一回計算済み時

                        // 計算する
                        int lnum = Integer.parseInt((String) result_formula_left.getText());
                        int nnum = Integer.parseInt((String) result_formula_right.getText());
                        int res = 0;

                        String mark = (String) result_formula_mark.getText();

                        if(-1 != mark.indexOf('/')){
                            res = lnum/nnum;
                        }else if(-1 != mark.indexOf('*')){
                            res = lnum*nnum;
                        }else if(-1 != mark.indexOf('-')){
                            res = lnum-nnum;
                        }else if(-1 != mark.indexOf('+')){
                            res = lnum+nnum;
                        }else{
                            Toast.makeText(getBaseContext(), "計算できず", Toast.LENGTH_LONG).show();
                        }

                        // 解をleft に入れる
                        result_formula_left.setText(res);
                        result_formula_mark.setText("*");
                        result_formula_right.setText(nowstr);

                        // 計算する
                        lnum = Integer.parseInt((String) result_formula_left.getText());
                        nnum = Integer.parseInt(nowstr);
                        res = lnum*nnum;

                        result_num.setText(res);
                    }else if(null != result_formula_right){
                        // 初回計算時

                        // 計算する
                        int lnum = Integer.parseInt((String) result_formula_left.getText());
                        int nnum = Integer.parseInt(nowstr);
                        int res = lnum*nnum;

                        result_num.setText(res);
                    }

                    break;
                case R.id.minus:
                    // 引く
                    if(null == result_formula_mark) {
                        // 初回記号タップ時
                        result_formula_left.setText(nowstr);
                        result_formula_mark.setText("-");
                    }else if(null != result_formula_right){
                        // 一回計算済み時

                        // 計算する
                        int lnum = Integer.parseInt((String) result_formula_left.getText());
                        int nnum = Integer.parseInt((String) result_formula_right.getText());
                        int res = 0;

                        String mark = (String) result_formula_mark.getText();

                        if(-1 != mark.indexOf('/')){
                            res = lnum/nnum;
                        }else if(-1 != mark.indexOf('*')){
                            res = lnum*nnum;
                        }else if(-1 != mark.indexOf('-')){
                            res = lnum-nnum;
                        }else if(-1 != mark.indexOf('+')){
                            res = lnum+nnum;
                        }else{
                            Toast.makeText(getBaseContext(), "計算できず", Toast.LENGTH_LONG).show();
                        }

                        // 解をleft に入れる
                        result_formula_left.setText(res);
                        result_formula_mark.setText("-");
                        result_formula_right.setText(nowstr);

                        // 計算する
                        lnum = Integer.parseInt((String) result_formula_left.getText());
                        nnum = Integer.parseInt(nowstr);
                        res = lnum-nnum;

                        result_num.setText(res);
                    }else if(null != result_formula_right){
                        // 初回計算時

                        // 計算する
                        int lnum = Integer.parseInt((String) result_formula_left.getText());
                        int nnum = Integer.parseInt(nowstr);
                        int res = lnum-nnum;

                        result_num.setText(res);
                    }

                    break;
                case R.id.plus:
                    // 足す
                    if(null == result_formula_mark) {
                        // 初回記号タップ時
                        result_formula_left.setText(nowstr);
                        result_formula_mark.setText("+");
                    }else if(null != result_formula_right){
                        // 一回計算済み時

                        // 計算する
                        int lnum = Integer.parseInt((String) result_formula_left.getText());
                        int nnum = Integer.parseInt((String) result_formula_right.getText());
                        int res = 0;

                        String mark = (String) result_formula_mark.getText();

                        if(-1 != mark.indexOf('/')){
                            res = lnum/nnum;
                        }else if(-1 != mark.indexOf('*')){
                            res = lnum*nnum;
                        }else if(-1 != mark.indexOf('-')){
                            res = lnum-nnum;
                        }else if(-1 != mark.indexOf('+')){
                            res = lnum+nnum;
                        }else{
                            Toast.makeText(getBaseContext(), "計算できず", Toast.LENGTH_LONG).show();
                        }

                        // 解をleft に入れる
                        result_formula_left.setText(res);
                        result_formula_mark.setText("+");
                        result_formula_right.setText(nowstr);

                        // 計算する
                        lnum = Integer.parseInt((String) result_formula_left.getText());
                        nnum = Integer.parseInt(nowstr);
                        res = lnum+nnum;

                        result_num.setText(res);
                    }else if(null != result_formula_right){
                        // 初回計算時

                        // 計算する
                        int lnum = Integer.parseInt((String) result_formula_left.getText());
                        int nnum = Integer.parseInt(nowstr);
                        int res = lnum+nnum;

                        result_num.setText(res);
                    }

                    break;
                case R.id.equal:
                    // 解を求める
                    if(null != result_formula_mark){
                        // 一回計算済み時

                        // 計算する
                        int lnum = Integer.parseInt((String) result_formula_left.getText());
                        int nnum = Integer.parseInt((String) result_formula_right.getText());
                        int res = 0;

                        String mark = (String) result_formula_mark.getText();

                        if(-1 != mark.indexOf('/')){
                            res = lnum/nnum;
                        }else if(-1 != mark.indexOf('*')){
                            res = lnum*nnum;
                        }else if(-1 != mark.indexOf('-')){
                            res = lnum-nnum;
                        }else if(-1 != mark.indexOf('+')){
                            res = lnum+nnum;
                        }else{
                            Toast.makeText(getBaseContext(), "計算できず", Toast.LENGTH_LONG).show();
                        }

                        // 解をleft に入れる
                        result_formula_left.setText(res);
                        result_formula_mark.setText("+");
                        result_formula_right.setText(nowstr);

                        // 計算する
                        lnum = Integer.parseInt((String) result_formula_left.getText());
                        nnum = Integer.parseInt(nowstr);
                        res = lnum+nnum;

                        result_num.setText(res);
                    }
                    break;

                case R.id.copy:
                    // クリップボードへコピー
                    //クリップボードに格納するItemを作成
                    ClipData.Item item = new ClipData.Item(result_num.getText());

// MIMETYPEの作成
                    String[] mimeType = new String[1];
                    mimeType[0] = ClipDescription.MIMETYPE_TEXT_URILIST;

//クリップボードに格納するClipDataオブジェクトの作成
                    ClipData cd = new ClipData(new ClipDescription("text_data", mimeType), item);

//クリップボードにデータを格納
                    ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    cm.setPrimaryClip(cd);
                    break;
                case R.id.ac:
                    // 全て初期化
                    result_formula_left.setText(null);
                    result_formula_mark.setText(null);
                    result_formula_right.setText(null);
                    result_num.setText(null);

                    break;
                case R.id.bs:
                    // ひとけた目を削除
                    if(0 < nowstr.length()) {
                        nowstr = nowstr.substring(0, nowstr.length() - 1);
                    }else{
                        Toast.makeText(getBaseContext(), "消せる文字がない", Toast.LENGTH_LONG).show();
                    }
                    result_num.setText(nowstr);
                    break;
                case R.id.c:
                    // 式以外を削除
                    result_num.setText(null);
                    break;


                default:
                    Toast.makeText(getBaseContext(), "default", Toast.LENGTH_LONG).show();

            }

            //result_num.setText(_num);
            //Toast.makeText(this, "test", Toast.LENGTH_LONG).show();
            //Toast.makeText(getBaseContext(), String.valueOf(v.getId()), Toast.LENGTH_LONG).show();
            //Log.i(v.toString());
            //result_num.setText(String.valueOf(v.toString()));
            //System.out.println(v.toString());
        }
    }

    private void _setFormula(){

    }




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
