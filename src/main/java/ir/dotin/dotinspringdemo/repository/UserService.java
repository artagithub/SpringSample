package ir.dotin.dotinspringdemo.repository;

import ir.dotin.dotinspringdemo.account.Card;
import ir.dotin.dotinspringdemo.account.User;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private CardRepository cardRepository;

    private UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void updateUserAndCardPan(User user) throws Exception {
        userRepository.save(user);
        Optional<Card> cardById = cardRepository.findById(1);
        Card card = cardById.get();
        cardRepository.updateCardPan(card);

    }

}
