
/**
 * Random cool applet
 *
 * @author Will Butler   (wcbutler)
 * @author Daniel Wright (dawrigh2)
 * @version 1.0
 */

import javax.swing.*;
import java.applet.Applet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class coolapplet extends Applet implements MouseListener, MouseMotionListener {
	
	   /**
            * text for display
            */
	private String	strOne	= "none";
	   /**
            * second text for display
            */
	private String	strTwo	= "none";
	   /**
            * sets color
            */
	private Color	color	= Color.blue;
	   /**
            * text for display
            */
	private Font	font;
	   /**
            * font for display
            */
	private String	strDraw;
	   /**
            * x coordinate
            */
	private int	xPos;
	   /**
            * y coordinate
            */
	private int	yPos;

	public static void main(String args[]) { }

	   /**
            * sets up applet
            */

	public void init() {
		getParameters();
		strDraw = strOne;
		font = new Font("Verdana", Font.BOLD, 20);
		setBackground(Color.black);
		addMouseListener(this);
		addMouseMotionListener(this);
		repaint();
	}

	   /**
            * paints the applet
            */
	public void paint(Graphics g) {
		g.setFont(font);
		g.setColor(color);
		g.drawString(strDraw, xPos, yPos);

	}

	   /**
            * Gets text used from html input
            */
	public void getParameters() {
		String s = null;
		s = getParameter("first");
		if (null != s) {
			strOne = s;
		}
		s = getParameter("second");
		if (null != s) {
			strTwo = s;
		}
		repaint();
	}
	
	   /**
            * mouse listener method
	    */
	public void mousePressed(MouseEvent e) { }
	   /**
            * mouse listener method
	    */
	public void mouseReleased(MouseEvent e) { }

	   /**
            * When clicked it selects which to use
	    */
	public void mouseClicked(MouseEvent e) {
		if (strDraw.compareTo(strOne) == 0) {
			strDraw = strTwo;
			color	= Color.blue;

		} else {
			strDraw = strOne;
			color	= Color.red;
		}
		System.out.println(strDraw);
		repaint();
	}
	   /**
            * mouse exited
	    */
	public void mouseExited(MouseEvent e) { }
	   /**
            * mouse exited
	    */
	public void mouseEntered(MouseEvent e) { }
	
	   /**
            * mouse motion listener method
	    */
	public void mouseMoved(MouseEvent e) {
	// does a little bit random and switches x and y coords
		xPos = Math.abs((e.getY() % 455))+1;
		yPos = Math.abs((e.getX() % 455))+1;
		repaint();

	}
	   /**
            * mouse listener dragged
	    */
	public void mouseDragged(MouseEvent e) { }
}
