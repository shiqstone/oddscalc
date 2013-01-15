package com.example.tes1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	OnClickListener listener0 = null;
	OnClickListener listener1 = null;
	OnClickListener listener2 = null;

	Button button0;
	Button button1;
	Button button2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listener0 = new OnClickListener() {
			public void onClick(View v) {
				Intent intent0 = new Intent(MainActivity.this, ActivityJczq.class);
				setTitle("¾º²Ê×ãÇò");
				startActivity(intent0);
			}
		};
		
		listener1 = new OnClickListener() {
			public void onClick(View v) {
				Intent intent1 = new Intent(MainActivity.this, ActivityBjdc.class);
				setTitle("±±¾©µ¥³¡");
				startActivity(intent1);
			}
		};
		
		listener2 = new OnClickListener() {
			public void onClick(View v) {
				Intent intent0 = new Intent(MainActivity.this, ActivityJclq.class);
				setTitle("¾º²ÊÀºÇò");
				startActivity(intent0);
			}
		};
		setContentView(R.layout.activity_main);
		button0 = (Button) findViewById(R.id.button2jczq);
		button0.setOnClickListener(listener0);
		button1 = (Button) findViewById(R.id.button2bjdc);
		button1.setOnClickListener(listener1);
		button2 = (Button) findViewById(R.id.button2jclq);
		button2.setOnClickListener(listener2);
    }

    
}
