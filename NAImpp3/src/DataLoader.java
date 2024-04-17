import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    private final Path dataDirectoryPath;
    public DataLoader(Path dataDirectoryPath) {
        this.dataDirectoryPath = dataDirectoryPath;
    }

    public List<TextFile> loadData() {
        List<TextFile> textFiles = new ArrayList<>();
        try {
            Files.walkFileTree(dataDirectoryPath, new SimpleFileVisitor<>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    textFiles.add(
                            new TextFile(
                                    file.getParent().getFileName().toString(),
                                    Files.readString(file).toLowerCase().replaceAll("[^a-z]", ""))
                    );
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return textFiles;
    }
}
