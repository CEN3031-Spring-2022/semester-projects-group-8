package laucher;

import objects.Coin;

public class ObjectHandler {
	GamePanel game;
	
	public ObjectHandler(GamePanel game) {
		this.game = game;
	}
	
	public void setObject() {
		game.object[0] = new Coin();
		game.object[0].x = 250;
		game.object[0].y = 100;
		
		game.object[1] = new Coin();
		game.object[1].x = 850;
		game.object[1].y = 560;
	}
}
