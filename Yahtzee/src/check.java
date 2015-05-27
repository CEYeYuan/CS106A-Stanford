import acm.program.*;
import java.util.*;
public class check extends ConsoleProgram {
	public void run (){
		boolean tf=false;
	//	println("ssssssssss");
	int [] diceroll={1,2,2,1,1};
	if (1==1){
		tf=false;
		 for(int i=0;i<N_DICE;i++)
			 for (int j=i+1;j<N_DICE;j++)
				 for (int k=j+1;k<N_DICE;k++)
				 { if(diceroll[i]==diceroll[j]&&diceroll[j]==diceroll[k])
					 tf=true;	}
	 }
	
	if(tf==true)
		println("it's true");
	else 
		println("it's false");
}
	private int  N_DICE=5;
}