package ir.dotin.dotinspringdemo.repository;

import ir.dotin.dotinspringdemo.account.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {



}
