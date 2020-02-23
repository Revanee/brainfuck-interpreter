package com.github.revanee.brainfuck.lexer;

import java.util.AbstractList;
import java.util.List;

public class Utils {
  public static List<Character> asList(final String string) {
    return new AbstractList<Character>() {
      public int size() { return string.length(); }
      public Character get(int index) { return string.charAt(index); }
    };
  }
}
