package com.github.revanee.brainfuck.interpreter;

import com.github.revanee.brainfuck.parser.Instruction;
import com.github.revanee.brainfuck.parser.InstructionTree;

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
      executeInstructions(tree.instructions);
    }
    if (tree.hasChildInstructionTree() && !shouldSkipSubBlock()) {
      while (shouldRepeatSubBlock()) {
        executeInstructionTree(tree.childInstructionTree);
      }
    }
    if (tree.hasNextInstructionTree()) {
      executeInstructionTree(tree.nextInstructionTree);
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
          System.out.println(currentValue);
          break;
      }
    });
  }

}
