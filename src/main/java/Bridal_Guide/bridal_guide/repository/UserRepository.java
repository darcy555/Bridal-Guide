package Bridal_Guide.bridal_guide.repository;

import Bridal_Guide.bridal_guide.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByEmailAndPassword(String email, String password);

}
