package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import laucher.GamePanel;
import laucher.InputHandler;

public class Player extends Entity {

	GamePanel gp;
	InputHandler userInput;
	int playerCounter;
	
	public Player(GamePanel gp, InputHandler userInput) {
		this.gp = gp;
		this.userInput = userInput;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/walkUp1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/walkUp2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/walkDown1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/walkDown2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/walkLeft1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/walkLeft2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/walkRight1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/walkRight2.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		//Updates player's position based on key pressed
		if(userInput.upKey == true || userInput.downKey == true || userInput.leftKey == true || userInput.rightKey == true)
		{
				if(userInput.upKey == true) {
					direction = "up";
					y -= speed; 
				}
				else if(userInput.downKey == true) {
					direction = "down";
					y += speed;
				}
				else if(userInput.leftKey == true) {
					direction = "left";
					x -= speed;
				}
				else if(userInput.rightKey == true) {
					direction = "right";
					x += speed;
				}
				
				entityCounter++;
				if(entityCounter > 10)
				{
					if(entityImageNum == 1)
					{
						entityImageNum = 2;
					} else if(entityImageNum == 2)
					{
						entityImageNum = 1;
					}
					entityCounter = 0;
				}
		}
	}
	
	public void draw(Graphics2D g2) {
		
		//g2.setColor(Color.blue);
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(entityImageNum == 1)
			{
				image = up1;
			}
			if(entityImageNum == 2)
			{
				image = up2;
			}
			break;
		case "down":
			if(entityImageNum == 1)
			{
				image = down1;
			}
			if(entityImageNum == 2)
			{
				image = down2;
			}
			break;
		case "left":
			if(entityImageNum == 1)
			{
				image = left1;
			}
			if(entityImageNum == 2)
			{
				image = left2;
			}
			break;
		case "right":
			if(entityImageNum == 1)
			{
				image = right1;
			}
			if(entityImageNum == 2)
			{
				image = right2;
			}
			break;			
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
	}
}
