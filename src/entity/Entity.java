package entity;

import java.awt.image.BufferedImage;

public class Entity {

	public int x, y;
	public int speed;
	
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	
	//This counter is used to switch the image to give the entity some animation
	public int entityCounter = 0;
	
	//These keeps track of what image is being displayed for the entity
	public int entityImageNum = 1;
}
