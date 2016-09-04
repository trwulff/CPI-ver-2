package cpi.tools;

import edu.wpi.first.wpilibj.networktables.*;
import java.util.Arrays;

public class  SetMaster {

	Object  Default;
	Object  DefaultArray[];
	String className;
	Object value;
	Object valueArray[];
	boolean isArray=false;
	boolean isLocked=false;
	boolean isFirst=true;
	static boolean isHerdCode=true;
	boolean isPersistent;
	public static String TITLE="Robot";
	String tableName;
	String key;
	public static final String SEPARATOR= Character.toString( NetworkTable.PATH_SEPARATOR);
	NetworkTable table;
	
// Begin Constructors
	public SetMaster(String table,String key,Object Default,boolean setPersistance)
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
			className=className.substring(0, className.length()-2);
			System.out.println(className);
		}else{
			isArray=false;
		}
		this.table=NetworkTable.getTable(TITLE+"/"+tableName);
		System.out.println ("SetMaster - #"+lineNumber());
		value=this.table.getValue(this.key, this.Default);
		this.table.putValue(key, value);
		System.out.println ("SetMaster - #"+lineNumber());
		
	}	
	// End of Constructors	
	


	public Object Value(){
		return value;
	}	

	public Object[] ValueArray(){
		return valueArray;
	}	
	public Object Value(Object value){
			if(value==this.value)return this.value;
		this.value=value;
		table.putValue(key, this.value);
		return this.value;
	}	
	public Object[] ValueArray(Object value,int element){
		
		table.putValue(key, valueArray);
		return this.valueArray;
	}
	
	public void Lock(boolean setLocked){
		isLocked=setLocked;
	}

	public static int lineNumber(){
		return Thread.currentThread().getStackTrace()[2].getLineNumber();
	}
}