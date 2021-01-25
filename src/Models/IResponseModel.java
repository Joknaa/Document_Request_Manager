package GLProject.src.Models;

public interface IResponseModel {
    void SendDocument(String email, IDocumentModel document);
    void SendError(String email, String error);
}
