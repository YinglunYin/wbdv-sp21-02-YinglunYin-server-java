package com.example.wbdvsp2102YinglunYinserverjava.services;

import com.example.wbdvsp2102YinglunYinserverjava.models.Widget;
import com.example.wbdvsp2102YinglunYinserverjava.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;

//  private List<Widget> widgets = new ArrayList<Widget>();
//
//  {
//    Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "Welcome to ABC123");
//    Widget w2 = new Widget(234l, "ABC123", "PARAGRAPH", 1, "Lorem Ipsum");
//    Widget w3 = new Widget(345l, "ABC234", "HEADING", 1, "Welcome to ABC234");
//    Widget w4 = new Widget(567l, "ABC234", "PARAGRAPH", 2, "Lorem Ipsum");
//    Widget w5 = new Widget(678l, "ABC234", "PARAGRAPH", 1, "Lorem Ipsum");
//
//    widgets.add(w1);
//    widgets.add(w2);
//    widgets.add(w3);
//    widgets.add(w4);
//    widgets.add(w5);
//  }

  public Widget createWidget(String topicId, Widget widget) {

    return repository.save(widget);

//    widget.setTopicId(topicId);
//    widget.set_id(new Date().getTime());
//    widgets.add(widget);
//    return widget;
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    return repository.findWidgetsForTopic(tid);
//    List<Widget> ws = new ArrayList<Widget>();
//    for (Widget w : widgets) {
//      if (w.getTopicId().equals(tid)) {
//        ws.add(w);
//      }
//    }
//    return ws;
  }

  public List<Widget> findAllWidgets() {
//    return widgets;
    return (List<Widget>) repository.findAll();
  }

  public int updateWidget(String wid, Widget widget) {
    Optional<Widget> r = repository.findById(Long.parseLong(wid));
    if (r.isPresent()) {
      Widget originalWidget = r.get();
      if (widget.getTopicId() != null) originalWidget.setTopicId(widget.getTopicId());
      if (widget.getType() != null) originalWidget.setType(widget.getType());
      if (widget.getSize() != null) originalWidget.setSize(widget.getSize());
      if (widget.getText() != null) originalWidget.setText(widget.getText());
      if (widget.getWidth() != null) originalWidget.setWidth(widget.getWidth());
      if (widget.getHeight() != null) originalWidget.setHeight(widget.getHeight());
      if (widget.getSrc() != null) originalWidget.setSrc(widget.getSrc());
      if (widget.getWidgetOrder() != null) originalWidget.setWidgetOrder(widget.getWidgetOrder());

      repository.save(originalWidget);
      return 1;

    } else {
      return 0;
    }


  }

  public int deleteWidget(String wid) {
    repository.deleteById(Long.parseLong(wid));
    return 1;
//    int index = -1;
//    for (int i = 0; i < widgets.size(); i++) {
//      if (widgets.get(i).get_id().equals(Long.parseLong(wid))) {
//        index = i;
//        widgets.remove(index);
//        return 1;
//      }
//    }
//    return -1;
  }

  public Widget findWidgetById(Long wid) {
    Optional<Widget> r = repository.findById(wid);
    return r.orElseGet(Widget::new);
  }


}
