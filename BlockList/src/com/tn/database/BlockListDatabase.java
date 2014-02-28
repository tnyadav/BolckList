package com.tn.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BlockListDatabase extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "MyContacts.db";
	private static final int DATABASE_VERSION = 1;

	public static final String TABLE_BLOCK_LIST = "TableBlockList";
	public static final String BLOCK_COLUMN_ID = "_id";
	public static final String BLOCK_COLUMN_CONTACT_NAME = "contatName";
	public static final String BLOCK_COLUMN_CONTACT_PHONE_NO = "contactPhoneNo";
	public static final String IS_INCOMING_CALL_BLOCKED = "isIncomingCallBlocked";
	public static final String IS_OUTGOING_CALL_BLOCKED = "isOutgoingCallBlocked";
	public static final String IS_INCOMING_SMS_BLOCKED = "isIncomingSmsBlocked";
	public static final String IS_OUTGOING_SMS_BLOCKED = "isOutgoingSmsBlocked";

	public static final String IS_SCHEDULE_CALL_BLOCKED = "isScheduleCallBlocked";
	public static final String IS_SCHEDULE_SMS_BLOCKED = "isScheduleSmsBlocked";
	public static final String CALL_SCHEDULE_BLOCK_START_TIME = "callScheduleBlockStartTime";
	public static final String CALL_SCHEDULE_BLOCK_END_TIME = "callScheduleBlockEndTime";
	public static final String SMS_SCHEDULE_BLOCK_START_TIME = "smsScheduleBlockStartTime";
	public static final String SMS_SCHEDULE_BLOCK_END_TIME = "smsScheduleBlockEndTime";

	private static final String CREATE_BLOCK_LIST_TABLE = " create table "
			
			+ TABLE_BLOCK_LIST + " (" + BLOCK_COLUMN_ID + " integer primary key autoincrement, "
			+ BLOCK_COLUMN_CONTACT_PHONE_NO + " text , "
			+ BLOCK_COLUMN_CONTACT_NAME + " text," 
			
			+ IS_INCOMING_CALL_BLOCKED + " integer," 
			+ IS_OUTGOING_CALL_BLOCKED + " integer,"
			
			+ IS_INCOMING_SMS_BLOCKED + " integer,"
			+ IS_OUTGOING_SMS_BLOCKED + " integer," 
			
			+ IS_SCHEDULE_CALL_BLOCKED + " integer,"
			+ IS_SCHEDULE_SMS_BLOCKED + " integer,"

			+ CALL_SCHEDULE_BLOCK_START_TIME + " integer,"
			+ CALL_SCHEDULE_BLOCK_END_TIME + " integer,"
			
			+ SMS_SCHEDULE_BLOCK_START_TIME + " integer,"
			+ SMS_SCHEDULE_BLOCK_END_TIME + " integer);";

	BlockListDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		sqLiteDatabase.execSQL(CREATE_BLOCK_LIST_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int arg1, int arg2) {
		sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_BLOCK_LIST_TABLE);
	}

}
