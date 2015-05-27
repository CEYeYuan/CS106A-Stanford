import acm.program.*;
public class fibonacci extends ConsoleProgram{
	private static final int MAX_TERM_VALUE=10000;
	public void run(){
	int Fibs=0;
	int Fibl=0;
	int Fib=1;
	println ("Fibonacci sequence");
	println (0);
	while(Fib<=MAX_TERM_VALUE)
	{println(Fib);
	Fibs=Fib;//Fib=Fibcurrent+Fibprevious,we store the Fibcurrent to Fibs
	Fib=Fibl+Fib;//When we caculate next Fib, Fibl is the previous value
	Fibl=Fibs;//after we caculating the next Fib, the current Fib,which stored in Fibs, is passed to Fibl, which means for next caculation, it became the previous value
	}
	}

}
