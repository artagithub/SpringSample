package ir.dotin.dotinspringdemo;

import ir.dotin.dotinspringdemo.account.Card;
import ir.dotin.dotinspringdemo.account.CardPK;
import ir.dotin.dotinspringdemo.account.User;
import ir.dotin.dotinspringdemo.repository.CardRepository;
import ir.dotin.dotinspringdemo.repository.UserService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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


//        Account account1 = appContext.getBean(Account.class);
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        account1.printAccount();
//        CardPublisher cardPublisher = appContext.getBean(CardPublisher.class);
//        System.out.println(cardPublisher);
//        System.out.println(account1);
//        CardPhysical cardActions = ((CardPhysical) appContext.getBean(CardPhysical.class));
//        System.out.println(cardActions);
        CardRepository cardRepository = appContext.getBean(CardRepository.class);
        UserService userService = appContext.getBean(UserService.class);
//        cardRepository.getAllCards().forEach(card -> System.out.println(card.getCardNumber()));
//        System.out.println(cardRepository.fetchCardByCustomerNumber(23).getCustomerNumber());
//        System.out.println(cardRepository.fetchCardByCustomerNumberCustomMapper(23).getCardNumber());
//        System.out.println(cardRepository.insertCard(Card.builder().customerNumber(26)
//                .panNumber("456516351").cardNumber("546135185").issuedDate(new Date()).build()));
//        System.out.println(cardRepository.updateCard(Card.builder().customerNumber(26).cardNumber("546235185").build()));
//        System.out.println(cardRepository.deleteCardByCustomerNumber(26));

//        List<Card> batchCards = new ArrayList<>();
//        batchCards.add(
//                Card.builder().customerNumber(30)
//                        .panNumber("456sd516351").cardNumber("54613sd5185").issuedDate(new Date()).build()
//        );
//        batchCards.add(
//                Card.builder().customerNumber(31)
//                        .panNumber("456sd516351").cardNumber("54613sd5185").issuedDate(new Date()).build()
//        );
//        batchCards.add(
//                Card.builder().customerNumber(32)
//                        .panNumber("456sd516351").cardNumber("54613sd5185").issuedDate(new Date()).build()
//        );
//        batchCards.add(
//                Card.builder().customerNumber(33)
//                        .panNumber("456sd516351").cardNumber("54613sd5185").issuedDate(new Date()).build()
//        );
//        batchCards.add(
//                Card.builder().customerNumber(34)
//                        .panNumber("456sd516351").cardNumber("54613sd5185").issuedDate(new Date()).build()
//        );
//        cardRepository.batchInsertIntoCardTableWithNamedParameter(batchCards);


//        cardRepository.save(Card.builder().customerId(34).bankId(56)
//                .panNumber("456sd516351").cardNumber("54613sd5185").issuedDate(new Date()).build());

//        cardRepository.save(Card.builder()
//                .panNumber("456sd516351").cardNumber("54613sd5185").issuedDate(new Date()).build());
//
        cardRepository.save(Card.builder()
                .panNumber("456sd516351").cardNumber("54613sd5185").issuedDate(new Date()).build());
        cardRepository.findByCustomerNumberAndCardNumberIs(1,"54613sd5185");
//        Optional<Card> byId = cardRepository.findById(new CardPK(45, 65));
//        System.out.println("the card entity "+ byId.get().getCardNumber());
//cardRepository.findAll(JpaSort.unsafe("LENGTH(panNumber)"));


    }

}
