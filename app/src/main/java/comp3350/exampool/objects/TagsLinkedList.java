package comp3350.exampool.Tags;
import comp3350.exampool.Tags.Tags;
import comp3350.exampool.Tags.Node; 
import java.util.ArrayList; // import the ArrayList class

public class TagsLinkedList  {
  private static Node head;
  private static int noOfTags = 0;
  public void insert(Tags data) {
    Node newElement = new Node(data);
    
    if (head == null) {
      head = newElement;
      return;
    }
    
    newElement.setNext(head); 
    head = newElement;       
    noOfTags++;
  }
  
  public Node remove(Tags target, Node curr) {
    /* If current reaches the end (null), target was not found. */
    if (curr == null) {
      return null;
    }
    
    /* Conditional to check if target is found. */
    if (curr.getTags().equals(target)) {
      /* remove target node by returning next. */
      noOfTags--;
      return curr.getNext();
      
    }
    /* Target is not found, so set next to recursive call. */
    else {
      curr.setNext(remove(target, curr.getNext()));
    }
    
    return curr;
  }
  public Node getHead(){
    return head; 
  }
  public static ArrayList<Integer> searchTag(String searchName){
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
  public static Tags tagAtIndex(int index){//Function to return a tag found at index
    Node temp = head;
    if(index <= noOfTags){  
      for (int i = 0; i < index; i++) {
        temp.getNext();
      }
    }
    return temp.getTags();
  }
  
}
