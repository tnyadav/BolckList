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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
 
 
 
public class blocked_operator_list extends Activity implements OnClickListener {
 
    Intent i;
    MobileCircleDatabase db;
    DBAdapter db1;
    ListView myList;
    Context context;
    Button but_save,but_cancel;
    TextView txt_empty;
    
 
    /** Called when the activity is first created. */
 
    @Override
 
    public void onCreate(Bundle savedInstanceState) {
 
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.blocked_operator_list);
        context=this;
        myList = (ListView)findViewById(R.id.listViewcircle);
 
       
         
        but_save = (Button) findViewById(R.id.but_save);
        but_save.setOnClickListener(this);
        
        but_cancel = (Button) findViewById(R.id.but_cancel);
        but_cancel.setOnClickListener(this);
        txt_empty = (TextView) findViewById(R.id.txt_empty);
        
        db1 = new DBAdapter(this);
        db = new MobileCircleDatabase(this);
       
        updateList();
    }



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()) {
	   
	    case R.id.but_save:
	    	 String selected = "";
	    	 int cntChoice = myList.getCount();
	    	 db.open();
	    	 List<String> Blocked_Operators = db.getAllOperators();
	    	 List<String> Blocked_OperatorsDesc = db.getAllOperatorsDesc();
             SparseBooleanArray sparseBooleanArray = myList.getCheckedItemPositions();

             if(sparseBooleanArray.size()==0)
             {
            	 Toast.makeText(blocked_operator_list.this,"Please select operators to save!!",Toast.LENGTH_LONG).show(); 
             }
             else
             {
            	
            	 db1.open();
            	 db1.delete_Saved_Operators();
            	 for(int i = 0; i < cntChoice; i++)
            	 {

                     if(sparseBooleanArray.get(i)) 
                     {

                         selected += Blocked_OperatorsDesc.get(i).toString() + "\n";
                         db1.insertOperator(Blocked_Operators.get(i).toString(), Blocked_OperatorsDesc.get(i).toString());
                      }

                 }
                 Toast.makeText(blocked_operator_list.this,selected+"Selected",Toast.LENGTH_LONG).show();
                 db1.close();
             }
             db.close();
           
		      break;
	    case R.id.but_cancel:
	      finish();
	      break;
	   
	      }
	}
	public void  updateList() 
	{
		  	db.open();
	        List<String> Blocked_OperatorsDesc = db.getAllOperatorsDesc();
	        
		      if(Blocked_OperatorsDesc.size()<1)
		      {
		    	 myList.setVisibility(View.GONE);
		    	 but_save.setEnabled(false);
		    	 txt_empty.setVisibility(View.VISIBLE);
		      }
		      else
		      {
		    	  txt_empty.setVisibility(View.GONE);
		    	  but_save.setEnabled(true);
	        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,Blocked_OperatorsDesc);
	        myList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	 
	        myList.setAdapter(adapter);
	        db.close();
	        db1.open();
	       
	        List<String> Blocked_Operators1 = db1.getSavedOperatorsName();
	       if(Blocked_Operators1.size()>0)
	       {
	        for(int i = 0; i < Blocked_OperatorsDesc.size(); i++)
	        { 
	        	 for(int j = 0; j < Blocked_Operators1.size(); j++)
			        {
		        	 if(Blocked_OperatorsDesc.get(i).toString().equals(Blocked_Operators1.get(j).toString()))
					  {
						  myList.setItemChecked(i, true);  
					  }
			        }
	        	
	        }
	       }
	       db1.close();
		  }
		  
		
	}
 
}