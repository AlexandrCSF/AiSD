package sc.vsu.Kotov;

import org.jfree.ui.RefineryUtilities;


public class Main {
    public static void main(final String[] args) {
        final BarChart demo = new BarChart("Bar Chart");
        demo.pack();
        // Размещаем окно по центру
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        //Окно для описания графиков
        new MainFrame().setVisible(true);

    }
}
