
//Placeholder class to fix errors until next iteration
package comp3350.exampool.Tags;

public class Tags {
    private String tagName;//The name of the tag
    private static int noOfTags =0;//The number of tags that exists

    public Tags(String tN) {
        tagName = tN;
        noOfTags++;
    }

    public String getTagName() {
        return tagName;
    }
}
