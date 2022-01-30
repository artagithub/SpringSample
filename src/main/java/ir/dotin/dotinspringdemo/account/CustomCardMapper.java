package ir.dotin.dotinspringdemo.account;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//public class CustomCardMapper implements RowMapper {
//
////    @Override
////    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
//////       return Card.builder().customerNumber(rs.getInt("customer_number"))
//////                .cardNumber(rs.getString("card_number").concat("-number"))
//////                .issuedDate(rs.getDate("issued_date"))
//////                .panNumber(rs.getString("pan_number")).build();
////    }
//}
