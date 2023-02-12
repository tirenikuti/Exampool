package comp3350.exampool.Tags;

//Placeholder class to fix errors until next iteration
public class Tags {
    private String tagName;//The name of the tag
    private static noOfTags =0;//The number of tags that exists

    public Tags(String tN) {
        tagName = tN;
        noOfTags++;
    }

    public String getTagName() {
        return tagName;
    }
}

