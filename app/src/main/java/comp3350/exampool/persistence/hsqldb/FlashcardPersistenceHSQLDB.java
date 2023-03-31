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
import comp3350.exampool.objects.MultipleChoiceQuestion;
import comp3350.exampool.objects.TypedAnswerQuestion;
import comp3350.exampool.objects.TrueFalseQuestion;
import comp3350.exampool.objects.User;
import comp3350.exampool.persistence.FlashcardPersistence;

public class FlashcardPersistenceHSQLDB implements FlashcardPersistence {

    private final String dbPath;

    public FlashcardPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "User", "");
    }

    private Flashcard fromResultSet(final ResultSet rs) throws SQLException {
        final String flashcardID = rs.getString("flashcardID");
        final String userID = rs.getString("userID");

        final String question = rs.getString("question");
        final String answer = rs.getString("answer");

        final String option1 = rs.getString("option1");
        final String option2 = rs.getString("option2");
        final String option3;

        Flashcard flashcard;

        if(option2 != null){
            option3 = rs.getString("option1");
            flashcard = new MultipleChoiceQuestion(flashcardID, userID, question, answer, option1, option2, option3);
        }
        else if(option1 != null){
            flashcard = new TrueFalseQuestion(flashcardID, userID, question, answer, option1);
        }
        else{
            flashcard = new TypedAnswerQuestion(flashcardID, userID, question, answer);
        }
         return flashcard;
    }

    @Override
    public List<Flashcard> getFlashcardsSequential(){
        final List<Flashcard> flashcards = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM flashcards");
            while(rs.next())
            {
                final Flashcard flashcard = fromResultSet(rs);
                flashcards.add(flashcard);
            }
            rs = st.executeQuery("SELECT * FROM multiplechoicequestion");
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
    public List<Flashcard> getMultipleChoiceFlashcard(String currentFlashcard){
        final List<Flashcard> flashcards = new ArrayList<>();

        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM multiplechoicequestion WHERE flashCardID = ?");
            st.setString (1, currentFlashcard);

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
    public List<Flashcard> getFlashcard(String currentFlashcard){
        final List<Flashcard> flashcards = new ArrayList<>();

        try(final Connection c = connection()) {
            PreparedStatement st = c.prepareStatement("SELECT * FROM multiplechoicequestion WHERE flashCardID = ?");
            st.setString (1, currentFlashcard);

            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                final Flashcard flashcard = fromResultSet(rs);
                flashcards.add(flashcard);
            }
            st = c.prepareStatement("SELECT * FROM flashcards WHERE flashCardID = ?");
            st.setString (1, currentFlashcard);

            rs = st.executeQuery();
            while(rs.next())
            {
                final Flashcard flashcard = fromResultSet(rs);
                flashcards.add(flashcard);
            }
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
    public List<Flashcard> getFlashcardOfUser(User currentUser) {
        final List<Flashcard> flashcards = new ArrayList<>();

        try (final Connection c = connection()) {
            PreparedStatement st = c.prepareStatement("SELECT * FROM flashcards WHERE userID = ?");
            st.setString(1, currentUser.getUserID());

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                final Flashcard flashcard = fromResultSet(rs);
                flashcards.add(flashcard);
            }
            st = c.prepareStatement("SELECT * FROM multiplechoicequestion WHERE userID = ?");
            st.setString(1, currentUser.getUserID());

            rs = st.executeQuery();
            while (rs.next()) {
                final Flashcard flashcard = fromResultSet(rs);
                flashcards.add(flashcard);
            }
            rs.close();
            st.close();

            return flashcards;
        } catch (final SQLException e) {
            throw new android.database.SQLException();
        }
    }

    public Flashcard insertMultipleChoiceFlashcard(MultipleChoiceQuestion currentFlashcard)
    {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO multiplechoicequestion VALUES(?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, currentFlashcard.getFlashcardID());
            st.setString(2, currentFlashcard.getUserID());
            st.setString(4, currentFlashcard.getQuestion());
            st.setString(5, currentFlashcard.getAnswer());
            st.setString(6, currentFlashcard.getOption1());
            st.setString(7, currentFlashcard.getOption2());
            st.setString(8, currentFlashcard.getOption3());

            st.executeUpdate();

            return currentFlashcard;
        } catch (final SQLException e) {
            throw new android.database.SQLException();
        }
    }

    @Override
    public Flashcard insertFlashcard(Flashcard currentFlashcard){
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO flashcards VALUES(?, ?, ?, ?)");
            st.setString(1, currentFlashcard.getFlashcardID());
            st.setString(2, currentFlashcard.getUserID());
            st.setString(4, currentFlashcard.getQuestion());
            st.setString(5, currentFlashcard.getAnswer());

            st.executeUpdate();

            return currentFlashcard;
        } catch (final SQLException e) {
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


