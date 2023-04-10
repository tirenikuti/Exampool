//class to wrap the SQL Exception and surpass the catching if not needed
package comp3350.exampool.persistence.hsqldb;

/**
 * java.sql.SQLException is a checked exception, but the interface doesn't have any
 * checked exceptions, so java.sql.SQLException is wrapped in an unchecked java.lang.RuntimeException
 * so they can be thrown around, but they don't need to be caught if we don't want to.
 */

public class PersistenceException extends RuntimeException{
    public PersistenceException(final Exception cause) {
        super(cause);
    }
}
