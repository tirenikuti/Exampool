//package comp3350.exampool.Tags;
//import comp3350.exampool.Tags.Tags; 

public class Node {
    private Tags data;
    private Node next;
    
    public Node(Tags data) {
      this.data = data;
      this.next = null;  
    }
    public Node getNext(){
     return next; 
    }
    public void setNext(Node next){
     this.next = next; 
    }
    
    public Tags getTags(){
      return this.data;
    }
    
  }