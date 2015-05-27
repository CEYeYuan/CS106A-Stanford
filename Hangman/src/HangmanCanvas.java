/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas{
	
	
	
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		height=getHeight();
		width=getWidth();
		GLine scaffold=new GLine(width/2-BEAM_LENGTH,(height-SCAFFOLD_HEIGHT)/3,width/2-BEAM_LENGTH,(height-SCAFFOLD_HEIGHT)/3+SCAFFOLD_HEIGHT);
		GLine beam=new GLine(width/2-BEAM_LENGTH,(height-SCAFFOLD_HEIGHT)/3,width/2,(height-SCAFFOLD_HEIGHT)/3);
		GLine rope=new GLine(width/2,(height-SCAFFOLD_HEIGHT)/3,width/2,(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH);
        add (scaffold);
        add(beam);
        add(rope);

	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word,String error) {
	GLabel display=new GLabel(word,width/2-BEAM_LENGTH,(height-SCAFFOLD_HEIGHT)/3*2+SCAFFOLD_HEIGHT);
	display.setFont("family-plain-15");
	add(display);
	GLabel errorplay=new GLabel(error,width/2-BEAM_LENGTH,(height-SCAFFOLD_HEIGHT)/3*2+SCAFFOLD_HEIGHT+50);
	errorplay.setFont("family-plain-15");
	add(errorplay);
		/* You fill this in */
	       
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(int times) {
		
		/* You fill this in */
		if (times<=7){
			GOval head=new GOval(width/2-HEAD_RADIUS,(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH,2*HEAD_RADIUS,2*HEAD_RADIUS);
			add (head);
		}
		
		if (times<=6){
			GLine body=new GLine(width/2,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH,width/2,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH);
			add(body);
		}
		
		if (times<=5){
			GLine leftarmp=new GLine(width/2,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+ARM_OFFSET_FROM_HEAD,width/2-UPPER_ARM_LENGTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+ARM_OFFSET_FROM_HEAD);
			GLine leftarmv=new GLine(width/2-UPPER_ARM_LENGTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+ARM_OFFSET_FROM_HEAD,width/2-UPPER_ARM_LENGTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
			add(leftarmp);
			add(leftarmv);
		}
		
		if (times<=4){
			GLine rightarmp=new GLine(width/2,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+ARM_OFFSET_FROM_HEAD,width/2+UPPER_ARM_LENGTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+ARM_OFFSET_FROM_HEAD);
			GLine rightarmv=new GLine(width/2+UPPER_ARM_LENGTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+ARM_OFFSET_FROM_HEAD,width/2+UPPER_ARM_LENGTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
			add(rightarmp);
			add(rightarmv);
		}
		
		if (times<=3){
			GLine leftlegp=new GLine(width/2,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH,width/2-HIP_WIDTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH);
			GLine leftlegv=new GLine(width/2-HIP_WIDTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH,width/2-HIP_WIDTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH+LEG_LENGTH);
			add(leftlegp);
			add(leftlegv);
		}
		
		if (times<=2){
			GLine rightlegp=new GLine(width/2,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH,width/2+HIP_WIDTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH);
			GLine rightlegv=new GLine(width/2+HIP_WIDTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH,width/2+HIP_WIDTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH+LEG_LENGTH);
			add(rightlegp);
			add(rightlegv);
		}
		
		if(times<=1){
			GLine leftfoot=new GLine(width/2-HIP_WIDTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH+LEG_LENGTH,width/2-HIP_WIDTH-FOOT_LENGTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH+LEG_LENGTH);
			add (leftfoot);
		}
		
		if(times<=0){
			GLine rightfoot=new GLine(width/2+HIP_WIDTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH+LEG_LENGTH,width/2+HIP_WIDTH+FOOT_LENGTH,2*HEAD_RADIUS+(height-SCAFFOLD_HEIGHT)/3+ROPE_LENGTH+BODY_LENGTH+LEG_LENGTH);
			add (rightfoot);
		}
	}

/* Constants for the simple version of the picture (in pixels) */
	private double height;
	private double width;
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
