package com.github.revanee.brainfuck.language;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TokenTest {
  @Test
  void valueIsCorrect() {
    Token expected = Token.INCREMENT;
    Optional<Token> actual = Token.parseToken('+');

    assertTrue(actual.isPresent());
    assertEquals(actual.get(), expected);
  }

  void valueIsIncorrect() {
    Token expected = Token.INCREMENT;
    Optional<Token> actual = Token.parseToken('~');

    assertFalse(actual.isPresent());
  }
}
