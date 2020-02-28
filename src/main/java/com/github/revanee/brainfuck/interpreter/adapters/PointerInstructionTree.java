package com.github.revanee.brainfuck.interpreter.adapters;

import com.github.revanee.brainfuck.interpreter.InstructionTree;
import com.github.revanee.brainfuck.parser.Instruction;
import com.github.revanee.brainfuck.parser.PointerTree;

import java.util.HashMap;
import java.util.List;

public class PointerInstructionTree implements InstructionTree {

  PointerTree tree;
  HashMap<Integer, List<Instruction>> instructionsMap;

  public PointerInstructionTree(PointerTree tree, HashMap<Integer, List<Instruction>> map) {
    this.tree = tree;
    this.instructionsMap = map;
  }

  @Override
  public List<Instruction> getInstructions() {
    return this.instructionsMap.get(tree.pointer);
  }

  @Override
  public InstructionTree getChild() {
    return new PointerInstructionTree(tree.child, instructionsMap);
  }

  @Override
  public InstructionTree getNext() {
    return new PointerInstructionTree(tree.next, instructionsMap);
  }

  @Override
  public Boolean hasInstructions() {
    return tree.hasPointer();
  }

  @Override
  public Boolean hasChild() {
    return tree.hasChild();
  }

  @Override
  public Boolean hasNext() {
    return tree.hasNext();
  }
}
