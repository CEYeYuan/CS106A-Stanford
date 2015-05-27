import acm.program.*;
public class instanceVariable extends ConsoleProgram{
	public void run(){
		method1();
		method2(instance);		
	}
	private void method1(){
		instance=5;
		
	}
	private void method2(int instance){
		int i=instance;
		println(i);
	}
private int instance=3;
}
