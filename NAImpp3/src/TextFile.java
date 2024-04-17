import java.nio.file.Path;

public class TextFile {
    private String content;
    private final String language;

    public TextFile(String language, String content) {
        this.language = language;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextFile{" +
                "content='" + content + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
