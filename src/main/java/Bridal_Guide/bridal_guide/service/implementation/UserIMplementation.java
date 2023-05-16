package Bridal_Guide.bridal_guide.service.implementation;

import Bridal_Guide.bridal_guide.model.UserModel;
import Bridal_Guide.bridal_guide.repository.UserRepository;
import Bridal_Guide.bridal_guide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.SimpleMailMessage;

import java.util.List;
import java.util.Optional;

@Service
public class UserIMplementation implements UserService {
    @Autowired
    UserRepository userRepo;
//    @Autowired
//    private JavaMailSender mailSender;

    @Override
    public UserModel createUser(UserModel user) {
//    SimpleMailMessage message = new SimpleMailMessage();
//    message.setFrom("darcyntaganira149@gmail.com");
//    message.setTo(user.getEmail());
//    message.setText("Thank you for signing up");
//    message.setSubject("confirmation mail");
//
//    mailSender.send(message);
        return userRepo.save(user) ;
    }

    @Override
    public UserModel findUserById(UserModel user) {
        return userRepo.findById(user.getId()).get();
    }

    @Override
    public UserModel getUser(UserModel user) {
        return userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword()).orElse(null);
    }


    @Override
    public List<UserModel> userList() {
        return userRepo.findAll();
    }
}
