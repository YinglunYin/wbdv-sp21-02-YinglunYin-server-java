package com.example.wbdvsp2102YinglunYinserverjava.services;

import com.example.wbdvsp2102YinglunYinserverjava.models.Widget;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
  private List<Widget> widgets = new ArrayList<Widget>();

  {
    Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "Welcome to ABC123");
    Widget w2 = new Widget(234l, "ABC123", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w3 = new Widget(345l, "ABC234", "HEADING", 1, "Welcome to ABC234");
    Widget w4 = new Widget(567l, "ABC234", "PARAGRAPH", 2, "Lorem Ipsum");
    Widget w5 = new Widget(678l, "ABC234", "PARAGRAPH", 1, "Lorem Ipsum");

    widgets.add(w1);
    widgets.add(w2);
    widgets.add(w3);
    widgets.add(w4);
    widgets.add(w5);
  }

  public Widget createWdiget(String topicId, Widget widget) {
    widget.setTopicId(topicId);
    widget.set_id(new Date().getTime());
    widgets.add(widget);
    return widget;
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    List<Widget> ws = new ArrayList<Widget>();
    for (Widget w : widgets) {
      if (w.getTopicId().equals(tid)) {
        ws.add(w);
      }
    }
    return ws;
  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public int updateWidget(String wid, Widget widget) {
    for (int i = 0; i < widgets.size(); i++) {
      if (widgets.get(i).get_id().equals(Long.parseLong(wid))) {
        widgets.set(i, widget);
        return i;
      }
    }
    return -1;
  }

  public int deleteWidget(String wid) {
    int index = -1;
    for (int i = 0; i < widgets.size(); i++) {
      if (widgets.get(i).get_id().equals(Long.parseLong(wid))) {
        index = i;
        widgets.remove(index);
        return 1;
      }
    }
    return -1;
  }


}
