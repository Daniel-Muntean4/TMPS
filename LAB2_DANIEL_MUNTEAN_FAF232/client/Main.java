package client;
import domain.DocumentOperationManager;
import domain.models.Section;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DocumentOperationManager documentOperationManager = new DocumentOperationManager();
        Section titleSection = new Section("My Notes");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce commands: ");
        while (true) { 
            String input = scanner.nextLine();
            String[] commands = input.split(" ");
            String command = commands[0];
            
            if (command.equals("add_section")){
                String name = commands[1];
                titleSection.add(new Section(name));
            }
            else if (command.equals("add_subsection")){
                String name = commands[1];
                String rootName = commands[2];
                documentOperationManager.addSubsection(titleSection,name,rootName);
            }
            else if (command.equals("remove_section")){
                String name = commands[1];
                documentOperationManager.removeSection(titleSection, name);
            }
            else if (command.equals("add_paragraph")){
                String rootSection = commands[1];
                System.out.println("Introduce the content of the paragraph");
                String text = scanner.nextLine();
                System.out.println("Introduce the root section");

                documentOperationManager.addParagraph(titleSection, text, rootSection);
            }
            else if (command.equals("remove_paragraph")){
                String name = commands[1];
                
                documentOperationManager.removeParagraph(titleSection, name);
            }
            else if (command.equals("export")){
                String fileName = commands[1];
                System.out.println("Introduce the text format('ascii','markdown','plain text')");
                String format = scanner.nextLine();
                documentOperationManager.exportNotestoFile(titleSection, fileName, format);
            }
            else if (command.equals("show_tree")){
                System.out.println(titleSection.getTitle());
            }
            else if (command.equals("exit")){
                break;
            }
            }
        }
        
    }

