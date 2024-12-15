package com.decipline.self.errors;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(ResourceNotFoundException exception) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .message("Resource not Found " + exception.getError())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return ResponseEntity.ok(errorResponseDto);
    }
}
