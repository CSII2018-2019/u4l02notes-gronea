import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private int width;
	private int height;
	
	BufferedImage image = null;
	
	public ImagePanel(String fn){
		image = readImageFile(this, fn);
		width = image.getWidth();
		height = image.getHeight();
		

	}
	
	public static BufferedImage readImageFile(Object requestor, String fileName){
		BufferedImage image = null;
		try {
			InputStream input = requestor.getClass().getResourceAsStream(fileName);
			image = ImageIO.read(input);
		} catch (IOException e){
			String message = "The image file " + fileName + " could not be opened.";
			JOptionPane.showMessageDialog(null, message);
		}
		return image;

	}
	
	
	public void paintComponent(Graphics g) {
		/*g.drawImage(image, 0, 0, null);
		g.setColor(Color.YELLOW);
		g.drawString("When you don't like pictures but your friend forces you take a picture", 50, 50);
		
		//U4L03 Warm-Up: Given loop thorugh all pixels
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width;  x++) {
				//Here (x, y) will return as one int identifying the color
				int p = image.getRGB(x,y);
			}
		}
		//Pixel smallest unit of an image
			//Alpha (determines transparency), Red, Green, Blue
		//Integer stores 32 bits of memory [8 per value]
		//Bitwise Operators: Logic
			//Or | is when either one is true
			//XOR^ if exactly one is true
				//0110^1011 = 1101
			//AND & is if both are true, then true
			//Not ~ returns the opposite of each bit
				// ~ 0101 = 1010
		//Shifting bits:
			//Shift Left (<<) - shifts bits left in 0 in blank
				//a = 0000 0101
				//a << 1 = 0000 1010
			//Shift Right (>>) - shifts bits right and fills in 0 in blanks, if the most left-most bit is 1, it fills in 1's to the left
				//b = 1111 01110
				//b >> 2 = 1111 1101
				//c = 01101
				//c >> 1 = 00110 b/c the farthest left # is 0 it fills in zero on the right
				//d = 1111 0110
				//d >> 2 = 1111 1101 b/c the farthest left # is 1 it fills in one on the right
		// 01 10 11 10 >> 2 = 00 01 10 11 then & 00 00 00 11 = 00 00 00 11
		//int a = (p >>24)&Oxff;
		*/
		g.drawImage(image, 0, 0, null);	
	}
	
	public void convertToGrayscle() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				//get value for 1 pixel
				int p = image.getRGB(x, y);
				
				int a = (p>>24) & 0xff;
				int r = (p>>16) & 0xff;
				int g = (p>>8) & 0xff;
				int b = (p>>0) & 0xff;
				
				//calculate average
				int avg = (r + g + b)/3;
				
				//reset our pixel
				p = (a<<24) | (avg<<16) | (avg<<8) | (avg<<0);
				image.setRGB(x, y, p);
			}
		}
	}
	
	public void convertToNegscle() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				//get value for 1 pixel
				int p = image.getRGB(x, y);
				
				int a = (p>>24) & 0xff;
				int r = (p>>16) & 0xff;
				int g = (p>>8) & 0xff;
				int b = (p>>0) & 0xff;
				
				//calculate average
				int newR = 255 - r;
				int newG = 255 - g;
				int newB = 255 - b;
				
				//reset our pixel
				p = (a<<24) | (newR<<16) | (newG<<8) | (newB<<0);
				image.setRGB(x, y, p);
			}
		}
	}
	
	//When converting to color scales 0 out the other colors (Ex. [r=0, g=0, p&0xff] = blue scale)
	
	public void convertToPurplescle() {
		for (int i = height; i > 0; i--) {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					//get value for 1 pixel
					int p = image.getRGB(x, y);
					
					int a = (p>>24) & 0xff;
					int r = (p>>16) & 0xff;
					int g = (p>>8) & 0xff;
					int b = (p>>0) & 0xff;
					
					//calculate average
					int newR = 255 - r;
					int newG = 0;
					int newB = 255 - b;
					
					//reset our pixel
					p = (a<<24) | (newR<<16) | (newG<<8) | (newB<<0);
					image.setRGB(x, y, p);
				}
			}
		}
	}
	
	public void convertToSepia() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				//get value for 1 pixel
				int p = image.getRGB(x, y);
				
				int a = (p>>24) & 0xff;
				int r = (p>>16) & 0xff;
				int g = (p>>8) & 0xff;
				int b = (p>>0) & 0xff;
				
				int newR = (int)(0.393 * r + 0.769 * g + 0.189 * b);
				int newG = (int)(0.349 * r + 0.686 * g + 0.168 * b);
				int newB = (int)(0.272 * r + 0.534 * g + 0.131 * b);
				
				if (newR > 255) {
					newR = 255;
				}
				if (newG > 255) {
					newG = 255;
				}
				if (newB > 255) {
					newB = 255;
				}
				
				//reset our pixel
				p = (a<<24) | (newR<<16) | (newG<<8) | (newB<<0);
				image.setRGB(x, y, p);
			}
		}
	}
	
	public Dimension getPreferredSize() {
		Dimension size = new Dimension (width, height);
		return size;
	}

}
