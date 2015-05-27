/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	
	
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
		}
	
	
    public void run() {
		/* You fill this in */
    
    	//println(wordCount);
        word=words.getWord(selection);
        canvas.reset();
       // println(word);
    	println("Welcome to Hangman!");
    	HangmanConsole();
	}
    
    
private void HangmanConsole(){//Initialize the display and input ,and print the instruction 
	display="";
	answer=word;
    times=8;
	for(int i=0;i<word.length();i++){
		display+="- ";
	}
	judge();//make a judge whether your input exists in that Word 
	
}



private void judge(){
	String input=new String();
	String error=new String();
		{while(times>0){
		    canvas.displayWord(display,error);
			println("The word now looks like this: "+display);
			println("You have "+times+" guesses left.");
			input=readLine("Your guess: ");
			if (input.length()!=1)
			{println("the guess is illegal and accept a new guess");}
			else if (('a'<=input.charAt(0)&&input.charAt(0)<='z')||('A'<=input.charAt(0)&&input.charAt(0)<='Z')){
				int i;
				if ('a'<=input.charAt(0)&&input.charAt(0)<='z'){
				input=input.toUpperCase();}
				
				i=answer.indexOf(input);
				if (i>=0){
					answer=answer.substring(0, i)+'-'+answer.substring(i+1);
					display=display.substring(0,2*i)+input+' '+display.substring(2*i+2);
					println("That guess is correct.");
					if(display.indexOf('-')==-1)
					{ canvas.displayWord(display,error);
					println("The word now looks like this: "+display);
						println("You win!");
						break;
					}
					}
				else{
					error=error+input;
					println("There are no "+input+"'s in the word.");
					times-=1;
					canvas.noteIncorrectGuess(times);
				}
			
			}
			else{
				println("please input a letter!");
			}
		
		
		}
		if (times==0)
		println("Game over, You have lost, The answer is: "+word);
		}
	
}
private static HangmanCanvas canvas;
private HangmanLexicon words=new HangmanLexicon();
private int wordCount=words.getWordCount();
private RandomGenerator rgen=new RandomGenerator();
private int selection=rgen.nextInt(0,wordCount);
private String word=new String();
private int times;
private String answer=new String();
private String display=new String();

}
