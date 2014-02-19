package com.blocklist;
 


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
 
import android.os.Bundle;
 
import android.view.View;
import android.view.View.OnClickListener;
 
import android.widget.EditText;
import android.widget.Button;
 
import android.widget.Toast;
 
 
 
public class add_sms_contact extends Activity implements OnClickListener {
 
     Intent i;
     public DBAdapter db;
    
    Context context;
    Button but_add,but_cancel;
    EditText edt_contactNo,edt_contactName;
    
 
    /** Called when the activity is first created. */
 
    @Override
 
    public void onCreate(Bundle savedInstanceState) {
 
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.add_sms_contact);
        context=this;
        
        but_add = (Button) findViewById(R.id.but_add);
        but_add.setOnClickListener(this);
        
        but_cancel = (Button) findViewById(R.id.but_cancel);
        but_cancel.setOnClickListener(this);

        edt_contactNo = (EditText) findViewById(R.id.edt_contactNo);
        edt_contactName = (EditText) findViewById(R.id.edt_contactName);
       
        db=new DBAdapter(context);
     }



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()) {
	    case R.id.but_add:
	    	if(edt_contactNo.getText().length()<10||edt_contactName.getText().length()<1)
	    	{
			    Toast.makeText(add_sms_contact.this,"Please Fill Name and Number(10 digits)!!",Toast.LENGTH_LONG).show();
	    	}
	    	else
	    	{
	    	db.open();
	    	db.insertSmsContact(edt_contactNo.getText().toString(),edt_contactName.getText().toString());
		    db.close();
		    Toast.makeText(add_sms_contact.this,"Contact Added To The Unwanted SMS Blacklist!!",Toast.LENGTH_LONG).show();
		    finish();
	        i=new Intent(getApplicationContext(),blocked_sms_list.class);
		     startActivity(i);
	    	}
	      break;
	    
	    case R.id.but_cancel:
	    	finish();
		    i=new Intent(getApplicationContext(),blocked_sms_list.class);
			startActivity(i);
	      break;
	   
	      }
	}
	 
}