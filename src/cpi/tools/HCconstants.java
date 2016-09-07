package cpi.tools;


import edu.wpi.first.wpilibj.networktables.NetworkTable;
import cpi.tools.Constants;

public class HCconstants {
	public static final void set(){
		NetworkTable.getTable(Constants.TITLE+"/"+Constants.HC_TABLE+"/"+"Table3").putBoolean("Key1", true);
	}

}
