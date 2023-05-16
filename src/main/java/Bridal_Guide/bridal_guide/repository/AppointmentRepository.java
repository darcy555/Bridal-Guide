package Bridal_Guide.bridal_guide.repository;

import Bridal_Guide.bridal_guide.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Optional<Appointment> findById(Integer id);

    Optional<Appointment> findFirstById(Integer id);

    @Query("SELECT p FROM Appointment p WHERE CONCAT(p.fullName, ' ',p.email, ' ',p.phoneNumber, ' ', p.budget, ' ', p.guest) like %?1%")
    public List<Appointment> search (String keyword);
}
