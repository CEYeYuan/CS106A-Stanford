/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;

import java.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		for (int i=0;i<nPlayers;i++)
			for (int j=0;j<4;j++)
			scoreBoard[i][j]=0;
		playGame();
	}

	
	
	
	private void playGame() {
		/* You fill this in */
		for (int turn=0;turn<N_SCORING_CATEGORIES;turn++){
		//for (int turn=0;turn<3;turn++){
	   
			for (int i=1;i<nPlayers+1;i++){
		   
		    display.printMessage(playerNames[i-1] + "'s turn!"+"Click \"Roll Dice\" button to roll the dice");
	    	display.waitForPlayerToClickRoll(i);//after click the roll button,initialize this turn
	    	getdiceroll();
	    	
	    	display.printMessage("Select the dice you wish to re-roll and click the button \"Roll Again\"");
	    	checkDicerollSelected();//first check if need reroll
	    	display.printMessage("Select the dice you wish to re-roll and click the button \"Roll Again\"");
	    	checkDicerollSelected();//second check if need reroll
	   
	    	
	    	display.printMessage("Select the category for this roll");//select the category
	    	int category;
	    	while (true)
	    	{category = display.waitForPlayerToSelectCategory();//make sure every category can only be used once
	    	    if (selectedCategory[i-1][category-1]==1)
	    	    	display.printMessage("You have selected this category,please seleled another one");
	    	    else
	    	    	break;}//select the category;
	    	selectedCategory[i-1][category-1]=1;
	    	int scoreThisTurn=0;
	    	
	    	if(checkCategory(category)==true)
	    		scoreThisTurn=caulateScore(category,i);
	    	     
	    	    	 
	    	    	 
	    	    	 
	    		scoreBoard[i-1][3]+=scoreThisTurn;//check if this is the last turn,if so ,check if we need to add the bonus of upper board
	    		
	    		if (turn==N_SCORING_CATEGORIES-1){
	    			if (scoreBoard[i-1][0]>=63){
	    	   	    	 scoreBoard[i-1][1]=35;
	    	   	    	 scoreBoard[i-1][3]+=35;
	    	   	         
	    	   	         }
	    		}
	    	
	    	display.updateScorecard(category, i, scoreThisTurn);
	    	display.updateScorecard(TOTAL, i, scoreBoard[i-1][3]);
	    	display.updateScorecard(UPPER_BONUS, i, scoreBoard[i-1][1]);
	    	display.updateScorecard(UPPER_SCORE, i, scoreBoard[i-1][0]);
	    	display.updateScorecard(LOWER_SCORE, i, scoreBoard[i-1][2]);
	    	if(turn!=2||i!=nPlayers)
	    	display.printMessage(playerNames[i%nPlayers] + "'s turn.");
	    	else break;
	    
	    
			
		}
		}
		selectTheWinner();
	}
	
	
	
    private void getdiceroll(){//initializing the dice for the first time
		for(int i=0;i<N_DICE;i++){
			diceroll[i]=rgen.nextInt(1,6);
		}
		display.displayDice(diceroll);
	}
		
    
    
    
	private void checkDicerollSelected(){//check if there're dices selected;if selected, regenerate them
	 	display.waitForPlayerToSelectDice();
		for (int i=0;i<N_DICE;i++){
			if (display.isDieSelected(i))
				diceroll[i]=rgen.nextInt(1,6);
		}
		display.displayDice(diceroll);
	}
	
	
	private int caulateScore(int i,int player){//calculate the score if the player satisfy this category's criteria
		int score=0;
		if (i<=SIXES && i>=ONES ){
			for (int j=0;j<N_DICE;j++){
				if (diceroll[j]==i)
					score+=i;
			}
			scoreBoard[player-1][0]+=score;
			
			}
			
		if (i==THREE_OF_A_KIND|| i==FOUR_OF_A_KIND||i==CHANCE){
			for (int j=0;j<N_DICE;j++){
				score+=diceroll[j];
			}
			scoreBoard[player-1][2]+=score;
		}
			
		
		if(i==FULL_HOUSE) {
			score=25;
			scoreBoard[player-1][2]+=score;
		}
		if(i==SMALL_STRAIGHT) {
			score=30;
			scoreBoard[player-1][2]+=score;
		}
		if(i==LARGE_STRAIGHT) {
			score=40;
			scoreBoard[player-1][2]+=score;
		}
		if(i==YAHTZEE) {
			score=50;
			scoreBoard[player-1][2]+=score;
		}
		
		
		return score;
			
			
		}
		
		
		
	private void selectTheWinner(){//compare all the players score and decide who win the game
		int winnerScore=0;
		int winnerNumber=0;
		for (int i=0;i<MAXIMUMPLAYERS;i++){
			if (scoreBoard[i][3]>=winnerScore)
			
			{winnerScore=scoreBoard[i][3];
			 winnerNumber=i;	
			}
			
		}
		display.printMessage("Congratulations, "+playerNames[winnerNumber] + ", you're the winner with a total score of "+winnerScore);
		
	}
			

	
	private boolean checkCategory (int category){
		boolean tf=false;
		
		 if ((category<=SIXES && category>=ONES)||category==CHANCE)//for these categories, there's no restriction
			 tf=true;
		 
		 
		 if (category==THREE_OF_A_KIND){
			tf=false;
			 for(int i=0;i<N_DICE;i++){
				 for (int j=i+1;j<N_DICE;j++){
					 for (int k=j+1;k<N_DICE;k++){
					   if(diceroll[i]==diceroll[j]&&diceroll[j]==diceroll[k])
						 {tf=true;}		}	}		} 	 
		 }
		 
		 
		 if (category==FOUR_OF_A_KIND){
			 tf=false;
			 for(int i=0;i<N_DICE;i++)
				 for (int j=i+1;j<N_DICE;j++)
					 for (int k=j+1;k<N_DICE;k++)
						 for (int h=k+1;h<N_DICE;h++){
						 if(diceroll[i]==diceroll[j]&&diceroll[j]==diceroll[k]&&diceroll[k]==diceroll[h])
						 tf=true;			}		 	 
		 }
		 
		 
		 if (category==FULL_HOUSE){
			 int i,j,k;
			 tf=false;
			 for( i=0;i<N_DICE;i++)
				 for ( j=i+1;j<N_DICE;j++)
					 for ( k=j+1;k<N_DICE;k++)
						 {if(diceroll[i]==diceroll[j]&&diceroll[j]==diceroll[k])
						 {
							 ArrayList<Integer> arrlist=new ArrayList<Integer>();
							 for(int index=0;index<N_DICE;index++){
								 if ((index!=i)&&(index!=j)&&(index!=k))
									 arrlist.add(index);
							 }
						 int num1,num2;
						 num1=arrlist.get(0);
						 num2=arrlist.get(1);
						 if ((diceroll[num1]==diceroll[num2])&&(diceroll[num1]!=diceroll[k]))
						 tf=true;			}	}	 
		 }
		 
		 
		 
		 if(category==SMALL_STRAIGHT){
			 tf=false;
			 for (int i=0;i<N_DICE;i++){
				if (diceroll[i]==3){
					for (int j=0;j<N_DICE;j++){
						if (diceroll[j]==4){
							for (int k=0;k<N_DICE;k++){
								if (diceroll[k]==2){
									for (int h=0;h<N_DICE;h++)
		                            	if (diceroll[h]==5||diceroll[h]==1)
		                            		tf=true;
								}
								
	                  
									
								}
							for (int h=0;h<N_DICE;h++)
                            	if (diceroll[h]==5){
                            		for (int p=0;p<N_DICE;p++)
                                    	if (diceroll[p]==6)
                                    		tf=true;
                            		
                            	}
						}
							
						}
				}
			 }
		 }
		 
		 
		 
		 
		 if(category==LARGE_STRAIGHT){
			 tf=false;
			 for (int i=0;i<N_DICE;i++){
                if (diceroll[i]==2)
                { for (int j=0;j<N_DICE;j++)
                	if (diceroll[j]==3){
                		for (int k=0;k<N_DICE;k++)
                        	if (diceroll[k]==4)
                        	{for (int h=0;h<N_DICE;h++)
                            	if (diceroll[h]==5){
                            		for (int p=0;p<N_DICE;p++)
                                    	if (diceroll[p]==1||diceroll[p]==6)
                                    		tf=true;
                            	}
                        		
                        	}
                	}
                	
                }
					
			 }
		 }
		 
		 
		 
		 
		 if (category==YAHTZEE){
			 tf=true;
			 for (int i=0;i<N_DICE-1;i++){
				 if (diceroll[i]!=diceroll[i+1])
					 tf=false;
			 }
			
		 }
		 
		 
		 return tf;
	}
	
    
    
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
	private String rerollist;
	private int [] diceroll=new int [N_DICE];
	private int[][] scoreBoard=new int[MAXIMUMPLAYERS][4];
	private int[][] selectedCategory=new int[MAXIMUMPLAYERS][TOTAL];

}
