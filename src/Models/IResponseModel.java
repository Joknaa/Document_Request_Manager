package ENSA.GenieLogiciel.Project.GLProject.src.Models;

public interface IResponseModel {
    void SendDocument(IDocumentModel document);
    void SendError(String error);
}
