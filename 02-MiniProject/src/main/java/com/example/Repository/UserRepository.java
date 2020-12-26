package com.example.Repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.User;

public interface UserRepository extends JpaRepository<User,Serializable>
{
   User findByeMail(String emailId);
   User findeMailAndpwd(String emailId,String pwd);

}
