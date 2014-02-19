package com.blocklist;
 
 
 
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
 
 
 
public class setting extends Activity {
 
    /** Called when the activity is first created. */
	  SharedPreferences sharedPreferences ;
	  TextView txt_sms;
	  TextView txt_call;
	  TextView txt_circle;
	  TextView txt_operator;
    @Override
 
    public void onCreate(Bundle savedInstanceState) {
 
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.setting);
        CheckBox chk_sms =( CheckBox ) findViewById( R.id.cb_sms );
        CheckBox chk_call =( CheckBox ) findViewById( R.id.cb_call );
        CheckBox chk_circle =( CheckBox ) findViewById( R.id.cb_circle );
        CheckBox chk_operator =( CheckBox ) findViewById( R.id.cb_operator );
        
        txt_sms =( TextView ) findViewById( R.id.txt_sms );
        txt_call =( TextView ) findViewById( R.id.txt_call );
        txt_circle =( TextView ) findViewById( R.id.txt_circle );
        txt_operator =( TextView ) findViewById( R.id.txt_operator );
        
        sharedPreferences = getSharedPreferences("BlockedList",0);
       
        
        if(sharedPreferences.getString("SMS", "").equals("disabled"))
        {
            chk_sms.setChecked(false);
            txt_sms.setText("Your SMS Blacklist is "+sharedPreferences.getString("SMS", ""));
        }
        else
        {
        	chk_sms.setChecked(true);
        	txt_sms.setText("Your SMS Blacklist is "+sharedPreferences.getString("SMS", ""));
        }
      
        if(sharedPreferences.getString("CALL", "").equals("disabled"))
        {
        
            chk_call.setChecked(false);
            txt_call.setText("Your Call Blacklist is "+sharedPreferences.getString("CALL", ""));
        }
        else
        {
        	chk_call.setChecked(true);
        	txt_call.setText("Your Call Blacklist is "+sharedPreferences.getString("CALL", ""));
        }
       
        if(sharedPreferences.getString("CIRCLE", "").equals("disabled"))
        {
        
            chk_circle.setChecked(false);
            txt_circle.setText("Your Circle Blacklist is "+sharedPreferences.getString("CIRCLE", ""));
        }
        else
        {
        	chk_circle.setChecked(true);
        	txt_circle.setText("Your Circle Blacklist is "+sharedPreferences.getString("CIRCLE", ""));
        }
        if(sharedPreferences.getString("OP", "").equals("disabled"))
        {
        
            chk_operator.setChecked(false);
            txt_operator.setText("Your Operator Blacklist is "+sharedPreferences.getString("OP", ""));
        }
        else
        {
        	chk_operator.setChecked(true);
        	txt_operator.setText("Your Operator Blacklist is "+sharedPreferences.getString("OP", ""));
        }
        //Toast.makeText(setting.this,"SMS Blocking "+sharedPreferences.getString("SMS", "")+"&"+"CALL Blocking "+sharedPreferences.getString("CALL", ""),Toast.LENGTH_LONG).show();
        chk_sms.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                	sharedPreferences.edit().putString("SMS","enabled").commit();
                	txt_sms.setText("Your SMS Blacklist is "+sharedPreferences.getString("SMS", ""));
                	
                }
                else
                {
                	sharedPreferences.edit().putString("SMS","disabled").commit();
                	txt_sms.setText("Your SMS Blacklist is "+sharedPreferences.getString("SMS", ""));
                	
                }

            }
        });
        chk_call.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                	sharedPreferences.edit().putString("CALL","enabled").commit();
                	txt_call.setText("Your Call Blacklist is "+sharedPreferences.getString("CALL", ""));
                }
                else
                {
                	sharedPreferences.edit().putString("CALL","disabled").commit();
                	txt_call.setText("Your Call Blacklist is "+sharedPreferences.getString("CALL", ""));
                	
                }

            }
        });
        chk_circle.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                	sharedPreferences.edit().putString("CIRCLE","enabled").commit();
                	txt_circle.setText("Your Circle Blacklist is "+sharedPreferences.getString("CIRCLE", ""));
                }
                else
                {
                	sharedPreferences.edit().putString("CIRCLE","disabled").commit();
                	txt_circle.setText("Your Circle Blacklist is "+sharedPreferences.getString("CIRCLE", ""));
                	
                }

            }
        });
        chk_operator.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                	sharedPreferences.edit().putString("OP","enabled").commit();
                	txt_operator.setText("Your Operator Blacklist is "+sharedPreferences.getString("OP", ""));
                }
                else
                {
                	sharedPreferences.edit().putString("OP","disabled").commit();
                	txt_operator.setText("Your Operator Blacklist is "+sharedPreferences.getString("OP", ""));
                	
                }

            }
        });
    }
 
}