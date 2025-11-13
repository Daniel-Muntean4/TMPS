package domain;
import domain.data.ASCIIDocExporter;
import domain.data.SimpleExporter;
import domain.data.TextExporter;
import domain.models.IDocumentElement;
import domain.models.Paragraph;
import domain.models.Section;
import java.io.FileNotFoundException;

public class DocumentOperationManager {
    ASCIIDocExporter asciiDocExporter  = new ASCIIDocExporter();
    SimpleExporter simpleExporter = new SimpleExporter();
    TextExporter textExporter = new TextExporter();
    public void exportNotestoFile(Section section, String fileName, String exportType) throws FileNotFoundException{
        if(exportType.equals("ascii")){
            asciiDocExporter.exportToTxt(section.getTitle(), fileName);
        }
        else if(exportType.equals("markdown")){
            simpleExporter.exportTextToFile(section.getTitle(), fileName);
        }
        else {
            textExporter.exportToTxt(section.getTitle(), fileName);
        }
        System.out.println("The Notes are exported in the following file: "+ fileName+ ".txt");
    }
    public void addSubsection(Section section, String name, String rootName){
        for (IDocumentElement elem : section.getdocElementList()) {
            if(elem instanceof Section ){
                Section s = (Section) elem;
                if(s.getName().equals(rootName)){
                    s.add(new Section(name));
                }
            }}
    }
    public void removeSection(Section section, String name){
        for (IDocumentElement elem : section.getdocElementList()) {
            if(elem instanceof Section ){
                Section s = (Section) elem;
                if(s.getName().equals(name)){
                   section.remove(elem);
                }
            }
        }
    }
    public void removeParagraph(Section section, String name){
        for (IDocumentElement elem : section.getdocElementList()) {
            if(elem instanceof Paragraph ){
                Paragraph p = (Paragraph) elem;
                if(p.getName().equals(name)){
                    section.remove(elem);
                }
            }}

    }
    public void addParagraph(Section section, String name, String rootSection){

    for (IDocumentElement elem : section.getdocElementList()) {
        if(elem instanceof Section s){
            if(s.getName().equals(rootSection)){
                s.add(new Paragraph(name));
            }
        }
    }
}


    // Paragraph paragraph;


    // public void addSubsectionTo(String text, String className){
    //     for (IDocumentElement elem : section.getdocElementList()) {
    //         if(elem instanceof Section s){
    //             if(s.receiveName().equals(className)){
    //                 s.add(new Section(text));
    //             }
    //         }
    //     }
    // }
    
    // public void addParagraphTo(String text, String className){
    //     for (IDocumentElement elem : section.getdocElementList()) {
    //         if(elem instanceof Section s ){
    //             if(s.receiveName().equals(className)){
    //                 s.add(new Paragraph(text));
    //             }
    //         }
    //     }
    // }
    
    // public void showTree(){
    //     System.out.println(section.getName());
    // }

    
   
}
