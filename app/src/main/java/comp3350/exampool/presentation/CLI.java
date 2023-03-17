package comp3350.exampool.presentation;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Locale;

import comp3350.exampool.business.AccessNotes;
import comp3350.exampool.business.AccessFlashcards;
import comp3350.exampool.business.AccessUsers;
import comp3350.exampool.objects.Notes;
import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.User;

public class CLI
{
    public static BufferedReader console;
    public static String inputLine;
    public static String[] inputTokens;

    public static Notes currentNote;
    public static Flashcard currentFlashcard;
    public static User currentUser;

    public static String noteNumber;
    public static String flashcardNumber;
    public static String userNumber;

    public static String indent = " ";

    public static void run()
    {
        try
        {
            console = new BufferedReader(new InputStreamReader(System.in));
            process();
            console.close();
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    public static void process()
    {
        readLine();
        while ((inputLine != null) && (!inputLine.equalsIgnoreCase("exit"))
        && (!inputLine.equalsIgnoreCase("quit"))
        && (!inputLine.equalsIgnoreCase("q"))
        && (!inputLine.equalsIgnoreCase("bye")))
        {
            inputTokens = inputLine.split("\\s+");
            parse();
            readLine();
        }
    }

    public static void readLine()
    {
        try
        {
            System.out.print(">");
            inputLine = console.readLine();
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    public static void parse()
    {
        if(inputTokens[0].equalsIgnoreCase("get"))
        {
            processGet();
        }
        else
        {
            System.out.println("Invalid command.");
        }
    }

    public static void processGet()
    {
        if (inputTokens[1].equalsIgnoreCase("User"))
        {
            processGetUser();
        }
        else if (inputTokens[1].equalsIgnoreCase("Notes"))
        {
            processGetNote();
        }
        else if (inputTokens[1].equalsIgnoreCase("Flashcard"))
        {
            processGetFlashcard();
        }
        else
        {
            System.out.println("Invalid data tyoe");
        }
    }

    public static void processGetUser()
    {
        AccessUsers accessUsers;
        accessUsers = new AccessUsers();

    }

    public static void processGetNote()
    {
        AccessNotes accessNotes;
        accessNotes = new AccessNotes();
    }

    public static void processGetFlashcard()
    {
        AccessFlashcards accessFlashcards;
        accessFlashcards = new AccessFlashcards();
    }
}
