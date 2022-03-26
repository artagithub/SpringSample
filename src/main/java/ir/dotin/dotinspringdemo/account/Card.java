package ir.dotin.dotinspringdemo.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import ir.dotin.dotinspringdemo.validation.PanNumberValid;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.swing.text.View;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

//@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Builder
@Entity
@Table(name = "C_CARD")
//@IdClass(CardPK.class)
//@EntityListeners(AuditCurrentUserListener.class)
public class Card{

    public Card() {
    }

    public Card(Integer customerNumber, String cardNumber, String panNumber, Date issuedDate) {
        this.customerNumber = customerNumber;
        this.cardNumber = cardNumber;
        this.panNumber = panNumber;
        this.issuedDate = issuedDate;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    @JsonView(Views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(generator = "sequence-generator")
//    @GenericGenerator(
//            name = "sequence-generator",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @Parameter(name = "sequence_name", value = "card_sequence"),
//                    @Parameter(name = "initial_value", value = "4"),
//                    @Parameter(name = "increment_size", value = "5")
//            }
//    )
//    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE,generator = "card_id_table_generator")
//    @TableGenerator(name = "card_id_table_generator",table = "TABLE_KEY",
//    pkColumnName = "key_column",valueColumnName = "key_value")
    private Integer customerNumber;


//    @GeneratedValue("custom_generator")
//    @GenericGenerator(name = "custom_generator",parameters = @org.hibernate.annotations.Parameter(
//            name = "prefix" , value="card" ) , strategy = "ir.dotin.dotinspringdemo.account.CustomPrimaryGenerator"
//    ))
//
//    @Id
//    @GeneratedValue("custom_generator")
//    @GenericGenerator(name = "custom_generator",parameters = @org.hibernate.annotations.Parameter(
//            name = "devider" , value="card" ) , strategy = "ir.dotin.dotinspringdemo.account.CustomPrimaryGenerator"
//    ))
//    private Integer customerNumber;


//    @Id
//    @GeneratedValue(generator = "custom_generator")
//    @GenericGenerator(name = "custom_generator", parameters = @org.hibernate.annotations.Parameter(
//            name = "divider" ,value = "-"
//    ) , strategy = "ir.dotin.dotinspringdemo.account.CustomPrimaryGenerator")
//    private String customerNumber;



//
//    @EmbeddedId

//    @Column(name = "customer_number")
//    private CardPK cardPK;

//    example @IdClass
//
//    private Integer customerId;
//
//    private Integer bankId;

//    @Column(name = "customer_number")
//    private CardPK cardPK;
//
//    @OneToOne
//    private User user;

    @JsonView({Views.Public.class,Views.Create.class})
    @Column(name = "card_number")
    @NotNull(message = "Card Number must not be null")
    private String cardNumber;
    @JsonView({Views.Public.class,Views.Create.class})
    @Column(name = "pan_number")
    @PanNumberValid(message = "Pan number is not valid")
    private String panNumber;
    @JsonView({Views.Public.class,Views.Create.class})
    @Column(name = "issued_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date issuedDate;


//    @PostPersist
//    public void postPersist(){
////        example logging purpose
//    }
//
//    @PreUpdate
//    public void preUpdate(){
////        load current user and set to card
//    }




}
