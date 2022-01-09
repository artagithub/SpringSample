package ir.dotin.dotinspringdemo;

import ir.dotin.dotinspringdemo.account.CardActions;
import ir.dotin.dotinspringdemo.account.Account;
import ir.dotin.dotinspringdemo.account.CardPhysical;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;

@ComponentScan(excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,classes =ExcludeBean.class
))
//@Configuration
@SpringBootApplication
public class DotinSpringDemoApplication {


//    @Bean
//    public CardActions cardAction(){
//        return new CardPhysical();
//    }

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor(){
        return factory-> {
            BeanDefinitionRegistry definitionRegistry = (BeanDefinitionRegistry) factory;
            definitionRegistry.registerBeanDefinition("accountNumber", BeanDefinitionBuilder
                    .genericBeanDefinition(String.class).addConstructorArgValue("1000")
                    .getBeanDefinition());
        };
    }

    public static void main(String[] args) {
        boolean report = true;
        ConfigurableApplicationContext appContext = SpringApplication.run(DotinSpringDemoApplication.class);

//        todo: without springbootapplication
//            AnnotationConfigApplicationContext annotationConfigApplicationContext;
//            annotationConfigApplicationContext = new AnnotationConfigApplicationContext(DotinSpringDemoApplication.class);


        Account account1 = appContext.getBean(Account.class);
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        account1.printAccount();
        System.out.println(account1);
//        CardPhysical cardActions = ((CardPhysical) appContext.getBean(CardPhysical.class));
//        System.out.println(cardActions);



    }

}
