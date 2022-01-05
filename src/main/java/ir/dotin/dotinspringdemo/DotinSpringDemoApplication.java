package ir.dotin.dotinspringdemo;

import ir.dotin.dotinspringdemo.account.CardActions;
import ir.dotin.dotinspringdemo.account.Account;
import ir.dotin.dotinspringdemo.account.CardPhysical;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,classes =ExcludeBean.class
))
@SpringBootApplication
public class DotinSpringDemoApplication {

    public static void main(String[] args) {
        boolean report = true;
        ConfigurableApplicationContext appContext = SpringApplication.run(DotinSpringDemoApplication.class);

        Account account1 = appContext.getBean(Account.class);
        System.out.println(account1);
        CardPhysical cardActions = ((CardPhysical) appContext.getBean(CardPhysical.class));
        System.out.println(cardActions);


    }

}
