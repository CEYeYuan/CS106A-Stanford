import acm.program.*;
public class findrange extends ConsoleProgram {
	private static final int sentinel=6;
	public void run()
	{int small,large,current;
	current=readInt("?");
	if (current==sentinel)//special case1
		println("no value entered");
	small=large=current;
	current=readInt("?");
	if (current==sentinel)//special case2
	{println("smallest:"+small);
	println("largest:"+large);
	}
	else//normal cases
	{ if (current>large)
    	large=current;
    if (current<small)
 	small=current;
	       while(true){
	        	current=readInt("?");
	            if (current>large)
		    	large=current;
		        if (current<small)
		     	small=current;
		        if (current==sentinel) 
	        		break;
	}
    	println("smallest:"+small);
    	println("largest:"+large);
		
	}
	}
}
