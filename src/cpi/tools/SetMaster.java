package cpi.tools;

import edu.wpi.first.wpilibj.networktables.*;
import java.util.Arrays;

public class  SetMaster <Type>{
	
	Type  Default=(Type)new Object();
	String className;
	Type value;
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
	public SetMaster(String table,String key,Type Default,boolean setPersistance)
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
		System.out.println ("SetMaster - #46");
		value=(Type)this.table.getValue(this.key, (Object)this.Default);
//		value = this.Default;
		System.out.println ("SetMaster - #48");
	}	
	// End of Constructors	
	


	public Type Value(){
		return value;
	}	
	public Type Value(Type value){
		if(isArray){
			if(Arrays.equals ((Object[])value, (Object[])this.value))return this.value;
		}
		else{
			if(value==this.value)return this.value;
		}
		this.value=value;
		table.putValue(key, this.value);
		return this.value;
	}	
	public Type Value(Object value,int element){
		if(isArray){
			Object[] tmp=(Object[])this.value;
			if(tmp[element]==value)return this.value;
			tmp[element]=value;
			this.value=(Type)tmp;
		}else{
			this.value=(Type)value;
		}
		table.putValue(key, this.value);
		return this.value;
	}
	
	public void Lock(boolean setLocked){
		isLocked=setLocked;
	}

}