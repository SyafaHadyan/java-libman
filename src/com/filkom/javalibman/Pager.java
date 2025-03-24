import java.util.Scanner;

public class Pager {
    private int pageWidth = 25;
    private char horizontalBar = '-';
    private char verticalBar = '|';
    private char edge = '+';
    private String inputStyle = "$";
    private Scanner scanner = new Scanner(System.in);

    private void printSpace() {
        beginLine();
        for (int i = 0; i < pageWidth; i++) {
            System.out.print(" ");
        }
        endLine();
    }

    private void printEmptySpace() {
        System.out.println();
    }

    private void beginLine() {
        System.out.print(this.verticalBar);
    }

    private void endLine() {
        System.out.println(this.verticalBar);
    }

    public void setPageWidth(int pageWidth) {
        this.pageWidth = pageWidth;
    }

    public void setHorizontalBar(char bar) {
        this.horizontalBar = bar;
    }

    public void setVerticalBar(char bar) {
        this.verticalBar = bar;
    }

    public void setEdge(char edge) {
        this.edge = edge;
    }

    public void setInputStyle(String inputStyle) {
        this.inputStyle = inputStyle;
    }

    public void horizontalSeparator() {
        System.out.print(this.edge);
        for (int i = 0; i < this.pageWidth; i++) {
            System.out.print(horizontalBar);
        }
        System.out.println(this.edge);
    }

    public void spacer() {
        printSpace();
    }

    public void spacer(int space) {
        for (int i = 0; i < space; i++) {
            printSpace();
        }
    }

    public void emptySpace() {
        printEmptySpace();
    }

    public void emptySpace(int space) {
        for (int i = 0; i < space; i++) {
            printEmptySpace();
        }
    }

    public void header(String message) {
        horizontalSeparator();
        spacer();
        messageCenter(message);
        spacer();
        horizontalSeparator();
    }

    public void footer() {
        spacer();
        horizontalSeparator();
        emptySpace();
    }

    public void messageCenter(String message) {
        int size = this.pageWidth - message.length();
        beginLine();
        for (int i = 0; i < size / 2; i++) {
            System.out.print(" ");
        }
        System.out.print(message);
        for (int i = 0; i < size / 2; i++) {
            System.out.print(" ");
        }
        if (message.length() % 2 == 0) {
            System.out.print(" ");
        }
        endLine();
    }

    public void message(String message, int spaceBefore) {
        int spaceAfter = pageWidth - spaceBefore - message.length();
        beginLine();
        for (int i = 0; i < spaceBefore; i++) {
            System.out.print(" ");
        }
        System.out.print(message);
        for (int i = 0; i < spaceAfter; i++) {
            System.out.print(" ");
        }
        endLine();
    }

    public String input(int spaceBefore) {
        beginLine();
        for (int i = 0; i < spaceBefore; i++) {
            System.out.print(" ");
        }
        System.out.print(this.inputStyle + " ");
        return scanner.nextLine();
    }

    public String customInput(String inputStyle, int spaceBefore) {
        beginLine();
        for (int i = 0; i < spaceBefore; i++) {
            System.out.print(" ");
        }
        System.out.print(inputStyle + " ");
        return scanner.nextLine();
    }
}
