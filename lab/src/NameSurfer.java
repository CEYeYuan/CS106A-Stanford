/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;

import java.awt.event.*;

import javax.swing.*;

public class NameSurfer extends  Program implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
	
		drawgraph=new NameSurferGraph();
		drawgraph.update();
		add(drawgraph);
		tf=new JTextField(15);
		tf.setEditable(true);
		tf.setEnabled(true);
		tf.addActionListener(this);
		add(new JLabel("name: "),SOUTH);
		add(tf,SOUTH);
		graph=new JButton("Graph");
		add(graph,SOUTH);
		clear=new JButton("Clear");
		add (clear,SOUTH);
		addActionListeners();
		
		
		
		// test if NameSurferWorks
		/*nse=new NameSurferEntry("Tom");
		println(nse.getName());
		println(nse.toString());
		println(nse.getRank(2000));*/
		
	    // You fill this in, along with any helper methods //
	}

/* Method: actionPerformed(e) */

/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==tf){
			println(tf.getText());
			nse=new NameSurferEntry(tf.getText());
			if (nse.getName()!=null){
			drawgraph.addEntry(nse);
			drawgraph.update();}
		}
		// You fill this in //
		
		if (e.getSource()==clear){
			drawgraph.clear();
			drawgraph.update();
			
		}
		
		if (e.getSource()==graph){
			nse=new NameSurferEntry(tf.getText());
			if (nse.getName()!=null){
				drawgraph.addEntry(nse);
				drawgraph.update();}
			}
	}
	
	private NameSurferGraph drawgraph;  
    public NameSurferEntry nse;
	private JTextField tf;
	private JButton clear;
	private JButton graph;
}

