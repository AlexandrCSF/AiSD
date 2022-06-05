package sc.vsu.Kotov;

import org.jfree.ui.RefineryUtilities;

import java.lang.reflect.Array;
import java.util.Arrays;


public class Main {
    public static void main(final String[] args) {
        final BarChart demo = new BarChart("Bar Chart");
        demo.pack();
        // Размещаем окно по центру
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);


    }
}
