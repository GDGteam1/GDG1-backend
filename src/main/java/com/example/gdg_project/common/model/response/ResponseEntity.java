package com.example.gdg_project.common.model.response;

import com.example.gdg_project.common.message.ResponseMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Getter
public class ResponseEntity<T> {
    private final int status;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final T data;

    public ResponseEntity(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseEntity<T> of(HttpStatus httpStatus, ResponseMessage message){
        int status = Optional.ofNullable(httpStatus)
                .orElse(HttpStatus.OK)
                .value();
        return new ResponseEntity<>(status, message.toString(), null);
    }

    public static <T> ResponseEntity<T> of(HttpStatus httpStatus, ResponseMessage message, T data) {
        int status = Optional.ofNullable(httpStatus)
                .orElse(HttpStatus.OK)
                .value();
        return new ResponseEntity<>(status, message.toString(), data);
    }
}