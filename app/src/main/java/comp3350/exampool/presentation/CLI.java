//Command line interface to run programs, manage files and interact with the database
package comp3350.exampool.presentation;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

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

    /**
     * Initiates the reader for the database file and starts the processing of it.
     */
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

    /**
     * Reads in and processes the database file line by line.
     */
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

    /**
     * reads the line from the console to inputLine variable
     */
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
            System.out.println("Invalid data type");
        }
    }

    public static void processGetUser()
    {
        AccessUsers accessUsers;
        accessUsers = new AccessUsers();

        if(inputTokens.length > 2) {
            if (inputTokens[2].equalsIgnoreCase("orphan"))
            {
                currentUser = accessUsers.getSequential();
                while (currentUser != null)
                {
                    userNumber = currentUser.getUserID();
                    currentUser = accessUsers.getSequential();
                }
            }
            else
            {
                userNumber = inputTokens[2];
                currentUser = accessUsers.getRandom(userNumber);
                System.out.println(indent + currentUser);
            }
        }
        else{
            currentUser = accessUsers.getSequential();
            while (currentUser != null)
            {
                userNumber = currentUser.getUserID();
                System.out.println(indent + currentUser);
                currentUser = accessUsers.getSequential();
            }
        }
    }

    public static void processGetNote()
    {
        AccessNotes accessNotes;
        accessNotes = new AccessNotes();

        if(inputTokens.length > 2) {
            if (inputTokens[2].equalsIgnoreCase("orphan"))
            {
                currentNote = accessNotes.getSequential();
                while (currentNote != null)
                {
                    noteNumber = currentNote.getNoteID();
                    currentNote = accessNotes.getSequential();
                }
            }
            else
            {
                noteNumber = inputTokens[2];
                currentNote = accessNotes.getNote(noteNumber);
                System.out.println(indent + currentUser);
            }
        }
        else{
            currentNote = accessNotes.getSequential();
            while (currentNote != null)
            {
                noteNumber = currentNote.getNoteID();
                System.out.println(indent + currentNote);
                currentNote = accessNotes.getSequential();
            }
        }
    }

    public static void processGetFlashcard()
    {
        AccessFlashcards accessFlashcards;
        accessFlashcards = new AccessFlashcards();

        if(inputTokens.length > 2) {
            if (inputTokens[2].equalsIgnoreCase("orphan"))
            {
                currentFlashcard = accessFlashcards.getSequential();
                while (currentFlashcard != null)
                {
                    flashcardNumber = currentFlashcard.getFlashcardID();
                    currentFlashcard = accessFlashcards.getSequential();
                }
            }
            else
            {
                flashcardNumber = inputTokens[2];
                currentFlashcard = accessFlashcards.getFlashcard(flashcardNumber);
                System.out.println(indent + currentFlashcard);
            }
        }
        else{
            currentFlashcard = accessFlashcards.getSequential();
            while (currentFlashcard != null)
            {
                flashcardNumber = currentFlashcard.getFlashcardID();
                System.out.println(indent + currentFlashcard);
                currentFlashcard = accessFlashcards.getSequential();
            }
        }
    }
}
