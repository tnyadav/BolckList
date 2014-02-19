package com.blocklist;
 


import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
 
import android.os.Bundle;
 
import android.util.SparseBooleanArray;
 
import android.view.View;
import android.view.View.OnClickListener;
 
import android.widget.ArrayAdapter;
import android.widget.TextView;
 
import android.widget.Button;
 
import android.widget.ListView;
 
import android.widget.Toast;
 
 
 
public class blocked_call_list extends Activity implements OnClickListener {
 
     Intent i;
     public DBAdapter db;
    ListView myList;
    Context context;
    Button but_add,but_del,but_cancel;
    TextView txt_empty;
    
 
    /** Called when the activity is first created. */
 
    @Override
 
    public void onCreate(Bundle savedInstanceState) {
 
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.blocked_call_list);
        context=this;
        myList = (ListView)findViewById(R.id.listViewcall);
 
        but_add = (Button) findViewById(R.id.but_add);
        but_add.setOnClickListener(this);
         
        but_del = (Button) findViewById(R.id.but_del);
        but_del.setOnClickListener(this);
        
        but_cancel = (Button) findViewById(R.id.but_cancel);
        but_cancel.setOnClickListener(this);
 
        txt_empty = (TextView) findViewById(R.id.txt_empty);
        db=new DBAdapter(context);
        updateList();
    }



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()) {
	    case R.id.but_add:
	    	finish();
	    	i=new Intent(getApplicationContext(),choose_call_contact.class);
			startActivity(i);
	      break;
	    case R.id.but_del:
	    	 String selected = "";
	    	 int cntChoice = myList.getCount();
	    	 db.open();
	    	 List<String> Blocked_CALLNo = db.getAllCallNumbers();
             SparseBooleanArray sparseBooleanArray = myList.getCheckedItemPositions();
             if(sparseBooleanArray.size()==0)
             {
            	 Toast.makeText(blocked_call_list.this,"Please select a contact to delete!!",Toast.LENGTH_LONG).show(); 
             }
             else
             {
             for(int i = 0; i < cntChoice; i++){

                 if(sparseBooleanArray.get(i)) {

                     selected += Blocked_CALLNo.get(i).toString() + "\n";
                	 
                	 db.delete_Call_Contact(Blocked_CALLNo.get(i).toString());
                 }

             }
             Toast.makeText(blocked_call_list.this,selected+"Deleted",Toast.LENGTH_LONG).show();
             }
             db.close();
             updateList();
		      break;
	    case R.id.but_cancel:
	      finish();
	      break;
	   
	      }
	}
	public void  updateList() 
	{
		  db.open();
	        List<String> Blocked_CALL = db.getAllCallContacts();
	        db.close();
		      if(Blocked_CALL.size()<1)
		      {
		    	 myList.setVisibility(View.GONE);
		    	 but_del.setEnabled(false);
		    	 txt_empty.setVisibility(View.VISIBLE);
		      }
		      else
		      {
		    	  txt_empty.setVisibility(View.GONE);
		    	  but_del.setEnabled(true);
	        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,Blocked_CALL);
	        myList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	 
	        myList.setAdapter(adapter);
	 
		      }
		    
	}
 
}