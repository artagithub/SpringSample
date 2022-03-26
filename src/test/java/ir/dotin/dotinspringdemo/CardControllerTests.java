package ir.dotin.dotinspringdemo;

import ir.dotin.dotinspringdemo.account.Card;
import ir.dotin.dotinspringdemo.controller.CardController;
import ir.dotin.dotinspringdemo.exception.CustomRestException;
import ir.dotin.dotinspringdemo.repository.CardRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith({SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = DotinSpringDemoApplication.class)
@Import(TestConfig.class)
@EnableWebMvc
@TestPropertySource( locations = "classpath:business-test.properties")
public class CardControllerTests {


    @Autowired
    MockMvc mvc;



    @Mock
    @Autowired
    private CardRepository cardRepositoryMock;

    @InjectMocks
    @Autowired
    private CardController CARD_CONTROLLER;


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @BeforeAll
    public static void init(){
        System.out.println("Before All!");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Before Each Test!");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After Each Test!");
    }

    @Test
    @Order(1)
    public void test_PanNumberValid() throws Exception {


        mvc.perform(get("/card/all")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                        .andExpect(jsonPath("$[0].panNumber",is("456sd516351")))
                ;

//        when(cardRepositoryMock.save(any())).thenReturn(new Card(1231234,
//                "adfa","54654",new Date()));
//        ResponseEntity<Card> cardResponseEntity = CARD_CONTROLLER.insertCard(new Card());
//        assertEquals(cardResponseEntity.getBody().getPanNumber(),"54654");
    }


    @Test
    @Order(2)
//    @Disabled
    public void test_CardNumberValid(){
        assertEquals(CARD_CONTROLLER.calculateCardFee(4,3),12);
    }

}
