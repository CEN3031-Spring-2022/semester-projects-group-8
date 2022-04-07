package gameBackground;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import laucher.GamePanel;

public class backgroundManager {
	
	GamePanel game;
	backgroundPanel[] background;
	int mapTileSize[][];
	
	public backgroundManager(GamePanel game)
	{
		this.game = game;
	
		background = new backgroundPanel[10];
		mapTileSize = new int[game.tilesPerCol][game.tilesPerRow];
		
		getTileImage();
		loadMap();
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
	
	public void loadMap() {
		
		try {
			InputStream is = getClass().getResourceAsStream("/maps/testingmap.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < game.tilesPerCol && row < game.tilesPerRow) 
			{
				String line = br.readLine();
				
				while(col < game.tilesPerCol)
				{
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileSize[col][row] = num;
					col++;
				}
					if(col == game.tilesPerCol) { 
						col = 0;
						row++;
					}
				}
			
			br.close();
			
		} catch(Exception e) {
			
		}
	}
	
	public void draw(Graphics2D g2) {
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < game.tilesPerCol && row < game.tilesPerRow) 
		{			
			int tileNum = mapTileSize[col][row];
		
			g2.drawImage(background[tileNum].background, x, y, game.tileSize, game.tileSize, null);
			col++;
			x += game.tileSize;
			
			if(col == game.tilesPerCol) {
				col = 0;
				x = 0;
				row++;
				y += game.tileSize;
			}
			
		}
			
	}

}
