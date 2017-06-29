package com.abbot.study.eventbus;

/**
 * Created by fangzheng on 2017/6/23.
 */

public class MessageEvent {
  String content;

  public MessageEvent(String content){
    this.content = content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }
}
