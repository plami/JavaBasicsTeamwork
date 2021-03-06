package gamePart;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Board extends JPanel implements ActionListener {
	private Image dbImage;
	private javax.swing.Timer timer;
	private Graphics dbg;
	private static final long serialVersionUID = 1L;
	public static ArrayList<Aliens> aliensList = new ArrayList<Aliens>();
	private Aliens al;
	Random rand = new Random();
	public Board(){
		System.out.println("new game created");
		setBackground(Color.DARK_GRAY);
		timer = new javax.swing.Timer(5, this);
		timer.start();
	}
	public void born(){
		al = new Aliens(200,0);
		aliensList.add(al);
	}

	public void paints(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paint(dbg);
		g.drawImage(dbImage, 0, 0, this);
		
		repaint();
	}
	public void paint(Graphics g){
		for (int i = 0; i < aliensList.size(); i++) {
			Aliens a = aliensList.get(i);
			//a.move();
			if(a.isVisible()){
				g.drawImage(a.getImage(),getX(),getY(),this);	
			}
			else {
				aliensList.remove(i);
			}
		}
//		try {
//			//Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("STARTEDDDDDDDDDDD");
		while(true){
			
			born();
			for (int i = 0; i < aliensList.size(); i++) {
				Aliens a = aliensList.get(i);
				if(a.isVisible()){
					a.move();
				}
				else {
					aliensList.remove(i);
				}
			}}
	}

}


