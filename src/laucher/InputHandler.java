package laucher;

import java.awt.event.*;

public class InputHandler implements KeyListener{
	
	public boolean upKey, leftKey, downKey, rightKey;
	GamePanel game;
	
	public InputHandler(GamePanel game) {
		this.game = game;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		//Recognizes when a particular key is pressed and updates variable accordingly
		
		int pressedKey = e.getKeyCode();
		
		if(game.gameState == game.TITLE) {
			if(pressedKey == KeyEvent.VK_W) {
				game.UI.commandNum--;
				if(game.UI.commandNum < 0) {
					game.UI.commandNum = 2;
				}
			}
			if(pressedKey == KeyEvent.VK_S) {
				game.UI.commandNum++;
				if(game.UI.commandNum > 2) {
					game.UI.commandNum = 0;
				}
			}
			if(pressedKey == KeyEvent.VK_ENTER) {
				if(game.UI.commandNum == 0) {
					game.gameState = game.PLAY;
				}
				if(game.UI.commandNum == 1) {
					//TODO
				}
				if(game.UI.commandNum == 2) {
					System.exit(0);
				}
			}
		}
		
		if(pressedKey == KeyEvent.VK_W) {
			upKey = true;
		}
		if(pressedKey == KeyEvent.VK_A) {
			leftKey = true;
		}
		if(pressedKey == KeyEvent.VK_S) {
			downKey = true;
		}
		if(pressedKey == KeyEvent.VK_D) {
			rightKey = true;
		}
		if(pressedKey == KeyEvent.VK_ESCAPE) {
			if(game.gameState == game.PLAY) {
				game.gameState = game.PAUSE;
			}
			else if(game.gameState == game.PAUSE) {
				game.gameState = game.PLAY;
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//Recognizes when a particular key is released and updates variable accordingly
		
		int releasedKey = e.getKeyCode();
		
		if(releasedKey == KeyEvent.VK_W) {
			upKey = false;
		}
		if(releasedKey == KeyEvent.VK_A) {
			leftKey = false;
		}
		if(releasedKey == KeyEvent.VK_S) {
			downKey = false;
		}
		if(releasedKey == KeyEvent.VK_D) {
			rightKey = false;
		}
	}
}
