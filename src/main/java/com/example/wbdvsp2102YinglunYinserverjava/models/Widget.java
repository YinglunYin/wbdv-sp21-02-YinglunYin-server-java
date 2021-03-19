package com.example.wbdvsp2102YinglunYinserverjava.models;

public class Widget {
  private String name;
  private Long id;
  private String type;
  private String topicId;
  private int widgetOrder;
  private Integer size;
  private String text;
  private Integer width;
  private Integer height;
  private String cssClass;
  private String style;
  private String value;
  private String src;
  private String url;
  private String href;

  public Widget(String name, Long id, String type, String topicId, int widgetOrder, Integer size, String text, Integer width, Integer height, String cssClass, String style, String value, String src, String url, String href) {
    this.name = name;
    this.id = id;
    this.type = type;
    this.topicId = topicId;
    this.widgetOrder = widgetOrder;
    this.size = size;
    this.text = text;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.style = style;
    this.value = value;
    this.src = src;
    this.url = url;
    this.href = href;
  }

  public Widget(Long id, String topicId, String type,  Integer size, String text) {
    this.id = id;
    this.type = type;
    this.topicId = topicId;
    this.size = size;
    this.text = text;
  }

  public Widget() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public int getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(int widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }
}
