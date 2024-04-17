import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static final Path dataDirectoryPath = Paths.get("/Users/kubasajnog/Desktop/PJATK/Semestr IV/NAI - narzędzia sztucznej inteligencji/Projekty_Programistyczne/Projekt03/NAImpp3/NAImpp3/Data");
    public static void main(String[] args) {
        List<Perceptron> perceptrons = Perceptron.createPerceptronLists(dataDirectoryPath);
    }
}