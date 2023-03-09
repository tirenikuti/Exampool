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
import comp3350.exampool.persistence.FlashcardPersitence;

public class FlashcardPersitenceHSQLDB implements FlashcardPersistence {
    
    public FlashcardPersitenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "USer", "");
    }

    private Flashcard fromResultSet(final ResultSet rs) throws SQLException {
        final String flashcardID = rs.getString("flashcardID");
        final String userID = rs.getString("userID");
    }

}
