package com.github.revanee.brainfuck.lexer;

import com.github.revanee.brainfuck.language.Token;

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
    return Token.parseToken(character).get();
  }
}
