package ir.dotin.dotinspringdemo;

import ir.dotin.dotinspringdemo.account.Card;
import ir.dotin.dotinspringdemo.account.CardDto;
import ir.dotin.dotinspringdemo.repository.CardRepository;
import ir.dotin.dotinspringdemo.repository.UserService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@ComponentScan(excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,classes =ExcludeBean.class
))
//@Configuration
@SpringBootApplication
@EnableWebMvc
@ServletComponentScan
public class DotinSpringDemoApplication implements WebMvcConfigurer {





    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource reloadableResourceBundleMessageSource
                = new ResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("classpath:messages");
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return reloadableResourceBundleMessageSource;
    }

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/templates/");
        bean.setSuffix(".jsp");
        return bean;
    }


//    @Bean
//    @Description("Thymeleaf Template Resolver")
//    public ServletContextTemplateResolver templateResolver() {
//        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
//        templateResolver.setPrefix("/WEB-INF/views/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//
//        return templateResolver;
//    }
//
//    @Bean
//    @Description("Thymeleaf Template Engine")
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setTemplateEngineMessageSource(messageSource());
//        return templateEngine;
//    }

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
        cardRepository.save(Card.builder()
                .panNumber("452326sd516351").cardNumber("54613sd5185").issuedDate(new Date()).build());
        cardRepository.findByPanNumberEqualsAndAndCardNumberEquals("456sd516351","54613sd5185");
        cardRepository.findAllByCardNumber("54613sd5185",CardDto.class);


//        Optional<Card> byId = cardRepository.findById(new CardPK(45, 65));
//        System.out.println("the card entity "+ byId.get().getCardNumber());
//cardRepository.findAll(JpaSort.unsafe("LENGTH(panNumber)"));


    }

}
