import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/

public class View {
	final int frameCount = 10;
    int picNum = 0;
    BufferedImage[][] pics;
    int x = 0;
    int y = 0;
    final int xIncr = 8;
    final int yIncr = 2;
    int width = 500;
    int height = 300;
    int imageWidth = 165;
    int imageHeight = 165;
    Direction direct;
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getImageWidth() {
		return imageWidth;
	}
	
	public int getImageHeight() {
		return imageHeight;
	}
	
	//load images of all direction
    private BufferedImage createImage(){
    	BufferedImage bufferedImage;
    	try {
    		//southeast image
    		if(direct == Direction.SOUTHEAST) {//SE
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_southeast.png"));
        		return bufferedImage;
    		}
    		//southwest image
    		else if(direct == Direction.SOUTHWEST) {//sw
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_southwest.png"));
        		return bufferedImage;
    		}
    		//northeast image
    		else if(direct == Direction.NORTHEAST) {//NE
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_northeast.png"));
        		return bufferedImage;
    		}
    		//northwest image
    		else if(direct == Direction.NORTHWEST) {//nw
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_northwest.png"));
        		return bufferedImage;
    		}
    		
    		else if(direct == Direction.NORTH) {//n
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_north.png"));
        		return bufferedImage;
    		}
    		
    		else if(direct == Direction.SOUTH) {//s
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_south.png"));
        		return bufferedImage;
    		}
    		
    		else if(direct == Direction.EAST) {//e
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_east.png"));
        		return bufferedImage;
    		}
    		
    		else if(direct == Direction.WEST) {//w
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_west.png"));
        		return bufferedImage;
    		}
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    	// TODO: Change this method so you can load other orc animation bitmaps
    }
    
	
	public View() {
    	BufferedImage img = createImage();
    	pics = new BufferedImage[8][10];
    	for(int i = 0; i < frameCount; i++)
    		pics[0][i] = img.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
    	
    	direct = Direction.SOUTHWEST;//sw
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[1][i] = img.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
    	
    	direct = Direction.NORTHEAST;//ne
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[2][i] = img.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
    	
    	
    	direct = Direction.NORTHWEST;//nw
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[3][i] = img.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
    	
    	direct = Direction.NORTH;//n
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[4][i] = img.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
    	
    	direct = Direction.SOUTH;//s
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[5][i] = img.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
    	
    	direct = Direction.EAST;//e
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[6][i] = img.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
    	
    	direct = Direction.WEST;//w
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[7][i] = img.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
	}
	
	public void update(int x, int y, Direction direct){
		Graphics g;
		picNum = (picNum + 1) % frameCount;
    	switch(direct) {
    	case  NORTH: //north
    		g.drawImage(pics[4][picNum], x, y, Color.gray, this);
    	case NORTHEAST: //northeast
    		g.drawImage(pics[2][picNum], x, y, Color.gray, this);
    	case EAST: //east
    		g.drawImage(pics[6][picNum], x, y, Color.gray, this);
    	case SOUTHEAST: //southeast, x and y increase
    		g.drawImage(pics[0][picNum], x, y, Color.gray, this);
    		
    	case SOUTH: //south
    		g.drawImage(pics[5][picNum], x, y, Color.gray, this);
    	case SOUTHWEST: //southwest, x decreases and y increases
    		g.drawImage(pics[1][picNum], x, y, Color.gray, this);
    	case WEST: //west
    		g.drawImage(pics[7][picNum], x, y, Color.gray, this);
    	case NORTHWEST: //northwest, x decreases and y decreases
    		g.drawImage(pics[3][picNum], x, y, Color.gray, this);
    	}

	}
}