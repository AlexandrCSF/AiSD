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
        int[] arr5 = createRandomArray(5);
        int[] arraycopy5 = Arrays.copyOf(arr5,5);
        int[] arr10= createRandomArray(10);
        int[] arraycopy10 = Arrays.copyOf(arr10,10);
        int[] arr7= createRandomArray(7);
        int[] arraycopy7 = Arrays.copyOf(arr7,7);
        // Получаем количество сравнений и обменов для разных массивов
        int[] amountBubbleSort5 = getSwapAndCompareAmountBubbleSort(arr5);
        int[] amountShakerSort5 = getSwapAndCompareAmountShakerSort(arraycopy5);
        int[] amountBubbleSort10 = getSwapAndCompareAmountBubbleSort(arr10);
        int[] amountShakerSort10 = getSwapAndCompareAmountShakerSort(arraycopy10);
        int[] amountBubbleSort7 = getSwapAndCompareAmountBubbleSort(arr7);
        int[] amountShakerSort7 = getSwapAndCompareAmountShakerSort(arraycopy7);

        // Создание категорий, в которые будут распределяться данные
        final String series1 = "BubbleSort";
        final String series2 = "ShakerSort";
        final String category1 = "Сравнения, n = 5";
        final String category2 = "Обмены, n = 5";
        final String category3 = "Сравнения, n = 10";
        final String category4 = "Обмены, n = 10";
        final String category5 = "Сравнения, n = 7";
        final String category6 = "Обмены, n = 7";

        dataset = new DefaultCategoryDataset();
        //Добавление данных в датасет
        dataset.addValue(amountBubbleSort5[0], series1, category1);
        dataset.addValue(amountBubbleSort5[1], series1, category2);
        dataset.addValue(amountShakerSort5[0], series2, category1);
        dataset.addValue(amountShakerSort5[1], series2, category2);

        dataset.addValue(amountBubbleSort10[0],series1,category3);
        dataset.addValue(amountBubbleSort10[1],series1,category4);
        dataset.addValue(amountShakerSort10[0],series2,category3);
        dataset.addValue(amountShakerSort10[1],series2,category4);

        dataset.addValue(amountBubbleSort7[0],series1,category5);
        dataset.addValue(amountBubbleSort7[1],series1,category6);
        dataset.addValue(amountShakerSort7[0],series2,category5);
        dataset.addValue(amountShakerSort7[1],series2,category6);


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