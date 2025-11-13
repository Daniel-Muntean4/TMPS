package domain.models;
public class Paragraph implements IDocumentElement{
    
    private String paragraphText;
    public Paragraph(String paragraphText) {
        this.paragraphText=paragraphText;
    }
    @Override
    public String getTitle() {
        String structure="";
        structure+=paragraphText+"\n";
        return structure;
    }
    @Override
    public String getName() {
        return this.paragraphText;
    }   
}
