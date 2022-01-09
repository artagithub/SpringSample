package ir.dotin.dotinspringdemo.account;

import lombok.*;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Card {

    private Integer customerNumber;
    private String cardNumber;
    private String panNumber;
    private Date issuedDate;


}
