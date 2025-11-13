package domain.data;
import java.io.FileNotFoundException;

public interface IExporter {
    public void exportToTxt(String text, String FileName) throws FileNotFoundException;
    // display
}

