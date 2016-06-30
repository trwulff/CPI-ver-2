package cpi;

import cpi.tools.SetMaster;

public class Set <Type> extends SetMaster <Type> {
	public Set(String table,String name,Type Default){
		super(table,name,Default,true);
	}

}
