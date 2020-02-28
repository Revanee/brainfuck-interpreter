package com.github.revanee.brainfuck.language;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public enum Token {
  LEFT('<'),
  RIGHT('>'),
  INCREMENT('+'),
  DECREMENT('-'),
  INPUT(','),
  OUTPUT('.'),
  OPEN('['),
  CLOSE(']');

  private char character;

  Token(char c) {
    this.character = c;
  }

  Character getSymbol() {
    return this.character;
  }

  public static Optional<Token> parseToken(Character c) {
    List<Token> tokens = Arrays.asList(Token.values());
    AtomicReference<Token> matched = new AtomicReference<>();
    tokens.forEach(t -> {
      if (t.getSymbol() == c) {
        matched.set(t);
      }
    });
    return Optional.ofNullable(matched.get());
  }
}
