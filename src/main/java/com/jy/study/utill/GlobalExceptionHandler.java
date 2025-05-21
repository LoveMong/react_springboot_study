package com.jy.study.utill;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Validation 실패 처리 (예: @Valid, @Validated 사용 시)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Validation 예외에서 필드와 메시지 추출
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); // 응답: 400 Bad Request
    }

    // HTTP 메서드가 잘못된 경우
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        String message = "해당 HTTP 메서드는 지원되지 않습니다: " + ex.getMethod();
        return new ResponseEntity<>(message, HttpStatus.METHOD_NOT_ALLOWED); // 응답: 405 Method Not Allowed
    }

    // 모든 IllegalArgumentException 처리
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST); // 응답: 400 Bad Request
    }

    // 모든 기타 예외 처리 (catch-all)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        String message = "서버에서 알 수 없는 오류가 발생했습니다. 관리자에게 문의하세요.";
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR); // 응답: 500 Internal Server Error
    }
}