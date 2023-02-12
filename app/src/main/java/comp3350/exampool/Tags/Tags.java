package comp3350.exampool.Tags;

import java.util.ArrayList;
import java.util.ArrayList; // import the ArrayList class


//Placeholder class to fix errors until next iteration
public class Tags {
    public Tags(){
    }
    
    public String getTagName(){
        return null;
    }

public ArrayList searchTag(String searchName){
  ArrayList<Integer> result = new ArrayList<Integer>();
  if (head != null) {  
    Node temp = head;
    int foundAtIndex = 0;
    while (temp != null) {
      //Store index of that particular element, if found.
      if ((temp.getTagName()).equals(searchName)) {
        result.add(index);//If tag was found, add it's particular index to the arraylist
      }
      //Gradually increases index while
      //traversing through the Linked List
      index++;
      temp = temp.next;
    }
  }
  return result;
}

public Tags tagAtIndex(int index){//Function to return a tag found at index 
  Node temp = head;
  if(index <= size()){  
    for (int i = 0; i < index; i++) {
      temp.next();
    }
  }
  return temp;
}

}
