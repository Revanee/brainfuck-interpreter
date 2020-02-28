package com.github.revanee.brainfuck.interpreter;

import com.github.revanee.brainfuck.parser.Instruction;

import java.util.List;

public class Interpreter {

  private Processor processor = new Processor();

  public Boolean shouldSkipSubBlock() {
    return processor.getCurrentValue() == 0;
  }

  public Boolean shouldRepeatSubBlock() {
    return processor.getCurrentValue() != 0;
  }

  public void executeInstructionTree(InstructionTree tree) {
    if (tree.hasInstructions()) {
      List<Instruction> instructions = tree.getInstructions();
      executeInstructions(instructions);
    }
    if (tree.hasChild() && !shouldSkipSubBlock()) {
      while (shouldRepeatSubBlock()) {
        executeInstructionTree(tree.getChild());
      }
    }
    if (tree.hasNext()) {
      executeInstructionTree(tree.getNext());
    }
  }

  private void executeInstructions(List<Instruction> instructions) {
    instructions.forEach(instruction -> {
      switch (instruction) {
        case LEFT:
          processor.moveLeft();
          break;
        case RIGHT:
          processor.moveRight();
          break;
        case INCREMENT:
          processor.increment();
          break;
        case DECREMENT:
          processor.decrement();
          break;
        case OUTPUT:
          Integer currentValue = processor.getCurrentValue();
          System.out.print((char) (int) currentValue);
          break;
      }
    });
  }

}
