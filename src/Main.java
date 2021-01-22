package ENSA.GenieLogiciel.Project.GLProject.src;

import ENSA.GenieLogiciel.Project.GLProject.src.Models.DemandeModel;
import ENSA.GenieLogiciel.Project.GLProject.src.Models.SchoolCertificateModel;
import ENSA.GenieLogiciel.Project.GLProject.src.Models.TranscriptModel;

public class Main {
    public static void main(String[] args) {

        DemandeModel demande1 = new DemandeModel(new TranscriptModel());
        demande1.DisplayDemande();

        DemandeModel demande2 = new DemandeModel(new SchoolCertificateModel());
        demande2.DisplayDemande();

    }
}
