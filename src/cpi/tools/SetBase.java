package cpi.tools;

import edu.wpi.first.wpilibj.networktables.*;
import java.util.Arrays;

public class  SetBase <Type>{

	Type  Default;
	Object  DefaultArray[];
	String className;
	Type value;
	Object valueArray[];
	boolean isArray=false;
	boolean isLocked=false;
	boolean isFirst=true;
	static boolean isHerdCode=true;
	boolean isPersistent;
	String tableName;
	String key;
	NetworkTable table;
	
// Begin Constructors
	public SetBase(String table,String key,Type Default,boolean setPersistance)
	{
		if(isFirst){ // this is done once upon  the first instanciation
			// Initialize NetworkTables here
	        NetworkTable.initialize();
			isFirst=false;
		}
		this.Default=Default;
		tableName=table;
		this.key=key;
		isPersistent=setPersistance;
		className=Default.getClass().getSimpleName();
		System.out.println(className);


		if(className.contains("[]")){
			isArray=true;
		}else{
			isArray=false;
		}
		this.table=NetworkTable.getTable(Constants.TITLE+"/"+tableName);
		value=(Type)this.table.getValue(this.key, this.Default);
		this.table.putValue(key, value);
		System.out.println ("SetBase - #"+lineNumber());
		
	}	
	// End of Constructors	
	


	public Type Value(){
		return value;
	}	

	public Type Value(Type value){
			if(value==this.value)return this.value;
		this.value=value;
		table.putValue(key, this.value);
		return this.value;
	}
	
	public void Lock(boolean setLocked){
		isLocked=setLocked;
	}

	public static int lineNumber(){
		return Thread.currentThread().getStackTrace()[2].getLineNumber();
	}
}