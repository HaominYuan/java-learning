package java10newfeature.scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/java10newfeature/scanner/1.txt"));
        scanner.useDelimiter("[ .]");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
