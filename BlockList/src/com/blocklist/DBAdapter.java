package com.blocklist;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
	
	
	private final Context mCtx;
	private DatabaseHelper mDbHelper;
	private static SQLiteDatabase mDb;
	
	private static final String DATABASE_NAME = "MyContacts.db";
	private static final int DATABASE_VERSION = 1;
     //for contact
	public static final String TABLE_SMSLIST = "TABLE_SMSLIST";
	public static final String SMSCOLUMN_ID = "_id";
	public static final String SMSCOLUMN_CONTACT_NAME = "CONTACT_NAME";
	public static final String SMSCOLUMN_CONTACT_PHONENO="CONTACT_PHONENO";
	
	public static final String TABLE_CALLLIST = "TABLE_CALLLIST";
	public static final String CALLCOLUMN_ID = "_id";
	public static final String CALLCOLUMN_CONTACT_NAME = "CONTACT_NAME";
	public static final String CALLCOLUMN_CONTACT_PHONENO="CONTACT_PHONENO";
	
	public static final String TABLE_CLIST = "TABLE_CLIST";
	public static final String CCOLUMN_ID = "_id";
	public static final String CCOLUMN_CIRCLE = "CIRCLE_NAME";
	public static final String CCOLUMN_DESC="CIRCLE_DESC";
	
	public static final String TABLE_OLIST = "TABLE_OLIST";
	public static final String OCOLUMN_ID = "_id";
	public static final String OCOLUMN_OP = "OP_NAME";
	public static final String OCOLUMN_DESC="OP_DESC";
	public static final String DISTINCT="DISTINCT";
	
	private static final String DBTABLE_SMS = " create table " + TABLE_SMSLIST + " (" 
			+ SMSCOLUMN_ID + " integer primary key autoincrement, " 
			+  SMSCOLUMN_CONTACT_PHONENO+ " text , "
			+  SMSCOLUMN_CONTACT_NAME+ " text );";
	
	private static final String DBTABLE_CALL = " create table " + TABLE_CALLLIST + " (" 
	+ CALLCOLUMN_ID + " integer primary key autoincrement, " 
	+ CALLCOLUMN_CONTACT_PHONENO + " text , "
	+ CALLCOLUMN_CONTACT_NAME+ " text);";
	
	private static final String DBTABLE_CIRCLE = " create table " + TABLE_CLIST + " (" 
	+ CCOLUMN_ID + " integer primary key autoincrement, " 
	+ CCOLUMN_CIRCLE + " text , "
	+ CCOLUMN_DESC+ " text);";
	
	private static final String DBTABLE_OPERATOR = " create table " + TABLE_OLIST + " (" 
	+ OCOLUMN_ID + " integer primary key autoincrement, " 
	+ OCOLUMN_OP + " text , "
	+ OCOLUMN_DESC+ " text);";
	
	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			
			db.execSQL(DBTABLE_SMS);
			
			db.execSQL(DBTABLE_CALL);
			
			db.execSQL(DBTABLE_CIRCLE);
			db.execSQL(DBTABLE_OPERATOR);
			System.out.println("Table created"+DBTABLE_SMS+""+DBTABLE_CIRCLE);
			
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_SMSLIST);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALLLIST);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIST);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_OLIST);
			onCreate(db);
		}
		
	}

	
	public DBAdapter(Context ctx) {
		this.mCtx = ctx;
	}
	
	public DBAdapter open() throws SQLException {
		mDbHelper = new DatabaseHelper(mCtx);
		mDb = mDbHelper.getWritableDatabase();
		mDb = mDbHelper.getReadableDatabase();
		System.out.println("Database opened");
		return this;
	}
	
	public void close() {
		mDbHelper.close();
		mDb.close();
		System.out.println("Database closed");
	}

	
	public long insertSmsContact(String phoneno,String name) 
	{
		ContentValues values = new ContentValues();
		values.put(SMSCOLUMN_CONTACT_PHONENO, phoneno);
		values.put(SMSCOLUMN_CONTACT_NAME, name);
			
		long insertId = mDb.insert(TABLE_SMSLIST, null, values);
		
		return insertId;
	}
	public long insertCallContact(String phoneno,String name) 
	{
		ContentValues values = new ContentValues();
		values.put(CALLCOLUMN_CONTACT_PHONENO, phoneno);
		values.put(CALLCOLUMN_CONTACT_NAME, name);
		
			
		long insertId = mDb.insert(TABLE_CALLLIST, null, values);
		
		return insertId;
	}
	
	public long insertCircle(String circle,String desc) 
	{
		ContentValues values = new ContentValues();
		values.put(CCOLUMN_CIRCLE, circle);
		values.put(CCOLUMN_DESC, desc);
			
		long insertId = mDb.insert(TABLE_CLIST, null, values);
		
		return insertId;
	}
	
	public long insertOperator(String operator,String desc) 
	{
		ContentValues values = new ContentValues();
		values.put(OCOLUMN_OP, operator);
		values.put(OCOLUMN_DESC, desc);
			
		long insertId = mDb.insert(TABLE_OLIST, null, values);
		
		return insertId;
	}
	public List<String> getAllSmsContacts()
	{
		List<String> contactRecords = new ArrayList<String>();
		Cursor cursor =mDb.query(true,TABLE_SMSLIST, new String[] {SMSCOLUMN_CONTACT_PHONENO,SMSCOLUMN_CONTACT_NAME}, null, null, SMSCOLUMN_CONTACT_PHONENO, null, null, null);
		///Cursor cursor = mDb.rawQuery("SELECT DISTINCT(CONTACT_PHONENO),CONTACT_NAME FROM " +TABLE_SMSLIST, null);

		
	        if (cursor.moveToFirst()) 
	        {
	            do {
	            	contactRecords.add(cursor.getString(1).toString()+"\n"+cursor.getString(0).toString());
	            	//System.out.println("in getAllSmsContacts() sms method"+cursor.getString(1).toString()+"\n"+cursor.getString(0).toString());
	            } while (cursor.moveToNext());
	        }
	        
	        cursor.close();
	       
		return contactRecords;
	}
	
	public List<String> getAllSmsNumbers()
	{
		List<String> contactRecords = new ArrayList<String>();

		//Cursor cursor = mDb.rawQuery("SELECT DISTINCT(CONTACT_PHONENO),CONTACT_NAME FROM " +TABLE_SMSLIST, null);
		Cursor cursor =mDb.query(true,TABLE_SMSLIST, new String[] {SMSCOLUMN_CONTACT_PHONENO,SMSCOLUMN_CONTACT_NAME}, null, null, SMSCOLUMN_CONTACT_PHONENO, null, null, null);
		
	        if (cursor.moveToFirst()) 
	        {
	            do {
	            	contactRecords.add(cursor.getString(0).toString());
	            	// System.out.println("in getAllSmsNumbers()sms method"+cursor.getString(0).toString());
	            } while (cursor.moveToNext());
	        }
	        
	        cursor.close();
	       
		return contactRecords;
	}
	
	public List<String> getSavedCirclesDesc()
	{
		List<String> contactRecords = new ArrayList<String>();

		Cursor cursor = mDb.rawQuery("SELECT * FROM " +TABLE_CLIST, null);

		
	        if (cursor.moveToFirst()) 
	        {
	            do {
	            	contactRecords.add(cursor.getString(2).toString());
	            	
	            } while (cursor.moveToNext());
	        }
	        
	        cursor.close();
	       
		return contactRecords;
	}
	
	public List<String> getSavedOperatorsName()
	{
		List<String> contactRecords = new ArrayList<String>();

		Cursor cursor = mDb.rawQuery("SELECT * FROM " +TABLE_OLIST, null);

		
	        if (cursor.moveToFirst()) 
	        {
	            do {
	            	contactRecords.add(cursor.getString(2).toString());
	            	
	            } while (cursor.moveToNext());
	        }
	        
	        cursor.close();
	       
		return contactRecords;
	}
	public void delete_Sms_Contact(String strNumber)
	{
		 //System.out.println("in del sms method"+strNumber);
		
		mDb.delete(TABLE_SMSLIST,SMSCOLUMN_CONTACT_PHONENO + "='" + strNumber +"'",null);
		
	}

	public List<String> getAllCallContacts()
	{
		List<String> contactRecords = new ArrayList<String>();

		//Cursor cursor = mDb.rawQuery("SELECT DISTINCT(CONTACT_PHONENO),CONTACT_NAME FROM " +TABLE_CALLLIST, null);
		Cursor cursor =mDb.query(true,TABLE_CALLLIST, new String[] {CALLCOLUMN_CONTACT_PHONENO,CALLCOLUMN_CONTACT_NAME}, null, null, CALLCOLUMN_CONTACT_PHONENO, null, null, null);

		
	        if (cursor.moveToFirst()) 
	        {
	            do {
	            	contactRecords.add(cursor.getString(1).toString()+"\n"+cursor.getString(0).toString());
	            	//System.out.println("in getAllCallContacts() method"+cursor.getString(1).toString()+"\n"+cursor.getString(0).toString());
	            } while (cursor.moveToNext());
	        }
	        
	        cursor.close();
	       
		return contactRecords;
	}
	
	public List<String> getAllCallNumbers()
	{
		List<String> contactRecords = new ArrayList<String>();

		//Cursor cursor = mDb.rawQuery("SELECT DISTINCT(CONTACT_PHONENO),CONTACT_NAME FROM " +TABLE_CALLLIST, null);
		Cursor cursor =mDb.query(true,TABLE_CALLLIST, new String[] {CALLCOLUMN_CONTACT_PHONENO,CALLCOLUMN_CONTACT_NAME}, null, null, CALLCOLUMN_CONTACT_PHONENO, null, null, null);
		
	        if (cursor.moveToFirst()) 
	        {
	            do {
	            	contactRecords.add(cursor.getString(0).toString());
	            	//System.out.println("in getAllCallNumbers() method"+cursor.getString(0).toString());
	            } while (cursor.moveToNext());
	        }
	        
	        cursor.close();
	       
		return contactRecords;
	}
	public void delete_Call_Contact(String strNumber)
	{
		//System.out.println("in del call method"+strNumber);
		mDb.delete(TABLE_CALLLIST,CALLCOLUMN_CONTACT_PHONENO + "='" + strNumber +"'",null);
		
	}
	
	public void delete_Saved_Circles()
	{
		
		mDb.delete(TABLE_CLIST,null,null);
		
	}
	public void delete_Saved_Operators()
	{
		
		mDb.delete(TABLE_OLIST,null,null);
		
	}
	
	
	
}

	

