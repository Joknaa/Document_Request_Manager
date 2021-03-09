package DocCreationTest;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlLoadOptions;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class CreateCertificate {
    static Path certificateTemplatePath = Paths.get("Resources/Documents/Certificate/CertificateTemplate.html");
    static final File certificateTemplate = certificateTemplatePath.toFile();

    static Path CertificatePath = Paths.get("Resources/Documents/Certificate/Certificate.html");
    static final File Certificate = CertificatePath.toFile();

    public static void main(String[] args) {
        WriteChangesIntoFile();
        ExportToPDF();
    }

    private static void ExportToPDF() {
        Document certificatePDF = new Document(String.valueOf(CertificatePath), new HtmlLoadOptions());
        certificatePDF.save("Resources/Documents/Certificate/Certificate.pdf");

    }

    private static void WriteChangesIntoFile() {
        String[] studentData = {"oknaaaaaaaaaa", "ifuhzifhzei", "aouefhdaiedhai"};
        System.out.println("gotcha");

        try{
            Scanner fileScanner = new Scanner(certificateTemplate);
            FileWriter writer = new FileWriter(Certificate);
            int i = 0;
            String currentLine;

            while (fileScanner.hasNextLine()) {
                currentLine = fileScanner.nextLine();
                if (currentLine.contains("[FillTheBlank]")) {
                    currentLine = currentLine.replace("[FillTheBlank]", studentData[i++]);
                }
                Files.write(CertificatePath, currentLine.concat("\n").getBytes(), StandardOpenOption.APPEND);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
