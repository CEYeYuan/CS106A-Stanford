import acm.graphics.*;
import acm.program.*;
import acm.program.GraphicsProgram;
public class pyra extends GraphicsProgram{
	private static final int BRICK_WIDTH =30 ;
	private static final int BRICK_HEIGHT=15 ;
	private static final int BRICKS_IN_BASE=14;
	public void run(){
		int width=getWidth();
		int height=getHeight();
		width/=2;
		int awayFromcenter=(int)BRICKS_IN_BASE*BRICK_WIDTH/2;
	
		for (int i=0;i<BRICKS_IN_BASE;i++)
			drawline(i,awayFromcenter,height,width);

	}
	
private void drawline(int n,int awayFromcenter,int height,int width )
{int startPointX=width-awayFromcenter;
int startPointY=height-BRICK_HEIGHT;
int step=BRICK_WIDTH/2;
for(int j=0;j<BRICKS_IN_BASE-n;j++)
{GRect rect=new GRect(startPointX+n*step+j*BRICK_WIDTH,startPointY-n*BRICK_HEIGHT,BRICK_WIDTH,BRICK_HEIGHT);
add(rect);}
}}