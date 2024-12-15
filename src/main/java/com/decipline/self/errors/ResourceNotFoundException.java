package com.decipline.self.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

    private String error;
    private String errorCode;
}
