package ENSA.GenieLogiciel.Project.GLProject.src.Models;

public class DemandeModel {
    IDocumentModel Document = new TranscriptModel();

    public DemandeModel(){}
    public DemandeModel(IDocumentModel neededDocument){
        SetDocument(neededDocument);
    }

    public void SetDocument(IDocumentModel neededDocument){ this.Document = neededDocument; }
    public IDocumentModel GetDocument(){ return this.Document; }

    public void DisplayDemande(){
        Document.GetDetails();
    }
}
