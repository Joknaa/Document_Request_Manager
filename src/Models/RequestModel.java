package ENSA.GenieLogiciel.Project.GLProject.src.Models;

public class RequestModel {
    private String id;
    private IDocumentModel Document;
    private String requesterCNE;

    public RequestModel(){}
    public RequestModel(String id, String requesterCNE, IDocumentModel neededDocument){
        SetID(id);
        SetRequesterCNE(requesterCNE);
        SetDocument(neededDocument);
    }

    public void SetID(String id) { this.id = id; }
    public String GetID() { return this.id; }

    public void SetRequesterCNE(String requesterCNE) { this.requesterCNE = requesterCNE; }
    public String GetRequesterCNE() { return this.requesterCNE; }

    public void SetDocument(IDocumentModel neededDocument){ this.Document = neededDocument; }
    public IDocumentModel GetDocument(){ return this.Document; }

    public String GetDetails(){
        return String.format("=> RequestID: '%s' | RequestedDocument: '%s' | RequesterCNE: '%s'\n",
                GetID(),
                GetDocument().GetType(),
                GetRequesterCNE());
    }
}
