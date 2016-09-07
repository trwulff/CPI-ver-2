
package org.usfirst.frc.team1405.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import cpi.Set;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Set <Double[]> dASet;
	Set<Double> dSet;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        System.out.println ("robotInit");
        Double D []={1.0,2.,3.};
        System.out.println ("Robot - #"+cpi.tools.SetBase.lineNumber());
        dASet=new Set<Double[]>("Table","Name1",D);
        System.out.println ("Robot - #"+cpi.tools.SetBase.lineNumber());
        System.out.println("dASet= ("+dASet.Value()[0]+", "+dASet.Value()[1]+", "+dASet.Value()[2]+")");
        Double Di=5.;
        dSet=new Set<Double>("Table","Name2",Di);
        System.out.println("dSet="+dSet.Value());
        System.out.println ("End robotInit");
        
        
        
        
    }
    
	/**
	 */
    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
