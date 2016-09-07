package cpi.tools;

import edu.wpi.first.wpilibj.networktables.*;
import edu.wpi.first.wpilibj.tables.*;
import java.util.Arrays;

public class  SetBase <Type>{

	Type  Default;
	Object  DefaultArray[];
	String className;
	Type value;
	Type HCvalue;
	boolean isArray=false;
	boolean isLocked=false;
	boolean isTempUnlocked=false;
	boolean isFirst=true;
	static boolean isHerdCode=true;
	boolean isPersistent;
	String tableName;
	String key;
	NetworkTable table;
	NetworkTable HCconstantsTable;
	public static NetworkTable HCtable=NetworkTable.getTable(Constants.TITLE);
	
// Begin Listeners
	ITableListener listener=new ITableListener(){
		public void valueChanged(ITable Table, String str, Object obj, boolean bool){
			if((isHerdCode&&isPersistent||isLocked)&& !isTempUnlocked){
				obj=(Object)value;
				table.putValue(key, value);
				return;
			}
			isTempUnlocked=false;
			value=(Type)obj;
		}
	};
	ITableListener HClistener=new ITableListener(){
		public void valueChanged(ITable Table, String str, Object obj, boolean bool){
			isHerdCode=(boolean)obj;
		}
	};
	ITableListener HCconstantsTablelistener=new ITableListener(){
		public void valueChanged(ITable Table, String str, Object obj, boolean bool){
			obj=(Object)HCvalue;
		}
	};
// End Listeners
	
// Begin Constructor
	public SetBase(String table,String key,Type Default,boolean setPersistance)
	{
		if(isFirst){ // this is done once upon  the first instanciation
			// Initialize NetworkTables here
	        NetworkTable.initialize();
	        HCtable.putBoolean(Constants.HC_KEY, true);
	        HCtable.clearPersistent(Constants.HC_KEY);
	        HCtable.addTableListener(Constants.HC_KEY, HClistener, true);
			isFirst=false;
			HCconstants.set();
		}
			// End done once
		
		this.Default=Default;
		tableName=table;
		this.key=key;
		isPersistent=setPersistance;
		className=Default.getClass().getSimpleName();

		if(className.contains("[]")){
			isArray=true;
		}else{
			isArray=false;
		}
		this.table=NetworkTable.getTable(Constants.TITLE+"/"+tableName);
		this.table.addTableListener(this.key, listener, true);
		tempLock();
		value=getValue(this.key, this.Default);
		this.table.putValue(key, value);
		if(isPersistent){
			this.table.setPersistent(this.key);
			
		}
		else{
			this.table.clearPersistent(this.key);
		}
		HCconstantsTable=NetworkTable.getTable(Constants.TITLE+"/"+Constants.HC_TABLE+"/"+tableName);
		HCvalue=(Type) HCconstantsTable.getValue(this.key, this.Default);
		HCconstantsTable.addTableListener(this.key, HCconstantsTablelistener, true); // Permanently locked
	}	
	// End of Constructor	
	


	public Type Value(){
		return value;
	}	

	public Type Value(Type value){
		this.value=value;
		table.putValue(key, this.value);
		return this.value;
	}
	
	public void Lock(boolean setLocked){
		isLocked=setLocked;
	}	
	public void tempLock(){
		isTempUnlocked=true;
	}
	
	public void addListener(ITableListener listener){
		table.addTableListener(key, listener, true);
	}
	public void addHCListener(ITableListener listener){
		HCtable.addTableListener(key, listener, true);
	}

	public static int lineNumber(){
		return Thread.currentThread().getStackTrace()[2].getLineNumber();
	}
	Type getValue(String key, Type defaultValue){
		Type tmpValue=Default;
		switch(className){

		case "Boolean[]":
			tmpValue=(Type)table.getBooleanArray(key, (Boolean[])defaultValue);
			break;
		case "Double[]":
			tmpValue=(Type)table.getNumberArray(key, (Double[])defaultValue);
			break;
		case "String[]":
			tmpValue=(Type)table.getStringArray(key, (String[])defaultValue);
			break;
		default:
			tmpValue=(Type)table.getValue(key, (Type)defaultValue);
		}
		return tmpValue;
	}
}