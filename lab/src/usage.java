import acm.program.*;
public class usage extends ConsoleProgram{
	public void run(){
		
		ExpandableArray myList = new ExpandableArray();
		myList.set(14, "Bob");
		myList.set(21, "Sally");
		
		
		
		String value = (String) myList.get(21); // Note the cast
		if (value != null) {
		println("Got value: " + value);
		}
		
	}

}
