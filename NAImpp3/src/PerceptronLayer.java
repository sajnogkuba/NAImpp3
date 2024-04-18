import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    public double checkAccuracy() {
        double correctAnswers = 0;
        for (TextFile textFile : testSet) {
            if(textFile.getLanguage().equals(classify(textFile))){
                correctAnswers++;
            }
        }
        return correctAnswers / testSet.size() * 100;
    }

    public String classify(TextFile textFile){
        Map<Perceptron, Double> netValues = HashMap.newHashMap(perceptrons.size());
        for (Perceptron perceptron : perceptrons) {
            netValues.put(perceptron, perceptron.calculateNetValue(textFile));
        }
        Perceptron mostActivated = perceptrons.getFirst();
        for (Map.Entry<Perceptron, Double> entry : netValues.entrySet()) {
            if(entry.getValue() > mostActivated.calculateNetValue(textFile)){
                mostActivated = entry.getKey();
            }
        }
        return mostActivated.getLanguage();
    }
    public void teach() {
        for (TextFile textFile : trainSet) {
            for (Perceptron perceptron : perceptrons) {
                    perceptron.teach(textFile);
            }
        }
    }

    public void test() {
        for (TextFile textFile : trainSet) {
            System.out.println(classify(textFile));
        }
    }
}
