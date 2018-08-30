import javax.swing.*;
import java.applet.Applet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class StateApplet extends Applet implements MouseListener, MouseMotionListener {
	private String	strOne	= "NC State";
	private String	strTwo	= "Wolfpack";
	private Color	color	= Color.black;
	private Font	font;
	private String	strDraw;
	private int	xPos;
	private int	yPos;
	
	public static void main(String args[]) { }
	
	public void init() {
		getParameters();
		strDraw = strOne;
		font = new Font("Verdana", Font.BOLD, 20);
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
		repaint();
	}
	
	public void paint(Graphics g) {
		g.setFont(font);
		g.setColor(color);
		g.drawString(strDraw, xPos, yPos);
	}

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
	// mouse listener methods
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }

	public void mouseClicked(MouseEvent e) {
		if (strDraw.compareTo(strOne) == 0) {
			strDraw = strTwo;
			color	= Color.red;
		} else {
			strDraw = strOne;
			color	= Color.black;
		}
		System.out.println(strDraw);
		repaint();
	}
	public void mouseExited(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	
	// mouse motion listener
	public void mouseMoved(MouseEvent e) {
		xPos = e.getX();
		yPos = e.getY();
		repaint();
	}
	public void mouseDragged(MouseEvent e) { }
}
