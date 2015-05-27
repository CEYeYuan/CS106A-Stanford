/**
* This class provides methods for working with an array that expands
* to include any positive index value supplied by the caller.
*/
public class ExpandableArray {
	
	
/**
* Creates a new expandable array with no elements.
*/
public ExpandableArray() {
	expandablearray=new Object[0] ;
//. . . You fill in the implementation . . .
}
/**
* Sets the element at the given index position to the specified.
* value. If the internal array is not large enough to contain that
* element, the implementation expands the array to make room.
*/
public void set(int index, Object value) {
	if (expandablearray.length-1>index)
		expandablearray[index]=value;
	else{
		 Object[] arr=new  Object[expandablearray.length] ;
		 for(int i=0;i<expandablearray.length;i++)
			 arr[i]=expandablearray[i];
		 expandablearray=new Object[index+1];
		 for(int i=0;i<arr.length;i++)
			 expandablearray[i]=arr[i];
		 for(int i=arr.length;i<index;i++)
			 expandablearray[i]=null;
		 expandablearray[index]=value;
			 
		 
		
	}
	
//. . . You fill in the implementation . . .
}
/**
* Returns the element at the specified index position, or null if
* no such element exists. Note that this method never throws an
* out-of-bounds exception; if the index is outside the bounds of
* the array, the return value is simply null.
*/
public Object get(int index) {
//. . . You fill in the implementation . . .
	return expandablearray[index];
}

private Object[] expandablearray;
}