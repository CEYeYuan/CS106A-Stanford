/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;

import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;

public class FacePamphlet extends Program 
					implements FacePamphletConstants {

	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init() {
		// You fill this in
		add (new JLabel("Name"),NORTH);
		Name=new JTextField(TEXT_FIELD_SIZE);
		Name.addActionListener(this);
		add(Name,NORTH);
		Add=new JButton("Add");
		Delete=new JButton("Delete");
		Lookup=new JButton("Lookup");
		add(Add,NORTH);
		add(Delete,NORTH);
		add(Lookup,NORTH);
		ChangeStatus=new  JButton("Change Status");
		ChangePicture=new  JButton("Change Picture");
		AddFriend=new  JButton("Add Friend");
	    Change_Status=new JTextField(TEXT_FIELD_SIZE);
		Change_Picture=new JTextField(TEXT_FIELD_SIZE);
		Add_Friend=new JTextField(TEXT_FIELD_SIZE);
		Change_Status.addActionListener(this);
		Change_Picture.addActionListener(this);
		Add_Friend.addActionListener(this);
		add(Change_Status,WEST);
		add(ChangeStatus,WEST);
		add (new JLabel(EMPTY_LABEL_TEXT),WEST);
		add(Change_Picture,WEST);
		add(ChangePicture,WEST);
		add (new JLabel(EMPTY_LABEL_TEXT),WEST);
		add(Add_Friend,WEST);
		add(AddFriend,WEST);
		addActionListeners();
		database=new FacePamphletDatabase();
		canvas = new FacePamphletCanvas();
		add(canvas);
    }
    
  
    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
		// You fill this in as well as add any additional methods
    	
    	
    	if (e.getSource()==Change_Status||e.getSource()==ChangeStatus)
    	     {if (Name.getText().equals(""))    
    	    	 canvas.displayAppMessage("Please select a profile to change status");
    	     else if(Change_Status.getText().equals(""))
    	    	 ;
    	    
    	     else  {
    	    	 
    	    	 database.getProfile(Name.getText()).setStatus(Change_Status.getText());
    	    	 canvas.displayProfile(database.getProfile(Name.getText()));
    	    	 canvas.displayAppMessage("Status updated to "+Change_Status.getText());
    	    	 
    	    	 
    	    	/* println(database.getProfile(Name.getText()).getStatus());*/}
    	     
    	     }
    	if (e.getSource()==Change_Picture||e.getSource()==ChangePicture)
    	     
    	   {if (Name.getText().equals(""))    
  	    	 canvas.displayAppMessage("Please select a profile to change status");
    	   else if(Change_Picture.getText().equals(""))
  	    	 ;
    	    else {
    	    	//println(Change_Picture.getText());
    	    	 image = null;
    	    try {
    	    image = new GImage(Change_Picture.getText());
    	    database.getProfile(Name.getText()).setImage(image);
    		canvas.displayProfile(database.getProfile(Name.getText()));
    		canvas.displayAppMessage("Picture updated");
    	   // println("image found!");
    	    } catch (ErrorException ex) {
    	    	canvas.removeAll();
    	    	canvas.displayProfile(database.getProfile(Name.getText()));
    	    	canvas.displayAppMessage("Unable to open image file: "+Change_Picture.getText());
    	    // Code that is executed if the filename cannot be opened.
    	    }
    	 
    	    } }
    	
    	
    	if (e.getSource()==Add_Friend||e.getSource()==AddFriend)
    	     {if (Name.getText().equals(""))    
      	    	 canvas.displayAppMessage("Please select a profile to change status");
      	   else if(Add_Friend.getText().equals(""))
    	    	 ;
    	     else {
    	    	 
    	    	 if (database.containsProfile(Add_Friend.getText()))
    	    		 
    	    		 if (database.getProfile(Name.getText()).getfriendlist().contains(Add_Friend.getText())){
    	    			 canvas.removeAll();
    	    	    	  canvas.displayProfile(database.getProfile(Name.getText()));
    	    	    	  canvas.displayAppMessage((Name.getText()+" already has "+Add_Friend.getText()+" as a friend"));
    	    		 }
    	    			 
    	    		 else
    	    		 
    	    	 {database.getProfile(Name.getText()).addFriend(Add_Friend.getText());//friendship is reciprocal
    	    	 database.getProfile(Add_Friend.getText()).addFriend(Name.getText());
    	    		canvas.displayProfile(database.getProfile(Name.getText()));
    	    		canvas.displayAppMessage(Add_Friend.getText()+" added as a friend");
    	    	/* println(Add_Friend.getText());*/}
    	    	 
    	    	 else
    	    	 {canvas.removeAll();
    	    	  canvas.displayProfile(database.getProfile(Name.getText()));
    	    		 canvas.displayAppMessage(Add_Friend.getText()+" does not exist.");}
    	    	 
    	     
    	     }
            }
    	
    	
    	
    	if (e.getSource()==Add)
    	{if (Name.getText().equals("")) 
    		;
    
    
    		
    	else {
    		
    		
    		
    		if (database.containsProfile(Name.getText()))  
    		{
        	
        	canvas.displayProfile(database.getProfile(Name.getText()));
        	canvas.displayAppMessage("A profile with the name "+Name.getText()+" already exists");
        	}//	println(Name.getText()+" Already exsist!");
    		
    		else{
    	    FacePamphletProfile profile=new FacePamphletProfile(Name.getText());
    		database.addProfile(profile);
    		canvas.displayProfile(database.getProfile(Name.getText()));
    		canvas.displayAppMessage("New profile created");
    		/*println("Add: "+database.getProfile(Name.getText()).toString());*/}}
    	}
    	
    	
    	
    	if (e.getSource()==Delete)
    	{if (Name.getText().equals("")) ;
    	else{
    		
    		if (database.containsProfile(Name.getText())==false)  
    		{canvas.removeAll();
    		canvas.displayAppMessage("Profile of "+Name.getText()+" deleted");}
    		//	println(Name.getText()+" doesn't exsist!");
    		
    		else{
    			
    				Iterator it=database.getDatabase().keySet().iterator();
    				while (it.hasNext())
    					database.getDatabase().get(it.next()).removeFriend(Name.getText());			
    		database.deleteProfile(Name.getText());
    		canvas.removeAll();
    		canvas.displayAppMessage("Profile of "+Name.getText()+" deleted");
    		/*println("Delete: "+Name.getText());*/}}
    	}
    	
    	
    	
    	if (e.getSource()==Lookup)
    	{if (Name.getText().equals("")) ;
    	else {
    		if (database.containsProfile(Name.getText())==false)  
    			{canvas.removeAll();
    			canvas.displayAppMessage("A profile with the name "+Name.getText()+" doesn't exists");}//println(Name.getText()+" doesn't exsist!");
    		else
    			{canvas.displayProfile(database.getProfile(Name.getText()));
    			canvas.displayAppMessage("Displaying "+Name.getText());
    			}
    			/*println("Lookup: "+database.getProfile(Name.getText()).toString())*/;}
    			
    		
    	}
    }
	
    
    
private FacePamphletCanvas canvas;
private GImage image;
private JButton Add;
private JButton Delete;
private JButton Lookup;
private JButton ChangeStatus;
private JButton ChangePicture;
private JButton AddFriend;
private JTextField Change_Status;
private JTextField Change_Picture;
private JTextField Add_Friend;
private JTextField Name;
private FacePamphletDatabase database;


}
