package com.github.revanee.brainfuck.lexer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Lexer tests")
class LexerTest {

  @Test
  @DisplayName("Every supported character should be parsed into a corresponding Token")
  void testParseToken() {
    assertEquals(Lexer.parseToken('<'), Token.LEFT);
    assertEquals(Lexer.parseToken('>'), Token.RIGHT);
    assertEquals(Lexer.parseToken('+'), Token.INCREMENT);
    assertEquals(Lexer.parseToken('-'), Token.DECREMENT);
    assertEquals(Lexer.parseToken('.'), Token.OUT);
    assertEquals(Lexer.parseToken(','), Token.IN);
    assertEquals(Lexer.parseToken('['), Token.OPEN);
    assertEquals(Lexer.parseToken(']'), Token.CLOSE);
  }

}