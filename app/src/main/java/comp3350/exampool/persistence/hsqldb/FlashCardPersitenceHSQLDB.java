package comp3350.exampool.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import comp3350.exampool.objects.Flashcard;
import comp3350.exampool.objects.QuestionType;
import comp3350.exampool.objects.User;
import comp3350.exampool.persistence.FlashcardsPersistence;

public class FlashCardPersitenceHSQLDB implements FlashcardsPersistence {

    private final String dbPath;
    
    public FlashCardPersitenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "USer", "");
    }

    private Flashcard fromResultSet(final ResultSet rs) throws SQLException {
        final String flashcardID = rs.getString("flashcardID");
        final String userID = rs.getString("userID");
        final String type = rs.getString("questionType");
        QuestionType questionType = QuestionType.LAQ;


        final String question = rs.getString("question");
        final String answer = rs.getString("answer");
        final int optionsNum = Integer.parseInt(rs.getString("optionsNum"));

        final String option1; 
        final String option2;
        final String option3;

        Flashcard flashcard = new Flashcard();

        if (type.equals("MCQ")){
            questionType = QuestionType.MCQ;
            option1 = rs.getString("option1");
            option2 = rs.getString("option1");
            option3 = rs.getString("option1");
            flashcard = new Flashcard(flashcardID, userID, questionType, question, answer, optionsNum, option1, option2, option3);
        }
        else if(type.equals("TFQ")){
            questionType = QuestionType.TFQ;
            option1 = rs.getString("option1");
            flashcard = new Flashcard(flashcardID, userID, questionType, question, answer, optionsNum, option1);
        }
        else if(type.equals("SAQ")){
            questionType = QuestionType.SAQ;
            flashcard = new Flashcard(flashcardID, userID, questionType, question, answer, optionsNum);
        }
        else{
            questionType = QuestionType.LAQ;
            flashcard = new Flashcard(flashcardID, userID, questionType, question, answer, optionsNum);
        }

         return flashcard;
    }

    @Override
    public List<Flashcard> getFlashcardsSequential(){
        final List<Flashcard> flashcards = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM flashcards");
            while(rs.next())
            {
                final Flashcard flashcard = fromResultSet(rs);
                flashcards.add(flashcard);
            }
            rs.close();
            st.close();

            return flashcards;
        }
        catch (final SQLException e){
            throw new android.database.SQLException();
        }
    }

    @Override
    public List<Flashcard> getFlashcard(Flashcard currentFlashcard){
        final List<Flashcard> flashcards = new ArrayList<>();

        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM flashcards WHERE flashCardID = ?");
            st.setString (1, currentFlashcard.getFlashcardID());

            final ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                final Flashcard flashcard = fromResultSet(rs);
                flashcards.add(flashcard);
            }
            rs.close();
            st.close();

            return flashcards;
        }
        catch (final SQLException e){
            throw new android.database.SQLException();
        }
    }

    @Override
    public List<Flashcard> getFlashcardUsers(User currentUser){
        final List<Flashcard> flashcards = new ArrayList<>();

        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM flashcards WHERE userID = ?");
            st.setString (1, currentUser.getUserID());

            final ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                final Flashcard flashcard = fromResultSet(rs);
                flashcards.add(flashcard);
            }
            rs.close();
            st.close();

            return flashcards;
        }
        catch (final SQLException e){
            throw new android.database.SQLException();
        }
    }

    @Override
    public void deleteFlashcard(Flashcard currentFlashcard){
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM flashcards WHERE flashCardID = ?");
            st.setString (1, currentFlashcard.getFlashcardID());
            st.executeUpdate();
        }
        catch (final SQLException e){
            throw new android.database.SQLException();
        }
    }
   
}


