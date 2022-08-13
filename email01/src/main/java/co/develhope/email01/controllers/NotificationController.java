package co.develhope.email01.controllers;

import co.develhope.email01.entities.NotificationDto;
import co.develhope.email01.entities.Student;
import co.develhope.email01.services.EmailService;
import co.develhope.email01.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private StudentServices studentServices;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity sendNotification(@RequestBody NotificationDto message) {
        try {
            Student studentToSendNotification = studentServices.getStudentById(message.getContactId());
            if (studentToSendNotification == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Did not find the student");
            }
            emailService.sendTo(studentToSendNotification.getEmail(), message.getTitle(), message.getText());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        catch (Exception e) {
            System.err.println("Error in notification controller: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
