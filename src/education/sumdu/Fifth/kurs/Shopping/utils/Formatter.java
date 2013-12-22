package education.sumdu.Fifth.kurs.Shopping.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import education.sumdu.Fifth.kurs.Shopping.format.Line;
import education.sumdu.Fifth.kurs.Shopping.format.Sheet;
import education.sumdu.Fifth.kurs.Shopping.kernel.Item;
import education.sumdu.Fifth.kurs.Shopping.kernel.ShoppingCart;

public class Formatter {
    private static final NumberFormat MONEY;
    
    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        MONEY = new DecimalFormat("$#.00", symbols);

        instance = new Formatter();
    }

    private static Formatter instance;

    private Formatter() {
    };

    public static Formatter getInstance() {
        return instance;
    }

    /**
     * Formats shopping price.
     * 
     * @return string as lines, separated with \n, first line: # Item Price
     *         Quan. Discount Total second line:
     *         --------------------------------------------------------- next
     *         lines: NN Title $PP.PP Q DD% $TT.TT 1 Some title $.30 2 - $.60 2
     *         Some very long $100.00 1 50% $50.00 ... 31 Item 42 $999.00 1000 -
     *         $999000.00 end line:
     *         --------------------------------------------------------- last
     *         line: 31 $999050.60
     * 
     *         if no items in cart returns "No items." string.
     */
    public String formatTicket(ShoppingCart cart) {
        List<Item> items = cart.getItems();
        if (items == null || items.size() == 0)
            return "No items.";

        Sheet sheet = new Sheet();
        sheet.setLines(itemsToLines(items));
        sheet.setHeader(new Line(new String[] { "#", "Item", "Price", "Quan.",
                "Discount", "Total" }));
        sheet.setFooter(new Line(new String[] { String.valueOf(cart.size()),
                "", "", "", "", MONEY.format(cart.total()) }));

        int[] columnMaxLenght = sheet.width();
        int lineLength = sheet.maxLineLength();

        StringBuilder sb = new StringBuilder();

        // Build header
        for (int i = 0; i < sheet.getHeader().length(); i++)
            appendFormatted(sb, sheet.getHeader().column(i), sheet.getHeader()
                    .columnAlign(i), columnMaxLenght[i]);
        sb.append("\n");

        separator(sb, lineLength);

        // Build all item lines
        for (Line line : sheet.getLines()) {
            for (int i = 0; i < line.length(); i++)
                appendFormatted(sb, line.column(i), line.columnAlign(i),
                        columnMaxLenght[i]);
            sb.append("\n");
        }

        if (sheet.getLines().size() > 0)
            separator(sb, lineLength);

        // Build footer
        for (int i = 0; i < sheet.getFooter().length(); i++)
            appendFormatted(sb, sheet.getFooter().column(i), sheet.getFooter()
                    .columnAlign(i), columnMaxLenght[i]);

        return sb.toString();
    }

    private void separator(StringBuilder sb, int lineLength) {
        for (int i = 0; i < lineLength; i++)
            sb.append("-");
        sb.append("\n");
    }

    /**
     * Formatting each line
     * */
    private List<Line> itemsToLines(List<Item> items) {
        List<Line> lines = new ArrayList<Line>();

        int index = 0;
        for (Item item : items) {
            lines.add(new Line(
                    new String[] {
                            String.valueOf(++index),
                            item.getTitle(),
                            MONEY.format(item.getPrice()),
                            String.valueOf(item.getQuantity()),
                            (item.discount() == 0) ? "-" : (String.valueOf(item
                                    .discount()) + "%"),
                            MONEY.format(item.fullPrice()) }));
        }
        return lines;
    }

    /**
     * Appends to sb formatted value. Trims string if its length > width.
     * 
     * @param align
     *            -1 for align left, 0 for center and +1 for align right.
     */
    private void appendFormatted(StringBuilder sb, String value, int align,
            int width) {
        if (value.length() > width)
            value = value.substring(0, width);
        int before = (align == 0) ? (width - value.length()) / 2
                : (align == -1) ? 0 : width - value.length();
        int after = width - value.length() - before;
        while (before-- > 0)
            sb.append(" ");
        sb.append(value);
        while (after-- > 0)
            sb.append(" ");
        sb.append(" ");
    }
}