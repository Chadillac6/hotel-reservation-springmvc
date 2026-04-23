package com.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class RequestExposingAdvice {

    @ModelAttribute("request")
    public HttpServletRequest exposeRequest(HttpServletRequest request) {
        return request;
    }
}
