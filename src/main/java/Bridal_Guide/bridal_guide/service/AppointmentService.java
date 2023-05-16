package Bridal_Guide.bridal_guide.service;

import Bridal_Guide.bridal_guide.model.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment saveRegistration(Appointment appointment);
    Appointment updateRegistration(Appointment appointment);

    List<Appointment> listAppoint(String keyword);

    void deleteAppointment(Appointment appointment);

    Appointment findAppointmentById(Appointment appointment);
}
