package education.sumdu.Fifth.kurs.Shopping.format;

import java.util.ArrayList;
import java.util.List;

public class Sheet {
    private Line header;
    private Line footer;
    private List<Line> lines;

    public Sheet() {
        header = new Line();
        footer = new Line();
        lines = new ArrayList<Line>();
    }

    public Sheet(Line header, Line footer, List<Line> lines) {
        super();
        setHeader(header);
        setFooter(footer);
        setLines(lines);
    }

    public Line getHeader() {
        return header;
    }

    public void setHeader(Line header) {
        this.header = header;
    }

    public Line getFooter() {
        return footer;
    }

    public void setFooter(Line footer) {
        this.footer = footer;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public int[] width() {
        int[] width = new int[header.length()];
        for (Line line : lines)
            for (int i = 0; i < line.length(); i++)
                width[i] = (int) Math.max(width[i], line.columnLength(i));
        for (int i = 0; i < header.length(); i++)
            width[i] = (int) Math.max(width[i], header.columnLength(i));
        for (int i = 0; i < footer.length(); i++)
            width[i] = (int) Math.max(width[i], footer.columnLength(i));
        return width;
    }

    public int maxLineLength() {
        int[] columnMaxLenght = width();

        int length = columnMaxLenght.length - 1;
        for (int w : columnMaxLenght)
            length += w;

        return length;
    }

}