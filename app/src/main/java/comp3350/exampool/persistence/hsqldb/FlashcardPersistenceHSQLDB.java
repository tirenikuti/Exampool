package comp3350.exampool.persistence.hsqldb;

import java.lang.reflect.Type;
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
import comp3350.exampool.objects.Notes;
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
        System.out.println(dbPath);
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Flashcard fromResultSetMultipleChoice(final ResultSet rs) throws SQLException {
        final String flashcardID = rs.getString("flashcardID");
        final String userID = rs.getString("userID");

        final String question = rs.getString("question");
        final String answer = rs.getString("answer");

        final String option1 = rs.getString("option1");
        final String option2 = rs.getString("option2");
        final String option3 = rs.getString("option3");

        MultipleChoiceQuestion flashcard = new MultipleChoiceQuestion(flashcardID, userID, question, answer, option1, option2, option3);
        return flashcard;
    }

    private Flashcard fromResultSetTrueFalse(final ResultSet rs) throws SQLException {
        final String flashcardID = rs.getString("flashcardID");
        final String userID = rs.getString("userID");

        final String question = rs.getString("question");
        final String answer = rs.getString("answer");

        TrueFalseQuestion flashcard = new TrueFalseQuestion(flashcardID, userID, question, answer);
        return flashcard;
    }

    private Flashcard fromResultSetTyped(final ResultSet rs) throws SQLException {
        final String flashcardID = rs.getString("flashcardID");
        final String userID = rs.getString("userID");

        final String question = rs.getString("question");
        final String answer = rs.getString("answer");

        TypedAnswerQuestion flashcard = new TypedAnswerQuestion(flashcardID, userID, question, answer);
         return flashcard;
    }

    @Override
    public List<Flashcard> getFlashcardsSequential(){
        final List<Flashcard> flashcards = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM TYPEDQUESTION");
            while(rs.next())
            {
                final Flashcard flashcard = fromResultSetTyped(rs);
                flashcards.add(flashcard);
            }
            rs = st.executeQuery("SELECT * FROM MULTIPLECHOICEQUESTION");
            while(rs.next())
            {
                final Flashcard flashcard = fromResultSetMultipleChoice(rs);
                flashcards.add(flashcard);
            }
            rs = st.executeQuery("SELECT * FROM TRUEANDFALSEQUESTION");
            while(rs.next())
            {
                final Flashcard flashcard = fromResultSetTrueFalse(rs);
                flashcards.add(flashcard);
            }
            rs.close();
            st.close();

            return flashcards;
        }
        catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<Flashcard> getFlashcard(String currentFlashcard){
        final List<Flashcard> flashcards = new ArrayList<>();

        try(final Connection c = connection()) {
            PreparedStatement st = c.prepareStatement("");
            st.setString (1, currentFlashcard);

            ResultSet rs = st.executeQuery();
            //the while statement
            rs.close();
            st.close();

            return flashcards;
        }
        catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<Flashcard> getFlashcardOfUser(User currentUser) {
        final List<Flashcard> flashcards = new ArrayList<>();

        try (final Connection c = connection()) {
            PreparedStatement st = c.prepareStatement("SELECT * FROM flashcards WHERE userID = ?");
            st.setString(1, currentUser.getUserID());

            ResultSet rs = st.executeQuery();
            //the while statement
            rs.close();
            st.close();

            return flashcards;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
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
    public Flashcard insertTrueFalseFlashcard(TrueFalseQuestion currentFlashcard){
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO flashcards VALUES(?, ?, ?, ?, ?)");
            st.setString(1, currentFlashcard.getFlashcardID());
            st.setString(2, currentFlashcard.getUserID());
            st.setString(4, currentFlashcard.getQuestion());
            st.setString(5, currentFlashcard.getAnswer());

            st.executeUpdate();

            return currentFlashcard;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Flashcard insertTypedFlashcard(TypedAnswerQuestion currentFlashcard){
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO flashcards VALUES( ?, ?, ?, ?)");
            st.setString(1, currentFlashcard.getFlashcardID());
            st.setString(2, currentFlashcard.getUserID());
            st.setString(4, currentFlashcard.getQuestion());
            st.setString(5, currentFlashcard.getAnswer());

            st.executeUpdate();

            return currentFlashcard;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
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
            throw new PersistenceException(e);
        }
    }
}


