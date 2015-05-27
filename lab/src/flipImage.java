import acm.graphics.*;
import acm.program.*;
public class flipImage extends GraphicsProgram{
	public void run(){
		GImage image=new GImage("image.jpg");
		GImage newimage=flip(image);
	    add(newimage);
	}
private GImage flip(GImage image){
	int array[][]=image.getPixelArray();
	int newarray[][]=new int[array.length][array[1].length];
	  for (int i=0;i<array.length;i++){
		  for(int j=0;j<array[1].length;j++){
			  newarray[i][j]=array[i][array[1].length-1-j];
			  
		  }
		 
	  }
	  return new GImage(newarray);	
}
}
