import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class U4L02Notes extends JFrame {
	
	public static final String FILE_NAME = "/ImagesofImages.jpg";
	
	public U4L02Notes(){
		initGUI();
		setTitle("Examples");
		setResizable(true);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initGUI(){
		//title Panel
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		JLabel titleLabel = new JLabel("Examples");
		titleLabel.setForeground(Color.WHITE);
		titlePanel.add(titleLabel);
		add(titlePanel, BorderLayout.PAGE_START);
		
		//image panel
		ImagePanel imgPanel = new ImagePanel(FILE_NAME);
		add(imgPanel, BorderLayout.CENTER);
		
		//grayscale image panel
		ImagePanel grayImgPanel = new ImagePanel(FILE_NAME);
		//grayImgPanel.convertToGrayscle();
		grayImgPanel.convertToSepia();
		add(grayImgPanel, BorderLayout.LINE_END);
		
		//negscale image panel
		ImagePanel negImgPanel = new ImagePanel(FILE_NAME);
		negImgPanel.convertToNegscle();
		add(negImgPanel, BorderLayout.LINE_END);
				
		//purplescale image panel
		ImagePanel purpleImgPanel = new ImagePanel(FILE_NAME);
		purpleImgPanel.convertToPurplescle();
		add(purpleImgPanel, BorderLayout.LINE_END);

	}
	
	
	public static void main(String[] args) {
		try {
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		} catch (Exception e){}
		
		SwingUtilities.invokeLater(new Runnable (){
            @Override
            public void run() {
                new U4L02Notes();
            }   
        });

	}

}

