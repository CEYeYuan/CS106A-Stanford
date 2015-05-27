import acm.graphics.*;
import acm.program.*;
import acm.util.*;
public class randomCircles extends GraphicsProgram {
	public void run(){
		int i,radius,x,y;
		int height=getHeight();
		int width=getWidth();
		for(i=0;i<10;i++){
			RandomGenerator rgen=new RandomGenerator();
		radius=rgen.nextInt(5,50);
		x=rgen.nextInt(0,width-2*radius);
		y=rgen.nextInt(0,height-2*radius);
		GOval oval=new GOval(x,y,2*radius,2*radius);
		oval.setFilled(true);
		oval.setColor(rgen.nextColor());
		add (oval);
		}
	}

}
