import robocode.DeathEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;
import robocode.HitRobotEvent;

import java.awt.*;

import robocode.*;
 
public class MaxCoders extends AlphaBot {
	
	boolean peek; 
	double moveAmount; 
	
    public void run() {
		
		setBodyColor(Color.orange);
		setGunColor(Color.black);
		setRadarColor(Color.yellow);
		setBulletColor(Color.red);
		setScanColor(Color.green);
		
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		
		peek = false;

		
		turnLeft(getHeading() % 90);
		ahead(moveAmount);
		// Turn the gun to turn right 90 degrees.
		peek = true;
		turnGunRight(90);
		turnRight(90);
		
		
        while (true) {
           // ahead(100);
            //turnGunRight(360);
				peek = true;
			// Move up the wall
			ahead(moveAmount);
			// Don't look now
			peek = false;
			// Turn to the next wall
			turnRight(90);
			
           // back(100);
            //turnGunRight(360);
        }
    }
 
    /*public void onScannedRobot(ScannedRobotEvent e) {
        fire(1);
    }*/ 
	
	public void onHitRobot(HitRobotEvent e) {
		
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			back(100);
		} 
		else {
			ahead(100);
		}
	}
	
	
	
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(2);
		
		if (peek) {
			scan();
		}
	}
	
	/*public void onHitByBullet(HitByBulletEvent e) {
		turnLeft(90 - e.getBearing());
	}*/
	
	
}
