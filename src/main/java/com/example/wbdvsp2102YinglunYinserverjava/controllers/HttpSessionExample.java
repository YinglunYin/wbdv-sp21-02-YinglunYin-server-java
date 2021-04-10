package com.example.wbdvsp2102YinglunYinserverjava.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HttpSessionExample {

  @GetMapping("/SessionExample")
  public String SessionExample(){
    return("<h1>Session Example<h1>");
  }

  @GetMapping("/api/session/set/{attr}/{value}")
  public String setSessionAttribute(
          @PathVariable("attr") String attr,
          @PathVariable("value") String value,
          HttpSession session) {
    session.setAttribute(attr, value);
    return attr + " = " + value;
  }

  @GetMapping("/api/session/get/{attr}")
  public String getSessionAttribute(
          @PathVariable ("attr") String attr,
          HttpSession session) {
    return (String)session.getAttribute(attr);
  }

  @GetMapping("/api/session/invalidate")
  public String invalidateSession(
          HttpSession session) {
    session.invalidate();
    return "session invalidated";
  }



}
