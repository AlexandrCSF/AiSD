package sc.vsu.Kotov;

import javax.swing.*;

public class MainFrame extends JFrame{
    private JPanel panelMain;
    private JTextArea textArea;

    public MainFrame(){
        this.setTitle("Описание графиков");
        this.setContentPane(panelMain);
        this.pack();
        this.setSize(1100,100);
        textArea.setText("""
                Проводя сравнение двух видов сортировки(BubbleSort и ShakerSort), мы получили следующие данные:
                Количество сравнений в обоих методах сортировки одинаково и равно (n-1)*n/2, где n - количество входных элементов
                Количество обменов в обоих случаях одинакова и зависит от входных данных.""");

    }
}
