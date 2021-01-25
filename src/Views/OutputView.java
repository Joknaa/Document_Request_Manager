package GLProject.src.Views;

public class OutputView {

    static public void DisplayMainMenu(){
        System.out.println();
        System.out.println("########################[ MainMenu ]########################");
        System.out.println("|| -----------------> 1 : Student Space <---------------- ||");
        System.out.println("|| -----------------> 2 : Admin Space   <---------------- ||");
        System.out.println("|| -----------------> 0 : Exit The Menu <---------------- ||");
        System.out.println("############################################################");
        System.out.print("#-> Option : ");
    }

    static public void DisplayStudentSpaceMenu(){
        System.out.println();
        System.out.println("#####################[ StudentSpaceMenu ]####################");
        System.out.println("|| ----------------> 1 : Fill The Form    <--------------- ||");
        System.out.println("|| ----------------> 2 : Display Requests <--------------- ||");
        System.out.println("|| ----------------> 0 : Main Menu        <--------------- ||");
        System.out.println("#############################################################");
        System.out.print("#-> Option : ");
    }

    static public void DisplayAdminSpaceMenu(){
        System.out.println();
        System.out.println("######################[ AdminSpaceMenu ]#####################");
        System.out.println("|| ----------------> 1 : Select a Request <--------------- ||");
        System.out.println("|| ----------------> 2 : Display Requests <--------------- ||");
        System.out.println("|| ----------------> 3 : Logout           <--------------- ||");
        System.out.println("|| ----------------> 0 : Main Menu        <--------------- ||");
        System.out.println("#############################################################");
        System.out.print("#-> Option : ");
    }

    static public void DisplayRequestConfirmationMenu(){
        System.out.println();
        System.out.println("#########[ RequestConfirmationMenu ]#########");
        System.out.println("|| -----------> 1 : ACCEPT    <----------- ||");
        System.out.println("|| -----------> 2 : DECLINE   <----------- ||");
        System.out.println("|| -----------> 0 : Main Menu <----------- ||");
        System.out.println("#############################################");
        System.out.print("#-> Option : ");
    }

    public static void DisplayError(String error) { System.out.print(error); }
    public static void DisplayMessage(String message) { System.out.print(message); }
}
