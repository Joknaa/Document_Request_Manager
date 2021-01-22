package ENSA.GenieLogiciel.Project.GLProject.src.Views;

public class OutputView {

    static public void DisplayMainMenu(){
        System.out.println();
        System.out.println("#########################[ MainMenu ]#########################");
        System.out.println("|| -----------------> 1  : Requests Space <---------------- ||");
        System.out.println("|| -----------------> 2  : Admin Space    <---------------- ||");
        System.out.println("|| -----------------> 0  : Exit The Menu  <---------------- ||");
        System.out.println("##############################################################");
        System.out.print("#-> Option : ");
    }

    static public void DisplayRequestSpaceMenu(){
        System.out.println();
        System.out.println("#####################[ RequestSpaceMenu ]#####################");
        System.out.println("|| -----------------> 1  : Fill The Form  <---------------- ||");
        System.out.println("|| -----------------> 0  : Exit The Menu  <---------------- ||");
        System.out.println("##############################################################");
        System.out.print("#-> Option : ");
    }

    public static void DisplayError() { System.out.print("Error PopUp goes here."); }
    public static void DisplayMessage(String message) { System.out.print(message); }
}
