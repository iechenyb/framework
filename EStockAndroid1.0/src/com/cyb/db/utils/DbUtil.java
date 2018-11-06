package com.cyb.db.utils;

import com.cyb.db.bean.Person;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbUtil extends SQLiteOpenHelper {
	public DbUtil(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	public  SQLiteDatabase getReadDb(){
		 return this.getReadableDatabase();
	}
	public  SQLiteDatabase getWriteDb(){		
		 return this.getWritableDatabase();
	}
	public void createTable(){
		this.getWriteDb().execSQL("drop table if exists person");
		this.getWriteDb().execSQL("create table person(_id integer primary key autoincrement"
				+ ",name varchar,password smallint)");
	}
	public void addPerson(Person p){
		this.getWriteDb().execSQL("insert into person values(null,?,?)",new Object[]{p.getName(),p.getPassword()});
	}
	public void delPerson(String id){
		this.getWriteDb().delete("person", "age = ?", new String[]{id});
	}
	public boolean getPersonByNameAndPassword(Person p){
		Cursor c = 	this.getReadDb().rawQuery("select * from person where name = ? and password = ? ", new String[]{p.getName(),p.getPassword()});
		int count = c.getCount();
		if(count==0){
			return false;
		}else{
			return true;
		}
	}
	public void displayPerson(){
		Cursor c = this.getReadDb().rawQuery("select * from person ", null);
		while(c.moveToNext()){
			int _id = c.getInt(c.getColumnIndex("_id"));
			String name = c.getString(c.getColumnIndex("name"));
			String password = c.getString(c.getColumnIndex("password"));
			System.out.println(_id+"#"+name+"#"+password);
		}
	}
	
	public boolean hasTable(String tabName){
		String sql ="select count(*)  from sqlite_master where type='table' and name = ? ";
		Cursor c = this.getReadDb().rawQuery(sql,new String[]{tabName});
		int count = c.getCount();
		if(count<=0){
			return false;
		}else{
			return true;
		}
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table if not exists  person(_id integer primary key autoincrement"
				+ ",name varchar,password smallint)");
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {		
	}
}
