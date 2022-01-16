package ir.dotin.dotinspringdemo.repository;

import ir.dotin.dotinspringdemo.account.Card;
import ir.dotin.dotinspringdemo.account.CustomCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Card> getAllCards(){
        return jdbcTemplate.query("select * from c_card"
                , new BeanPropertyRowMapper<Card>(Card.class));
    }

    public Card fetchCardByCustomerNumber(int customerNumber){
        return jdbcTemplate.queryForObject("select * from c_card c where c.customer_number = ?"
        ,new BeanPropertyRowMapper<>(Card.class),new Object[]{customerNumber});
    }

    public int insertCard(Card card){
        String sql =
        "INSERT INTO C_CARD (customer_number,\n" +
                "    card_number,\n" +
                "pan_number,\n" +
                "issued_date) VALUES (?,?,?,?)" ;
       return jdbcTemplate.update(sql,new Object[]{card.getCustomerNumber(),card.getCardNumber(),
        card.getPanNumber(),card.getIssuedDate()});
    }

    public int updateCard(Card card){
        String sql = "UPDATE C_CARD SET card_number = ? where customer_number = ?";
        return jdbcTemplate.update(sql,new Object[]{card.getCardNumber(),card.getCustomerNumber()});
    }

    public int deleteCardByCustomerNumber(int customerNumber){
        String sql = "DELETE FROM C_CARD c WHERE c.customer_number = ?";
        return jdbcTemplate.update(sql,new Object[]{customerNumber});
    }

    public Card fetchCardByCustomerNumberCustomMapper(int customerNumber){
        return (Card) jdbcTemplate.queryForObject("select * from c_card c where c.customer_number = ?"
                ,new CustomCardMapper(),new Object[]{customerNumber});
    }


}
