/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

/* Constructor: NameSurferEntry(line) */
/**
 * Creates a new NameSurferEntry from a data line as it appears
 * in the data file.  Each line begins with the name, which is
 * followed by integers giving the rank of that name for each
 * decade.
 */
	public NameSurferEntry(String line) {
		
		rd=null;//read the txt file and search for if there's a line match the input line
		while (rd==null){
			try{
				rd=new BufferedReader(new FileReader("names-data.txt"));
				while (true){
					entryline=rd.readLine();
					if (entryline==null)  break;
					else  if (entryline.indexOf(line)>=0)
						break;
				}
				
			}
		    
			catch(IOException ex){
				
			}
		// You fill this in //
	}
	}

/* Method: getName() */
/**
 * Returns the name associated with this entry.
 */
	public String getName() {
		// You need to turn this stub into a real implementation //
		String name="";
		if (entryline.equals(""))
		return null;
		else 
		{
			int i=entryline.indexOf(' ');
			name=entryline.substring(0,i);
			return name;
		}
		
	}

/* Method: getRank(decade) */
/**
 * Returns the rank associated with an entry for a particular
 * decade.  The decade value is an integer indicating how many
 * decades have passed since the first year in the database,
 * which is given by the constant START_DECADE.  If a name does
 * not appear in a decade, the rank value is 0.
 */
	public int getRank(int decade) {
		// You need to turn this stub into a real implementation //
		int num=(decade-1900)/10;
		int rank,length;
		String str=new String();
		str=entryline;
		int lastdex;
		
		
		if (entryline.equals(" "))
			return -1;
		else{
		for (int i=0;i<num+1;i++){
			int index=str.indexOf(' ');
			str=str.substring(index+1);
		}
		if (num!=10){
		lastdex=str.indexOf(' ');
		length=str.length()-str.substring(lastdex).length();
		rank=Integer.parseInt(str.substring(0,length));
		return rank;

		}
		
		else
			{rank=Integer.parseInt(str);
		    return rank;}
			
		
		}
		
	}

/* Method: toString() */
/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {
		// You need to turn this stub into a real implementation //
		if (entryline.equals("" ))
		return "";
		else{
			String str;
			int index;
			index=entryline.indexOf(' ');
			str="\""+entryline.substring(0,index+1)+"["+entryline.substring(index+1)+"]\"";
			return str;
			
		}
		
		
	}
	
	
	
	
	private static String entryline="";
	private BufferedReader rd;
}

