import java.nio.file.Path;
import java.util.List;


public class PerceptronLayer {
    private final List<TextFile> trainSet;
    private final List<TextFile> testSet;
    private final List<Perceptron> perceptrons;
    public PerceptronLayer(Path dataDirectoryPath, Path testDirectoryPath) {
        this.perceptrons = Perceptron.createPerceptronLists(dataDirectoryPath);
        DataLoader dataLoader = new DataLoader(dataDirectoryPath);
        this.trainSet = dataLoader.loadData();
        dataLoader = new DataLoader(testDirectoryPath);
        this.testSet = dataLoader.loadData();
    }

    public int checkAccuracy() {
        return 0;
    }

    public String classify(TextFile textFile){
        return null;
    }
    public void teach() {
        for (TextFile textFile : trainSet) {
            for (Perceptron perceptron : perceptrons) {
                if(
                        (perceptron.isActive(textFile) && !textFile.getLanguage().equals(perceptron.getLanguage())
                        || !perceptron.isActive(textFile) && textFile.getLanguage().equals(perceptron.getLanguage()))
                ){
                    perceptron.teach(textFile);
                }
            }
        }
    }
}
