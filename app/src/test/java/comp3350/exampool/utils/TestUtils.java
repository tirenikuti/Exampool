package comp3350.exampool.utils;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

import comp3350.exampool.application.Main;

public class TestUtils{
    private static final FILE DB_SRC = new File("src/main/assets/db/DB.script");

    public static File copyDB() throws IOException {
        final File target = File.createTempFile("temp-dp", ".script");
        Files.copy(DB_SRC, target);
        Main.setDBPathName(target.getAbsolutePath().replace(".script", ""));
        return target;
    }
}
