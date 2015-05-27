import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import acm.program.*;
public class FlightPlanner extends ConsoleProgram {
	public void run(){
		readTheFile();//read the file and build the data structure;we use an ArrayList to store the citylist
		//also use ArrayList  to store a  particular city's destinations; use Hashmap to build the connection
		//between cities and destinations;
		println("Welcome to Flight Planner");
		println("Here's a list of all the citys in our database");
		printCityList();
		println("Ley's plan a round-trip route!");
		while (citylist.contains(startcity)==false)
		    startrun();
		
	    while (true){
	    //	println("start city is "+loop.get(0));
	    	if (loop.get(0).equals(nextcity))   break;
		planroutine();	
		
	    }
	    
	    printloop();
	}
	
	
	
	
	public void readTheFile(){// open the file; add all the data structers we need
		int i=0;
		int j=0;
		BufferedReader rd=null;
		while (rd==null){
			try{
				rd=new BufferedReader(new FileReader("flights.txt"));

				while (true){
					String line=rd.readLine();		
					if(line==null) 
						
						break;
					else
					{
					{int index;
					   index=line.indexOf("->");
					   String nameOfCity=new String();
					   String nameOfdestination=new String();
					   nameOfCity=line.substring(0, index-1);
					   nameOfdestination=line.substring(index+3);
					  // println(nameOfCity+" "+nameOfdestination);
					   citylist.add(nameOfCity);
					   if (i==0)
					   {map.put(nameOfCity, new ArrayList<String>());
					   map.get(nameOfCity).add(nameOfdestination);}
					 
				   
						   else{
							  
							   if (citylist.get(i-1).equals(nameOfCity))
								   map.get(nameOfCity).add(nameOfdestination);
							   
							   else
							   {   map.put(nameOfCity, new ArrayList<String>());
							       map.get(nameOfCity).add(nameOfdestination);
								   
							   }
							   
								   
						  
						   
					   }
				
					}
					}
					i++;}}
				catch(IOException ex){
					
			}}}
		
	
	
	public void printCityList(){
		it=map.keySet().iterator();
		while (it.hasNext())
			println(it.next());
	}
	
	
	
	private void planroutine(){
		println("From "+startcity+" you can fly directly to: ");
		for(int i=0;i<map.get(startcity).size();i++)
			println(map.get(startcity).get(i));
		
		
		while(true){
			nextcity=readLine("Where do you want to go from "+startcity+"? ");
		if (map.get(startcity).contains(nextcity))
			break;
		else
			println("you can't get to "+nextcity +" directly from "+startcity);
			
			
		}
		endcity=nextcity;
		startcity=nextcity;
		loop.add(nextcity);
		//println("endcity is "+endcity);
		
}
	
	private void printloop(){
		println("The route you have chosen is:");
		for (int i=0;i<loop.size();i++){
			if (i==loop.size()-1)
				print(loop.get(loop.size()-1));
			else
			print(loop.get(i)+"->");
		}
	}
	
	private void startrun(){
		
		startcity=readLine("Enter the starting city: ");
	     loop.add(startcity);}
	
	
	private BufferedReader rd;
	private ArrayList<String> citylist=new ArrayList<String>();
	private HashMap<String,ArrayList> map=new HashMap<String,ArrayList>();
	private ArrayList<String> loop=new ArrayList<String>();
	
	private Iterator<String> it;
	private String startcity;
	private String endcity;
	private String nextcity;
 
}
