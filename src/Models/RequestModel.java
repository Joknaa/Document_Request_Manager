package ENSA.GenieLogiciel.Project.GLProject.src.Models;

public class RequestModel {
    private String id;
    private String email;
    private IDocumentModel Document;
    private String requesterCNE;
    private boolean accepted = false;

    public RequestModel(){}
    public RequestModel(String id, String requesterCNE, IDocumentModel neededDocument){
        SetID(id);
        SetEmail(email);
        SetRequesterCNE(requesterCNE);
        SetDocument(neededDocument);
    }

    public void SetID(String id) { this.id = id; }
    public String GetID() { return this.id; }

    public void SetRequesterCNE(String requesterCNE) { this.requesterCNE = requesterCNE; }
    public String GetRequesterCNE() { return this.requesterCNE; }

    public void SetDocument(IDocumentModel neededDocument){ this.Document = neededDocument; }
    public IDocumentModel GetDocument(){ return this.Document; }

    public void SetEmail(String email){ this.email = email;}
    public String GetEmail(){ return this.email;}

    public void SetAccepted(boolean value){ this.accepted = value; }
    public boolean IsAccepted(){ return this.accepted; }

    public String GetDetails(){
        return String.format("=> RequestID: '%s' | RequestedDocument: '%s' | RequesterCNE: '%s' | Accepted: '%s'\n",
                this.GetID(),
                this.GetDocument().GetType(),
                this.GetRequesterCNE(),
                this.IsAccepted());
    }
}