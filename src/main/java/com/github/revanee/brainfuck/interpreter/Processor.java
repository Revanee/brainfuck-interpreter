package com.github.revanee.brainfuck.interpreter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Processor {
  private List<Integer> memory = new ArrayList<>(Collections.nCopies(10, 0));
  private Integer pointer = 0;

  public void moveRight() {
    this.pointer += 1;
  }

  public void moveLeft() {
    this.pointer -= 1;
  }

  public void increment() {
    memory.set(pointer, getCurrentValue() + 1);
  }

  public void decrement() {
    memory.set(pointer, getCurrentValue() - 1);
  }

  public void setValue(Integer newValue) {
    memory.set(pointer, newValue);
  }

  public Integer getCurrentValue() {
    return memory.get(pointer);
  }

}
