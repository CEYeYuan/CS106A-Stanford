import java.util.HashMap;
import java.util.Iterator;

import acm.program.*;

public class NameCounts extends ConsoleProgram{
	public void run(){
		HashMap<String,Integer> namelist=new HashMap<String,Integer>();
	
		while (true){
			String name=readLine("enter: ");
			if (name.equals(""))  break;
			Integer count=namelist.get(name);
			
		if (count==null){
		
				namelist.put(name,1);
			
		}
		else
			{Integer times=new Integer(count+1);
		namelist.put(name,times);
		println(times);
	}}
		printnamelist(namelist);
	}
	private void printnamelist(HashMap<String,Integer> namelist){
		Iterator <String> it=namelist.keySet().iterator();
		while(it.hasNext()){
			String name=it.next();
			Integer times=new Integer(namelist.get(name));
			println(name+": "+times);
		}
		
	}
}