package ir.dotin.dotinspringdemo.eventbus;

import ir.dotin.dotinspringdemo.DestroyPrototypeBeansPostProcessor;
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
    public CardPublisher stockTradePublisher() {
        return new CardPublisher();
    }

}
