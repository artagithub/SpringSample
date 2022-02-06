package ir.dotin.dotinspringdemo.account;



public class CardDto {

    private String cardNumber;
    private String panNumber;

    public CardDto(String cardNumber, String panNumber) {

        this.cardNumber = cardNumber;
        this.panNumber = panNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }
}
