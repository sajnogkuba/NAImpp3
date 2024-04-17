import java.nio.file.Path;
import java.util.List;


public class PerceptronLayer {
    private final List<Perceptron> perceptrons;
    public PerceptronLayer(Path dataDirectoryPath) {
        this.perceptrons = Perceptron.createPerceptronLists(dataDirectoryPath);
    }
}
