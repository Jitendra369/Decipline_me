package com.decipline.self.errors;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
@Getter
@Setter
@Builder
public class ErrorResponseDto {

    private String message;
    private HttpStatus httpStatus;
}
