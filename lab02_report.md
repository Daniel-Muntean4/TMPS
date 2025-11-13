# Topic: *Creational Design Patterns*
## Author: *Daniel Muntean* *FAF 232*
------
## Objectives:
&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities using structural design patterns.__

## Theoretical background:
&ensp; &ensp; In software engineering, the Structural Design Patterns are concerned with how classes and objects are composed to form larger structures. Structural class patterns use inheritance to create a hierarchy of classes/abstractions, but the structural object patterns use composition which is generally a more flexible alternative to inheritance.

&ensp; &ensp; Some examples of from this category of design patterns are:

   * Adapter: used to adapt a method from a class that is incompatible with the interface of the another class.
   * Bridge: Decouples the abstractions from the implementation, used when the implementation has to be changed at runtime
   * Composite: composed objects include tree structures to represent part code hierarchies.  It lets clients treat individual objects (leafs) and compositions of objects(branches) uniformingly
   * Decorator: attach additional responsibilities dinamically, add extend functionality
   * Facade: provides a simplified interface to a library, a framework, or any other complex set of classes, used ot modify the client as little as possible
   * Flyweight: uses sharing to support large numbers of fine-grained objects efficiently.
   * Proxy: lets you provide a substitute or placeholder for another object
   
## Main tasks:
&ensp; &ensp; __1. By extending your project, implement atleast 3 structural design patterns in your project:__
  * The implemented design pattern should help to perform the tasks involved in your system.
  * The object creation mechanisms/patterns can now be buried into the functionalities instead of using them into the client.
  * There should only be one client for the whole system.

&ensp; &ensp; __2. Keep your files grouped (into packages/directories) by their responsibilities (an example project structure):__
  * client
  * domain
      * factories
      * builder 
      * models
  * utilities
  * data(if applies)

## Structural Design Patterns implemented
Composite, Facade and Adapter.


## Snippets
### Composite
```
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
```
This Paragraph class is our composite pattern *leaf*, we can get the content and of it with and without spaces, depending on the use we will have 
```
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
```
Above are shown the methods that the *Composite* class has, we can add, remove, get title(which includes the paragraphs and other titles the current title might have) and we can get the element the ArrayList that contains both Paragraph and Sections.

### Adapter
```
public class SimpleExporter {
    public void exportTextToFile(String text, String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        PrintWriter writer = new PrintWriter(fileName);
        writer.write(text);
        writer.close();
    }
}
```
Above we have the class that writes the given string to a file, and creates a file with that given fileName.  
```
public class ASCIIDocExporter implements IExporter{
    SimpleExporter simpleExporter = new SimpleExporter();
    @Override
    public void exportToTxt(String text,String fileName) throws FileNotFoundException {
        text = text.replaceAll("#", "=");
        simpleExporter.exportTextToFile(text, fileName);
    }
```
The class ASCIIDocExporter is not compatible with the simple exporter, after an operation we make it compatible and use the method from the simpleExporter object.
### Facade
```
public class DocumentOperationManager {
    ASCIIDocExporter asciiDocExporter  = new ASCIIDocExporter();
    SimpleExporter simpleExporter = new SimpleExporter();
    TextExporter textExporter = new TextExporter();
    public void exportNotestoFile(Section section, String fileName, String exportType) throws FileNotFoundException {

        if(exportType.equals("ascii")){   asciiDocExporter.exportToTxt(section.getTitle(), fileName); }
        else if(exportType.equals("markdown")){  simpleExporter.exportTextToFile(section.getTitle(), fileName);  }
        else {   textExporter.exportToTxt(section.getTitle(), fileName); }
        System.out.println("The Notes are exported in the following file: "+ fileName+ ".txt");
 }
    public void addSubsection(Section section, String name, String rootName){
        for (IDocumentElement elem : section.getdocElementList()) {
            if(elem instanceof Section ){
                Section s = (Section) elem;
                if(s.getName().equals(rootName)){
                    s.add(new Section(name));
                }}} }
    public void removeSection(Section section, String name){
        for (IDocumentElement elem : section.getdocElementList()) {
            if(elem instanceof Section ){
                Section s = (Section) elem;
                if(s.getName().equals(name)){
                   section.remove(elem);
                } } } }
```
Lastly we have the DocumentOperationManager which serves as Facade, it has three types of exporter objects for a method that will handle the decision logic according to the import of the parameter. It has several methods for adding and removing sections and paragraphs(the paragraph mehtods were omitted fro mantaining brevity)
## Conclusion
This program has the functionality of creating notes by adding new sections with paragraphs of text. Once finished the notes can be exported in three different formats: ASCII, Markdown or Plain text according to user preferences.  
## Screenshots
<img width="725" height="315" alt="image" src="https://github.com/user-attachments/assets/b5e7fa11-a72e-4727-8006-7a94a0049352" />
