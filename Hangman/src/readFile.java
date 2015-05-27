import acm.program.*;

import java.io.*;
public class readFile extends ConsoleProgram{
	public void run(){
		BufferedReader rd=null;
		while (rd==null){
			try{
				rd=new BufferedReader(new FileReader("HangmanLexicon.txt"));
				while (true){
					String line=rd.readLine();		
					println(line);
					if(line==null) break;
					}}
				catch(IOException ex){
					
			}
	}}}


