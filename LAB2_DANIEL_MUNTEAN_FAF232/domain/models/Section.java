package domain.models;
import java.util.ArrayList;
import java.util.List;

public class Section implements IDocumentElement{
    private String name;
    private List<IDocumentElement> docElementList = new ArrayList<>();
    public Section(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void add(IDocumentElement docElement){
        docElementList.add(docElement);
    }
    public void remove(IDocumentElement docElement){
        docElementList.remove(docElement);
    }
    @Override
    public String getTitle() {
        String structure = "";
        String prefix = " ";
        structure = structure + prefix+this.name+"\n";
        for  (IDocumentElement elem : docElementList) {
            if(elem instanceof Section){
                structure = structure+ "##" +elem.getTitle();
            }
            else{
            structure = structure+ elem.getTitle();
            }
        }
        return structure;
    }
    public List<IDocumentElement> getdocElementList() {
        return docElementList;
    }   
}
