/*
 *Main Search bar - Tags
 * Needed in Tag getTagName()
 */
package comp3350.exampool.business.search;

import java.util.ArrayList;

import comp3350.exampool.Tags.TagsLinkedList;


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
        result.add(TagsLinkedList.tagAtIndex(tagIndex.get(i)));
      }
    }
    return result;
  }
  public String displaySearchResults(Tags tagNames){
    return tagNames.getTagName(); 
  }
}



