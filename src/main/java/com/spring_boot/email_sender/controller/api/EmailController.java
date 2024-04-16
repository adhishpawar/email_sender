package com.spring_boot.email_sender.controller.api;

import com.spring_boot.email_sender.Helper.CustomResponse;
import com.spring_boot.email_sender.Helper.EmailRequest;
import com.spring_boot.email_sender.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
    {
        emailService.sendEmailWithHtml(request.getTo(),request.getSubject(),request.getMessage());
        return ResponseEntity.ok(
                CustomResponse.builder().message("Email Send SuccessFully !!!").httpStatus(HttpStatus.OK).success(true).build()
        );
    }

    @PostMapping("/send-with-file")
    public ResponseEntity<CustomResponse> sendWithFile(@RequestPart EmailRequest request,@RequestPart MultipartFile file) throws IOException {
        emailService.sendEmailWithFile(request.getTo(), request.getSubject(), request.getMessage(),file.getInputStream());
        return ResponseEntity.ok(
                CustomResponse.builder().message("Email Send SuccessFully !!!").httpStatus(HttpStatus.OK).success(true).build()
        );
    }
}
