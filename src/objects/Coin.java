package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Coin extends ParentObject{
	
	public Coin() {
		this.name = "Coin";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/coin2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
