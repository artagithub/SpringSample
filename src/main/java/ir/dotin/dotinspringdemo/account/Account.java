package ir.dotin.dotinspringdemo.account;

import ir.dotin.dotinspringdemo.eventbus.GlobalEventBus;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@PropertySource("classpath:business.properties")
public class Account implements InitializingBean, DisposableBean {


    //    same as @PostConstruct
//    @PostConstruct
//    void init(){
//        this.accountNumber = "asdf";
//    }


    @Override
    public void afterPropertiesSet() throws Exception {
        this.accountNumber = "5564";
    }


    @Value("${account.number}")
    private String accountNumber;

//    private CardActions cardPhysical;

    public Account() {

    }

//
//    @Autowired
//    @Qualifier("physical")
//    @Required
//    public void setCardAction(CardActions cardAction) {
//        this.cardPhysical = cardAction;
//    }
//
//    public CardActions getCardAction() {
//        return cardPhysical;
//    }

    public void printAccount(){
        GlobalEventBus.post(Card.builder().cardNumber("1002").customerNumber(12345)
                .issuedDate(new Date()).build());
//        System.out.println(cardPhysical.printCard().concat(" account Number ".concat(accountNumber)));
    }

//    same as destroy
//    @PreDestroy
//    void destory(){
//        this.accountNumber = null;
//    }


    @Override
    public void destroy() throws Exception {
        this.accountNumber = null;
    }


}
