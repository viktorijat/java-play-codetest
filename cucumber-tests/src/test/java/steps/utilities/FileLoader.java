package steps.utilities;

import com.google.common.base.Charsets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class FileLoader {

    public static String getStringFromJson(String fileName) throws IOException {

        String path = Thread.currentThread().getContextClassLoader().getResource("files/" + fileName).getFile();
        File testFile = Paths.get(path).toFile();
        return readFile(testFile.getAbsolutePath());
    }

    private static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charsets.UTF_8);
    }
}
