import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Perceptron {
    private final String language;
    private List<Double> weights;
    private double threshold;

    public Perceptron(String language) {
        this.language = language;
        generateWeightsVector();
    }

    public boolean isActive(TextFile textFile){
        return calculateNetValue(textFile) > threshold;
    }

    public double calculateNetValue(TextFile textFile){
        double sum = 0;
        ProportionVector proportionVector = textFile.getProportionVector();
        for(int i = 0; i < proportionVector.size() - 1; i++){
            sum += proportionVector.get(i) * weights.get(i);
        }
        return sum;
    }

    private void generateWeightsVector() {
        this.threshold = Math.random();
        this.weights = Stream.generate(Math::random).limit(ProportionVector.latinaCharacters.size()).toList();
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
