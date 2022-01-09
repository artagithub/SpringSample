package ir.dotin.dotinspringdemo.account;

import ir.dotin.dotinspringdemo.eventbus.CardPublishedListener;
import ir.dotin.dotinspringdemo.eventbus.CardPublisher;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Qualifier("physical")
@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CardPhysical implements CardActions , CardPublishedListener, DisposableBean {


    private CardPublisher cardPublisher;

    @Autowired
    public void setCardPublisher(CardPublisher cardPublisher) {
        this.cardPublisher = cardPublisher;
    }



    public CardPhysical() {


    }

    public String printCard(){
        return "physical card";
    }


    @Override
    public void cardPublished(Card card) {
        System.out.println(card.getCardNumber());
    }

    @Override
    public void destroy() throws Exception {

    }
}
