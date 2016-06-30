package cpi.tools;

import edu.wpi.first.wpilibj.networktables.*;

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
	String table;
	String key;
	public static final String SEPARATOR= Character.toString( NetworkTable.PATH_SEPARATOR);
	
// Begin Constructors
	public SetMaster(String table,String key,Type Default,boolean setPersistance)
	{
		if(isFirst){
			// Initialize NetworkTables here
			isFirst=false;
		}
		this.Default=Default;
		this.table=table;
		this.key=key;
		isPersistent=setPersistance;
		className=Default.getClass().getSimpleName();
		System.out.println(className);


		value=Default;
		if(className.contains("[]")){
			isArray=true;
			className=className.substring(0, className.length()-2);
			System.out.println(className);
		}else{
			isArray=false;
		}
		
	}	
	// End of Constructors	
	


	public Type Value(){
		return value;
	}	
	public Type Value(Type value){
		this.value=value;
		return this.value;
	}	
	public Type Value(Object value,int element){
		if(isArray){
			Object[] tmp=(Object[])this.value;
			tmp[element]=value;
			this.value=(Type)tmp;
		}else{
			this.value=(Type)value;
		}
		return this.value;
	}
	
	public void Lock(boolean setLocked){
		isLocked=setLocked;
	}

}