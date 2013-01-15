package com.example.tes1;

import java.math.BigDecimal;
import java.util.StringTokenizer;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityLab extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);;
		setContentView(R.layout.activity_lab);
		calcOdds();
		calcOddsStr();
	}
	
	public void calcOddsStr(){
		Button calcStrButton = (Button) findViewById(R.id.buttonCalc0);
		calcStrButton.setOnClickListener(listener0);
	}
	
	public void calcOdds(){
		Button calcButton = (Button) findViewById(R.id.buttonCalc1);
		calcButton.setOnClickListener(listener1);
	}
	
	private Button.OnClickListener listener0 = new Button.OnClickListener(){
		@Override
		public void onClick(View v){
			EditText etext = (EditText) findViewById(R.id.editText1);
			Editable oddsStr = etext.getText();
			StringTokenizer oddsToken = new StringTokenizer(oddsStr.toString(), "*");
			TextView text = (TextView) findViewById(R.id.textView1);
			if(oddsToken.countTokens()>8){
				text.setText("请输入正确的赔率连乘公式");
			}else{
				BigDecimal res = new BigDecimal(1);
				while(oddsToken.hasMoreTokens()){
					BigDecimal odds = new BigDecimal(oddsToken.nextToken());
					if(odds.compareTo(BigDecimal.ZERO)>0){
						res = res.multiply(odds);
					}
				}
				res = res.multiply(new BigDecimal(2));
				res = res.setScale(3, BigDecimal.ROUND_DOWN);
				String result = res.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString();
				text.setText(result);
			}
		}
	};
	
	private Button.OnClickListener listener1 = new Button.OnClickListener(){
		@Override
		public void onClick(View v){
			EditText etext = (EditText) findViewById(R.id.editText2);
			Editable odds = etext.getText();
			BigDecimal res = new BigDecimal(odds.toString());
			res = res.setScale(3, BigDecimal.ROUND_DOWN);
			String result = res.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString();
			TextView text = (TextView) findViewById(R.id.textView1);
			text.setText(result);
		}
	};
}
