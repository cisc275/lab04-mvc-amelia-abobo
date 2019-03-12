import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

public class Model {
	final int frameCount = 10;
    int picNum = 0;
    int x = 0;
    int y = 0;
    final int xIncr = 8;
    final int yIncr = 2;
    int width = 500;
    int height = 300;
    int frameWidth = 500;
    int frameHeight = 300;
    int imageWidth = 165;
    int imageHeight = 165;
    Direction direct;
    
    public int getX() {
    	return x;
    }
    
    public int getY() {
    	return y;
    }
    
    public Direction getDirect() {
    	return direct;
    }
    
	Model(int width, int height, int imageWidth, int imageHeight){
		this.width = width;
		this.height = height;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;	
	}
	
	public void updateLocationAndDirection() {
		//UPDATES LOCATION    	
    	//orc traveling southeast, x and y increase
    	if (direct == Direction.SOUTHEAST) {//SE
    		x+=xIncr;
    		y+=yIncr;
    	}
    
    	//orc traveling southwest, x decreases and y increases
    	if (direct == Direction.SOUTHWEST) {//SW
    		x-=xIncr;
    		y+=8;
    	}
    	//orc traveling northwest, x decreases and y decreases
    	if (direct == Direction.NORTHWEST) {//NW
    		 x-=xIncr;
    		 y-=8;
    	}
    	//orc traveling northeast, x increases and y decreases
    	if (direct == Direction.NORTHEAST) {//NE
    		x+=xIncr;
    		y-=2;
    	}
		
		//UPDATES DIRECTION
    	//if orc hits right wall, go southwest
    	if (((x+imageWidth) >= frameWidth)) {
    		direct = Direction.SOUTHWEST;
    	}
    	//if orc hits bottom wall, go northwest
    	if ((y+imageHeight) >= frameHeight){
    		direct = Direction.NORTHWEST; //nw
    	}
    	//if orc hits left wall, go northeast
    	if ((x<=0)) {
    		direct = Direction.SOUTHEAST; //se
    	}
    	//if orc hits top wall, go southwest
    	if((y<=0)){
    		direct = Direction.SOUTHWEST; //sw
    	}
		
	}
}