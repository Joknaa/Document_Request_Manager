package MVPPresenters;

import MVPModels.Documents;
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
import static MVPPresenters.OutputPresenter.*;

public class DocumentPresenter {
    static Path certificateTemplatePath = Paths.get("Resources/Documents/Certificate/CertificateTemplate.html");
    static final File certificateTemplate = certificateTemplatePath.toFile();
    static Path certificatePath = Paths.get("Resources/Documents/Certificate/Certificate.pdf");
    static final File certificate = certificatePath.toFile();
    static Path transcriptTemplatePath = Paths.get("Resources/Documents/Transcript/TranscriptTemplate.html");
    static final File transcriptTemplate = transcriptTemplatePath.toFile();
    static Path transcriptPath = Paths.get("Resources/Documents/Transcript/Transcript.pdf");
    static final File transcript = transcriptPath.toFile();
    static String[] Marks = new String[7];
    static String[] Results = new String[7];

    public static void CreateDocument(Documents docType, String[] requestData, String requestName){
        System.out.println("Creating the document ...");
        if (docType == Documents.Certificate) GenerateCertificate(requestData);
        else if (docType == Documents.Transcript) GenerateTranscript(requestData);
    }

    private static void GenerateCertificate(String[] userdata) {
        try{
            Scanner fileScanner = new Scanner(certificateTemplate);
            FileWriter writer = new FileWriter(certificate);
            int i = 0;
            String currentLine;

            while (fileScanner.hasNextLine()) {
                currentLine = fileScanner.nextLine();
                if (currentLine.contains("[FillTheBlank]"))
                    currentLine = currentLine.replace("[FillTheBlank]", userdata[i++]);

                Files.write(certificate.toPath(), currentLine.concat("\n").getBytes(), StandardOpenOption.APPEND);
            }
            writer.close();
            Document PDFFileNew = new Document(String.valueOf(certificate), new HtmlLoadOptions());
            PDFFileNew.save("Resources/Documents/Certificate/Certificate.pdf");
        } catch (FileNotFoundException e) {
            DisplayError("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void GenerateTranscript(String[] userdata) {
        GetRandomMarks();

        try{
            Scanner fileScanner = new Scanner(transcriptTemplate);
            FileWriter writer = new FileWriter(transcript);
            int i = 0, j = 0;
            String currentLine;

            while (fileScanner.hasNextLine()) {
                currentLine = fileScanner.nextLine();

                if (currentLine.contains("[FillTheBlank]"))
                    currentLine = currentLine.replace("[FillTheBlank]", userdata[i++]);
                if (currentLine.contains("[NOTE]"))
                    currentLine = currentLine.replace("[NOTE]", Marks[j] + "/20");
                if (currentLine.contains("[RESULTAT]"))
                    currentLine = currentLine.replace("[RESULTAT]", Results[j++]);

                Files.write(transcript.toPath(), currentLine.concat("\n").getBytes(), StandardOpenOption.APPEND);
            }
            writer.close();

            Document PDFFileNew = new Document(String.valueOf(transcript), new HtmlLoadOptions());
            PDFFileNew.save("Resources/Documents/Transcript/Transcript.pdf");

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
}
