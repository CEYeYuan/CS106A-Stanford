import acm.program.*;
public class hailstone extends ConsoleProgram{
	public void run(){
		int num,ini;
		ini=num=readInt("enter a number: ");
		while (num!=1){
			if (num%2==0)
			{println("number "+num+ " is even,so I take half:"+(num/2));
				num=num/2;}
	     	else{
	     		{println("number "+num+ " is odd,so I make 3n+1:"+(num*3+1));
				num=num*3+1;}
	     	}
			
		}
		
		println("The process took "+ini+" to reach 1");
	}

}
