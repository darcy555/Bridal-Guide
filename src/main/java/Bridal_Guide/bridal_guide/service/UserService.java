package Bridal_Guide.bridal_guide.service;

import Bridal_Guide.bridal_guide.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserModel createUser(UserModel user);
    UserModel findUserById(UserModel user);
    UserModel getUser(UserModel user);
    List<UserModel> userList();
}
