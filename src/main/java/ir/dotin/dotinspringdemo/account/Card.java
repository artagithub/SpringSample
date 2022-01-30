package ir.dotin.dotinspringdemo.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "C_CARD")
//@IdClass(CardPK.class)
@EntityListeners(AuditCurrentUserListener.class)
@Data
public class Card extends Auditable{

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

    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "pan_number")
    private String panNumber;
    @Column(name = "issued_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
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
