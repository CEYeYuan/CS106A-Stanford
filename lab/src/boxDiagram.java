import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;

import acm.program.*;
import acm.graphics.*;



public class boxDiagram extends GraphicsProgram{
	    public void init(){
	    canvas=new GCanvas();
		adds=new JButton("add");
		remove=new JButton("remove");
		clear=new JButton("clear");
		tf=new JTextField(15);
		tf.addActionListener(this);
		add(new JLabel("name: "),SOUTH);
		add(tf,SOUTH);
		add(adds,SOUTH);
		add(remove,SOUTH);
		add(clear,SOUTH);
		addActionListeners();
		addMouseListeners();	
	}
	    

	    
public void run(){
	 strobj=new HashMap<String,GObject>();
	
}
public void actionPerformed(ActionEvent e){
	if (e.getSource()==adds||e.getSource()== tf){
		addgbox(tf.getText());	
}
	
	if (e.getSource()==clear)
		removeAll();
	
	if (e.getSource()==remove){
		obj=strobj.get(tf.getText());
		if (obj!=null)
			remove(obj);
	}
}


public void MousePressed(MouseEvent e){
	point=new GPoint(e.getPoint());
	obj=getElementAt(point);
	
}





public void  mouseDragged(MouseEvent e){
	point=new GPoint(e.getPoint());
	obj=getElementAt(point);
	if(obj!=null)
		obj.move(e.getX()-obj.getX(), e.getY()-obj.getY());
	
}
private void addgbox (String str){
     gbox=new GCompound();
     rect=new GRect(BOX_WIDTH,BOX_HEIGHT);
     gbox.add(rect,-BOX_WIDTH/2,-BOX_HEIGHT/2);
     label=new GLabel(str);
     gbox.add(label,-label.getWidth()/2,-label.getAscent()/2);
     add(gbox,getWidth()/2,getHeight()/2+dy);
     dy+=BOX_HEIGHT;
     strobj.put(str, gbox);
}





private HashMap<String,GObject> strobj;
private JTextField tf;
private GPoint point;
private GObject obj;
private double xbox=getWidth()/2;
private double ybox=getHeight()/2;
private GCompound gbox;
private static final double BOX_WIDTH = 120;
private static final double BOX_HEIGHT = 50;
private GLabel label;
private JButton adds;
private GRect rect;
private int dy=0;
private JButton remove;
private GCanvas canvas;
private JButton clear;
}
