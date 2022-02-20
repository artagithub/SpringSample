package ir.dotin.dotinspringdemo.service;

import ir.dotin.dotinspringdemo.account.Card;
import ir.dotin.dotinspringdemo.exception.CardNotFoundException;
import ir.dotin.dotinspringdemo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

@Service
public class CardService {


    @Autowired
    CardRepository cardRepository;


    public Card patchCard(Card byCustomerNumber , Map<String,Object> props){

        if (byCustomerNumber != null) {
            props.forEach((fieldName, value) -> {
                Field field = ReflectionUtils.findField(Card.class, fieldName);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, byCustomerNumber, value);
            });
        }

        return cardRepository.save(byCustomerNumber);
    }


    public void deleteCard(Integer cardId) throws CardNotFoundException{
        Card byCustomerNumber = cardRepository.findByCustomerNumber(cardId);
        if(Objects.isNull(byCustomerNumber))
            throw new CardNotFoundException("Card Not found!!");

        cardRepository.delete(byCustomerNumber);

    }

}
