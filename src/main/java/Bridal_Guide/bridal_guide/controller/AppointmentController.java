package Bridal_Guide.bridal_guide.controller;

import Bridal_Guide.bridal_guide.model.Appointment;
import Bridal_Guide.bridal_guide.repository.AppointmentRepository;
import Bridal_Guide.bridal_guide.service.implementation.AppointmentImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AppointmentController {

    @Autowired
    AppointmentRepository appointmentRepository;

    private final AppointmentImplementation appService;

    public AppointmentController(AppointmentImplementation appService) {
        this.appService = appService;
    }

    @GetMapping("/registerAppointment")
    public String appointmentPage(Model model){
        model.addAttribute("appointmentRequest", new Appointment());
        return "registration";
    }
    @GetMapping("/personal")
    public String Page(Model model){
        model.addAttribute("appointmentRequest", new Appointment());
        return "personal_page";
    }
    @GetMapping("/appointments")
    public String appointmentList(Model model, @Param("keyword") String keyword){
        List<Appointment> ListOfAppointment = appService.listAppoint(keyword);

//        List<Appointment> ListOfAppointment = appService.listAppoint(keyword);
        model.addAttribute("ListOfAppointment", ListOfAppointment);

        return "display";
    }

    @PostMapping("/registerAppointment")

    public String register(@ModelAttribute Appointment appointment){
        System.out.println("register request: " + appointment);
        Appointment registerAppointment = appService.saveRegistration(appointment);

        return registerAppointment == null ? "try" : "redirect:/personal";
    }

    @GetMapping("/UpdateAppointment/{id}")
    public String updateAppointment(@PathVariable("id") Integer id, Model model){
        Optional<Appointment> apps = appointmentRepository.findFirstById(id);
        Appointment userApps = apps.get();
        model.addAttribute("appointment", userApps);

        return "Edit_pag";
    }

    @GetMapping("DeleteAppointment/{id}")
    public String deleteAppointment(@PathVariable("id") Integer id){
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }
}
