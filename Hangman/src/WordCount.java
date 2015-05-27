import acm.program.*;
import java.util.*;
import acm.util.*;
import java.io.*;
public class WordCount extends ConsoleProgram {
	public void run(){
		BufferedReader rd=null;
		while (rd==null){
			try{
				String nameOfFile=readLine("Please enter the file name: ");
		        rd=new BufferedReader(new FileReader(nameOfFile));
				while(true){
					String line=rd.readLine();	
					if (line==null){
						println("number of lines= "+numOfline);
						println("number of words= "+numOfWords);
						println("number of chars= "+numOfChars);
						break;
					}
					for(int i=0;i<line.length();i++){
						char ch=line.charAt(i);
						if (ch!='\n')
						numOfChars++;
						 if (Character.isLetterOrDigit(ch)){
							 }
						 else
						 numOfWords++;
					}
					numOfline+=1;
					println(line);
					}}
	
				catch(IOException ex){
					println("bad times!");
				}
					
				}
		
	}
private int numOfline=0;
private int numOfWords=0;
private int numOfChars=0;
}
