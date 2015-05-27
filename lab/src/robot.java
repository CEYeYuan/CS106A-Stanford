import java.awt.*;
import acm.graphics.*;
import acm.program.*;
public class robot extends GraphicsProgram{
	private static final int HEAD_WIDTH=200;
	private static final int HEAD_HEIGHT=300;
	private static final int EYE_RADIUS=15;
	private static final int MOUTH_WIDTH=100;
	private static final int MOUTH_HEIGHT=50;
	public void run(){
		int width=getWidth();
		int height=getHeight();
		
		addhead (width,height);
		addeyes(width,height);		
		addmouth(width,height);		
	}
private void addhead (int width,int height)
{
	GRect head=new GRect((width-HEAD_WIDTH)/2,(height-HEAD_HEIGHT)/2,HEAD_WIDTH,HEAD_HEIGHT);
	head.setFillColor(Color.GRAY);
	head.setFilled(true);
	add (head);
}
private void addeyes(int width,int height)
{GOval eye1=new GOval((width-HEAD_WIDTH)/2+HEAD_WIDTH/4,(height-HEAD_HEIGHT)/2+HEAD_HEIGHT/4,2*EYE_RADIUS,2*EYE_RADIUS)
;	
GOval eye2=new GOval((width-HEAD_WIDTH)/2+HEAD_WIDTH*3/4-2*EYE_RADIUS,(height-HEAD_HEIGHT)/2+HEAD_HEIGHT*1/4,2*EYE_RADIUS,2*EYE_RADIUS)
;	
add(eye1);
add(eye2);
eye1.setColor(Color.YELLOW);
eye1.setFilled(true);
eye2.setColor(Color.YELLOW);
eye2.setFilled(true);
}
private void addmouth(int width,int height){
	GRect mouth=new GRect((width-HEAD_WIDTH)/2+HEAD_WIDTH/4,(height-HEAD_HEIGHT)/2+HEAD_HEIGHT*3/4-MOUTH_HEIGHT,MOUTH_WIDTH,MOUTH_HEIGHT);
	mouth.setColor(Color.WHITE);
	mouth.setFilled(true);
	add(mouth);
}
}
