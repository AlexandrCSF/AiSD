package sc.vsu.Kotov;

import java.util.Stack;


public class CardGame {


    public enum State {
        Playing,
        End;
    }
    // Масти карт
    private static final CardSuit[] SUITS = {
            CardSuit.Spades,
            CardSuit.Hearts,
            CardSuit.Clubs,
            CardSuit.Diamonds
    };
    // Подкласс, описывающий каждую карту
    public static class Card {
        private final CardSuit suit;
        private final int num;

        public Card(CardSuit suit, int num) {
            this.suit = suit;
            this.num = num;
        }

        public CardSuit getSuit() {
            return suit;
        }

        public int getNum() {
            return num;
        }
    }
    // Колода
    Stack<Card> deck = new Stack<>();
    // Текущая карта
    public Card currCard;
    // Следующая карта
    public Card nextCard;
    public State state;

    public CardGame() {
        // Наполняем колоду картами
        for (int i = 0; i < 36; i++) {
            {
                deck.push(new Card(SUITS[i / 9], (int) (Math.random() * 10) + 1));
            }
        }
        // Вытаскиваем из колоды две карты
        currCard = deck.pop();
        nextCard = deck.pop();
        state = State.Playing;
    }

    // Проверяем, сходятся ли следующа и текущая карта по масти или номиналу
    public void checkCard() {

        if (deck.size() == 0) {
            return;
        }
        if (nextCard.getSuit() == currCard.getSuit() || nextCard.getNum() == currCard.getNum()) {
            currCard = nextCard;
            nextCard = deck.pop();
        } else {
            deck.add(0,nextCard);
            nextCard = deck.pop();
        }
    }
// Рассчитываем стадию игры
    public State calcstate() {
        for (Card card : deck) {
            if (currCard.getSuit() == card.getSuit() || currCard.getNum() == card.getNum() || currCard.getNum() == nextCard.getNum() || currCard.getSuit() == nextCard.getSuit()) {
                return State.Playing;
            }
        }
        return State.End;
        }
    //получить любую карту по индексу
        public Card getCard(int index){
        return deck.get(index);
        }
    }
