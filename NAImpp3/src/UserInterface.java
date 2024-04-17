import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UserInterface extends JFrame {
    private static final Path dataDirectoryPath = Paths.get("Data");
    private static final Path testDirectoryPath = Paths.get("Test");
    private static final PerceptronLayer perceptronLayer = new PerceptronLayer(dataDirectoryPath, testDirectoryPath);
    UserInterface(){
        for (int i = 0; i < 10000 && perceptronLayer.checkAccuracy() < 100; i++){
            System.out.println("Accuracy: " + perceptronLayer.checkAccuracy() + " %");
            perceptronLayer.teach();
        }


        JPanel north = new JPanel(new FlowLayout());
        JLabel typeInText = new JLabel("Type in Text to classify");
        JButton classify = new JButton("Classify!");
        north.add(typeInText);
        north.add(classify);
        JLabel south = new JLabel("              I think it is: ");
        JScrollPane center = new JScrollPane(new JTextArea());
        center.setPreferredSize(new Dimension(500, 300));
        this.add(north, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
