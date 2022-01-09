package ir.dotin.dotinspringdemo.eventbus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import ir.dotin.dotinspringdemo.account.Card;

import java.util.HashSet;
import java.util.Set;

@Subscriber
public class CardPublisher {

    Set<CardPublishedListener> cardPublishedListenerSet = new HashSet<>();

    public void addCardPublishListerner(CardPublishedListener  cardPublishedListener){
        synchronized (this.cardPublishedListenerSet){
            this.cardPublishedListenerSet.add(cardPublishedListener);
        }
    }

    public void removeCardPublishListener(CardPublishedListener cardPublishedListener){
        synchronized (this.cardPublishedListenerSet){
            this.cardPublishedListenerSet.remove(cardPublishedListener);
        }
    }


    @Subscribe
    @AllowConcurrentEvents
    public void handleCardPublishedEvent(Card card){
        Set<CardPublishedListener> listeners;
        synchronized (this.cardPublishedListenerSet){
            listeners = new HashSet<>(this.cardPublishedListenerSet);
        }
        listeners.forEach(cardPublishedListener -> {
            cardPublishedListener.cardPublished(card);
        });
    }
}
