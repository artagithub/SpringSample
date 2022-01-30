package ir.dotin.dotinspringdemo.repository;

import ir.dotin.dotinspringdemo.account.Card;

public interface CustomCardRepository {

    void updateCardPan(Card card) throws Exception;
}
