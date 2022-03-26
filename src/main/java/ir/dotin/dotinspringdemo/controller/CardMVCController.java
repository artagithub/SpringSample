package ir.dotin.dotinspringdemo.controller;

import ir.dotin.dotinspringdemo.account.Card;
import ir.dotin.dotinspringdemo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/cardMvc")
public class CardMVCController {

    @Autowired
    private CardService cardService;


    @InitBinder
    public void convertDate(WebDataBinder webDataBinder, WebRequest webRequest){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }

    @RequestMapping("/showCard")
    public String showCard(HttpServletRequest httpServletRequest, Model model){
        Card card = cardService.findCard(Integer.valueOf(httpServletRequest
                .getParameter("cardId")));
        model.addAttribute("panNumber",card.getPanNumber());
        return "showcard";
    }


    @RequestMapping("/showAddCardForm")
    public ModelAndView addCardPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("card",new Card());
        modelAndView.setViewName("addcard");
        return modelAndView;
    }

    @RequestMapping("/addCard")
    public String addCard(@Valid @ModelAttribute("card") Card card, Model model){
        Card card1 = cardService.addCard(card);
        model.addAttribute("panNumber",card.getPanNumber());
        model.addAttribute("cardNumber",card.getCardNumber());
        model.addAttribute("issuedDate",card.getIssuedDate());
        return "showcard";
    }





}
