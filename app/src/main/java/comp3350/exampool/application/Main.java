package comp3350.exampool.application;
//import java.util.Scanner;

//Obj Imports
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.MultipleChoiceQuestion;

public class Main 
{
  private static String dbName = "DB";

  public static void main(String[] args) 
  {


  }

  public static void setDBPathName(final String name)
  {
    try {
      Class.forName("org.hsqldb.jdbcDriver").newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e/printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace
    }
    dbName = name;
  }

  public static String getDBPathName() {
    return dbName; 
  }
}
