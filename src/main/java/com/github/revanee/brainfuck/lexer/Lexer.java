package com.github.revanee.brainfuck.lexer;

import com.github.revanee.brainfuck.language.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    Optional<Token> token = Token.parseToken(character);
    if (token.isEmpty()) {
      System.err.println("Could not parse token: " + character);
      return null;
    }
    return token.get();
  }
}
