package ir.dotin.dotinspringdemo.account;

import ir.dotin.dotinspringdemo.eventbus.GlobalEventBus;
import ir.dotin.dotinspringdemo.eventbus.Subscriber;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
