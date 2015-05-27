import java.util.*;
import acm.program.*;
public class UniqueNames extends ConsoleProgram{
	public void run(){
		ArrayList<String> namelist= new ArrayList<String>();
		while (true){
	    String line=readLine("Enter name: ");
		if (line.equals("")) break;
		if (namelist.contains(line)==false)
			namelist.add(line);
		}
      printList(namelist);}
	
	private void printList(ArrayList namelist){
		println("unique names are: ");
		for (int i=0;i<namelist.size();i++){
			println(namelist.get(i));
		}
	}
}
	