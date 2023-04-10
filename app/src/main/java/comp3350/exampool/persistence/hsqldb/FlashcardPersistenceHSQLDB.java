//Used to create and execute queries regarding creation, deletion and editing of flashcards in the Database
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

    /**
     * Constructor for the class
     * @param dbPath path to Database
     */
    public FlashcardPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    /**
     * Method to establish connection to the databse
     * @return the connection
     * @throws SQLException if the connection was unsuccessful
     */
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true;hsqldb.lock_file=false", "SA", "");
    }

    /**
     * Method to create multiple choice from a result set from a query in SQL
     * @param rs result set
     * @return flashcard from database
     * @throws SQLException if creation from database was unsuccessful
     */
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

    /**
     * Method to create true or false question from a result set from a query in SQL
     * @param rs result set
     * @return flashcard from database
     * @throws SQLException if creation from database was unsuccessful
     */
    private Flashcard fromResultSetTrueFalse(final ResultSet rs) throws SQLException {
        final String flashcardID = rs.getString("flashcardID");
        final String userID = rs.getString("userID");

        final String question = rs.getString("question");
        final String answer = rs.getString("answer");

        TrueFalseQuestion flashcard = new TrueFalseQuestion(flashcardID, userID, question, answer);
        return flashcard;
    }

    /**
     * Method to create typed question from a result set from a query in SQL
     * @param rs result set
     * @return flashcard from database
     * @throws SQLException if creation from database was unsuccessful
     */
    private Flashcard fromResultSetTyped(final ResultSet rs) throws SQLException {
        final String flashcardID = rs.getString("flashcardID");
        final String userID = rs.getString("userID");

        final String question = rs.getString("question");
        final String answer = rs.getString("answer");

        TypedAnswerQuestion flashcard = new TypedAnswerQuestion(flashcardID, userID, question, answer);
         return flashcard;
    }

    /**
     * Gets all the flashcards in the database
     * @return list of flashcards
     */
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

    /**
     * Gets all the multiple choice questions in the database
     * @return list of all multiple choice questions
     */
    @Override
    public List<Flashcard> getMCQFlashcardsSequential(){
        final List<Flashcard> flashcards = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM MULTIPLECHOICEQUESTION");
            while(rs.next())
            {
                final Flashcard flashcard = fromResultSetMultipleChoice(rs);
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

    /**
     * Gets all the true or false questions in the database
     * @return list of all true and false questions
     */
    @Override
    public List<Flashcard> getTFQFlashcardsSequential(){
        final List<Flashcard> flashcards = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM TRUEANDFALSEQUESTION");
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

    /**
     * Gets all the typed questions in the database
     * @return list of all typed questions
     */
    @Override
    public List<Flashcard> getTypedFlashcardsSequential(){
        final List<Flashcard> flashcards = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM TYPEDQUESTION");
            while(rs.next())
            {
                final Flashcard flashcard = fromResultSetTyped(rs);
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


    /**
     * Gets a specific flashcard from the database
     * @param currentFlashcardID flashcard needed from DB
     * @return flashcard if it exists
     */
    @Override
    public List<Flashcard> getFlashcard(String currentFlashcardID){
        final List<Flashcard> flashcards = new ArrayList<>();

        try(final Connection c = connection()) {
            PreparedStatement st = c.prepareStatement("Select * from MULTIPLECHOICEQUESTION where flashcardID = ?");
            st.setString (1, currentFlashcardID);

            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                final Flashcard flashcard = fromResultSetMultipleChoice(rs);
                flashcards.add(flashcard);
            }
            st = c.prepareStatement("Select * from TRUEANDFALSEQUESTION where flashcardID = ?");
            st.setString (1, currentFlashcardID);
            rs = st.executeQuery();
            while (rs.next())
            {
                final Flashcard flashcard = fromResultSetTrueFalse(rs);
                flashcards.add(flashcard);
            }
            st = c.prepareStatement("Select * from TYPEDQUESTION where flashcardID = ?");
            st.setString (1, currentFlashcardID);
            rs = st.executeQuery();
            while (rs.next())
            {
                final Flashcard flashcard = fromResultSetTyped(rs);
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

    /**
     * Gets a list of all flashcards of a specific user
     * @param currentUser user whose flashcards are being accessed
     * @return list of flashcards
     */
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

    /**
     * Method to insert a new MCQ flashcard to the database
     * @param currentFlashcard flashcard to be inserted
     * @return flashcard if it is inserted successfully
     */
    public Flashcard insertMultipleChoiceFlashcard(MultipleChoiceQuestion currentFlashcard)
    {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO MULTIPLECHOICEQUESTION VALUES(?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, currentFlashcard.getFlashcardID());
            st.setString(2, currentFlashcard.getUserID());
            st.setString(3, currentFlashcard.getQuestion());
            st.setString(4, currentFlashcard.getAnswer());
            st.setString(5, currentFlashcard.getOption1());
            st.setString(6, currentFlashcard.getOption2());
            st.setString(7, currentFlashcard.getOption3());

            st.executeUpdate();
            System.out.println("Added Flashcard");

            return currentFlashcard;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     * Method to insert a new TFQ flashcard to the database
     * @param currentFlashcard flashcard to be inserted
     * @return flashcard if it is inserted successfully
     */
    @Override
    public Flashcard insertTrueFalseFlashcard(TrueFalseQuestion currentFlashcard){
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO TRUEANDFALSEQUESTION VALUES(?, ?, ?, ?)");
            st.setString(1, currentFlashcard.getFlashcardID());
            st.setString(2, currentFlashcard.getUserID());
            st.setString(3, currentFlashcard.getQuestion());
            st.setString(4, currentFlashcard.getAnswer());

            st.executeUpdate();

            return currentFlashcard;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     * Method to insert a new Typed Answer flashcard to the database
     * @param currentFlashcard flashcard to be inserted
     * @return flashcard if it is inserted successfully
     */
    @Override
    public Flashcard insertTypedFlashcard(TypedAnswerQuestion currentFlashcard){
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO TYPEDQUESTION VALUES( ?, ?, ?, ?)");
            st.setString(1, currentFlashcard.getFlashcardID());
            st.setString(2, currentFlashcard.getUserID());
            st.setString(3, currentFlashcard.getQuestion());
            st.setString(4, currentFlashcard.getAnswer());

            st.executeUpdate();

            return currentFlashcard;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     * Method to delete a MCQ flashcard from the database
     * @param currentFlashcard flashcard to be deleted
     */
    @Override
    public void deleteMCQFlashcard(Flashcard currentFlashcard){
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM MULTIPLECHOICEQUESTION WHERE flashcardID = ?");
            st.setString(1,currentFlashcard.getFlashcardID());
            st.executeUpdate();
        }
        catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    /**
     * Method to delete a TFQ flashcard from the database
     * @param currentFlashcard flashcard to be deleted
     */
    @Override
    public void deleteTFQFlashcard(Flashcard currentFlashcard){
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM TRUEANDFALSEQUESTION WHERE flashcardID = ?");
            st.setString(1,currentFlashcard.getFlashcardID());
            st.executeUpdate();
        }
        catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    /**
     * Method to delete a Typed Answer flashcard from the database
     * @param currentFlashcard flashcard to be deleted
     */
    @Override
    public void deleteTypedFlashcard(Flashcard currentFlashcard){
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM TYPEDQUESTION WHERE flashcardID = ?");
            st.setString(1,currentFlashcard.getFlashcardID());
            st.executeUpdate();
        }
        catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    /**
     * Method to update a MCQ flashcard in the database
     * @param currentFlashcard flashcard to be updated
     * @return flashcard if it is updated successfully
     */
    @Override
    public Flashcard updateMCQFlashcard(MultipleChoiceQuestion currentFlashcard){
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("Update MULTIPLECHOICEQUESTION set question = ?, answer = ?, option1 = ?, option2 = ?, option3 = ? WHERE flashCardID = ?");
            st.setString (1, currentFlashcard.getQuestion());
            st.setString(2, currentFlashcard.getAnswer());
            st.setString(3, currentFlashcard.getOption1());
            st.setString(4,currentFlashcard.getOption2());
            st.setString(5,currentFlashcard.getOption3());
            st.setString(6,currentFlashcard.getFlashcardID());
            st.executeUpdate();

            return currentFlashcard;
        }
        catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    /**
     * Method to update a TFQ flashcard in the database
     * @param currentFlashcard flashcard to be updated
     * @return flashcard if it is updated successfully
     */
    @Override
    public Flashcard updateTFQFlashcard(TrueFalseQuestion currentFlashcard){
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("Update TRUEANDFALSEQUESTION set question = ?, answer = ? WHERE flashCardID = ?");
            st.setString (1, currentFlashcard.getQuestion());
            st.setString(2, currentFlashcard.getAnswer());
            st.setString(3,currentFlashcard.getFlashcardID());
            st.executeUpdate();

            return currentFlashcard;
        }
        catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    /**
     * Method to update a Typed flashcard in the database
     * @param currentFlashcard flashcard to be updated
     * @return flashcard if it is updated successfully
     */
    @Override
    public Flashcard updateTypedFlashcard(TypedAnswerQuestion currentFlashcard){
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("Update TYPEDQUESTION set question = ?, answer = ? WHERE flashCardID = ?");
            st.setString (1, currentFlashcard.getQuestion());
            st.setString(2, currentFlashcard.getAnswer());
            st.setString(3,currentFlashcard.getFlashcardID());
            st.executeUpdate();

            return currentFlashcard;
        }
        catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }
}


