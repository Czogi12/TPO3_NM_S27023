package zad1;

import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Futil {
    public static void processDir(String dirName, String resultFileName) {
        try (FileChannel outChannel = FileChannel.open(
                Paths.get(resultFileName),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE))
        {
            Files.walkFileTree(Paths.get(dirName), new RecursiveFileVisitor(outChannel));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
