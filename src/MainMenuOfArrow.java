import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;
public class MainMenuOfArrow extends JFrame{
	JLabel blMainMenu, blLevel, lblHighScore, lblHelp, lblHelpText, lblRank1, 	lblRank2, lblRank3, lblRank4, lblRank1Score, lblRank2Score, lblRank3Score, 	lblRank4Score;
	
	int level=1;
	Font fontStyle;
	Color fontClr,fontClr2;
	JButton quit, btnStart, btnLevel, btnHighScore, btnHelp, btnBack, btnBack2, 	btnBack3, btnLevel1, btnLevel2, btnLevel3, btnLevel4,
	btnScoreLevel1, btnScoreLevel2, btnScoreLevel3, btnScoreLevel4;
	static Properties p1;
	static FileInputStream fis;
	static FileOutputStream fos; 
	MainMenuOfArrow(){
		setLayout(null);
	        setSize(700,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setContentPane(new JLabel((new ImageIcon(new ImageIcon("images/menuImage.gif").getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT)))));  // to add image in back ground
		readScores(); 
	
		lblMainMenu = new JLabel("MAIN MENU");
		lblMainMenu.setBounds(200,10,500,50);
		setStyleHead(lblMainMenu);
		add(lblMainMenu);

		btnStart= new JButton("Start");
		btnStart.setBounds(200,100,300,80);
		setStyleButton(btnStart);
		add(btnStart);
		btnStart.addActionListener(new ActionListener() {
	  	  	public void actionPerformed(ActionEvent ae){
	  	  		dispose();
	  	  		new BowArrow(level);
	  	   	}
	  	});
	    
		//Level
		btnLevel= new JButton("Level");
		btnLevel.setBounds(200,200,300,80);
		setStyleButton(btnLevel);
		btnLevel.addActionListener(new ActionListener() {
	  		public void actionPerformed(ActionEvent ae){	
	  	    		showScreen(2);
	  	    	}
	  	});
		add(btnLevel);

		lblLevel= new JLabel("Level");
		lblLevel.setBounds(250,10,500,50);
		setStyleHead(lblLevel);
		add(lblLevel);

		btnLevel1= new JButton("Level 1");
		btnLevel1.setBounds(200,100,300,80);
		setStyleButton(btnLevel1);
		add(btnLevel1);
	    	btnLevel1.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent ae){
        			level=1;
        			toggleColorOfButton(btnLevel1);
        		}
        	});
		    
	    	btnLevel2= new JButton("Level 2");
        	btnLevel2.setBounds(200,200,300,80);
        	setStyleButton(btnLevel2);
        	btnLevel2.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent ae){
        			level=2;
        			toggleColorOfButton(btnLevel2);	
        		}
        	});
        	add(btnLevel2);
        
        	btnLevel3= new JButton("Level 3");
        	btnLevel3.setBounds(200,300,300,80);
        	setStyleButton(btnLevel3);
        	btnLevel3.addActionListener(new ActionListener() {
	       		public void actionPerformed(ActionEvent ae){
	       			level=3;
	       			toggleColorOfButton(btnLevel3);	
	       		}
	       	});
        	add(btnLevel3);
    
        	btnLevel4= new JButton("Level 4");
        	btnLevel4.setBounds(200,400,300,80);
        	setStyleButton(btnLevel4);
        	btnLevel4.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent ae){
	        		level=4;
	        		toggleColorOfButton(btnLevel4);
	        	}
	        });
		add(btnLevel4);

	        //High Score
		btnHighScore= new JButton("High Score");
	    	btnHighScore.setBounds(200,300,300,80);
	    	setStyleButton(btnHighScore);
	    	btnHighScore.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent ae){
	    			showScreen(3);	
	  	    	}
	  	});   
	    	add(btnHighScore);
	    
		lblHighScore= new JLabel("High Score");
    		lblHighScore.setBounds(250,10,500,50);
		setStyleHead(lblHighScore);
    		add(lblHighScore);
    
	    btnScoreLevel1= new JButton("Score L1");
        btnScoreLevel1.setBounds(200,100,300,80);
        setStyleButton(btnScoreLevel1);
        btnScoreLevel1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        		toggleColorOfButton(btnScoreLevel1);
        		rankDisplay(1);
        	}
        });
        add(btnScoreLevel1);
	        
        btnScoreLevel2= new JButton("Score L2");
        btnScoreLevel2.setBounds(200,200,300,80);
        setStyleButton(btnScoreLevel2);
        btnScoreLevel2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        		toggleColorOfButton(btnScoreLevel2);
        		rankDisplay(2);
        	}
        });
        add(btnScoreLevel2);
        
        btnScoreLevel3= new JButton("Score L3");
        btnScoreLevel3.setBounds(200,300,300,80);
	    setStyleButton(btnScoreLevel3);
	    btnScoreLevel3.addActionListener(new ActionListener() {
  	      	public void actionPerformed(ActionEvent ae){
  	       		toggleColorOfButton(btnScoreLevel3);
  	       		rankDisplay(3);
  	       	}
  	    });
	    add(btnScoreLevel3);
	        
	    btnScoreLevel4= new JButton("Score L4");
	    btnScoreLevel4.setBounds(200,400,300,80);
	    setStyleButton(btnScoreLevel4);
	    btnScoreLevel4.addActionListener(new ActionListener() {
  	       	public void actionPerformed(ActionEvent ae){
  	       		toggleColorOfButton(btnScoreLevel4);
  	       		rankDisplay(4);
  	       	}
  	    });
	    add(btnScoreLevel4);

    	lblRank1= new JLabel("Rank-1");
	    lblRank1.setBounds(200,100,150,80);
	    setStyleOtherLabel(lblRank1);
	    add(lblRank1);
			
	    lblRank1Score= new JLabel();	    
	    lblRank1Score.setBounds(400,100,150,80);
	    setStyleOtherLabel(lblRank1Score);
		add(lblRank1Score);

		lblRank2= new JLabel("Rank-2");
	    lblRank2.setBounds(200,200,150,80);
	    setStyleOtherLabel(lblRank2);
	    add(lblRank2);
			
		lblRank2Score= new JLabel();
	    lblRank2Score.setBounds(400,200,150,80);
	    setStyleOtherLabel(lblRank2Score);
	    add(lblRank2Score);
			
		lblRank3= new JLabel("Rank-3");
	    lblRank3.setBounds(200,300,150,80);
	    setStyleOtherLabel(lblRank3);
	    add(lblRank3);
			
		lblRank3Score= new JLabel();
	    lblRank3Score.setBounds(400,300,150,80);
	    setStyleOtherLabel(lblRank3Score);
	    add(lblRank3Score);
			
		lblRank4= new JLabel("Rank-4");
	    lblRank4.setBounds(200,400,150,80);
	    setStyleOtherLabel(lblRank4);
	    add(lblRank4);
		
		lblRank4Score= new JLabel();
	    lblRank4Score.setBounds(400,400,150,80);
	    setStyleOtherLabel(lblRank4Score);
	    add(lblRank4Score);
	    
	    //Help
	    btnHelp= new JButton("Help");
	    setStyleButton(btnHelp);
	    btnHelp.setBounds(200,400,300,80);	  	    
	    btnHelp.addActionListener(new ActionListener() {
	  	    public void actionPerformed(ActionEvent ae){
	  	    	showScreen(4);
	  	    }
	  	});
	    add(btnHelp);

	    	lblHelp= new JLabel("Help");
	    	lblHelp.setBounds(250,10,500,50);
		setStyleHead(lblHelp);
	    	add(lblHelp);
			
		lblHelpText = new JLabel("<html>Press Space to throw arrow<br>or click on the character<br> alt+f4 to stop game any time</html>");
    	lblHelpText.setBounds(10,200,500,200);
    	setStyleOtherLabel(lblHelpText);
    	add(lblHelpText);

    	//quit
	    quit= new JButton("Quit");
	    quit.setBounds(0,390,200,100);    
	    setStyleOtherButton(quit);
	    quit.addActionListener(new ActionListener() {
	  	    public void actionPerformed(ActionEvent ae){
	  	    		System.exit(0);
	  	    }
	  	});
	    add(quit);

		btnBack= new JButton("Back");
		btnBack.setBounds(500,390,200,100);
		setStyleOtherButton(btnBack);
	    btnBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae){
	    		showScreen(1);
	    	}
	  	});
	    add(btnBack);

		btnBack2= new JButton("Back");
		btnBack2.setBounds(500,390,200,100);
		setStyleOtherButton(btnBack2);
	    btnBack2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae){
	    		showScreen(3);
	    	}
	  	});
	    add(btnBack2);

		showScreen(1);
		toggleColorOfButton(btnLevel1);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MainMenuOfArrow();
	}
	void showScreen(int n){
		lblMainMenu.setVisible(false);
		btnStart.setVisible(false);
		btnLevel.setVisible(false);
		btnHighScore.setVisible(false);
		btnHelp.setVisible(false);
		lblLevel.setVisible(false);
		btnLevel1.setVisible(false);
		btnLevel2.setVisible(false);
		btnLevel3.setVisible(false);
		btnLevel4.setVisible(false);
		btnBack.setVisible(false);
		lblHighScore.setVisible(false);
		btnScoreLevel1.setVisible(false);
		btnScoreLevel2.setVisible(false);
		btnScoreLevel3.setVisible(false);
		btnScoreLevel4.setVisible(false);
		btnBack2.setVisible(false);
		lblHelp.setVisible(false);
		lblHelpText.setVisible(false);
		lblRank1.setVisible(false);
		lblRank1Score.setVisible(false);
		lblRank2.setVisible(false);
		lblRank2Score.setVisible(false);
		lblRank3.setVisible(false);
		lblRank3Score.setVisible(false);
		lblRank4.setVisible(false);
		lblRank4Score.setVisible(false);
		if(n==1){
			lblMainMenu.setVisible(true);
			btnStart.setVisible(true);
			btnLevel.setVisible(true);
			btnHighScore.setVisible(true);
			btnHelp.setVisible(true);
		}
		else if(n==2){
			lblLevel.setVisible(true);
			btnLevel1.setVisible(true);
			btnLevel2.setVisible(true);
			btnLevel3.setVisible(true);
			btnLevel4.setVisible(true);
			btnBack.setVisible(true);
		}
		else if(n==3){
			lblHighScore.setVisible(true);
			btnScoreLevel1.setVisible(true);
			btnScoreLevel2.setVisible(true);
			btnScoreLevel3.setVisible(true);
			btnScoreLevel4.setVisible(true);
			btnBack.setVisible(true);
		}
		else if(n==4){
			lblHelp.setVisible(true);
			lblHelpText.setVisible(true);
			btnBack.setVisible(true);
		}
		else if(n==5){
			lblRank1.setVisible(true);
			lblRank1Score.setVisible(true);
			lblRank2.setVisible(true);
			lblRank2Score.setVisible(true);
			lblRank3.setVisible(true);
			lblRank3Score.setVisible(true);
			lblRank4.setVisible(true);
			lblRank4Score.setVisible(true);
			btnBack2.setVisible(true);
		}
	}
	public static void readScores(){
		try{
			p1 =new Properties();
			fis= new FileInputStream("RankRecord.txt");  
			p1.load(fis);
			fis.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
    public void rankDisplay(int n){
    	showScreen(5);
		lblRank1Score.setText(p1.getProperty("rank1-"+n));  // to set the rank score
		lblRank2Score.setText(p1.getProperty("rank2-"+n));
		lblRank3Score.setText(p1.getProperty("rank3-"+n));
		lblRank4Score.setText(p1.getProperty("rank4-"+n)); 
	}
	void setStyleHead(JLabel cmp){
		fontStyle= new Font("Forte",Font.BOLD,50);
		cmp.setFont(fontStyle);
		fontClr= new Color(249, 2, 23);
		cmp.setForeground(fontClr);
    	}
	void setStyleOtherLabel(JLabel cmp){
		fontStyle= new Font("chiller",Font.BOLD,44);
		cmp.setFont(fontStyle);
		fontClr= new Color(196, 0, 78);
		cmp.setForeground(fontClr);
	}
	void setStyleButton(JButton cmp){
		fontStyle= new Font("Ravie",Font.BOLD,34);
		cmp.setFont(fontStyle);
		fontClr= new Color(219, 216, 212,255);  
		// 4th argument is the opacity
		cmp.setForeground(fontClr); 
		fontClr= new Color(112, 34, 37);
		cmp.setBackground(fontClr);
	    	cmp.setBorderPainted(false);
	    	cmp.setFocusPainted(false);
    	}
	void setStyleOtherButton(JButton cmp){
    		fontStyle= new Font("Forte",Font.BOLD,50);
		cmp.setFont(fontStyle);
		fontClr= new Color(249, 2, 23);
		cmp.setForeground(fontClr); 
		cmp.setContentAreaFilled(false);
    		cmp.setBorderPainted(false);
    		cmp.setFocusPainted(false);
    	}
    	void toggleColorOfButton(JButton btnLevel){
		fontClr= new Color(3, 181, 9);
		fontClr2= new Color(112, 34, 37);
		if(btnLevel==btnLevel1)
			btnLevel1.setBackground(fontClr);
		else
			btnLevel1.setBackground(fontClr2);
		if(btnLevel==btnLevel2)
			btnLevel2.setBackground(fontClr);
		else
			btnLevel2.setBackground(fontClr2);
		if(btnLevel==btnLevel3)
			btnLevel3.setBackground(fontClr);
		else
			btnLevel3.setBackground(fontClr2);
		if(btnLevel==btnLevel4)
			btnLevel4.setBackground(fontClr);
		else
			btnLevel4.setBackground(fontClr2);
		if(btnLevel==btnScoreLevel1)
			btnScoreLevel1.setBackground(fontClr);
		else
			btnScoreLevel1.setBackground(fontClr2);
		if(btnLevel==btnScoreLevel2)
			btnScoreLevel2.setBackground(fontClr);
		else
			btnScoreLevel2.setBackground(fontClr2);
		if(btnLevel==btnScoreLevel3)
			btnScoreLevel3.setBackground(fontClr);
		else
			btnScoreLevel3.setBackground(fontClr2);
		if(btnLevel==btnScoreLevel4)
			btnScoreLevel4.setBackground(fontClr);
		else
			btnScoreLevel4.setBackground(fontClr2);
	}
}
