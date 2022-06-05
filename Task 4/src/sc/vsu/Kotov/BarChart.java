package sc.vsu.Kotov;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class BarChart extends ApplicationFrame {


    public BarChart(final String title) {
        super(title);
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(480, 320));
        setContentPane(chartPanel);
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        // Создаем столбчатый график
        final JFreeChart chart = ChartFactory.createBarChart(
                "Сравнение методов сортировки",
                "Количество входных данных",
                "Количество сравнений и обменов",
                dataset,                  // data
                PlotOrientation.VERTICAL, // orientation
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );

        // Определение фона диаграммы
        chart.setBackgroundPaint(Color.white);

        // Настройка plot'а
        CategoryPlot plot = chart.getCategoryPlot();

        plot.setBackgroundPaint(new Color(212, 212, 248));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // Настройка значений меток NumberAxis (оси Y)
        // (только целочисленные значения)
        NumberAxis axis = (NumberAxis) plot.getRangeAxis();
        axis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        axis.setUpperMargin(0.15);

        // Настройка оси X
        CategoryAxis axis_d = plot.getDomainAxis();
        axis_d.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        return chart;
    }

    public CategoryDataset createDataset() {

        DefaultCategoryDataset dataset;
        //Создание произвольных массивов разных размеров
        int[] array10000 = createRandomArray(10000);
        int[] arraycopy10000 = createRandomArray(10000);
        int[] arr20000= createRandomArray(20000);
        int[] arraycopy20000 = createRandomArray(20000);
        int[] arr50000= createRandomArray(50000);
        int[] arraycopy50000 = createRandomArray(50000);

        // Получаем количество сравнений и обменов для разных массивов

        int[] amountBubbleSort10000 = getSwapAndCompareAmountBubbleSort(array10000);
        int[] amountShakerSort10000 = getSwapAndCompareAmountShakerSort(arraycopy10000);
        int[] amountBubbleSort20000 = getSwapAndCompareAmountBubbleSort(arr20000);
        int[] amountShakerSort20000 = getSwapAndCompareAmountShakerSort(arraycopy20000);
        int[] amountBubbleSort50000 = getSwapAndCompareAmountBubbleSort(arr50000);
        int[] amountShakerSort50000 = getSwapAndCompareAmountShakerSort(arraycopy50000);

        // Создание категорий, в которые будут распределяться данные
        final String series1 = "BubbleSort";
        final String series2 = "ShakerSort";
        final String category1 = "Сравнения, n = 10000";
        final String category2 = "Обмены, n = 10000";
        final String category3 = "Сравнения, n = 20000";
        final String category4 = "Обмены, n = 20000";
        final String category5 = "Сравнения, n = 50000";
        final String category6 = "Обмены, n = 50000";

        dataset = new DefaultCategoryDataset();
        //Добавление данных в датасет
        dataset.addValue(amountBubbleSort10000[0], series1, category1);
        dataset.addValue(amountBubbleSort10000[1], series1, category2);
        dataset.addValue(amountShakerSort10000[0], series2, category1);
        dataset.addValue(amountShakerSort10000[1], series2, category2);

        dataset.addValue(amountBubbleSort20000[0],series1,category3);
        dataset.addValue(amountBubbleSort20000[1],series1,category4);
        dataset.addValue(amountShakerSort20000[0],series2,category3);
        dataset.addValue(amountShakerSort20000[1],series2,category4);

        dataset.addValue(amountBubbleSort50000[0],series1,category5);
        dataset.addValue(amountBubbleSort50000[1],series1,category6);
        dataset.addValue(amountShakerSort50000[0],series2,category5);
        dataset.addValue(amountShakerSort50000[1],series2,category6);


        return dataset;
    }
    // Получаем количество сравнений и обменов для сортировки пузырьком

    public static int[] getSwapAndCompareAmountBubbleSort(int[] arr) {
        String[] split = BubbleSort.bubbleSort(arr).split(", ");
        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
    }
    // Получаем количество сравнений и обменов для шейкерной сортировки
    public static int[] getSwapAndCompareAmountShakerSort(int[] arr) {
        String[] split = ShakerSort.shakerSort(arr).split(", ");
        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
    }
    // Создание произвольного массива
    public static int[] createRandomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }
}