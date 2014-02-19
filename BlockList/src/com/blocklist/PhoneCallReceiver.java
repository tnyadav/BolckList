package com.blocklist;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;

import com.android.internal.telephony.ITelephony;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;

import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneCallReceiver extends BroadcastReceiver {
	 Context context = null;
	 private static final String TAG = "Phone call";
	 private ITelephony telephonyService;
	 String incommingNumber;
	 public DBAdapter db;
	 private AudioManager amanager;
	 MobileCircleDatabase dbc;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void onReceive(Context context, Intent intent)
	{/*
		// TODO Auto-generated method stub
		 Log.v(TAG, "Receving....");
		 Bundle b = intent.getExtras();
			
			if(null == b)
				return;
			
			incommingNumber = b.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
		    
			String state = b.getString(TelephonyManager.EXTRA_STATE);
			
			if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING))
			{
				
				TelephonyManager telephony = (TelephonyManager) 
				  context.getSystemService(Context.TELEPHONY_SERVICE);  
				  try {
				   Class c = Class.forName(telephony.getClass().getName());
				   Method m = c.getDeclaredMethod("getITelephony");
				   m.setAccessible(true);
				   telephonyService = (ITelephony) m.invoke(telephony);
				  
				   db=new DBAdapter(context);
				   dbc = new MobileCircleDatabase(context);
				   amanager= (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
			       SharedPreferences sharedPreferences = context.getSharedPreferences("BlockedList",0);
			       
		        if(sharedPreferences.getString("CALL", "").equals("enabled"))
		        {
		           db.open();
		  	       List<String> Blocked_CALLNo = db.getAllCallNumbers();
				   for(int i = 0; i < Blocked_CALLNo.size(); i++)
			        { 
			        	System.out.println("call "+"arr["+i+"] = " +"+91"+ Blocked_CALLNo.get(i).substring(Blocked_CALLNo.get(i).length()-10,Blocked_CALLNo.get(i).length()));
			       	if(incommingNumber.equals("+91"+Blocked_CALLNo.get(i).substring(Blocked_CALLNo.get(i).length()-10,Blocked_CALLNo.get(i).length())))
			 		   {
			       		   int ringerMode=amanager.getRingerMode();
			       		   amanager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			       		   telephonyService.endCall();
			 			   this.abortBroadcast();
			 			   //Thread.sleep(2000);
			 			   amanager.setRingerMode(ringerMode);
			 		   }
			        }
				   db.close();
		           }
		        if(sharedPreferences.getString("CIRCLE", "").equals("enabled"))
		        {
		          
		           dbc.open();
		           db.open();
		  	       List<String> Blocked_Circle = db.getSavedCirclesDesc();
		  	       Vector<String> loc = dbc.getLocation(incommingNumber.substring(3,7));
					
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
			       		   int ringerMode=amanager.getRingerMode();
			       		   amanager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			       		   telephonyService.endCall();
			 			   this.abortBroadcast();
			 			   //Thread.sleep(2000);
			 			   amanager.setRingerMode(ringerMode);
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
		  	       Vector<String> loc = dbc.getLocation(incommingNumber.substring(3,7));
					
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
			       		   int ringerMode=amanager.getRingerMode();
			       		   amanager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			       		   telephonyService.endCall();
			 			   this.abortBroadcast();
			 			   //Thread.sleep(2000);
			 			   amanager.setRingerMode(ringerMode);
			 		   }
			        }
				   dbc.close();
				   db.close();
		           }
				  }
		         catch (Exception e)
		          {
				   e.printStackTrace();
				
				  }
				
			}
				 
		 
	   */
		
	disconnectCall();
	}
	public void disconnectCall(){
		 try {

		    String serviceManagerName = "android.os.ServiceManager";
		    String serviceManagerNativeName = "android.os.ServiceManagerNative";
		    String telephonyName = "com.android.internal.telephony.ITelephony";
		    Class<?> telephonyClass;
		    Class<?> telephonyStubClass;
		    Class<?> serviceManagerClass;
		    Class<?> serviceManagerNativeClass;
		    Method telephonyEndCall;
		    Object telephonyObject;
		    Object serviceManagerObject;
		    telephonyClass = Class.forName(telephonyName);
		    telephonyStubClass = telephonyClass.getClasses()[0];
		    serviceManagerClass = Class.forName(serviceManagerName);
		    serviceManagerNativeClass = Class.forName(serviceManagerNativeName);
		    Method getService = // getDefaults[29];
		    serviceManagerClass.getMethod("getService", String.class);
		    Method tempInterfaceMethod = serviceManagerNativeClass.getMethod("asInterface", IBinder.class);
		    Binder tmpBinder = new Binder();
		    tmpBinder.attachInterface(null, "fake");
		    serviceManagerObject = tempInterfaceMethod.invoke(null, tmpBinder);
		    IBinder retbinder = (IBinder) getService.invoke(serviceManagerObject, "phone");
		    Method serviceMethod = telephonyStubClass.getMethod("asInterface", IBinder.class);
		    telephonyObject = serviceMethod.invoke(null, retbinder);
		    telephonyEndCall = telephonyClass.getMethod("endCall");
		    telephonyEndCall.invoke(telephonyObject);

		  } catch (Exception e) {
		    e.printStackTrace();
		 Log.e("Exception", ""+e);
		 }
		}
	}
