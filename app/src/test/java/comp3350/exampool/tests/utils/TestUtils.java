package comp3350.exampool.tests.utils;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

import comp3350.exampool.application.Services;

public class TestUtils{
    private static final File DB_SRC = new File("src/main/assets/db/DB.script");

    public static File copyDB() throws IOException {
        final File target = File.createTempFile("temp-dp", ".script");
        Files.copy(DB_SRC, target);
        Services.setDBPathName(target.getAbsolutePath().replace(".script", ""));
        return target;
    }
}
