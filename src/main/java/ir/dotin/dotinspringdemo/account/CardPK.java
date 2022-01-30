package ir.dotin.dotinspringdemo.account;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CardPK implements Serializable {

    public CardPK() {
    }

    public CardPK(Integer customerId, Integer bankId) {
        this.customerId = customerId;
        this.bankId = bankId;
    }

    private Integer customerId;
    private Integer bankId;
}
