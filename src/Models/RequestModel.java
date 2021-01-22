package ENSA.GenieLogiciel.Project.GLProject.src.Models;

public class RequestModel {
    private int id;
    private IDocumentModel Document = new TranscriptModel();
    private int requesterCNE;

    public RequestModel(){}
    public RequestModel(int id, int requesterCNE, IDocumentModel neededDocument){
        SetID(id);
        SetRequesterCNE(requesterCNE);
        SetDocument(neededDocument);
    }

    public void SetID(int id) { this.id = id; }
    public int GetID() { return this.id; }

    public void SetRequesterCNE(int requesterCNE) { this.requesterCNE = requesterCNE; }
    public int GetRequesterCNE() { return this.requesterCNE; }

    public void SetDocument(IDocumentModel neededDocument){ this.Document = neededDocument; }
    public IDocumentModel GetDocument(){ return this.Document; }

    public String GetDetails(){
        return String.format("=> RequestID: '%d' | RequestedDocument: '%s' | RequesterCNE: '%d'",
                GetID(),
                GetDocument().GetType(),
                GetRequesterCNE());
    }
}
