package ir.dotin.dotinspringdemo.eventbus;

import ir.dotin.dotinspringdemo.account.CardPhysical;
import ir.dotin.dotinspringdemo.account.CardVirtual;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostProcessorConfiguration {

    @Bean
    public GlobalEventBus eventBus() {
        return GlobalEventBus.getInstance();
    }

    @Bean
    public EventBusBeanPostPorcessor eventBusBeanPostProcessor() {
        return new EventBusBeanPostPorcessor();
    }


    @Bean
    @ConditionalOnBean(CardPhysical.class)
    public CardPublisher stockTradePublisher() {
        return new CardPublisher();
    }

}
