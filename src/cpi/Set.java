package cpi;

import cpi.tools.SetMaster;

public class Set <Type> extends SetMaster <Type> {
	public Set(String name,Type Default []){
		super(name,Default,true);
		System.out.println("Set Constructor #1");
	}
	public Set(String name,Type Default){
		super(name,Default,true);
		System.out.println("Set Constructor #2");
	}

}
