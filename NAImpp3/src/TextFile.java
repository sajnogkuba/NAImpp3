public class TextFile {
    private final String content;
    private final String language;
    private final ProportionVector proportionVector;

    public TextFile(String language, String content) {
        this.language = language;
        this.content = content;
        this.proportionVector = new ProportionVector(content);
    }

    @Override
    public String toString() {
        return "TextFile{" +
                "content='" + content + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public String getLanguage() {
        return language;
    }

    public ProportionVector getProportionVector() {
        return proportionVector;
    }
}
