package ir.dotin.dotinspringdemo.eventbus;

import ir.dotin.dotinspringdemo.account.Card;

@FunctionalInterface
public interface CardPublishedListener {
    void cardPublished(Card card);
}
