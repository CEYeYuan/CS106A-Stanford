import acm.graphics.*;
import java.awt.*;
import acm.program.GraphicsProgram;
public class logo extends GraphicsProgram{
	private static final int inch=72;
	public void run(){
		int height,width;
		height=getHeight();
		width=getWidth();
		int y=height/2;//get the centrel of there circle	
		int x=width/2;
		GOval oval=new GOval(x-inch,y-inch,2*inch,2*inch);
		oval.setColor(Color.RED);
		oval.setFilled(true);
		add(oval);
		GOval oval1=new GOval(x-0.65*inch,y-0.65*inch,0.65*2*inch,0.65*2*inch);
		oval1.setColor(Color.WHITE);
		oval1.setFilled(true);
		add(oval1);
		GOval oval2=new GOval(x-0.3*inch,y-0.3*inch,0.3*2*inch,0.3*2*inch);
		oval2.setColor(Color.RED);
		oval2.setFilled(true);
		add(oval2);
		
		
	}

}
