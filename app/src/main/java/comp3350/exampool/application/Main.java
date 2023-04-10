package comp3350.exampool.application;

import comp3350.exampool.presentation.CLI;

public class Main 
{
  private static String dbName = "DB";

  public static void main(String[] args) 
  {
    CLI.run();
    System.out.println("Done");
  }

  public static void setDBPathName(final String name)
  {
    try {
      Class.forName("org.hsqldb.jdbcDriver").newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    dbName = name;
  }

  public static String getDBPathName() {
    return dbName; 
  }
}
