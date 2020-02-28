package com.github.revanee.brainfuck.language;

public enum Instruction {
  LEFT(Token.LEFT),
  RIGHT(Token.RIGHT),
  INCREMENT(Token.INCREMENT),
  DECREMENT(Token.DECREMENT),
  INPUT(Token.INPUT),
  OUTPUT(Token.OUTPUT);

  private Token token;

  Instruction(Token token) {
    this.token = token;
  }
}
