import acm.program.*;
public class tricalculate extends ConsoleProgram {
	public void run()
	{double a,b,c;
	println("Enter your values of a and b");
	a=readDouble("a=");
	b=readDouble("b=");
	c=Math.sqrt(a*a+b*b);
		println("c="+c);
	}

}
