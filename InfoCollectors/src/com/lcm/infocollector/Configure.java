package com.lcm.infocollector;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Configure extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configure);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.configure, menu);
		return true;
	}

}
