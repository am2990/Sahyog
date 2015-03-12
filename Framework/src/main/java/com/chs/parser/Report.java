package com.chs.parser;

class Report{

  String concept;
  String dissagregation;
  String timestamp;
  String frequency;
  int dataValue;

 
  @Override
  public String toString() {
    return concept+" "+dissagregation+"("+timestamp+")"+frequency+":"+dataValue;
  }
}
