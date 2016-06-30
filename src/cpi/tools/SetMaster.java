package cpi.tools;

public class  SetMaster <Type>{
	
	Type  Default=(Type)new Object();
	String className;
	Type value;
	boolean isArray;
	
// Begin Constructors
	public SetMaster(String name,Type Default,boolean setPersistance)
	{
		this.Default=Default;
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
	
	
	
	protected void typeCheck(){
		
	}

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

	// End of Constructors	
}