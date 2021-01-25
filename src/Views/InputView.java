package GLProject.src.Views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    public static int GetIntInput() throws InputMismatchException { return sc.nextInt(); }
    public static String GetStringInput() throws InputMismatchException { return sc.next(); }

    public static void ClearInputBuffer() { sc.nextLine(); }
}
