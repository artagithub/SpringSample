package ir.dotin.dotinspringdemo.account;

import ir.dotin.dotinspringdemo.ExcludeBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@ExcludeBean
@Qualifier("virtual")
@Component
public class CardVirtual implements CardActions{

    public CardVirtual() {
    }

    public String printCard(){
        return "virtual card";
    }
}
