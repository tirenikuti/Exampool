/*
 *Main Search bar - Tags
 * Needed in Tag getTagName()
 */
package comp3350.exampool.Search;

import comp3350.exampool.Tags.TagsLinkedList;
import java.util.ArrayList; // import the ArrayList class

public class SearchBar {
  private String searchWord;
  public SearchBar(String sW){//Constructor
    this.searchWord = sW.trim();//Remove Leading and Trailing Whitespaces     
  }
  public ArrayList<Tags> searchTags(){
    ArrayList<Integer> tagIndex = TagsLinkedList.searchTag(searchWord);//Found indexes
    ArrayList<Tags> result = new ArrayList<Tags>();//Found results
    if (tagIndex.size() == 0) {
      return null; //System.out.println("Tag not found");
    }else{
      for(int i = 0; i < tagIndex.size(); i++){
        result.add(TagsLinkedList.tagAtIndex(tagIndex));
      }
    }
    return result;
  }
  public String displaySearchResults(Tags tagNames){
    return tagNames.getTagName(); 
  }
}



