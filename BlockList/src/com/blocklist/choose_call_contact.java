package com.blocklist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
 
public class choose_call_contact extends Activity {
	ListView listView;
	 Intent i;
	String[] values = new String[] {"Choose From Contacts", "Add Manually"};
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.choose_call_contact);
	         
	        listView = (ListView)findViewById(R.id.listView);
	     
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	        android.R.layout.simple_list_item_1, values);
	        // Assign adapter to ListView
	        listView.setAdapter(adapter); 
	        
	        listView.setOnItemClickListener(new OnItemClickListener() {
	          @Override
	          public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
	        	  
	        	  if(listView.getAdapter().getItem(position).equals("Choose From Contacts"))
	        	  {
	        		  
	     	         //Toast.makeText(getApplicationContext(),listView.getAdapter().getItem(position)+"selected", Toast.LENGTH_LONG).show();
	     	        finish();
	        		i=new Intent(getApplicationContext(),ListDisplayOfCALLContactsActivity.class);
	      			startActivity(i); 
	        	  }
	        	  else
	        	  {
	        		  
	     	         //Toast.makeText(getApplicationContext(),listView.getAdapter().getItem(position)+"selected", Toast.LENGTH_LONG).show();
	     	        finish();
	        		i=new Intent(getApplicationContext(),add_call_contact.class);
	      			startActivity(i); 
	        	  }
	         }
	      });
	    }
	}