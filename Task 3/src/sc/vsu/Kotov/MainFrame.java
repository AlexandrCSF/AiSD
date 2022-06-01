package sc.vsu.Kotov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainFrame extends JFrame {
    private JTextPane textPaneCurrCardSuit;
    private JTextPane textPaneNextCardSuit;
    private JButton buttonCheck;
    private JTextPane textPaneCurrCardNum;
    private JTextPane textPaneNextCardNum;
    private JPanel panelMain;
    private JLabel LabelState;
    private JLabel LabelCount;
    private JTextField textFieldDeck;
    private JTextField textFieldCards;
    // Создаем игру
    CardGame game = new CardGame();

    public MainFrame() throws SimplifiedLinkedList.SimplifiedLinkedListExeption {
        this.setTitle("Карточная игра");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


        ru.vsu.cs.util.SwingUtils.setShowMessageDefaultErrorHandler();

        // Заполняем поля для текста значениями карт
        textPaneCurrCardSuit.setText(String.valueOf(game.currCard.getSuit()));
        textPaneCurrCardNum.setText(String.valueOf(game.currCard.getNum()));
        textPaneNextCardNum.setText(String.valueOf(game.nextCard.getNum()));
        textPaneNextCardSuit.setText(String.valueOf(game.nextCard.getSuit()));
        textFieldCards.setText(game.currCard.getSuit() + " " + game.currCard.getNum() + " ");

        buttonCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Подсчёт ходов
                if (game.calcstate() == CardGame.State.Playing)
                    LabelCount.setText(String.valueOf(Integer.parseInt(LabelCount.getText()) + 1));
                // Впоследствии будем меня цвет на зеленый, если совпадают масти или номиналы карт
                textPaneNextCardNum.setForeground(Color.BLACK);
                textPaneCurrCardNum.setForeground(Color.BLACK);
                textPaneNextCardSuit.setForeground(Color.BLACK);
                textPaneCurrCardSuit.setForeground(Color.BLACK);

                textPaneCurrCardSuit.setText(String.valueOf(game.currCard.getSuit()));
                textPaneCurrCardNum.setText(String.valueOf(game.currCard.getNum()));
                textPaneNextCardNum.setText(String.valueOf(game.nextCard.getNum()));
                textPaneNextCardSuit.setText(String.valueOf(game.nextCard.getSuit()));

                try {
                    game.checkCard();
                } catch (SimplifiedLinkedList.SimplifiedLinkedListExeption ex) {
                    ex.printStackTrace();
                }

                LabelState.setText(String.valueOf(game.calcstate()));
// Если значения карт совпадают, меняем цвет на зеленый
                if (Objects.equals(textPaneNextCardSuit.getText(), textPaneCurrCardSuit.getText())) {
                    textPaneNextCardSuit.setForeground(Color.GREEN);
                    textPaneCurrCardSuit.setForeground(Color.GREEN);
                }
                if (Objects.equals(textPaneNextCardNum.getText(), textPaneCurrCardNum.getText())) {
                    textPaneNextCardNum.setForeground(Color.GREEN);
                    textPaneCurrCardNum.setForeground(Color.GREEN);
                }
                textFieldDeck.setText("");
                // Выводим все карты, который в колоде
                for (int i = 0; i < game.deck.getSize(); i++) {
                    textFieldDeck.setText(textFieldDeck.getText() + printCard(i));

                }
                // Выводим карты, которые на столе
                if (game.nextCard.getNum() == game.currCard.getNum() || game.currCard.getSuit() == game.nextCard.getSuit())
                    textFieldCards.setText(textFieldCards.getText() + game.nextCard.getSuit() + " " + game.nextCard.getNum() + " ");
            }
        });
    }
    // Выводим значения карты
    public String printCard(int index) {
        String card;
        card = String.valueOf(game.getCard(index).getSuit()) + " " + game.getCard(index).getNum() + " ";
        return card;
    }
}
