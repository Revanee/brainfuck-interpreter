package com.github.revanee.brainfuck.lexer;

import com.github.revanee.brainfuck.language.Token;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Lexer tests")
class LexerTest {

  @Test
  @DisplayName("Every supported character should be parsed into a corresponding Token")
  void testParseToken() {
    assertEquals(Token.LEFT, Lexer.parseToken('<'));
    assertEquals(Token.RIGHT, Lexer.parseToken('>'));
    assertEquals(Token.INCREMENT, Lexer.parseToken('+'));
    assertEquals(Token.DECREMENT, Lexer.parseToken('-'));
    assertEquals(Token.OUTPUT, Lexer.parseToken('.'));
    assertEquals(Token.INPUT, Lexer.parseToken(','));
    assertEquals(Token.OPEN, Lexer.parseToken('['));
    assertEquals(Token.CLOSE, Lexer.parseToken(']'));
  }

}