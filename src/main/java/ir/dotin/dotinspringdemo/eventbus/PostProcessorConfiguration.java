package ir.dotin.dotinspringdemo.eventbus;

import ir.dotin.dotinspringdemo.account.CardPhysical;
import ir.dotin.dotinspringdemo.account.CardVirtual;
import ir.dotin.dotinspringdemo.account.CustomSQLErrorTranslator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

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

    /* example for having two types of datasource and set exception translator for jdbc template
    @Bean
    public DataSource generateH2Datasource(){}

    @Bean
    public DataSource generateMysqlDatasource(){}

    @Bean
    public JdbcTemplate generateJdbcTemplate(){
        if(sqlType=="h2"){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(generateH2Datasource());
            jdbcTemplate.setExceptionTranslator(new CustomH2SQLErrorTranslator());
         return jdbcTemplate;
        }else if (sqlType=="mysql"){
            JdbcTemplate jdbcTemplate = new JdbcTemplate(generateMysqlDatasource());
            jdbcTemplate.setExceptionTranslator(new CustomSQLErrorTranslator());
            return jdbcTemplate;
        }

    }
    */
}
