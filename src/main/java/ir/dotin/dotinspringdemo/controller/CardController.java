package ir.dotin.dotinspringdemo.controller;


import ir.dotin.dotinspringdemo.account.Card;
import ir.dotin.dotinspringdemo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {


    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Card>> getAllCards(){
       return ResponseEntity.ok(cardRepository.findAll(Sort.by(Sort.Direction.ASC, "cardNumber")));
    }

    @RequestMapping(value = "/all-cards", method = RequestMethod.GET)
    public ResponseEntity<List<Card>> getAllCardsRequestMapping(){
        return ResponseEntity.ok(cardRepository.findAll(Sort.by(Sort.Direction.ASC, "cardNumber")));
    }


}
