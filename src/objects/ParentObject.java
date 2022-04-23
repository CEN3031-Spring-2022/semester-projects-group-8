package objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import laucher.GamePanel;

public class ParentObject {
	public BufferedImage image;
	public String name;
	public int x, y;
	
	public void draw(Graphics2D g2, GamePanel game) {
		g2.drawImage(image, this.x, this.y, 35, 35, null);
	}
}
