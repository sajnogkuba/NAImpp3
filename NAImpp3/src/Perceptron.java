import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Perceptron {
    private final String language;

    public Perceptron(String language) {
        this.language = language;
    }

    public static List<Perceptron> createPerceptronLists(Path dataDirectoryPath) {
        List<Perceptron> perceptrons = new ArrayList<>();
        try {
            Files.walkFileTree(dataDirectoryPath, new SimpleFileVisitor<>(){
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                    if (!dir.toFile().getName().equals(dataDirectoryPath.toFile().getName()))
                        perceptrons.add(new Perceptron(dir.toFile().getName()));
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return perceptrons;
    }

    public String getLanguage() {
        return language;
    }
}
