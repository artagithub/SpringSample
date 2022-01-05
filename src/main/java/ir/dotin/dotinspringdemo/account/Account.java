package ir.dotin.dotinspringdemo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class Account {


    private CardActions cardAction;

    public Account() {

    }


    @Autowired
    @Qualifier("physical")
    @Required
    public void setCardAction(CardActions cardAction) {
        this.cardAction = cardAction;
    }

    public CardActions getCardAction() {
        return cardAction;
    }

    public void printAccount(){
        System.out.println(cardAction.printCard());
    }
}
