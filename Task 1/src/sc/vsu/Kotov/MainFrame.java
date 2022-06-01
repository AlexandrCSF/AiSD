package sc.vsu.Kotov;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel panelMain;
    private JTextPane SumPane;
    private JTextPane PeriodPane;
    private JTextPane PercentPane;
    private JRadioButton AnnuityRadioButton;
    private JRadioButton DifferentiatedRadioButton;
    private JButton buttonAction;
    private JLabel LabelResult;
    private JButton CountButton;
    private JTextPane NumPane;
    private JLabel LabelCalc;


    public MainFrame() {

        this.setTitle("Калькулятор для расчета платежей по кредиту");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        ru.vsu.cs.util.SwingUtils.setShowMessageDefaultErrorHandler();

        Credit credit = new Credit();
        SumPane.setText(String.valueOf(700000));
        PeriodPane.setText(String.valueOf(12));
        PercentPane.setText(String.valueOf(18.5));

        buttonAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    // Считываем значения из TextPane-ов и записываем в поля класса Credit
                    credit.method = AnnuityRadioButton.isSelected() ? Method.Annuity : Method.Differentiated;
                    credit.sum =  Double.parseDouble(SumPane.getText());
                    credit.period = Integer.parseInt(PeriodPane.getText());
                    credit.percent = Double.parseDouble(PercentPane.getText());

                    LabelResult.setText("Общая сумма выплат: " + (credit.creditSum()));
                } catch (NumberFormatException | ArithmeticException exception) {
                    JOptionPane.showMessageDialog(null, "Некорректно введены данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        AnnuityRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //При выборе одной из кнопок(аннуитетный или дифференцированный платёж), другая становаится невыбранной
                DifferentiatedRadioButton.setSelected(false);
            }
        });

        DifferentiatedRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnnuityRadioButton.setSelected(false);
            }
        });

        CountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    credit.method = AnnuityRadioButton.isSelected() ? Method.Annuity : Method.Differentiated;
                    credit.sum =  Double.parseDouble(SumPane.getText());
                    credit.period = Integer.parseInt(PeriodPane.getText());
                    credit.percent = Double.parseDouble(PercentPane.getText());

                    if(Integer.parseInt(String.valueOf(NumPane.getText())) > credit.period){
                        JOptionPane.showMessageDialog(null, "Некорректно введены данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (credit.method == Method.Differentiated && NumPane.getText() != null) {
                        LabelCalc.setText("Выплата в " + NumPane.getText() + " месяц = " + credit.differentedCredit(Integer.parseInt((NumPane.getText()))));
                    }
                    // Выплаты каждый месяц одинаковые и равны sum / period
                    if (credit.method == Method.Annuity && NumPane.getText() != null) {
                        LabelCalc.setText("Выплата в " + NumPane.getText() + " месяц = " + credit.creditSum() / credit.period);
                    }

                }
                catch (NumberFormatException | ArithmeticException ex){
                    JOptionPane.showMessageDialog(null, "Некорректно введены данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}

