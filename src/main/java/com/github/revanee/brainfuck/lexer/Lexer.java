package com.github.revanee.brainfuck.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

  public static List<Token> parse(String code) {
    return parse(Utils.asList(code));
  }

  public static List<Token> parse(List<Character> code) {
    List<Token> tokens = new ArrayList<>();
    code.forEach(character -> {
      Token token = parseToken(character);
      if (token != null) tokens.add(token);
    });
    return tokens;
  }

  public static Token parseToken(Character character) {
    switch (character) {
      case '>':
        return Token.RIGHT;
      case '<':
        return Token.LEFT;
      case '+':
        return Token.INCREMENT;
      case '-':
        return Token.DECREMENT;
      case ',':
        return Token.IN;
      case '.':
        return Token.OUT;
      case '[':
        return Token.OPEN;
      case ']':
        return Token.CLOSE;
      default:
        return null;
    }
  }
}
