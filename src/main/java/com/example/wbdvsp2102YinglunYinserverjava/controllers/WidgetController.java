package com.example.wbdvsp2102YinglunYinserverjava.controllers;

import com.example.wbdvsp2102YinglunYinserverjava.models.Widget;
import com.example.wbdvsp2102YinglunYinserverjava.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Fix CORS Error
public class WidgetController {

  @Autowired
  WidgetService service;

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

//  @GetMapping("/api/widgets/{wid} ")
//  public Widget findWidgetById(
//          @PathVariable("wid") String widgetId
//  ){
//    service.findWidgetById(id);
//  }

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(
          @PathVariable("tid") String tid
  ) {
    return service.findWidgetsForTopic(tid);
  }

  @PostMapping("api/topics/{tid}/widgets")
  public Widget createWidget(
          @PathVariable("tid") String topicId,
          @RequestBody Widget widget
  ){
      return service.createWdiget(topicId, widget);
  }

  @PutMapping("/api/widgets/{wid}")
  public int updateWidget(
          @PathVariable("wid") String wid,
          @RequestBody Widget widget
  ){
    return service.updateWidget(wid, widget);
  }

  @DeleteMapping("/api/widgets/{wid}")
  public int deleteWidget(
          @PathVariable String wid
  ){
    return service.deleteWidget(wid);
  }

}
