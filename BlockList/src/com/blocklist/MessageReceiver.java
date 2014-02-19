package com.blocklist;

import java.util.List;
import java.util.Vector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.util.Log;

@SuppressWarnings("deprecation")
public class MessageReceiver extends BroadcastReceiver {
	
        private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
        //private String yourNumber = "+919555853674";
        public DBAdapter db;
        MobileCircleDatabase dbc;
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if (intent.getAction().equals(SMS_RECEIVED)) 
		{
            Log.v("MySMS", intent.getAction());
            Bundle bundle = intent.getExtras();
            if (bundle != null)
            {
                Object[] pdus = (Object[]) bundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                if (messages.length > -1) 
                {
                    String no = messages[0].getDisplayOriginatingAddress();
                    Log.v("MySMS", no);
                    
                    db=new DBAdapter(context);
         		   	
                    dbc=new MobileCircleDatabase(context);
                    
         		 SharedPreferences sharedPreferences = context.getSharedPreferences("BlockedList",0);
         	       
                 if(sharedPreferences.getString("SMS", "").equals("enabled"))
                 {
                	db.open();
            		List<String> Blocked_SMSNo = db.getAllSmsNumbers();
         		  for(int i = 0; i < Blocked_SMSNo.size(); i++)
      	          { 
         			 System.out.println("arr["+i+"] = " +"+91"+ Blocked_SMSNo.get(i).substring(Blocked_SMSNo.get(i).length()-10,Blocked_SMSNo.get(i).length()));
         			
         			 if (no != null && no.trim().equals("+91"+ Blocked_SMSNo.get(i).substring(Blocked_SMSNo.get(i).length()-10,Blocked_SMSNo.get(i).length())))
         			 {
                        this.abortBroadcast();
                    }
                 }
         		 db.close();
                }
                 if(sharedPreferences.getString("CIRCLE", "").equals("enabled"))
 		        {
 		          
 		           dbc.open();
 		           db.open();
 		  	       List<String> Blocked_Circle = db.getSavedCirclesDesc();
 		  	       Vector<String> loc = dbc.getLocation(no.trim().substring(3,7));
 					
 					String output;
 					if(loc != null && loc.size() == 3) {
 						output = loc.get(0);
 					} else {
 						output = "No result found";
 					}
 				   for(int i = 0; i < Blocked_Circle.size(); i++)
 			        { 
 					  if(output.equals(Blocked_Circle.get(i).toString()))
 			 		   {
 						 this.abortBroadcast();
 			 		   }
 			        }
 				   dbc.close();
 				   db.close();
 		           }
                
                 if(sharedPreferences.getString("OP", "").equals("enabled"))
   		        {
   		          
   		           dbc.open();
   		           db.open();
   		  	       List<String> Blocked_OperatorsDesc = db.getSavedOperatorsName();
   		  	       Vector<String> loc = dbc.getLocation(no.trim().substring(3,7));
   					
   					String output;
   					if(loc != null && loc.size() == 3) {
   						output = loc.get(1);
   					} else {
   						output = "No result found";
   					}
   				   for(int i = 0; i < Blocked_OperatorsDesc.size(); i++)
   			        { 
   					  if(output.equals(Blocked_OperatorsDesc.get(i).toString()))
   			 		   {
   						 this.abortBroadcast();
   			 		   }
   			        }
   				   dbc.close();
   				   db.close();
   		           }
              }
          }
	    }
	}
}
