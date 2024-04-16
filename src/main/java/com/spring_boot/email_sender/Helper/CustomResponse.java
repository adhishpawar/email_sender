package com.spring_boot.email_sender.Helper;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CustomResponse {

    private String message;

    private HttpStatus httpStatus;

    private boolean success = false;
}
