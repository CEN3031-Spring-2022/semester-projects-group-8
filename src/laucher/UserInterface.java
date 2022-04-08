package laucher;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;

public class UserInterface {
	GamePanel game;
	Font font, pausedFont;
	public boolean showMessage = false;
	public String message = "";
	int messageCount = 0;
	Graphics2D g2;
	public int commandNum = 0;
	
	public UserInterface(GamePanel game) {
		this.game = game;
		try {
			InputStream inStream = getClass().getResourceAsStream("/fonts/DungeonFont.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, inStream);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pausedFont = new Font("Arial Rounded MT Bold", Font.PLAIN, 80);
	}
	
	public void showMessage(String message) {
		this.message = message;
		showMessage = true;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		g2.setFont(font);
		g2.setColor(Color.BLACK);
		
		if(game.gameState == game.TITLE) {
			titleScreen();
		}
		if(game.gameState == game.PLAY) {
			//TODO
		}
		if(game.gameState == game.PAUSE) {
			pauseMessage();
		}
	}
	
	public void titleScreen() {
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 100F));
		String title = "Adventure Game";
		int x = 280;
		int y = 150;
		
		g2.setColor(Color.GRAY);
		g2.drawString(title, x + 5, y + 5);
		
		g2.setColor(Color.WHITE);
		g2.drawString(title, x, y);
		
		x = 415;
		y = 100;
		g2.drawImage(game.player.down1, x, y, game.tileSize * 5, game.tileSize * 5, null);
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 66F));
		
		String titleOption = "New Game";
		x = 480;
		y = 500;
		g2.drawString(titleOption, x, y);
		if(commandNum == 0) {
			g2.drawString("-->", x - game.tileSize, y);
		}
		
		titleOption = "Load Game";
		x = 480;
		y = 600;
		g2.drawString(titleOption, x, y);
		if(commandNum == 1) {
			g2.drawString("-->", x - game.tileSize, y);
		}
		
		titleOption = "Quit Game";
		x = 480;
		y = 700;
		g2.drawString(titleOption, x, y);
		if(commandNum == 2) {
			g2.drawString("-->", x - game.tileSize, y);
		}
	}
	
	public void pauseMessage() {
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 100F));
		String text = "GAME PAUSED";
		int x = game.screenWidth / 5;
		int y = game.screenHeight / 2;
		
		g2.drawString(text, x, y);
	}
	
}
