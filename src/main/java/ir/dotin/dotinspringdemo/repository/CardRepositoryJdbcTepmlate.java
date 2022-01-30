//package ir.dotin.dotinspringdemo.repository;
//
//import ir.dotin.dotinspringdemo.account.Card;
//import ir.dotin.dotinspringdemo.account.CustomCardMapper;
//import ir.dotin.dotinspringdemo.account.CustomSQLErrorTranslator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BatchPreparedStatementSetter;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
//import org.springframework.jdbc.core.simple.SimpleJdbcCall;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class CardRepositoryJdbcTepmlate {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    public List<Card> getAllCards(){
//        return jdbcTemplate.query("select * from c_card"
//                , new BeanPropertyRowMapper<Card>(Card.class));
//    }
//
//    public Card fetchCardByCustomerNumber(int customerNumber){
//        return jdbcTemplate.queryForObject("select * from c_card c where c.customer_number = ?"
//        ,new BeanPropertyRowMapper<>(Card.class),new Object[]{customerNumber});
//    }
//
//    public int insertCard(Card card){
//        String sql =
//        "INSERT INTO C_CARD (customer_number,\n" +
//                "    card_number,\n" +
//                "pan_number,\n" +
//                "issued_date) VALUES (?,?,?,?)";
//       return jdbcTemplate.update(sql,new Object[]{card.getCustomerNumber(),card.getCardNumber(),
//        card.getPanNumber(),card.getIssuedDate()});
//    }
//
//    public int updateCard(Card card){
//        String sql = "UPDATE C_CARD SET card_number = ? where customer_number = ?";
//        return jdbcTemplate.update(sql,new Object[]{card.getCardNumber(),card.getCustomerNumber()});
//    }
//
//    public int deleteCardByCustomerNumber(int customerNumber){
//        String sql = "DELETE FROM C_CARD c WHERE c.customer_number = ?";
//        return jdbcTemplate.update(sql,new Object[]{customerNumber});
//    }
//
//    public Card fetchCardByCustomerNumberCustomMapper(int customerNumber){
//        return (Card) jdbcTemplate.queryForObject("select * from c_card c where c.customer_number = ?"
//                ,new CustomCardMapper(),new Object[]{customerNumber});
//    }
//
//    /*  example calling stored procedure jdbctemplate
//    public String storedProcedureCallJdbcTemplate(String cardId){
//        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
//                .withProcedureName("C_CARD_DISABLE");
//        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//        mapSqlParameterSource.addValue("card_id",cardId);
//        Map<String, Object> result = simpleJdbcCall.execute(mapSqlParameterSource);
//        return ((String) result.get("CARD_NUMBER"));
//    }
//    */
//
//    public int[] batchInsertIntoCardTable(List<Card> cardList){
//        String sqlInsertQuery = "INSERT INTO C_CARD VALUES (?,?,?,?)";
//        BatchPreparedStatementSetter batchPreparedStatementSetter = new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps, int i) throws SQLException {
//                ps.setInt(1,cardList.get(i).getCustomerNumber());
//                ps.setString(2,cardList.get(i).getCardNumber());
//                ps.setString(3,cardList.get(i).getPanNumber());
//                ps.setDate(4,new Date(cardList.get(i).getIssuedDate().getTime()));
//            }
//
//            @Override
//            public int getBatchSize() {
//                return 5;
//            }
//        };
//        return jdbcTemplate.batchUpdate(sqlInsertQuery,batchPreparedStatementSetter);
//    }
//
//
//    public int[] batchInsertIntoCardTableWithNamedParameter(List<Card> cardList){
//        String sqlInsertQuery = "INSERT INTO C_CARD VALUES (:customerNumber," +
//                ":cardNumber,:panNumber,:issuedDate)";
//        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(cardList.toArray());
//        return namedParameterJdbcTemplate.batchUpdate(sqlInsertQuery,batch);
//    }
//
//}
