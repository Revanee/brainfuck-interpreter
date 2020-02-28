package com.github.revanee.brainfuck.lexer;

import com.github.revanee.brainfuck.language.Token;
import com.github.revanee.brainfuck.parser.Instruction;
import com.github.revanee.brainfuck.parser.InstructionTree;
import com.github.revanee.brainfuck.parser.Parser;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
  @Test
  void testSplitFirstBlock() {
    List<Token> inputTokens = List.of(
        Token.OPEN,
        Token.INCREMENT,
        Token.CLOSE,
        Token.DECREMENT
    );

    List<Token> expectedBlock = List.of(
        Token.INCREMENT
    );

    List<Token> expectedRemainder = List.of(
        Token.DECREMENT
    );

    Pair<List<Token>, List<Token>> result = Parser.splitFirstBlock(inputTokens);

    assertEquals(expectedBlock, result.getValue0());
    assertEquals(expectedRemainder, result.getValue1());
  }

  @Test
  void testSplitInstructionSequence() {
    List<Token> inputTokens = List.of(
        Token.INCREMENT,
        Token.OPEN,
        Token.INCREMENT,
        Token.CLOSE,
        Token.DECREMENT
    );

    List<Instruction> expectedInstructions = List.of(
        Instruction.INCREMENT
    );

    List<Token> expectedRemainder = List.of(
        Token.OPEN,
        Token.INCREMENT,
        Token.CLOSE,
        Token.DECREMENT
    );

    Pair<List<Instruction>, List<Token>> result = Parser.splitInstructionSequence(inputTokens);

    assertEquals(expectedInstructions, result.getValue0());
    assertEquals(expectedRemainder, result.getValue1());
  }

  @Test
  void testParseInstructionTree() {
    List<Token> input = List.of(
        Token.INCREMENT,
        Token.OPEN,
        Token.RIGHT,
        Token.CLOSE,
        Token.DECREMENT
    );
    InstructionTree result = Parser.parseInstructionTree(input);
    InstructionTree child = new InstructionTree(List.of(Instruction.RIGHT), null, null);
    InstructionTree next = new InstructionTree(List.of(Instruction.DECREMENT), null, null);

    InstructionTree expected = new InstructionTree(List.of(Instruction.INCREMENT), child, next);

    assertThat(result).isEqualToComparingFieldByFieldRecursively(expected);
  }

  void testIsInstruction() {
  }

  void testParseInstruction() {
  }
}
