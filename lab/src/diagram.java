import acm.graphics.*;
import acm.program.*;
public class diagram extends GraphicsProgram{
	private static final int HEIGHT=30;
	private static final int WIDTH=100;
	public void run(){
		int width=getWidth();
		int height=getHeight();
		addblocks(width,height);
		addlines(width,height);
		addlabels(width,height);
	}
	private void addblocks(int width,int height){
		GRect rect1=new GRect(width/2-WIDTH/2,height/4,WIDTH,HEIGHT);
		add(rect1);
		GRect rect2=new GRect(width/2-WIDTH*3,height/4*3-HEIGHT,WIDTH,HEIGHT);
		add(rect2);
		GRect rect3=new GRect(width/2-WIDTH/2,height/4*3-HEIGHT,WIDTH,HEIGHT);
		add(rect3);
		GRect rect4=new GRect(width/2+WIDTH*2,height/4*3-HEIGHT,WIDTH,HEIGHT);
		add(rect4);
	}
	private void addlines(int width,int height){
		GLine line1=new GLine(width/2,height/4+HEIGHT,width/2,height/4*3-HEIGHT);
		add (line1);
		GLine line2=new GLine(width/2,height/4+HEIGHT,width/2-WIDTH*2.5,height/4*3-HEIGHT);
		add (line2);
		GLine line3=new GLine(width/2,height/4+HEIGHT,width/2+WIDTH*2.5,height/4*3-HEIGHT);
		add (line3);
	}
	private void addlabels(int width,int height){
		double x=0;double y=0;
		GLabel label0=new GLabel("Program",x,y);
		x=width/2-WIDTH/2+(WIDTH-label0.getWidth())/2;
		y=height/4+(HEIGHT-label0.getAscent())/2+label0.getAscent();
		GLabel label1=new GLabel("Program",x,y);
		add (label1);
		
		GLabel label20=new GLabel("GraphicsProgram",x,y);
		x=width/2-WIDTH*3+(WIDTH-label20.getWidth())/2;
		y=height/4*3-HEIGHT+(HEIGHT-label20.getAscent())/2+label20.getAscent();
		GLabel label2=new GLabel("GraphicsProgram",x,y);
		add (label2);
		
		GLabel labe30=new GLabel("ConsoleProgram",x,y);
		x=width/2-WIDTH/2+(WIDTH-labe30.getWidth())/2;
		y=height/4*3-HEIGHT+(HEIGHT-labe30.getAscent())/2+labe30.getAscent();
		GLabel label3=new GLabel("ConsoleProgram",x,y);
		add (label3);
		
		GLabel labe40=new GLabel("DialogProgram",x,y);
		x=width/2+WIDTH*2+(WIDTH-labe40.getWidth())/2;
		y=height/4*3-HEIGHT+(HEIGHT-labe40.getAscent())/2+labe40.getAscent();
		GLabel label4=new GLabel("DialogProgram",x,y);
		add (label4);
	}
}
