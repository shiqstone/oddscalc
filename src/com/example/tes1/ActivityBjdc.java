package com.example.tes1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityBjdc extends Activity {
	Spinner spinner;

	private ArrayAdapter<String> aspnguans;
	private List<String> allguans;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("北京单场赔率计算");
		setContentView(R.layout.activity_bjdc);
		find_and_modify_view();
		calcOdds();

	}

	private static final String[] guans = { "单关", "2*1", "3*1", "4*1", "5*1",
			"6*1", "7*1", "8*1" };

	private void find_and_modify_view() {
		spinner = (Spinner) findViewById(R.id.bjdc_spinner_1);
		allguans = new ArrayList<String>();
		for (int i = 0; i < guans.length; i++) {
			allguans.add(guans[i]);
		}
		aspnguans = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, allguans);
		aspnguans
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(aspnguans);

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				showEntries(arg2);
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				Log.e("klkl", "klkl");

			}
			
			public void showEntries(int guan){
				TextView tv = null;
				EditText et = null;
				tv = (TextView) findViewById(R.id.bjdc_label8);
				et = (EditText) findViewById(R.id.bjdc_entry8);
				if((guan+1)<8){
					tv.setVisibility(View.INVISIBLE);
					et.setVisibility(View.INVISIBLE);
					et.setText("");
				}else{
					tv.setVisibility(View.VISIBLE);
					et.setVisibility(View.VISIBLE);
				}
				tv = (TextView) findViewById(R.id.bjdc_label7);
				et = (EditText) findViewById(R.id.bjdc_entry7);
				if((guan+1)<7){
					tv.setVisibility(View.INVISIBLE);
					et.setVisibility(View.INVISIBLE);
					et.setText("");
				}else{
					tv.setVisibility(View.VISIBLE);
					et.setVisibility(View.VISIBLE);
				}
				tv = (TextView) findViewById(R.id.bjdc_label6);
				et = (EditText) findViewById(R.id.bjdc_entry6);
				if((guan+1)<6){
					tv.setVisibility(View.INVISIBLE);
					et.setVisibility(View.INVISIBLE);
					et.setText("");
				}else{
					tv.setVisibility(View.VISIBLE);
					et.setVisibility(View.VISIBLE);
				}
				tv = (TextView) findViewById(R.id.bjdc_label5);
				et = (EditText) findViewById(R.id.bjdc_entry5);
				if((guan+1)<5){
					tv.setVisibility(View.INVISIBLE);
					et.setVisibility(View.INVISIBLE);
					et.setText("");
				}else{
					tv.setVisibility(View.VISIBLE);
					et.setVisibility(View.VISIBLE);
				};
				tv = (TextView) findViewById(R.id.bjdc_label4);
				et = (EditText) findViewById(R.id.bjdc_entry4);
				if((guan+1)<4){
					tv.setVisibility(View.INVISIBLE);
					et.setVisibility(View.INVISIBLE);
					et.setText("");
				}else{
					tv.setVisibility(View.VISIBLE);
					et.setVisibility(View.VISIBLE);
				};
				tv = (TextView) findViewById(R.id.bjdc_label3);
				et = (EditText) findViewById(R.id.bjdc_entry3);
				if((guan+1)<3){
					tv.setVisibility(View.INVISIBLE);
					et.setVisibility(View.INVISIBLE);
					et.setText("");
				}else{
					tv.setVisibility(View.VISIBLE);
					et.setVisibility(View.VISIBLE);
				};
				tv = (TextView) findViewById(R.id.bjdc_label2);
				et = (EditText) findViewById(R.id.bjdc_entry2);
				if((guan+1)<2){
					tv.setVisibility(View.INVISIBLE);
					et.setVisibility(View.INVISIBLE);
					et.setText("");
				}else{
					tv.setVisibility(View.VISIBLE);
					et.setVisibility(View.VISIBLE);
				};
			}
		});
	}
	
	public void calcOdds(){
		Button calcStrButton = (Button) findViewById(R.id.buttonCalc1);
		calcStrButton.setOnClickListener(listener0);
	}
	
	private Button.OnClickListener listener0 = new Button.OnClickListener(){
		public void onClick(View v){
			EditText etext = null;
			etext = (EditText) findViewById(R.id.bjdc_entry1);
			Editable oddsStr1 = etext.getText();
			etext = (EditText) findViewById(R.id.bjdc_entry2);
			Editable oddsStr2 = etext.getText();
			etext = (EditText) findViewById(R.id.bjdc_entry3);
			Editable oddsStr3 = etext.getText();
			etext = (EditText) findViewById(R.id.bjdc_entry4);
			Editable oddsStr4 = etext.getText();
			etext = (EditText) findViewById(R.id.bjdc_entry5);
			Editable oddsStr5 = etext.getText();
			etext = (EditText) findViewById(R.id.bjdc_entry6);
			Editable oddsStr6 = etext.getText();
			etext = (EditText) findViewById(R.id.bjdc_entry7);
			Editable oddsStr7 = etext.getText();
			etext = (EditText) findViewById(R.id.bjdc_entry8);
			Editable oddsStr8 = etext.getText();
			
			etext = (EditText) findViewById(R.id.bjdc_entry_multi);
			Editable multiStr = etext.getText();
			BigDecimal multi = BigDecimal.ONE;
			if(!multiStr.toString().equals("") && !multiStr.toString().equals("0")){
				multi = new BigDecimal(multiStr.toString());
			}

			TextView text = (TextView) findViewById(R.id.textViewRes_bjdc);
			
			BigDecimal res = new BigDecimal(1);
			BigDecimal odds = null;
			if(!oddsStr1.toString().equals("") && !oddsStr1.toString().equals("0")){
				odds = new BigDecimal(oddsStr1.toString());
				res = res.multiply(odds);
			}
			if(!oddsStr2.toString().equals("") && !oddsStr2.toString().equals("0")){
				odds = new BigDecimal(oddsStr2.toString());
				res = res.multiply(odds);
			}
			if(!oddsStr3.toString().equals("") && !oddsStr3.toString().equals("0")){
				odds = new BigDecimal(oddsStr3.toString());
				res = res.multiply(odds);
			}
			if(!oddsStr4.toString().equals("") && !oddsStr4.toString().equals("0")){
				odds = new BigDecimal(oddsStr4.toString());
				res = res.multiply(odds);
			}
			if(!oddsStr5.toString().equals("") && !oddsStr5.toString().equals("0")){
				odds = new BigDecimal(oddsStr5.toString());
				res = res.multiply(odds);
			}
			if(!oddsStr6.toString().equals("") && !oddsStr6.toString().equals("0")){
				odds = new BigDecimal(oddsStr6.toString());
				res = res.multiply(odds);
			}
			if(!oddsStr7.toString().equals("") && !oddsStr7.toString().equals("0")){
				odds = new BigDecimal(oddsStr7.toString());
				res = res.multiply(odds);
			}
			if(!oddsStr8.toString().equals("") && !oddsStr8.toString().equals("0")){
				odds = new BigDecimal(oddsStr8.toString());
				res = res.multiply(odds);
			}
			
			
			res = res.multiply(new BigDecimal(2));
			//res = res.setScale(3, BigDecimal.ROUND_DOWN);
			//res = res.setScale(2, BigDecimal.ROUND_HALF_EVEN);
			res = res.multiply(multi).multiply(new BigDecimal("0.65"));
			res = res.setScale(2, BigDecimal.ROUND_HALF_EVEN);
			String result = res.toString();
			text.setText(result);
			
		}
	};
}
