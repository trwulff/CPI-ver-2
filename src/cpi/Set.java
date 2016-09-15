package cpi;

import cpi.tools.SetBase;
/**
 * 
 * @author twulf
 *
 * @param <Type>
 */
public class  Set <Type> extends SetBase <Type> {
	/**
	 * 
	 * @param table
	 * @param key
	 * @param Default
	 */
	public Set(String table,String key,Type Default){
		super(table,key,Default,true);
	}

}
