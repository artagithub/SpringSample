package ir.dotin.dotinspringdemo.repository;

import ir.dotin.dotinspringdemo.account.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;



public class CustomCardRepositoryImpl implements CustomCardRepository{

    @Autowired
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED)
    @Override
    public void updateCardPan(Card card) throws Exception {
//        throw new Exception("A");
//
//        card.setPanNumber("123124124");
//        entityManager.merge(card);
//        throw new Exception("A");
    }
}
