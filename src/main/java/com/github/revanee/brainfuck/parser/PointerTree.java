package com.github.revanee.brainfuck.parser;

public class PointerTree {
  public Integer pointer;
  public PointerTree child;
  public PointerTree next;

  PointerTree(Integer pointer, PointerTree child, PointerTree next) {
    this.pointer = pointer;
    this.child = child;
    this.next = next;
  }

  public Boolean hasPointer() {
    return this.pointer != null;
  }
  public Boolean hasChild() {
    return this.child != null;
  }
  public Boolean hasNext() {
    return this.next != null;
  }
}
