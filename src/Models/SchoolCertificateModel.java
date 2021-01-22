package ENSA.GenieLogiciel.Project.GLProject.src.Models;

public class SchoolCertificateModel implements IDocumentModel{
    private int id;
    private static final String Type = "School Certificate";

    public SchoolCertificateModel(){}
    public SchoolCertificateModel(int id){
        SetID(id);
    }

    public void SetID(int id) { this.id = id; }
    public int GetID() { return this.id; }

    @Override
    public String GetType() { return Type; }

    @Override
    public String GetDetails() { return String.format("=> DocumentID: '%d' | DocumentType: '%s'", GetID(), GetType()); }
}
