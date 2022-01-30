package ir.dotin.dotinspringdemo.repository;

import ir.dotin.dotinspringdemo.account.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public interface CardRepository extends JpaRepository<Card, Integer>,CustomCardRepository {

    //JPQL
    @Query(value = "SELECT c FROM Card c where c.panNumber = ?1")
    Card findCardByCardPan(String panNumber);
    //Native set native query true
    @Query(value = "SELECT * FROM C_CARD c WHERE c.PAN_NUMBER = ?1",nativeQuery = true)
    Card findCardByCardPanNative(String panNumber);

    @Query(value = "SELECT c FROM Card c where c.panNumber = :pannumber" )
    Card findCardByCardPanNamedParam(@Param("pannumber") String pan);

    @Query(value = "SELECT c FROM Card c where c.panNumber IN :pannumber" )
    Card findCardByCardPanCollection(@Param("pannumber") Collection<String> pan);

    @Query(value = "update Card c set c.panNumber = :pannumber" )
    @Modifying
    Card updatePanNumber(@Param("pannumber") String pan);


    //todo: We can specify the count query
    @Query(value = "SELECT c FROM Card c where c.panNumber = ?1",
    countQuery = "SELECT count(c) FROM Card c where c.panNumber = ?1")
    Page<Card> findCardByCardPanPagination(String panNumber, Pageable pageable);

    //todo: the query by parameter name
    // first type the Type of Entity here for example Card then autocompletion
    Card findByCustomerNumberAndCardNumberIs(Integer customerNumber,String cardNumber);

}
