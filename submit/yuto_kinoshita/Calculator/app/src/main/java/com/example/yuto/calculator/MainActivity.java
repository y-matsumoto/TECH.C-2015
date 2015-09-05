package com.example.yuto.calculator;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    String sTest = "";
    int iRightNum[] = new int[10];
    int iLeftNum[] = new int[10];

    String sRightNum[] = new String[10];
    String sLeftNum[] = new String[10];

    boolean bMax = false;
    boolean bOverDigit = false;
    int iDigit = 0;
    double dRightNum = 0;
    double dLeftNum = 0;
    String sCalcType = "";

    String sView = "";

    /**
     *
     * @param sData
     */
    void vSetNumArray(String sData){
        if(iDigit == 10){
            // sRightView = "F";
            bOverDigit = true;
        }else{
            if(iDigit == 0) {
                for (int i = 0; i < 10; i++) {
                    sRightNum[i] = "";
                }
            }
            for (int i = sRightNum.length - 1; i > 0; i--) {
                sRightNum[i] = sRightNum[i - 1];
            }
            sRightNum[0] = sData;
            iDigit++;
        }
        vDisp();
    }

    void vDisp(){
        TextView textView = (TextView)findViewById(R.id.textView1);

        String sRightView = "";
        if(bOverDigit){
            sRightView = "F";
        }else {
            for (int i = 0; i < 10; i++) {
                sRightView += sRightNum[9 - i];
            }
        }
        textView.setText(sRightView);
    }

    void vClear(){
        for (int i = 0; i < 10; i++) {
            sRightNum[i] = "";
        }
        iDigit = 0;
        bOverDigit = false;

        vDisp();
    }

    void vAllClear(){
        for (int i = 0; i < 10; i++) {
            sRightNum[i] = "";
        }
        iDigit = 0;
        bOverDigit = false;

        vDisp();
    }

//    void vCalculator(int iButtonNum){
//        dRightNum = dRightNum*10 + iButtonNum;
//
//        vDisp();
//    }
//
//    void vCalc(String sCType){
//        if(sCalcType.equals("ad")){
//            dLeftNum = dLeftNum + dRightNum;
//            dRightNum = 0;
//        }else if(sCType.equals("su")){
//            dLeftNum = dLeftNum - dRightNum;
//            dRightNum = 0;
//        }else if(sCType.equals("mu")){
//            dLeftNum = dLeftNum * dRightNum;
//            dRightNum = 0;
//        }else if(sCType.equals("di")){
//            dLeftNum = dLeftNum / dRightNum;
//            dRightNum = 0;
//        }
//
//        dLeftNum = dRightNum;
//        dRightNum = 0;
//        sCalcType = sCType;
//    }
//
//    void vDispNum(String sButtonValue){
//        TextView textView = (TextView)findViewById(R.id.textView1);
//
//        iDigit ++;
//        if(iDigit == 10){
//            bOverDigit = true;
//        }
//
//        for (int i = iRightNum.length - 1; i > 0; i--) {
//            iRightNum[i] = iRightNum[i - 1];
//        }
//        iRightNum[0] = Integer.parseInt(sButtonValue);
//
//        sView += sButtonValue;
//        textView.setText(sView);
//        //do{
//
//        //}while(!sButtonValue.equals("="));
//    }
//
//    void vDisp(){
//        TextView textView = (TextView)findViewById(R.id.textView1);
//        TextView textView2 = (TextView)findViewById(R.id.textView2);
//        String sDispNum = "";
//
//        sDispNum = dRightNum + "";
//        String[] sDispNumArray = sDispNum.split("\\.", 0);
//        if(sDispNumArray[1].equals("0")){
//            textView.setText(sDispNumArray[0]);
//        }else{
//            textView.setText(sDispNumArray[0] + "\\." + sDispNumArray[1]);
//        }
//
////        textView.setText(dRightNum + "");
//
//        //if(bOverDigit)
//        double dDispDisp = dRightNum + dLeftNum;
//        textView2.setText(dDispDisp + "");
//    }
//
//    void vTestDayo(){
//        TextView textView = (TextView)findViewById(R.id.textView1);
//
//        String sTesTes = "";
//
//        for(int i =0;i<10;i++){
//            sTesTes += iRightNum[9-i];
//        }
//        textView.setText(sTesTes);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView)findViewById(R.id.textView1);
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setText("testtest");

        // button
        Button b1 =  (Button)findViewById(R.id.button1);
        Button b2 =  (Button)findViewById(R.id.button2);
        Button b3 =  (Button)findViewById(R.id.button3);
        Button b4 =  (Button)findViewById(R.id.button4);
        Button b5 =  (Button)findViewById(R.id.button5);
        Button b6 =  (Button)findViewById(R.id.button6);
        Button b7 =  (Button)findViewById(R.id.button7);
        Button b8 =  (Button)findViewById(R.id.button8);
        Button b9 =  (Button)findViewById(R.id.button9);
        Button b0 =  (Button)findViewById(R.id.button0);
        Button b00 = (Button)findViewById(R.id.button00);
        Button d =   (Button)findViewById(R.id.buttonD);
        Button ac =  (Button)findViewById(R.id.buttonAC);
        Button bs =  (Button)findViewById(R.id.buttonBS);
        Button c =   (Button)findViewById(R.id.buttonC);
        Button ad =  (Button)findViewById(R.id.buttonP);
        Button su =  (Button)findViewById(R.id.buttonM);
        Button mu =  (Button)findViewById(R.id.buttonK);
        Button di =  (Button)findViewById(R.id.buttonW);
        Button e =   (Button)findViewById(R.id.buttonE);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //vDispNum("1");
                vSetNumArray("1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //vDispNum("2");
                vSetNumArray("2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vSetNumArray("3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vSetNumArray("4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vSetNumArray("5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vSetNumArray("6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vSetNumArray("7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vSetNumArray("8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vSetNumArray("9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vSetNumArray("0");
            }
        });
        b00.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vSetNumArray("0");
                vSetNumArray("0");
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vClear();
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vTestDayo();
            }
        });
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vCalc("ad");
            }
        });
        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sTest = sTest + "-";
            }
        });
        mu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sTest = sTest + "*";
            }
        });
        di.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sTest = sTest + "/";
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vDisp();
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                vSetNumArray("\\.");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //setContentView(R.layout.activity_main);
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
