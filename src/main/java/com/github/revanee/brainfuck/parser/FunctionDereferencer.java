package com.github.revanee.brainfuck.parser;

import org.javatuples.Pair;

import java.util.HashMap;
import java.util.List;

public class FunctionDereferencer {

  HashMap<Integer, List<Instruction>> functions = new HashMap<>();

  public Pair<PointerTree, HashMap<Integer, List<Instruction>>>
  parseInstructionTree(InstructionTree tree) {

    Integer instructionsPointer = null;
    PointerTree child = null;
    PointerTree next = null;

    if (tree.hasInstructions()) {
      instructionsPointer = tree.instructions.toString().hashCode();
      functions.put(instructionsPointer, tree.instructions);
    }
    if (tree.hasChildInstructionTree()) {
      child = parseInstructionTreePartial(tree.childInstructionTree);
    }
    if (tree.hasNextInstructionTree()) {
      next = parseInstructionTreePartial(tree.nextInstructionTree);
    }

    PointerTree pointerTree = new PointerTree(instructionsPointer, child, next);
    return new Pair(pointerTree, functions);
  }

  public PointerTree parseInstructionTreePartial(InstructionTree tree) {
    Pair<PointerTree, HashMap<Integer, List<Instruction>>> result = parseInstructionTree(tree);
    return result.getValue0();
  }

}
