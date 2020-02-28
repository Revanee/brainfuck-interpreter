package com.github.revanee.brainfuck.interpreter.adapters;

import com.github.revanee.brainfuck.parser.Instruction;

import java.util.List;

public class SimpleInstructionTree implements com.github.revanee.brainfuck.interpreter.InstructionTree {

  com.github.revanee.brainfuck.parser.InstructionTree tree;

  public SimpleInstructionTree(com.github.revanee.brainfuck.parser.InstructionTree tree) {
    this.tree = tree;
  }

  @Override
  public List<Instruction> getInstructions() {
    return tree.instructions;
  }

  @Override
  public com.github.revanee.brainfuck.interpreter.InstructionTree getChild() {
    return new SimpleInstructionTree(tree.childInstructionTree);
  }

  @Override
  public com.github.revanee.brainfuck.interpreter.InstructionTree getNext() {
    return new SimpleInstructionTree(tree.nextInstructionTree);
  }

  @Override
  public Boolean hasInstructions() {
    return tree.hasInstructions();
  }

  @Override
  public Boolean hasChild() {
    return tree.hasChildInstructionTree();
  }

  @Override
  public Boolean hasNext() {
    return tree.hasNextInstructionTree();
  }
}
