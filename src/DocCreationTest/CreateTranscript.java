package DocCreationTest;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlLoadOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CreateTranscript {
    static Path templatePath = Paths.get("Resources/Documents/Transcript/TranscriptTemplate.html");
    static final File template = templatePath.toFile();
    static Path newPath = Paths.get("Resources/Documents/Transcript/Transcript.pdf");
    static final File newFile = newPath.toFile();

    static String[] Marks = new String[7];
    static String[] Results = new String[7];

    public static void main(String[] args) {
        WriteChangesIntoFile();
        ExportToPDF();
    }

    private static void WriteChangesIntoFile() {
        String[] studentData = {"apoge numberrrrr", "cccnnneeee"};
        GetRandomMarks();

        try{
            Scanner fileScanner = new Scanner(template);
            FileWriter writer = new FileWriter(newFile);
            int i = 0, j = 0;
            String currentLine;

            while (fileScanner.hasNextLine()) {
                currentLine = fileScanner.nextLine();
                if (currentLine.contains("[FillTheBlank]")) {
                    currentLine = currentLine.replace("[FillTheBlank]", studentData[i++]);
                }

                if (currentLine.contains("[NOTE]")) {
                    currentLine = currentLine.replace("[NOTE]", Marks[j] + "/20");
                }
                if (currentLine.contains("[RESULTAT]")) {
                    currentLine = currentLine.replace("[RESULTAT]", Results[j++]);
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

    private static void GetRandomMarks() {
        float sum = 0;
        for (int i = 0; i < 6; i++) {
            Marks[i] = String.valueOf((int) Math.floor(10 + Math.random()*10));
            Results[i] = Integer.parseInt(Marks[i]) >= 12 ? "Valide" : "Non Valide";
            sum += Integer.parseInt(Marks[i]);
        }
        Marks[6] = String.valueOf(sum / 6);
        Results[6] = Float.parseFloat(Marks[6]) >= 12 ? "Valide" : "Non Valide";

    }

    private static void ExportToPDF() {
        Document PDFFileNew = new Document(String.valueOf(newPath), new HtmlLoadOptions());
        PDFFileNew.save("Resources/Documents/Transcript/Transcript.pdf");

    }

}
