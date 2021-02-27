package old.Experiments;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class OutputView {
    private static final JFrame appFrame = new JFrame();
    static final IMenu mainMenu    = new MainMenu();
    static final IMenu studentMenu = new StudentScreen();
    static final IMenu loginMenu   = new LoginScreen();
    static final IMenu adminMenu   = new AdminScreen();

    public static void Start(){
        SetupFrame();
        new MainMenu().Display(appFrame);
    }

    private static void SetupFrame() {
        appFrame.setSize(600, 350);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }

    static class OnClick_SwapFrames implements ActionListener {
        private final IMenu fromManu;
        private final IMenu toMenu;
        OnClick_SwapFrames(IMenu fromManu, IMenu toMenu){
            this.fromManu = fromManu;
            this.toMenu = toMenu;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fromManu.GetPanel().setVisible(false);
            toMenu.GetPanel().setVisible(true);
            toMenu.Display(appFrame);
        }
    }
}
