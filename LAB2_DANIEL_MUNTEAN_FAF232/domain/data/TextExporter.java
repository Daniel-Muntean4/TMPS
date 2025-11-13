package domain.data;
import java.io.FileNotFoundException;

public class TextExporter implements IExporter {
    SimpleExporter simpleExporter = new SimpleExporter();
    @Override
    public void exportToTxt(String text,String fileName) throws FileNotFoundException  {
        text = text.replaceAll("#", "  ");
        simpleExporter.exportTextToFile(text, fileName);
    }
}
