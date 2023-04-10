//class to manage Exceptions from the activity
package comp3350.exampool.presentation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class Messages {
    /**
     * Error that prevents the user from moving on
     * @param owner
     * @param message
     */
    public static void fatalError(final Activity owner, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(owner).create();

        alertDialog.setTitle("Fatal error");
        alertDialog.setMessage(message);
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                owner.finish();
            }
        });

        alertDialog.show();
    }

    /**
     * Error that provides warnings to the user
     * @param owner
     * @param message
     */
    public static void warning(Activity owner, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(owner).create();

        alertDialog.setTitle("Warning");
        alertDialog.setMessage(message);

        alertDialog.show();
    }
}
