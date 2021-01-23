package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import ENSA.GenieLogiciel.Project.GLProject.src.Models.IDocumentModel;
import ENSA.GenieLogiciel.Project.GLProject.src.Models.SchoolCertificateModel;
import ENSA.GenieLogiciel.Project.GLProject.src.Models.TranscriptModel;
import java.util.ArrayList;
import java.util.List;

public class DocumentController {
    private static final List<Integer> ExistingIDs = new ArrayList<>();

    public static IDocumentModel GetDocumentInstance(String documentType) {
        if (documentType.trim().equalsIgnoreCase("SchoolCertificate")) {
            return new SchoolCertificateModel(GenerateUniqueID());
        } else if (documentType.trim().equalsIgnoreCase("Transcript")) {
            return new TranscriptModel(GenerateUniqueID());
        }
        return null;
    }
    
    private static int GenerateUniqueID(){
        int ID;
        do {
            ID = (int) Math.floor(Math.random() * 10000);
        } while (ExistingIDs.contains(ID));
        ExistingIDs.add(ID);
        return ID;
    }
}
