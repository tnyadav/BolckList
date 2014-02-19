package com.blocklist;




import java.util.List;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

public class MainActivity extends Activity implements OnClickListener{
Button but_call,but_sms,but_set,but_operator,but_circle;
Intent i;
SharedPreferences sharedPreferences ;
public DBAdapter db;

Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        context=this;
        but_call = (Button) findViewById(R.id.but_call);
        but_call.setOnClickListener(this);
        
        but_sms = (Button) findViewById(R.id.but_sms);
        but_sms.setOnClickListener(this);
        
        but_set = (Button) findViewById(R.id.but_set);
        but_set.setOnClickListener(this);
        
        but_operator = (Button) findViewById(R.id.but_operator);
        but_operator.setOnClickListener(this);
        
        but_circle = (Button) findViewById(R.id.but_circle);
        but_circle.setOnClickListener(this);
        
        sharedPreferences = getSharedPreferences("BlockedList",0);
       
        if(sharedPreferences.getString("SMS", "").equals(""))
        {
        
           sharedPreferences.edit().putString("SMS","disabled").commit();
          
        }
       
        if(sharedPreferences.getString("CALL", "").equals(""))
        {
        
           sharedPreferences.edit().putString("CALL","disabled").commit();
           
        }
        
        if(sharedPreferences.getString("CIRCLE", "").equals(""))
        {
        
           sharedPreferences.edit().putString("CIRCLE","disabled").commit();
           
        }
        
        if(sharedPreferences.getString("OP", "").equals(""))
        {
        
           sharedPreferences.edit().putString("OP","disabled").commit();
           
        }
        
        db=new DBAdapter(context);
        db.open();
       
        
        List<String> Blocked_OperatorDesc = db.getSavedOperatorsName();
        for(int i = 0; i < Blocked_OperatorDesc.size(); i++)
        { 
		   System.out.println("arr["+i+"] = "+Blocked_OperatorDesc.get(i));
        	
        }
        db.close();
      
       
}

    @Override
    public void onBackPressed()
    {
        new AlertDialog.Builder(this)
               .setMessage("Are you sure you want to exit?")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                   }
               })
               .setNegativeButton("No", null)
               .show();
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		 case R.id.but_circle:
	    	   i=new Intent(getApplicationContext(),blocked_circle_list.class);
				startActivity(i);
	    	   break;
	       case R.id.but_sms:
	    	   i=new Intent(getApplicationContext(),blocked_sms_list.class);
				startActivity(i);
	    	   break;
	       case R.id.but_call:
	    	   i=new Intent(getApplicationContext(),blocked_call_list.class);
				startActivity(i);
	    	   break;
	       case R.id.but_set:
	    	   i=new Intent(getApplicationContext(),setting.class);
				startActivity(i);
	    	   break;
	       case R.id.but_operator:
	    	   i=new Intent(getApplicationContext(),blocked_operator_list.class);
				startActivity(i);
	    	   break;
	}
	}
	@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
	        switch (keyCode) {
	        case KeyEvent.KEYCODE_HOME:
	          Toast.makeText(context, "home clicked", 1).show();
	        }
	    }
			return false;
			
		}
	@Override
		public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
	        switch (keyCode) {
	        case KeyEvent.KEYCODE_HOME:
	        	  Toast.makeText(context, "home long press", 1).show();
	        }
	    }
		return false;
		}
}
