//Executes the Command Line Interface (CLI) used to run programs, manage files and interact with the database
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

  /**
   * Setting up Database
   * @param name database path name
   */
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

  /**
   * Getter
   * @return path name
   */
  public static String getDBPathName() {
    return dbName; 
  }
}
