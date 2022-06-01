package sc.vsu.Kotov;


// Основной класс, в котором описана логика игры
public class CardGame {

    public enum State {
        Playing,
        End;
    }


    private static final CardSuit[] SUITS = {
            CardSuit.Spades,
            CardSuit.Hearts,
            CardSuit.Clubs,
            CardSuit.Diamonds
    };

    // Подкласс, который описывает параметры карты
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
    SelfMadeStack<Card> deck = new SelfMadeStack<>();
    // Текущая карта
    public Card currCard;
    // Следующая карта в колоде
    public Card nextCard;
    // Статус игры
    public State state;

    public CardGame() throws SimplifiedLinkedList.SimplifiedLinkedListExeption {
        // Заполняем колоду картами
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
    public void checkCard() throws SimplifiedLinkedList.SimplifiedLinkedListExeption {

        if (deck.getSize() == 0) {
            return;
        }
        if (nextCard.getSuit() == currCard.getSuit() || nextCard.getNum() == currCard.getNum()) {
            currCard = nextCard;
            nextCard = deck.pop();
        } else {
            deck.push(nextCard);
            nextCard = deck.pop();
        }
    }

    // Рассчитываем стадию игры
    public State calcstate() {
        for (int i = 0; i < deck.getSize(); i++) {
            if (currCard.getSuit() == getCard(i).getSuit() || currCard.getNum() == getCard(i).getNum() || currCard.getNum() == nextCard.getNum() || currCard.getSuit() == nextCard.getSuit()) {
                return State.Playing;
            }
        }
        return State.End;
    }

    //получить любую карту по индексу
    public Card getCard(int index) {
        return deck.get(index);
    }
}
