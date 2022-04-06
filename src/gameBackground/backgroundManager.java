package gameBackground;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import laucher.GamePanel;

public class backgroundManager {
	
	GamePanel game;
	backgroundPanel[] background;
	
	public backgroundManager(GamePanel game)
	{
		this.game = game;
	
		background = new backgroundPanel[10];
		
		getTileImage();
	}
	
	public void getTileImage()
	{
		try {
			
			background[0] = new backgroundPanel();
			background[0].background = ImageIO.read(getClass().getResourceAsStream("/background/leafygrasshires.png"));
			
			background[1] = new backgroundPanel();
			background[1].background = ImageIO.read(getClass().getResourceAsStream("/background/tilevariant2.png"));
			
			background[2] = new backgroundPanel();
			background[2].background = ImageIO.read(getClass().getResourceAsStream("/background/bigrock.png"));
			
			background[3] = new backgroundPanel();
			background[3].background = ImageIO.read(getClass().getResourceAsStream("/background/topmiddle.png"));
			
			background[4] = new backgroundPanel();
			background[4].background = ImageIO.read(getClass().getResourceAsStream("/background/leftsideflat.png"));
			
			background[5] = new backgroundPanel();
			background[5].background = ImageIO.read(getClass().getResourceAsStream("/background/rightsideflat.png"));
			
			background[6] = new backgroundPanel();
			background[6].background = ImageIO.read(getClass().getResourceAsStream("/background/bottommiddle.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < game.screenWidth && row < game.screenHeight) 
		{
		
			g2.drawImage(background[0].background, x, y, game.tileSize, game.tileSize, null);
			col++;
			x += game.tileSize;
			
			if(col == game.screenWidth) {
				col = 0;
				x = 0;
				row++;
				y += game.tileSize;
			}
			
		}
			
	}

}
