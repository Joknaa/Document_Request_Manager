package Models;

public class TranscriptModel implements IDocumentModel {
    private int id;
    private static final String Type = "Transcript";

    public TranscriptModel(){}
    public TranscriptModel(int id){
        SetRandomUniqueID(id);
    }

    private void SetRandomUniqueID(int id) { this.id = id; }
    public int GetID() { return this.id; }

    @Override
    public String GetType() { return Type; }

    @Override
    public String GetDetails() {
        return String.format("=> DocumentID: '%d' | DocumentType: '%s'", GetID(), GetType());
    }
}
