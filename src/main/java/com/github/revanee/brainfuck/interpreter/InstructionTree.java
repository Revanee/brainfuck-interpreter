package com.github.revanee.brainfuck.interpreter;

import com.github.revanee.brainfuck.parser.Instruction;

import java.util.List;

public interface InstructionTree {
  public List<Instruction> getInstructions();
  public InstructionTree getChild();
  public InstructionTree getNext();

  public Boolean hasInstructions();
  public Boolean hasChild();
  public Boolean hasNext();
}
