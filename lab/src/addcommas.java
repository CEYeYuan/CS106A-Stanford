import acm.program.*;
public class addcommas extends ConsoleProgram{
	public void run() {
	 while (true) {
		 String digits = readLine("Enter a numeric string: ");
		 if (digits.length() == 0) break;
		 println(add(digits));
		 }
		}
private String add(String org){
	String result="";
	int length=org.length();
	int j,k;
	k=length%3;
	if (k==0)
		k+=3;
	for (j=0;j<length;j++){
		if(j==k&&k<length){
		result+=',';
		k+=3;
	}
		result+=org.charAt(j);}
	return result;
	
}
}


