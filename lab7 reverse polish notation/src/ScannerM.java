// Scanner.java


import java.util.Scanner;

public class ScannerM {
    private Scanner scanner;

    public ScannerM() {
        this.scanner = new Scanner(System.in);
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}