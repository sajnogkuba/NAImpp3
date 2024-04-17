import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DataLoader {
    private final Path dataDirectoryPath;
    public DataLoader(Path dataDirectoryPath) {
        this.dataDirectoryPath = dataDirectoryPath;
    }
    private static final List<Character> asciiLetters = getAsciiLetters();

    private static List<Character> getAsciiLetters() {
        return IntStream.rangeClosed('a', 'z').mapToObj(c -> (char) c).toList();
    }

    public List<TextFile> loadData() {
        List<TextFile> textFiles = new ArrayList<>();
        try {
            Files.walkFileTree(dataDirectoryPath, new SimpleFileVisitor<>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    textFiles.add(new TextFile(file.getParent().getFileName().toString(), Files.readString(file)));
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<TextFile> result = deleteSpaces(textFiles);
        return result;
    }

    private List<TextFile> deleteSpaces(List<TextFile> textFiles) {
        textFiles.forEach(textFile -> textFile.setContent(textFile.getContent().replace(" ", "")));
        return textFiles;
    }
}
