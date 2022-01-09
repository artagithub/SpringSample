package ir.dotin.dotinspringdemo.account;

import ir.dotin.dotinspringdemo.eventbus.CardPublishedListener;
import ir.dotin.dotinspringdemo.eventbus.CardPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CardEventHandler implements CardPublishedListener {

    private CardPublisher cardPublisher;

    public CardEventHandler(@Autowired CardPublisher cardPublisher) {
        this.cardPublisher = cardPublisher;
    }

    @PostConstruct
    void init(){
        cardPublisher.addCardPublishListerner(this);
    }

    @Override
    public void cardPublished(Card card) {
        System.out.println(card.getCardNumber());
    }
}
