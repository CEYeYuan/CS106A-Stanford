import acm.program.*;
public class removeAllOccurrences extends ConsoleProgram{
	public void run(){

	println(removeAllOccurrences("Summer is here!", 'e'));
}
	private String removeAllOccurrences(String str, char ch){
		String result="";
		int length=str.length();
		for(int i=0;i<length;i++){
			if (str.charAt(i)!=ch)
			result=result+str.charAt(i);
		}
		return result;
	}
	
}
