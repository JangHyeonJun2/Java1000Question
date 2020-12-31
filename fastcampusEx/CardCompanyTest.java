package fastcampusEx;

public class CardCompanyTest {
    public static void main(String[] args) {
        CardCompany company = CardCompany.getInstance();

        Card myCard = company.createCard();
        Card yourCard = company.createCard();

        System.out.println(myCard.getCardNumber());
        System.out.println(yourCard.getCardNumber());
    }
}

/**
 * 싱글톤 객체
 */
class CardCompany {
    private static CardCompany cardCompany = new CardCompany();

    private CardCompany(){

    }

    public static CardCompany getInstance(){
        return cardCompany;
    }

    public Card createCard(){
        return new Card();
    }
}


class Card{
    private static int number = 10000;

    public Card() {

    }

    public int getCardNumber(){
        return ++number;
    }
}

