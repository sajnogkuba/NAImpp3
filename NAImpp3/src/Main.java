import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static final Path dataDirectoryPath = Paths.get("Data");
    private static final DataLoader dataLoader = new DataLoader(dataDirectoryPath);
    private static final PerceptronLayer perceptronLayer = new PerceptronLayer(dataDirectoryPath);
    private static final List<TextFile> trainSet = dataLoader.loadData();

    public static void main(String[] args) {

    }
}
