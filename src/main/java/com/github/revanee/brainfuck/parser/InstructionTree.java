package com.github.revanee.brainfuck.parser;

import java.util.List;

public class InstructionTree {
  public List<Instruction> instructions;
  public InstructionTree nextInstructionTree;
  public InstructionTree childInstructionTree;

  public InstructionTree(
      List<Instruction> instructions,
      InstructionTree childInstructionTree,
      InstructionTree nextInstructionTree) {
    this.instructions = instructions;
    this.childInstructionTree = childInstructionTree;
    this.nextInstructionTree = nextInstructionTree;
  }

  public Boolean hasInstructions() {
    return instructions != null && instructions.size() > 0;
  }

  public Boolean hasNextInstructionTree() {
    return nextInstructionTree != null;
  }

  public Boolean hasChildInstructionTree() {
    return childInstructionTree != null;
  }

  @Override
  public String toString() {
    return "InstructionTree{" +
        "instructions=" + instructions +
        ", nextInstructionTree=" + nextInstructionTree +
        ", childInstructionTree=" + childInstructionTree +
        '}';
  }
}
