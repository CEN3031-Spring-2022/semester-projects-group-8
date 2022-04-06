package laucher;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import entity.Player;
import gameBackground.backgroundManager;

import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
	
	final int originalTileSize = 16; //Tiles are 16x16 pixels
	final int scale = 3; //Scales the tiles by 3x
	public final int tileSize = originalTileSize * scale; //Actual tile size
	
	public final int tilesPerCol = 16; //16 tiles displayed horizontally
	public final int tilesPerRow = 12; //12 tiles displayed vertically
	
	public final int screenWidth = tileSize * tilesPerCol; //48 * 16 = 768 pixels wide
	public final int screenHeight = tileSize * tilesPerRow; //48 * 12 = 576 pixels tall
	
	BufferedImage backgroundTest = null;
	
	backgroundManager backgroundM = new backgroundManager(this);
	Thread thread;
	InputHandler userInput = new InputHandler();
	Player player = new Player(this,userInput);
	
	int framesPerSecond = 60; //The game will update and render 60 times per second
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setDoubleBuffered(true);
		
		this.addKeyListener(userInput); //Adds the InputHandler class to the GamePanel
		this.setFocusable(true);
	}

	public void startThread() {
		thread = new Thread(this); //Passes GamePanel to Thread
		thread.start();
	}
	
	@Override
	public void run() {
		//Game Loop - allows the game to update and render objects many times per second
		//Calls the update and repaint methods
		
		double drawInterval = 1000000000 / framesPerSecond; //Draws to screen every 0.01666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(thread != null) {
			//System.out.println("The thread is running");
			update();
			repaint();
			
			//Limits the game loop to only running 60 times per second
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;
				
				//remainingTime cannot go below 0
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		
		player.update();
	}
	
	
	public void paintComponent(Graphics g) {
		//Draws an object to the screen
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;		
		
		backgroundM.draw(g2);
		player.draw(g2);
		
		g2.dispose(); //Frees memory used by the object
	}
}
