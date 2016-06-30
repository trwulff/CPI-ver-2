package cpi.tools;

public class  SetMaster <Type>{
	
	Object [] Default=new Object[1];
	Type [] array;
	String className;
	boolean isArray;
	Type value;
	
// Begin Constructors
	public SetMaster(String name,Type Default [],boolean setPersistance)
	{
		this.Default=Default;
		className=Default.getClass().getSimpleName();
		isArray=true;
		Constructor(name,this.Default,setPersistance);
	}
	public SetMaster(String name,Type Default,boolean setPersistance)
	{
		this.Default[0]=Default;
		className=Default.getClass().getSimpleName();
		isArray=false;
		Constructor(name,this.Default,setPersistance);
	}
	
// End of Constructors	
	
	protected void Constructor(String name,Object Default [],boolean setPersistance)
	{
		System.out.println(Default[0]);
		System.out.println(className);
		
	}
	protected void typeCheck(){
		
	}

	public Type Value(){
		return value;
	}	
	public Type Value(Type value){
		this.value=value;
		return this.value;
	}
	public Type [] Array(){	
		return array;
	}	
	public Type [] Array(Type [] value){
		this.array=value;
		return this.array;
	}
	public Type  Element(int item){	
		return array[item];
	}	
	public Type Element(int item, Type value){
		this.array[item]=value;
		return this.array[item];
	}


}