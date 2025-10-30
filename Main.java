import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void CreateFile(String FilePath) {
        try (FileWriter writer = new FileWriter(FilePath)) {
            writer.write("Hello World");
            System.out.println("File created and text written successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static Person changeLastName(Person person, String newLastName){
        return person.changeLastName(newLastName);
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.err.println("Failed to delete the file.");
            }
        } else {
            System.err.println("File not found: " + filePath);
        }
    }

    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        CreateFile("/tmp/HelloWorld.txt");

        for (int i = 1; i <= 50; i++) {
            System.out.println("i = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sleep was interrupted" + e.getMessage());
            }
        }
        deleteFile("/tmp/HelloWorld.txt");

        Person Dmitry = new Person(10, "Dmitry","Zayats");
        Dmitry.displayPerson();
        System.out.println("Dmitry next year will be");
        Dmitry.growOneYearOlder().displayPerson();
        System.out.println("After changing last name");
        changeLastName(Dmitry, "Golub").displayPerson();

    }
}
