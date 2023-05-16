package Bridal_Guide.bridal_guide.service.implementation;

import Bridal_Guide.bridal_guide.model.Appointment;
import Bridal_Guide.bridal_guide.repository.AppointmentRepository;
import Bridal_Guide.bridal_guide.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentImplementation implements AppointmentService {
//    @Autowired
//    private JavaMailSender mailSender;
    @Autowired
    AppointmentRepository appointmentRepo;
    @Override
    public Appointment saveRegistration(Appointment appointment) {

        return appointmentRepo.save(appointment);
    }

    @Override
    public Appointment updateRegistration(Appointment appointment) {

        Appointment user = findAppointmentById(appointment);
        if(user !=null){
            user.setFullName(appointment.getFullName());
            user.setPhoneNumber(appointment.getPhoneNumber());
            user.setBudget(appointment.getBudget());
            user.setGuest(appointment.getGuest());

            return  appointmentRepo.save(appointment);
        }else{
            return saveRegistration(appointment);
        }
    }

    @Override
    public List<Appointment> listAppoint(String keyword) {
        if(keyword != null){
            return appointmentRepo.search(keyword);
        }

        return appointmentRepo.findAll();
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        appointmentRepo.delete(appointment);
    }

    @Override
    public Appointment findAppointmentById(Appointment appointment) {
        return appointmentRepo.findById(appointment.getId()).get();
    }
}
