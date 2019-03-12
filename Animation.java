//T Harvey
//based loosely on http://www.java2s.com/Code/JavaAPI/java.awt/GraphicsdrawImageImageimgintxintyImageObserverob.htm
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation extends JPanel {

    final int frameCount = 10;
    int picNum = 0;
    BufferedImage[][] pics;
    int xloc = 0;
    int yloc = 0;
    final int xIncr = 8;
    final int yIncr = 2;
    final static int frameWidth = 500;
    final static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    String direction = "SE";

    //Override this JPanel's paint method to cycle through picture array and draw images
    public void paint(Graphics g) {
    	picNum = (picNum + 1) % frameCount;
    	//g.drawImage(pics[picNum], xloc+=xIncr, yloc+=yIncr, Color.gray, this);
    	
    	//orc traveling southeast, x and y increase
    	if (direction.contentEquals("SE")) {
    		g.drawImage(pics[0][picNum], xloc+=xIncr, yloc+=yIncr, Color.gray, this);
    	}
    	//orc traveling southwest, x decreases and y increases
    	if (direction.contentEquals("SW")) {
    		g.drawImage(pics[1][picNum], xloc-=xIncr, yloc+=8, Color.gray, this);
    	}
    	//orc traveling northwest, x decreases and y decreases
    	if (direction.contentEquals("NW")) {
    		g.drawImage(pics[3][picNum], xloc-=xIncr, yloc-=8, Color.gray, this);
    	}
    	//orc traveling northeast, x increases and y decreases
    	if (direction.contentEquals("NE")) {
    		g.drawImage(pics[2][picNum], xloc+=xIncr, yloc-=2, Color.gray, this);
    	}
    	
    
    	
    	//if orc hits right wall, go southwest
    	if (((xloc+imgWidth) >= frameWidth)) {
    		direction = "SW";
    		
    	}
    	//if orc hits bottom wall, go northwest
    	if ((yloc+imgHeight) >= frameHeight){
    		direction = "NW";
    	}
    	//if orc hits left wall, go northeast
    	if ((xloc<=0)) {
    		direction = "SE";
    	}
    	//if orc hits top wall, go southwest
    	if((yloc<=0)){
    		direction = "SW";
    	}
    	
    	// TODO: Keep the orc from walking off-screen, turn around when bouncing off walls.
		//Be sure that animation picture direction matches what is happening on screen.
    }

    //Make frame, loop on repaint and wait
    public static void main(String[] args) {
    	JFrame frame = new JFrame();
    	frame.getContentPane().add(new Animation());
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
    	for(int i = 0; i < 1000; i++){
    		frame.repaint();
    		try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }

    //Constructor: get image, segment and store in array
    public Animation(){
    	BufferedImage img = createImage();
    	pics = new BufferedImage[8][10];
    	for(int i = 0; i < frameCount; i++)
    		pics[0][i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	direction = "SW";
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[1][i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	direction = "NE";
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[2][i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	
    	direction = "NW";
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[3][i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	direction = "N";
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[4][i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	direction = "S";
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[5][i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	direction = "E";
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[6][i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	direction = "W";
    	img= createImage();
    	for (int i =0; i<frameCount; i++)
    		pics[7][i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	// TODO: Change this constructor so that at least eight orc animation pngs are loaded
    }  
    
    //Read image from file and return
    private BufferedImage createImage(){
    	BufferedImage bufferedImage;
    	try {
    		//southeast image
    		if(direction.contentEquals("SE")) {
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_southeast.png"));
        		return bufferedImage;
    		}
    		//southwest image
    		else if(direction.contentEquals("SW")) {
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_southwest.png"));
        		return bufferedImage;
    		}
    		//northeast image
    		else if(direction.contentEquals("NE")) {
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_northeast.png"));
        		return bufferedImage;
    		}
    		//northwest image
    		else if(direction.contentEquals("NW")) {
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_northwest.png"));
        		return bufferedImage;
    		}
    		
    		else if(direction.contentEquals("N")) {
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_north.png"));
        		return bufferedImage;
    		}
    		
    		else if(direction.contentEquals("S")) {
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_south.png"));
        		return bufferedImage;
    		}
    		
    		else if(direction.contentEquals("E")) {
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_east.png"));
        		return bufferedImage;
    		}
    		
    		else if(direction.contentEquals("W")) {
    			bufferedImage = ImageIO.read(new File("src/orc_animation/orc_forward_west.png"));
        		return bufferedImage;
    		}
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    	// TODO: Change this method so you can load other orc animation bitmaps
    }
}