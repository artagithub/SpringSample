package ir.dotin.dotinspringdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@TestConfiguration
public class TestConfig {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Bean
    public MockMvc getMockMvc(){
        return MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }



}
