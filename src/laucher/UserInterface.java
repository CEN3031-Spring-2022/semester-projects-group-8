package laucher;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UserInterface {
	GamePanel game;
	Font font;
	public boolean showMessage = false;
	public String message = "";
	int messageCount = 0;
	Graphics2D g2;
	
	public UserInterface(GamePanel game) {
		this.game = game;
		font = new Font("Arial Rounded MT Bold", Font.PLAIN, 80);
	}
	
	public void showMessage(String message) {
		this.message = message;
		showMessage = true;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		g2.setFont(font);
		g2.setColor(Color.BLACK);
		
		if(game.gameState == game.PLAY) {
			//TODO
		}
		if(game.gameState == game.PAUSE) {
			pauseMessage();
		}
	}
	
	public void pauseMessage() {
		String text = "GAME PAUSED";
		int x = 200;
		int y = game.screenHeight / 2;
		
		g2.drawString(text, 200, y);
	}
	
}
