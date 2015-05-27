/*
* File: Breakout.java
* -------------------
* This file will eventually implement the game of Breakout.
*/
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class Breakout extends GraphicsProgram {
/** Width and height of application window in pixels */
public static final int APPLICATION_WIDTH = 400;
public static final int APPLICATION_HEIGHT = 600;
/** Dimensions of game board (usually the same) */
private static final int WIDTH = APPLICATION_WIDTH;
private static final int HEIGHT = APPLICATION_HEIGHT;
/** Dimensions of the paddle */
private static final int PADDLE_WIDTH = 60;
private static final int PADDLE_HEIGHT = 10;
/** Offset of the paddle up from the bottom */
private static final int PADDLE_Y_OFFSET = 30;
/** Number of bricks per row */
private static final int NBRICKS_PER_ROW = 6;
/** Number of rows of bricks */
private static final int NBRICK_ROWS = 4;
/** Separation between bricks */
private static final int BRICK_SEP = 4;
/** Width of a brick */
private static final int BRICK_WIDTH =
(WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
/** Height of a brick */
private static final int BRICK_HEIGHT = 8;
/** Radius of the ball in pixels */
private static final int BALL_RADIUS = 3;
/** Offset of the top brick row from the top */
private static final int BRICK_Y_OFFSET = 70;
/** Number of turns */
private static final int NTURNS = 3;
// Step time(delay between moves
private static final int DELAY=8;
public void run() {
	
	setUpBricks();
	createPaddle();
	addMouseListeners();
	createBall();
	ballMove();

	
	
/* You fill this in, along with any subsidiary methods */}
private void setUpBricks()
{  
	int i=0;
	int j=0;
	for(i=0;i < NBRICK_ROWS;i++) //set i rows of bricks
	{
		for(j=0;j<NBRICKS_PER_ROW;j++)//set a row of brick
		    {int x=0;int y=70;
		    GRect rect=new GRect(x+(BRICK_SEP+BRICK_WIDTH)*j,y+i*(BRICK_HEIGHT+NBRICK_ROWS),BRICK_WIDTH,BRICK_HEIGHT);
		    
		    //assign the color of bricks
		    if(i==0||i==1)
		    {rect.setColor(Color.RED);
		    rect.setFilled(true);
		    }
		   
		    if(i==2||i==3)
		    {rect.setColor(Color.ORANGE);
		    rect.setFilled(true);
		    }
		    
		    if(i==4||i==5)
		    {rect.setColor(Color.YELLOW);
		    rect.setFilled(true);
		    }
		    
		    if(i==6||i==7)
		    {rect.setColor(Color.GREEN);
		    rect.setFilled(true);
		    }
		    
		    if(i==8||i==9)
		    {rect.setColor(Color.GRAY);
		    rect.setFilled(true);
		    }
		    
		    
		    //add all bricks to the screen
		    add (rect);
	        }
		
		
	}
}
public void createPaddle(){//set up the initial value of the paddle 
double x=APPLICATION_WIDTH/2-PADDLE_WIDTH/2;
double y=APPLICATION_HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT;
paddle=new GRect(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
paddle.setFilled(true);
add (paddle);
	
}
public void mouseMoved(MouseEvent e){// when mouse moves, we should keep tracking 
	double x;
	double y=APPLICATION_HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT;
	if (e.getX()<=APPLICATION_WIDTH-PADDLE_WIDTH)
		x=e.getX();
	else
		x=APPLICATION_WIDTH-PADDLE_WIDTH;
	paddle.setLocation(x, y);
	
}

private void createBall(){//initialization of the ball, and check if ball is about to beyond the boundary 

	ballx=APPLICATION_WIDTH/2-BALL_RADIUS;
	bally=APPLICATION_HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT-2*BALL_RADIUS;
	ball=new GOval(ballx,bally,2*BALL_RADIUS,2*BALL_RADIUS);
	ball.setFilled(true);
	add(ball);
	rgen=new RandomGenerator();
	vx=rgen.nextDouble(1.0,3.0);//using rege to make vx more interesting 
	   if (rgen.nextBoolean()==true)
	   vx=-vx;
	   collider=paddle;//initialize the collider (collision with the paddle )
}


private void ballMove(){//check if the collider is null ;if it's no collision right now ,go to another time step 
	//at the end of that time step ,check the latest status of collision 
//if now there's collision, deal with it (change the velocity and clear the "collision status "),then start again 
	
	while(collider==null){//check if the ball is about to beyond the boundary ;if so ,change the velocity in that direction 
		
		
		
		if(ballx<0||ballx>APPLICATION_WIDTH-2*BALL_RADIUS){
			   vx=-vx;
			   
		   }
		   if(bally<=0){
			   vy=-vy;   
		   }
			   
		   ballx=ballx+vx;
		   bally=bally+vy;
		   ball.setLocation(ballx,bally);
		   pause(DELAY);
		   if (bally>getHeight()){
				if (turns>0)
					{turns-=1;
					pause(DELAY*300);
					createBall();
					ballMove();
					}
			}
		   collider=checkCollision(ballx,bally);
	   }
	dealWithCollider();
}

private GObject checkCollision(double x,double y){
	//check if there is a collision right now ,if all four corners don't have collision ,then return no collision 	
    collider=getElementAt(x,y);
	if (collider==null){
	x=x+2*BALL_RADIUS;
	collider=getElementAt(x,y);}
	if (collider==null){
	y=y+2*BALL_RADIUS;
    collider=getElementAt(x,y);}
	if (collider==null){
	x=x-2*BALL_RADIUS;
	collider=getElementAt(x,y);}
	return collider;
}

private void dealWithCollider(){//if the collider is just paddle ,reverse the vy
	 if (collider==paddle){
		vy=-vy;
	    collider=null;
		ballMove();
	}
	   else// if the ball collides with a brick ,remove it and reverse the vy
	   {
		   vy=-vy;
		  remove(collider) ;
		    collider=null;
			ballMove();	   
	   }
	
}
private int turns=NTURNS-1;
private GOval ball;
private GRect paddle;
private GObject collider;
private RandomGenerator rgen;
private double vx;
private double vy=3;
private double ballx,bally;
}