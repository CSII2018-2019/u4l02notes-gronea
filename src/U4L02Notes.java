import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class U4L02Notes extends JFrame {
	
	public static final String FILE_NAME = "/Spirit Week Color.jpg";

	
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
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.CYAN);
		add(buttonPanel, BorderLayout.CENTER);
		
		
		ImagePanel imgPanel = new ImagePanel(FILE_NAME);
		add(imgPanel, BorderLayout.PAGE_END);

		ImagePanel newImgPanel = new ImagePanel(FILE_NAME);
		
		
		//IMAGE FILTER BUTTONS
		JButton grayButton = new JButton("Gray");
		grayButton.setBackground(Color.GRAY);
		//action listener
		grayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				newImgPanel.convertToGrayscle();
			}
		});
		buttonPanel.add(grayButton);
		/*Original Code:
		//grayscale image panel
		ImagePanel grayImgPanel = new ImagePanel(FILE_NAME);
		//grayImgPanel.convertToGrayscle();
		grayImgPanel.convertToSepia();
		add(grayImgPanel, BorderLayout.LINE_END);*/
		
		JButton negButton = new JButton("Negative");
		negButton.setBackground(Color.BLACK);
		//action listener
		negButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newImgPanel.convertToNegscle();
			}
		});
		buttonPanel.add(negButton);
		/*//negscale image panel
		ImagePanel negImgPanel = new ImagePanel(FILE_NAME);
		negImgPanel.convertToNegscle();
		add(negImgPanel, BorderLayout.LINE_END);*/
		
		JButton redButton = new JButton("Red");
		redButton.setBackground(Color.RED);
		//action listener
		redButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newImgPanel.convertToRedscle();
			}
		});
		buttonPanel.add(redButton);
		/*//redscale image panel
		ImagePanel redImgPanel = new ImagePanel(FILE_NAME);
		redImgPanel.convertToRedscle();
		add(redImgPanel, BorderLayout.LINE_END);*/
		
		JButton greenButton = new JButton("Green");
		greenButton.setBackground(Color.GREEN);
		//action listener
		greenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newImgPanel.convertToGreenscle();
			}
		});
		buttonPanel.add(greenButton);
		/*//greenscale image panel
		ImagePanel greenImgPanel = new ImagePanel(FILE_NAME);
		greenImgPanel.convertToGreenscle();
		add(greenImgPanel, BorderLayout.LINE_END);*/
		
		JButton blueButton = new JButton("Blue");
		blueButton.setBackground(Color.BLUE);
		//action listener
		blueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newImgPanel.convertToBluescle();
			}
		});
		buttonPanel.add(blueButton);
		/*//bluescale image panel
		ImagePanel blueImgPanel = new ImagePanel(FILE_NAME);
		blueImgPanel.convertToBluescle();
		add(blueImgPanel, BorderLayout.LINE_END);*/
		
		JButton purpleButton = new JButton("Purple");
		purpleButton.setBackground(Color.PINK);
		//action listener
		purpleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newImgPanel.convertToPurplescle();
			}
		});
		buttonPanel.add(purpleButton);
		/*//purplescale image panel
		ImagePanel purpleImgPanel = new ImagePanel(FILE_NAME);
		purpleImgPanel.convertToPurplescle();
		add(purpleImgPanel, BorderLayout.LINE_END);*/
		/*JButton resetButton = new JButton("Reset");
		resetButton.setBackground(Color.WHITE);
		//action listener
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//newImgPanel
			}
		});
		buttonPanel.add(resetButton);*/
		imgPanel.add(newImgPanel, BorderLayout.LINE_END);
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

