package comp3350.exampool.Tags;
import comp3350.exampool.Tags.Tags;
import comp3350.exampool.Tags.Node; 
import java.util.ArrayList; // import the ArrayList class

public class TagsLinkedList { 
  private Node head;
  public void insert(Tags data) {
    Node newElement = new Node(data);
    
    if (head == null) {
      head = newElement;
      return;
    }
    
    newElement.setNext(head); 
    head = newElement;       
    
  }
  public Node getHead(){
   return head; 
  }
  public ArrayList<Integer> searchTag(String searchName){
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (head != null) {  
      Node temp = head;
      int foundAtIndex = 0;
      while (temp != null) {
        //Store index of that particular element, if found.
        if ((temp.getTags().getTagName()).equals(searchName)) {
          result.add(foundAtIndex);//If tag was found, add it's particular index to the arraylist
        }
        //Gradually increases index while
        //traversing through the Linked List
        foundAtIndex++;
        temp = temp.getNext();
      }
    }
    return result;
  }
  
}
