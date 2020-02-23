package com.github.revanee;

import com.github.revanee.brainfuck.interpreter.Interpreter;
import com.github.revanee.brainfuck.lexer.Lexer;
import com.github.revanee.brainfuck.lexer.Token;
import com.github.revanee.brainfuck.lexer.Utils;
import com.github.revanee.brainfuck.parser.InstructionTree;
import com.github.revanee.brainfuck.parser.Parser;

import java.util.List;

public class Main {

  private static String usage = "Arguments: [BrainFuck string]";

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Unsupported number of arguments. Usage:");
      System.out.println(usage);
      System.exit(1);
    }

    String codeArgument = args[0];
    List<Character> code = Utils.asList(codeArgument);

    List<Token> tokens = Lexer.parse(code);
    System.out.println(tokens.toString());
    InstructionTree instructions = Parser.parseInstructionTree(tokens);
    System.out.println(instructions.toString());

    Interpreter interpreter = new Interpreter();
    interpreter.executeInstructionTree(instructions);
  }
}
