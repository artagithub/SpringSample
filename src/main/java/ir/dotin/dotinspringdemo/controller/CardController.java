package ir.dotin.dotinspringdemo.controller;


import ir.dotin.dotinspringdemo.account.Card;
import ir.dotin.dotinspringdemo.account.CardDto;
import ir.dotin.dotinspringdemo.aspect.ExecutionTime;
import ir.dotin.dotinspringdemo.exception.CustomRestException;
import ir.dotin.dotinspringdemo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ExecutionTime
    public ResponseEntity<List<Card>> getAllCardsRequestMapping(){
        return ResponseEntity.ok(cardRepository.findAll(Sort.by(Sort.Direction.ASC, "cardNumber")));
    }

    @RequestMapping(path = "/insert-card",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Card> insertCard(@RequestBody Card card) throws CustomRestException {
//        throw new CustomRestException("Cant persist card");
        return ResponseEntity.ok(cardRepository.save(card));
    }




}
