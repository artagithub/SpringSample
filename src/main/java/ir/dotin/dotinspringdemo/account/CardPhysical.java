package ir.dotin.dotinspringdemo.account;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Qualifier("physical")
@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CardPhysical implements CardActions {
    private Account account;

    public CardPhysical() {
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String printCard(){
        return "physical card";
    }
}
