package cpi;

import cpi.tools.SetBase;
/**
 * 
 * @author Thomas Wulff
 *
 *
 * @param <Type>
 * Type is the generic type parameter for this class. 
 * Type can be one of the following:
 * Boolean
 * Double
 * String
 * Boolean[]
 * Double[]
 * String[]
 * 
 */
public class  Set <Type> extends SetBase <Type> {
	/**
	 * Title may be modified to suit the user. eg within the Robot Class the initial statement before any instantiation of Set or Net
	 * cpi.tools.Constants.TITLE="Team 1405 Robot (2017)";
	 */
		public static String TITLE="Robot";
	/**
	 * Set extends SetBase.
	 * Set can share data of type Type with other devices such as the driver Station laptop through the NetworkTables Class.
	 * The Set values are persistant. They can be changed in OnlineViewer or custom programs and will remain set to the new values when the code is rebooted.
	 * Set values cannot be modified when Hard Code is set (true). Hard code values are used instead.
	 * 
	 * @param table
	 * table identifies the subtable name of the master robot tabele neme specified in class cpi.tools.Constants.TITLE .
	 * eg. If Constants.TITLE = "Robot" and table = "Name1", the full table path name is "Robot/Name1"
	 * Slashes(/) may be used to define tables of subtables.
	 * @param key
	 * key is the final key identifier of type Type. Do not use / (slash) as part of key
	 * @param Default
	 * Default is the initial value of the set parameter with type Type.
	 */
	public Set(String table,String key,Type Default){
		super(table,key,Default,true);
	}
	/**
	 * 
	 * @param hardCodeValue
	 * false - use stored settings (default)
	 * true - use settings in tools HCconstants.java
	 * 
	 */
	public static void SetHardCode(boolean hardCodeValue){
		isHardCode=hardCodeValue;
	}

}
