package domain.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SimpleExporter {

    public void exportTextToFile(String text, String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        PrintWriter writer = new PrintWriter(fileName);
        writer.write(text);
        writer.close();
    }
}
