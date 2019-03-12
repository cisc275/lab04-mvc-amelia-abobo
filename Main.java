import java.awt.Color;

import javax.swing.JFrame;

public class Main {
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

}
