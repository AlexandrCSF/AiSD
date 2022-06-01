package sc.vsu.Kotov;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        ru.vsu.cs.util.SwingUtils.setLookAndFeelByName("Windows");
        ru.vsu.cs.util.SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        new MainFrame().setVisible(true);    }
}
