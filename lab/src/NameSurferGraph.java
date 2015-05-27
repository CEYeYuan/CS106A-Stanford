/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;

import java.awt.event.*;
import java.util.*;
import java.awt.*;

import acm.program.*;
import acm.util.RandomGenerator;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener{

	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
		//	 You fill in the rest //
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		//	 You fill this in //
		entrylist.clear();
		
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		// You fill this in //
		if (entry!=null)
		entrylist.add(entry);
		update();
	}
	
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		//	 You fill this in //
		
		
		removeAll();// draw the scheme of the diagram
		xdistance=getWidth()/11.0;
		for (int i=1;i<=10;i++){
			gl=new GLine(i*xdistance,0.0,i*xdistance,getHeight()*1.0);
			add(gl);
		}
		gl=new GLine(0.0,GRAPH_MARGIN_SIZE,getWidth(),GRAPH_MARGIN_SIZE);
		add(gl);
		gl=new GLine(0,getHeight()-GRAPH_MARGIN_SIZE,getWidth(),getHeight()-GRAPH_MARGIN_SIZE);
		add(gl);
		if(entrylist!=null){
			drawTheGraph(entrylist);//draw the specific names;
		}
	}
	
	
	private void drawTheGraph(ArrayList<NameSurferEntry> entrylist){//store all the searched history in an arraylist;when cleared,arraylist is cleared
		for (int i=0;i<entrylist.size();i++){//when updated,we redraw the graph according to the arraylist; if 
			//client clicked before or when program initialized, we will only draw the framework
			if (i%3==0) {	for (int j=0;j<NDECADES;j++){
				String display="";
				if (entrylist.get(i).getRank(1900+j*10)!=0)
				     display=entrylist.get(i).getName()+" "+entrylist.get(i).getRank(1900+j*10);
				else
					 display=entrylist.get(i).getName()+" *";
				double x,y;
				x=xdistance*j;
				if (entrylist.get(i).getRank(1900+j*10)==0)
					y=getHeight()-GRAPH_MARGIN_SIZE;
				else
					y=GRAPH_MARGIN_SIZE+getHeight()/1000.0*entrylist.get(i).getRank(1900+j*10);
					
				if(j<NDECADES-1){
					if (entrylist.get(i).getRank(1900+(j+1)*10)!=0)
					gl=new GLine(x,y,x+xdistance,GRAPH_MARGIN_SIZE+getHeight()/1000.0*entrylist.get(i).getRank(1900+(j+1)*10));
					else
						gl=new GLine(x,y,x+xdistance,getHeight()-GRAPH_MARGIN_SIZE);
	
					gl.setColor(Color.BLACK);
         			add(gl);
				}
				
				
				gla=new GLabel(display,x,y);
				
				add(gla);
				
			}}
			if (i%3==1) {	for (int j=0;j<NDECADES;j++){
				String display="";
				if (entrylist.get(i).getRank(1900+j*10)!=0)
				     display=entrylist.get(i).getName()+" "+entrylist.get(i).getRank(1900+j*10);
				else
					 display=entrylist.get(i).getName()+" *";
				double x,y;
				x=xdistance*j;
				if (entrylist.get(i).getRank(1900+j*10)==0)
					y=getHeight()-GRAPH_MARGIN_SIZE;
				else
					y=GRAPH_MARGIN_SIZE+getHeight()/1000.0*entrylist.get(i).getRank(1900+j*10);
					
				if(j<NDECADES-1){
					if (entrylist.get(i).getRank(1900+(j+1)*10)!=0)
					gl=new GLine(x,y,x+xdistance,GRAPH_MARGIN_SIZE+getHeight()/1000.0*entrylist.get(i).getRank(1900+(j+1)*10));
					else
						gl=new GLine(x,y,x+xdistance,getHeight()-GRAPH_MARGIN_SIZE);
	
					gl.setColor(Color.RED);
         			add(gl);
				}
				
				
				gla=new GLabel(display,x,y);
				
				add(gla);
				
			}}
			if (i%3==2) {	for (int j=0;j<NDECADES;j++){
				String display="";
				if (entrylist.get(i).getRank(1900+j*10)!=0)
				     display=entrylist.get(i).getName()+" "+entrylist.get(i).getRank(1900+j*10);
				else
					 display=entrylist.get(i).getName()+" *";
				double x,y;
				x=xdistance*j;
				if (entrylist.get(i).getRank(1900+j*10)==0)
					y=getHeight()-GRAPH_MARGIN_SIZE;
				else
					y=GRAPH_MARGIN_SIZE+getHeight()/1000.0*entrylist.get(i).getRank(1900+j*10);
					
				if(j<NDECADES-1){
					if (entrylist.get(i).getRank(1900+(j+1)*10)!=0)
					gl=new GLine(x,y,x+xdistance,GRAPH_MARGIN_SIZE+getHeight()/1000.0*entrylist.get(i).getRank(1900+(j+1)*10));
					else
						gl=new GLine(x,y,x+xdistance,getHeight()-GRAPH_MARGIN_SIZE);
	
					gl.setColor(Color.YELLOW);
         			add(gl);
				}
				
				
				gla=new GLabel(display,x,y);
				
				add(gla);
				
			}}
				
			
			}
			}
		
		
	
	
	/* Implementation of the ComponentListener interface */
	
	
	
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
	
	private RandomGenerator rgen=new RandomGenerator();
	private double xdistance;
	private GLabel gla;
	private GLine gl;
	private ArrayList<NameSurferEntry> entrylist=new ArrayList<NameSurferEntry>();
}
