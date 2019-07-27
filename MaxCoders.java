

import java.awt.*;

import robocode.*;
 
public class MaxCoders extends BravoBot {
	
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
		peek = true;
		turnGunRight(90);
		turnRight(90);
		
		
        while (true) {
           // ahead(100);
            //turnGunRight(360);
				peek = true;
			
			ahead(moveAmount);
			
			peek = false;
			
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
		if(getEnergy()>20)
			fire(3);
		else
			fire(1);
		
		if (peek) {
			scan();
		}
	}
	
	/*public void onHitByBullet(HitByBulletEvent e) {
		turnLeft(90 - e.getBearing());
	}*/
	
	
}
