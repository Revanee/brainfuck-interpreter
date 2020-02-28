package com.github.revanee.brainfuck.parser;

import com.github.revanee.brainfuck.language.Token;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class Parser {
  public static InstructionTree parseInstructionTree(List<Token> tokens) {
    Pair<List<Instruction>, List<Token>> splitInstructions = splitInstructionSequence(tokens);

    if (splitInstructions.getSize() == 1)
      return new InstructionTree(splitInstructions.getValue0(), null, null);
    List<Instruction> instructions = splitInstructions.getValue0();
    List<Token> childAndNext = splitInstructions.getValue1();

    Pair<List<Token>, List<Token>> splitChildAndNext = splitFirstBlock(childAndNext);
    InstructionTree childInstructionTree = null;
    try {
      childInstructionTree = parseInstructionTree(splitChildAndNext.getValue0());
    } catch (Exception e) { }
    InstructionTree nextInstructionTree = null;
    try {
      nextInstructionTree = parseInstructionTree(splitChildAndNext.getValue1());
    } catch (Exception e) { }

    return new InstructionTree(instructions, childInstructionTree, nextInstructionTree);
  }

  public static Pair<List<Token>, List<Token>> splitFirstBlock(List<Token> code) {
    if (code.size() < 2) {
      return new Pair(null, null);
    }

    Integer index = 1;
    Integer openedBlocks = 1;

    while (index < code.size() && openedBlocks > 0) {
      if (code.get(index) == Token.OPEN) openedBlocks++;
      if (code.get(index) == Token.CLOSE) openedBlocks--;
      index++;
    }

    List<Token> firstBlock = code.subList(1, index - 1);
    List<Token> remainder = code.subList(index, code.size());
    return new Pair(firstBlock, remainder);
  }

  public static Pair<List<Instruction>, List<Token>> splitInstructionSequence(List<Token> code) {
    Integer index = 0;
    while (index < code.size() && isInstruction(code.get(index))) {
      index++;
    }
    List<Instruction> instructions = new ArrayList<>();
    code.subList(0, index).forEach(token -> instructions.add(parseInstruction(token)));

    List<Token> remainingTokens = code.subList(index, code.size());

    return new Pair<>(instructions, remainingTokens);
  }

  static Boolean isInstruction(Token token) {
    return parseInstruction(token) != null;
  }

  static Instruction parseInstruction(Token token) {
    switch (token) {
      case INCREMENT:
        return Instruction.INCREMENT;
      case DECREMENT:
        return Instruction.DECREMENT;
      case LEFT:
        return Instruction.LEFT;
      case RIGHT:
        return Instruction.RIGHT;
      case INPUT:
        return Instruction.INPUT;
      case OUTPUT:
        return Instruction.OUTPUT;
      default:
        return null;
    }
  }
}
