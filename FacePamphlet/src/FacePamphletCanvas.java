/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;
import acm.graphics.*;

import java.awt.*;
import java.util.*;

public class FacePamphletCanvas extends GCanvas 
					implements FacePamphletConstants {
	
	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */
	public FacePamphletCanvas() {
		// You fill this in
	}

	
	/** 
	 * This method displays a message string near the bottom of the 
	 * canvas.  Every time this method is called, the previously 
	 * displayed message (if any) is replaced by the new message text 
	 * passed in.
	 */
	/*public void showMessage(String msg) {
		GLabel label=new GLabel(msg);
		label=new GLabel(msg,getWidth()/2-label.getHeight()/2,getHeight()-BOTTOM_MESSAGE_MARGIN);
		label.setFont(MESSAGE_FONT);
		
		add(label);
		// You fill this in
	}*/
	
	
	/** 
	 * This method displays the given profile on the canvas.  The 
	 * canvas is first cleared of all existing items (including 
	 * messages displayed near the bottom of the screen) and then the 
	 * given profile is displayed.  The profile display includes the 
	 * name of the user from the profile, the corresponding image 
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
		removeAll();
		// You fill this in
		
		GLabel name=new GLabel(profile.getName());
		name.setFont(PROFILE_NAME_FONT);
		name.setLocation(LEFT_MARGIN, TOP_MARGIN);
		add(name);
		
		if (profile.getImage()==null)
			add(new GRect(LEFT_MARGIN,IMAGE_MARGIN+TOP_MARGIN+name.getHeight(),IMAGE_WIDTH,IMAGE_HEIGHT));
		else
			{ima=profile.getImage();
		    ima.setSize(IMAGE_WIDTH,IMAGE_HEIGHT);
			add(ima,LEFT_MARGIN,IMAGE_MARGIN+TOP_MARGIN+name.getHeight());}
		
		
		if(profile.getStatus().equals(""))
			label=new GLabel("No current status");
		else
			label=new GLabel(profile.getName()+" is "+profile.getStatus());
		label.setFont(PROFILE_STATUS_FONT);
		label.setLocation(LEFT_MARGIN, IMAGE_MARGIN+TOP_MARGIN+name.getHeight()+IMAGE_HEIGHT+STATUS_MARGIN+label.getAscent());
		add(label);
			
		
		GLabel friends=new GLabel("Friend: ");
		friends.setFont(PROFILE_FRIEND_LABEL_FONT);
		friends.setLocation(getWidth()/2, IMAGE_MARGIN+TOP_MARGIN+name.getHeight());
		add(friends);
		Iterator it=profile.getFriends();
		ylocation=IMAGE_MARGIN+TOP_MARGIN+name.getHeight()+friends.getHeight();
		if (it==null) ;
		else{
     	while(it.hasNext())
		{GLabel friendlist=new GLabel((String) it.next());
		friendlist.setLocation(getWidth()/2, ylocation);
		friendlist.setFont(PROFILE_FRIEND_FONT);
		ylocation+=name.getHeight();
		add(friendlist);	
		}}
		
			
		
	}
	
	
	public void displayAppMessage(String str){
		GLabel AppMessage=new GLabel(str);
		 AppMessage.setFont(MESSAGE_FONT);
		 AppMessage.setLocation(getWidth()/2-AppMessage.getWidth()/2, getHeight()-BOTTOM_MESSAGE_MARGIN);
		 //AppMessage.setLocation(getWidth()/2, ylocation);
		 add(AppMessage);
		 
		
		
	}
	
	
	
	private double ylocation;
	private GLabel label;
    private GImage ima;
	private GCanvas canvas=new GCanvas();
}
