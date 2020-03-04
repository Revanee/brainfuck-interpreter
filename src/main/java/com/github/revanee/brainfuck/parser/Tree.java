package com.github.revanee.brainfuck.parser;

public class Tree {
  private Tree child;
  private Tree next;
  private Class<?> data;

  public Boolean hasChild() {
    return this.child != null;
  }
  public Boolean hasNext() {
    return this.next != null;
  }
  public Boolean hasData() {
    return this.data != null;
  }

  public Class<?> getData() {
    return data;
  }

}
