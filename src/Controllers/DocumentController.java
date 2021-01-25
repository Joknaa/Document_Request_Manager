package GLProject.src.Controllers;

import GLProject.src.Models.IDocumentModel;
import GLProject.src.Models.SchoolCertificateModel;
import GLProject.src.Models.TranscriptModel;
import java.util.ArrayList;
import java.util.List;

public class DocumentController {
    private static final List<Integer> ExistingIDs = new ArrayList<>();

    public static IDocumentModel GetDocumentInstance(String documentType){
        if (documentType.trim().equalsIgnoreCase("SchoolCertificate"))
            return new SchoolCertificateModel(GenerateUniqueID());
        else if (documentType.trim().equalsIgnoreCase("Transcript"))
            return new TranscriptModel(GenerateUniqueID());

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

    public static void CheckDocumentAvailable(String docType) throws InvalidDocumentException{
        if (docType.trim().equalsIgnoreCase("SchoolCertificate"))
            return;
        else if (docType.trim().equalsIgnoreCase("Transcript"))
            return;
        throw new InvalidDocumentException("Document type not supported");
    }

    static class InvalidDocumentException extends Exception {
        public InvalidDocumentException(String s) {super(s);}
    }
}
