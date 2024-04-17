import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProportionVector {
    public static final List<Character> latinaCharacters = getLatinaCharacters();
    private final List<Double> proportions = new ArrayList<>(Arrays.asList(new Double[26]));



    public ProportionVector(String text) {
        Collections.fill(proportions, 0.0);
        calculateProportions(text);
    }

    private void calculateProportions(String text) {
        text.chars().forEach(c -> proportions.set(
                latinaCharacters.indexOf((char) c), proportions.get(latinaCharacters.indexOf((char) c)) + 1
                )
        );
        proportions.replaceAll(aDouble -> aDouble / text.length());
    }

    private static List<Character> getLatinaCharacters() {
        return new ArrayList<>(IntStream.rangeClosed('a', 'z').mapToObj(c -> (char) c).toList());
    }
}
