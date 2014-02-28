package com.tn.database;

import java.util.ArrayList;
import java.util.List;

import com.tn.beans.ContactBlockSetting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class BlockListDatabaseHelper {

	
	  private SQLiteDatabase sqLiteDatabase;
	  private BlockListDatabase blockListDatabase;
	  private final String[] ALL_COLUMNS =  new String[] {
				BlockListDatabase.BLOCK_COLUMN_CONTACT_PHONE_NO,
				BlockListDatabase.BLOCK_COLUMN_CONTACT_NAME,
				BlockListDatabase.IS_INCOMING_CALL_BLOCKED,
				BlockListDatabase.IS_OUTGOING_CALL_BLOCKED,
				BlockListDatabase.IS_INCOMING_SMS_BLOCKED,
				BlockListDatabase.IS_OUTGOING_SMS_BLOCKED,
				BlockListDatabase.IS_SCHEDULE_CALL_BLOCKED,
				BlockListDatabase.IS_SCHEDULE_SMS_BLOCKED,
				BlockListDatabase.CALL_SCHEDULE_BLOCK_START_TIME,
				BlockListDatabase.CALL_SCHEDULE_BLOCK_END_TIME,
				BlockListDatabase.SMS_SCHEDULE_BLOCK_START_TIME,
				BlockListDatabase.SMS_SCHEDULE_BLOCK_END_TIME
	  };

	  public BlockListDatabaseHelper(Context context) {
		  blockListDatabase = new BlockListDatabase(context);
		  }

	  public void open() throws SQLException {
		  sqLiteDatabase = blockListDatabase.getWritableDatabase();
	  }

	  public void close() {
		  sqLiteDatabase.close();
	  }
	  
	  public long insertBlockContact(ContactBlockSetting contactBlockSetting) 
		{
			ContentValues values = getContantValue(contactBlockSetting);
				
			long insertId = sqLiteDatabase.insert(BlockListDatabase.TABLE_BLOCK_LIST, null, values);
			
			return insertId;
		}
	  

	  public ContactBlockSetting getSettingForNumber(String number) {
			
			ContactBlockSetting contactBlockSetting = null;
			String whereClause = BlockListDatabase.BLOCK_COLUMN_CONTACT_PHONE_NO+"="+number; 
			
			Cursor cursor = sqLiteDatabase.query(true,
					BlockListDatabase.TABLE_BLOCK_LIST, ALL_COLUMNS, whereClause, null,
	                null, null, null, null);

			if (cursor.moveToFirst()) {
				
					contactBlockSetting=getContactBlockSettingfromCursor(cursor);
				
			}

			cursor.close();

			return contactBlockSetting;
			
		}
	  public int updateContactBlockSetting(ContactBlockSetting contactBlockSetting) {
		  
		  String whereClause = BlockListDatabase.BLOCK_COLUMN_ID+"="+contactBlockSetting.getContactId(); 
		  ContentValues contentValues=getContantValue(contactBlockSetting);
		  return sqLiteDatabase.update(BlockListDatabase.TABLE_BLOCK_LIST, contentValues, whereClause, null);

		
	  }
	  public int deleteContactBlockSetting(ContactBlockSetting contactBlockSetting) {
		    String whereClause = BlockListDatabase.BLOCK_COLUMN_ID+"="+contactBlockSetting.getContactId(); 
		   return sqLiteDatabase.delete(BlockListDatabase.TABLE_BLOCK_LIST,whereClause,null);
	  }
	  
	 public List<ContactBlockSetting> getAllCallContacts() {
		List<ContactBlockSetting> ContactBlockSettingList = new ArrayList<ContactBlockSetting>();

		Cursor cursor = sqLiteDatabase.query(true,
				BlockListDatabase.TABLE_BLOCK_LIST, ALL_COLUMNS, null, null,
				null, null, BlockListDatabase.BLOCK_COLUMN_CONTACT_NAME, null);

		if (cursor.moveToFirst()) {
			do {
				ContactBlockSettingList
						.add(getContactBlockSettingfromCursor(cursor));
			} while (cursor.moveToNext());
		}

		cursor.close();

		return ContactBlockSettingList;
	}

	public ContactBlockSetting getContactBlockSettingfromCursor(Cursor cursor) {
		
		ContactBlockSetting contactBlockSetting = new ContactBlockSetting();
		contactBlockSetting.setContactId(cursor.getInt(cursor.getColumnIndex(BlockListDatabase.BLOCK_COLUMN_ID)));
		contactBlockSetting.setContactNumber(cursor.getString(cursor.getColumnIndex(BlockListDatabase.BLOCK_COLUMN_CONTACT_PHONE_NO)));
		contactBlockSetting.setContactName(cursor.getString(cursor.getColumnIndex(BlockListDatabase.BLOCK_COLUMN_CONTACT_NAME)));
		
		contactBlockSetting.setIncomingCallBlocked(getBooleanfromInt(cursor.getInt(cursor.getColumnIndex(BlockListDatabase.IS_INCOMING_CALL_BLOCKED))));
		contactBlockSetting.setOutgoingCallBlocked(getBooleanfromInt(cursor.getInt(cursor.getColumnIndex(BlockListDatabase.IS_OUTGOING_CALL_BLOCKED))));
		
		contactBlockSetting.setIncomingSmsBlocked(getBooleanfromInt(cursor.getInt(cursor.getColumnIndex(BlockListDatabase.IS_INCOMING_SMS_BLOCKED))));
		contactBlockSetting.setOutgoingSmsBlocked(getBooleanfromInt(cursor.getInt(cursor.getColumnIndex(BlockListDatabase.IS_OUTGOING_SMS_BLOCKED))));
		
		contactBlockSetting.setScheduleCallBlocked(getBooleanfromInt(cursor.getInt(cursor.getColumnIndex(BlockListDatabase.IS_SCHEDULE_CALL_BLOCKED))));
		contactBlockSetting.setScheduleSmsBlocked(getBooleanfromInt(cursor.getInt(cursor.getColumnIndex(BlockListDatabase.IS_SCHEDULE_SMS_BLOCKED))));
		
		contactBlockSetting.setCallScheduleBlockStartTime(cursor.getInt(cursor.getColumnIndex(BlockListDatabase.CALL_SCHEDULE_BLOCK_START_TIME)));
		contactBlockSetting.setCallScheduleBlockEndTime(cursor.getInt(cursor.getColumnIndex(BlockListDatabase.CALL_SCHEDULE_BLOCK_END_TIME)));
		
		contactBlockSetting.setSmsScheduleBlockStartTime(cursor.getInt(cursor.getColumnIndex(BlockListDatabase.SMS_SCHEDULE_BLOCK_START_TIME)));
		contactBlockSetting.setSmsScheduleBlockEndTime(cursor.getInt(cursor.getColumnIndex(BlockListDatabase.SMS_SCHEDULE_BLOCK_END_TIME)));
		
		return contactBlockSetting;

	}
  private ContentValues getContantValue(ContactBlockSetting contactBlockSetting) {
	
	ContentValues values = new ContentValues();
	
	values.put(BlockListDatabase.BLOCK_COLUMN_CONTACT_PHONE_NO, contactBlockSetting.getContactNumber());
	values.put(BlockListDatabase.BLOCK_COLUMN_CONTACT_NAME, contactBlockSetting.getContactName());
	
	values.put(BlockListDatabase.IS_INCOMING_CALL_BLOCKED, getIntFromBoolean(contactBlockSetting.isIncomingCallBlocked()));
	values.put(BlockListDatabase.IS_OUTGOING_CALL_BLOCKED, getIntFromBoolean(contactBlockSetting.isOutgoingCallBlocked()));
	
	values.put(BlockListDatabase.IS_INCOMING_SMS_BLOCKED, getIntFromBoolean(contactBlockSetting.isIncomingSmsBlocked()));
	values.put(BlockListDatabase.IS_OUTGOING_SMS_BLOCKED, getIntFromBoolean(contactBlockSetting.isOutgoingSmsBlocked()));
	
	values.put(BlockListDatabase.IS_SCHEDULE_CALL_BLOCKED, getIntFromBoolean(contactBlockSetting.isScheduleCallBlocked()));
	values.put(BlockListDatabase.IS_SCHEDULE_SMS_BLOCKED, getIntFromBoolean(contactBlockSetting.isScheduleSmsBlocked()));
	
	values.put(BlockListDatabase.CALL_SCHEDULE_BLOCK_END_TIME, contactBlockSetting.getCallScheduleBlockStartTime());
	values.put(BlockListDatabase.CALL_SCHEDULE_BLOCK_END_TIME, contactBlockSetting.getCallScheduleBlockEndTime());
	
	values.put(BlockListDatabase.SMS_SCHEDULE_BLOCK_START_TIME, contactBlockSetting.getSmsScheduleBlockStartTime());
	values.put(BlockListDatabase.SMS_SCHEDULE_BLOCK_END_TIME, contactBlockSetting.getSmsScheduleBlockEndTime());
	return values;
  }
	
	
	private int getIntFromBoolean(boolean b) {

		if (b) {
			return 1;
		} else {
			return 0;
		}

	}

	private boolean getBooleanfromInt(int i) {

		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}
}