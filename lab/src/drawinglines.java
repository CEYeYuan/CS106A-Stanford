import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
public class drawinglines extends GraphicsProgram{
	public void run(){
		addbricks();
		addMouseListeners();
	}
	public void addbricks(){
		
		line=new GRect(100,100,30,10);
		add(line);
	}
	public void mouseMoved(MouseEvent e){
		double x=e.getX();
		double y=e.getY();
		line.setLocation(x,y);
	}
private static GRect line;
}
	