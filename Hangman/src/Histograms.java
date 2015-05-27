import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import acm.program.*;
public class Histograms extends ConsoleProgram {
	public void run(){
		BufferedReader rd=null;
		while (rd==null){
			try{
				rd=new BufferedReader(new FileReader("MidtermScores.txt"));
				while (true){
					String line=rd.readLine();		
			        if(line==null) break;
			        int i=Integer.valueOf(line);
			        i=i/10;
			        scores[i]+=1;

					}}
				catch(IOException ex){
					
			}
	}
		
		
		for(int i=0;i<11;i++){
			String line="";
			for (int j=0;j<scores[i];j++){
				line+="*";
			}
			scoresstring[i]=line;
		}
		println("00-09: "+scoresstring[0]);
		for (int i=19;i<=90;i+=10){
			int j=i-9;
			println(j+"-"+i+": "+scoresstring[i/10]);				
		}
		println("  100: "+scoresstring[10]);
		
	}
	private int[] scores=new int[11];
	private String[]scoresstring=new String[11];
	}


