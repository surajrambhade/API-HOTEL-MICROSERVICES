package com.lcdw.user.service.payload;

import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponce {


    private  String message;
    private  boolean success;
    private HttpStatus status;



}
