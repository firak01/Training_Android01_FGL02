package de.fgl.tryout.android.training001;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class DisplayMessageActivity extends ActionBarActivity { //Activity

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//++++++++++++++++++++++++++++++++++++++++++++++
		// Get the message from the intent
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		//++++++++++++++++++++++++++++++++++++++++++++++
		int iColor;
		String alarmMessagePrefix = "Alarm";
		if(message.startsWith(alarmMessagePrefix)){
			iColor = Color.RED;
		}else{
			iColor = Color.GRAY;
		}
		
		//FGL: Check System Version at Runtime
				if ( Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB){
					//FGL: Aktiviere den Home / UP Button 
//					android.support.v7.app.ActionBar actionBar = getSupportActionBar();  //funktioniert nur in einer ActionBarActivity
//					actionBar.setDisplayHomeAsUpEnabled(true);
//					
//					//Style den Hintergrund		
//					actionBar.setBackgroundDrawable(new ColorDrawable(iColor)); // set your desired color
				}else{
		Log.d("FGLTEST", "Methode sDisplayActivity.onCreate(..) - minSdkVersion is 11 or higher.");
					
					// If your minSdkVersion is 11 or higher, instead use:
					android.app.ActionBar actionBar = getActionBar();
					if(actionBar==null){
						//TODO GOO 20160818: Warum ist Action Bar NULL?
						Log.d("FGLTEST", "Methode sDisplayActivity.onCreate(..) - action bar IS NULL.");
						
					}else{
					Log.d("FGLTEST", "Methode sDisplayActivity.onCreate(..) - action bar not null.");
					
					actionBar.setDisplayHomeAsUpEnabled(true);
					
					//Style den Hintergrund			
					actionBar.setBackgroundDrawable(new ColorDrawable(iColor)); // set your desired color
					}		
				}
					
			
		
		
		
		// Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText(message);

	    // Set the text view as the activity layout
	    setContentView(textView);

	    //FGL: Wenn man die View im Layout-Editor erstellt, kann man eine ID vergeben, die hier benutzt werden kann. 
	    //Initialize member TextView so we can manipulate it later
	    //mTextView = (TextView) findViewById(R.id.text_message);
		//setContentView(R.layout.activity_display_message);

		if (savedInstanceState == null) {
//			getSupportFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	//Wird für diese App nicht benötigt
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.display_message, menu);
//		return true;
//	}

	//FGL: Training/Adding the Action Bar / Adding Action Buttons
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
		
		// Handle presses on the action bar items
	    switch (id) {
	        case R.id.action_search:
	            openSearch();
	            return true;
	        case R.id.action_settings:
	            openSettings();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	
	private void openSettings() {
		// TODO Auto-generated method stub
		
	}

	private void openSearch() {
		// TODO Auto-generated method stub
		
	}

	//Folgendes wird nicht benötigt:
	/**
	 * A placeholder fragment containing a simple view.
	 */
//	public static class PlaceholderFragment extends Fragment {
//
//		public PlaceholderFragment() {
//		}
//
//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container,
//				Bundle savedInstanceState) {
//			View rootView = inflater.inflate(R.layout.fragment_display_message,
//					container, false);
//			return rootView;
//		}
//	}

	//FGL für neue Buttons in der Action Bar notwendig
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.display_message, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	//FGL für die Reaktion auf neue Buttons in der ActionBar notwendig
	
}
