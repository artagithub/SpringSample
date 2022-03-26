package ir.dotin.dotinspringdemo.controller;


import com.fasterxml.jackson.annotation.JsonView;
import ir.dotin.dotinspringdemo.account.Card;
import ir.dotin.dotinspringdemo.account.CardDto;
import ir.dotin.dotinspringdemo.account.Views;
import ir.dotin.dotinspringdemo.aspect.ExecutionTime;
import ir.dotin.dotinspringdemo.exception.CardNotFoundException;
import ir.dotin.dotinspringdemo.exception.CustomRestException;
import ir.dotin.dotinspringdemo.repository.CardRepository;
import ir.dotin.dotinspringdemo.service.CardService;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/card")
public class CardController {



    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardService cardService;

    @JsonView(Views.Public.class)
    @GetMapping("/all")
    public ResponseEntity<List<Card>> getAllCards( @RequestHeader Map<String, String> headers){
        headers.forEach((s, s2) -> {
            System.out.println("Header ="+s+" Value ="+s2);});
       return ResponseEntity.ok(cardRepository.findAll(Sort.by(Sort.Direction.ASC, "cardNumber")));
    }

    @RequestMapping(value = "/all-cards", method = RequestMethod.GET)
    @ExecutionTime
    public ResponseEntity<List<Card>> getAllCardsRequestMapping(@RequestHeader(value = "accept",required = false) String acceptHeader){
        System.out.println(acceptHeader);
        //adding response headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("acceptHeader",
                acceptHeader);
        return ResponseEntity
                .ok().headers(responseHeaders).body(cardRepository.findAll(Sort.by(Sort.Direction.ASC, "cardNumber")));
    }

    @RequestMapping(path = "/insert-card",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Card> insertCard(@Valid @RequestBody Card card) throws CustomRestException {
//        throw new CustomRestException("Cant persist card");
        return ResponseEntity.ok(cardRepository.save(card));
    }

    @JsonView(Views.Create.class)
    @PostMapping(path = "/create-card")
    @ResponseBody
    public Card createCard(@RequestBody Card card){
        return cardRepository.save(card);
    }
    @JsonView(Views.Create.class)
    @PutMapping("/update-card/{customer-number}")
    @ResponseBody
    public Card updateCard(@PathVariable("customer-number") Integer customerNumber
            ,@RequestBody Card card){
        Card byCustomerNumber = cardRepository.findByCustomerNumber(customerNumber);
        card.setCustomerNumber(byCustomerNumber.getCustomerNumber());
        return cardRepository.save(card);
    }


    @JsonView(Views.Create.class)
    @PatchMapping("/patch-card/{customer-number}/card-number-and-pan-number")
    @ResponseBody
    public Card patchCard(@PathVariable("customer-number") Integer customerNumber
            ,@RequestBody Card card){
        Card byCustomerNumber = cardRepository.findByCustomerNumber(customerNumber);
        byCustomerNumber.setCardNumber(card.getCardNumber());
        byCustomerNumber.setPanNumber(card.getPanNumber());
        return cardRepository.save(byCustomerNumber);
    }
    @JsonView(Views.Create.class)
    @PatchMapping("/patch-card-dynamic/{customer-number}")
    public Card patchCard(@PathVariable("customer-number") Integer customerNumber,
    @RequestBody Map<String,Object> cardProps){
        Card byCustomerNumber = cardRepository.findByCustomerNumber(customerNumber);
        return cardService.patchCard(byCustomerNumber,cardProps);
    }

    // /card/delete-card?id=*
    @DeleteMapping("/delete-card")
    public void deleteCard(@RequestParam("id") Integer customerNumber){

        cardService.deleteCard(customerNumber);
//
//        try {
//            cardService.deleteCard(customerNumber);
//        }catch (CardNotFoundException exc) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Foo Not Found", exc);
//        }
    }


//    @ExceptionHandler(CardNotFoundException.class)
//    public void handleCardNotFound(){
//        System.out.println("Card not found");
//    }


    public Card findCard(Integer cardId){
        return cardService.findCard(cardId);
    }

    public Integer calculateCardFee(Integer cardPrintFee,Integer cardProduceFee){
        return cardPrintFee * cardProduceFee;
    }




}
