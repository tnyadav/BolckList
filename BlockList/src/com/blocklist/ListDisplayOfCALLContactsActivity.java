package com.blocklist;

import java.util.ArrayList;
import java.util.Iterator;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListDisplayOfCALLContactsActivity extends Activity implements OnItemClickListener, OnClickListener 
{
	Button but_add,but_cancel;
	private ListView listView;
	ArrayList<ContactsDetails> listArrayContacts=null;
	ArrayList<ContactsDetails> addRemoveContacts =null;
	Intent i;
	private DBAdapter contentDataSource = null;
	private Context mContext;
	ArrayList<String> listOfContacts =null;
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.call_contact_list);
		
		listView = (ListView)findViewById(R.id.listView);
		
		listOfContacts=new ArrayList<String>();
		mContext = this;
		
		 	but_add = (Button) findViewById(R.id.but_add);
	        but_add.setOnClickListener(this);
	         
	        but_cancel = (Button) findViewById(R.id.but_cancel);
	        but_cancel.setOnClickListener(this);
		contentDataSource = new DBAdapter(mContext);
		
		contentDataSource.open();
		System.out.println("Database opened and displaycontacts()");
		displayContacts();
		contentDataSource.close();
		listView.setTextFilterEnabled(true);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setOnItemClickListener(this);
		
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,listOfContacts));
	}

		
	

	
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		// TODO Auto-generated method stub
		
		
		if(listView.isItemChecked(position)==true)
		{
			
			System.out.println(listView.isItemChecked(position)+" in true");
			
			addRemoveContacts.add(listArrayContacts.get(position));
			//System.out.println("item add in array to store database"+addRemoveContacts.iterator().toString());
			
		}
		
		if(listView.isItemChecked(position)==false)
		{
			System.out.println(listView.isItemChecked(position)+" in false");
			addRemoveContacts.remove(listArrayContacts.get(position));
			
		}

		
	}
	
	public void onClick(View view)
	{    
              	
		switch(view.getId()) {
	    case R.id.but_add:
	    	contentDataSource.open();
	    	Iterator<ContactsDetails> iterateList = addRemoveContacts.iterator();
			
			while (iterateList.hasNext()) 
			{  
				ContactsDetails contactsDetails = (ContactsDetails) iterateList.next();
				System.out.println(contactsDetails.getContactName());
				System.out.println(contactsDetails.getContactNo());
				contentDataSource.insertCallContact(contactsDetails.getContactNo(),contactsDetails.getContactName());
			}
			contentDataSource.close();
			Toast.makeText(ListDisplayOfCALLContactsActivity.this,"Contacts Added To The Unwanted CALL Blacklist!!",Toast.LENGTH_LONG).show();
			finish();
		     i=new Intent(getApplicationContext(),blocked_call_list.class);
			  startActivity(i);
	      break;
	   case R.id.but_cancel:
	      finish();
	      i=new Intent(getApplicationContext(),blocked_call_list.class);
		  startActivity(i);
	      
	      break;
	   
	      }
			
		
			
	}
	void displayContacts() {
	    addRemoveContacts=new ArrayList<ContactsDetails>(); 
		listArrayContacts = new ArrayList<ContactsDetails>();
	    	ContentResolver cr = null;
			try {
				cr = getContentResolver();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println(""+e1);
			}
	        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
	                null, null, null, null);
	    	System.out.println("curcer size is "+cur.getCount());
	    	int contactsize=cur.getCount();
	        if (contactsize > 0) {
	        	
	        	int i=0;
	        	while (cur.moveToNext()) {
	        		String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
	        	
	        		String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
	//name**********************************************
	        		
	        		//System.out.println("name is "+name);
	        		if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
	                     Cursor pCur = cr.query(
	                    		 ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
	                    		 null, 
	                    		 ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", 
	                    		 new String[]{id}, null);
	                     while (pCur.moveToNext()) {
	                    	
	                    	 String phoneNo = null;
							try {
//number*********************************
								phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
								
								listOfContacts.add(name+ "\n"+phoneNo );
								
								ContactsDetails contacts = getContacts(name, phoneNo);
								
								listArrayContacts.add(contacts);

							//	System.out.println("name is "+phoneNo);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								System.out.println(""+e);
								e.printStackTrace();
							}
	                    	
	                
	                     } 
	      	        pCur.close();
	      	    }
	        		i++;
	        	}
	        }
	    }
	private ContactsDetails getContacts(String name, String phoneNo)
	{
		// TODO Auto-generated method stub
		 ContactsDetails contacts = new ContactsDetails();
		 contacts.setContactName(name);
		 contacts.setContactNo(phoneNo);
		
		return contacts;
	}



	
	
	 
	@Override
	protected void onPause() 
	{
		
		super.onPause();
		
		
	}
}
