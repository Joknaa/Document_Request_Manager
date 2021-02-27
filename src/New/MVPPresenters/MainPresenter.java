package New.MVPPresenters;

import static New.MVPPresenters.DataBasePresenter.*;
import static New.MVPPresenters.OutputPresenter.*;

public class MainPresenter {
    public static void start() {
        SetupDataBaseConnection();
        SetUpGUI();
    }
}
