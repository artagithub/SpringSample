package ir.dotin.dotinspringdemo;

import ir.dotin.dotinspringdemo.account.Account;
import ir.dotin.dotinspringdemo.account.CardActions;
import ir.dotin.dotinspringdemo.account.CardPhysical;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        Account account = new Account();
        CardPhysical cardPhysical = new CardPhysical();
        cardPhysical.setAccount(account);

//        objectObjectHashMap.put("physical",cardPhysical);
//        account.setCardAction(((CardActions) objectObjectHashMap.get("physical")));
//        cardPhysical.setAccount(account);
//        account.printAccount();
    }

}
