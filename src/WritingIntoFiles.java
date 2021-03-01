import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlLoadOptions;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class WritingIntoFiles {
    static Path oldPath = Paths.get("Resources/Documents/Certificate/Certificate.html");
    static final File oldFile = oldPath.toFile();

    static Path newPath = Paths.get("Resources/Documents/Certificate/CertificateModified.html");
    static final File newFile = newPath.toFile();

    public static void main(String[] args) {
        WriteChangesIntoFile();
        ExportToPDF();
    }

    private static void ExportToPDF() {
        Document PDFFile = new Document(String.valueOf(newPath), new HtmlLoadOptions());
        PDFFile.save("Resources/Documents/Certificate/CertificateModified.pdf");
    }

    private static void WriteChangesIntoFile() {
        String[] studentData = {"oknaaaaaaaaaa", "ifuhzifhzei", "aouefhdaiedhai"};
        System.out.println("gotcha");

        try{
            Scanner fileScanner = new Scanner(oldFile);
            FileWriter writer = new FileWriter(newFile, true);
            int i = 0;
            String currentLine;

            while (fileScanner.hasNextLine()) {
                currentLine = fileScanner.nextLine();
                if (currentLine.contains("[FillTheBlank]")) {
                    currentLine = currentLine.replace("[FillTheBlank]", studentData[i++]);
                }
                Files.write(newPath, currentLine.concat("\n").getBytes(), StandardOpenOption.APPEND);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
