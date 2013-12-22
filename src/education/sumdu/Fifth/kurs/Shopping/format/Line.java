package education.sumdu.Fifth.kurs.Shopping.format;

public class Line {
    private String[] text;
    int[] align = new int[] { 1, -1, 1, 1, 1, 1 };

    public Line() {
    }

    public Line(String[] text) {
        setText(text);
    }

    public Line(String[] text, int[] align) {
        if (text.length != align.length)
            throw new IllegalArgumentException(
                    "text lenght != align length. Please, check you configuration");
        setText(text);
        setAlign(align);
    }

    public int[] getAlign() {
        return align;
    }

    public void setAlign(int[] align) {
        this.align = align;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    public int length() {
        return text.length;
    }

    public int columnLength(int index) {
        return column(index).length();
    }

    public String column(int index) {
        if (index < 0 || index >= text.length)
            throw new IllegalArgumentException("Invalid index: " + index);
        return text[index];
    }

    public int columnAlign(int index) {
        if (index < 0 || index >= align.length)
            throw new IllegalArgumentException("Invalid index: " + index);
        return align[index];
    }

}