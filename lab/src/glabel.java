import acm.graphics.*;
import acm.program.*;
public class glabel extends GraphicsProgram
{private static final int Eight=8;
	public void run()
	{int height=getHeight();
	height/=Eight;
	for(int i=0;i<Eight;i++)
	{for(int j=0;j<Eight;j++)
		{GRect rect=new GRect(i*height,j*height,height,height);
		if((i+j)%2==1)
	       rect.setFilled(true);
		add (rect);
		}}
	}
}

