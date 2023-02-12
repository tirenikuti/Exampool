package comp3350.exampool.Tags;
import java.util.ArrayList; // import the ArrayList class

//TagsList is a list of all tags created. Note: Tag must be unique
public class TagsList {
  private ArrayList<Tags> tagList;
  private static int noOfTags;
  
  public TagsList(){//Constructor to create an empty tag list
   tagList = new ArrayList<Tags> ();
   noOfTags = 0;
  }
  
  public void createTags(String tagName){//Creating a tag
       tagList.add(noOfTags, new Tag(tagName));
       noOfTags++;
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