package code401Challenges.utilities;

import code401Challenges.stacksandqueues.Stack;

public class MultiBracketValidation {
  public static boolean multiBracketValidation(String code) {
    Stack<Character> braceStack = new Stack<>();
    char[] charCode = code.toCharArray();
    for (Character c : charCode) {
      if (c.equals('(') || c.equals('[') || c.equals('{')) {
        braceStack.push(c);
      }
      else if (c.equals(')') || c.equals(']') || c.equals('}')) {
        char openingBrace = braceStack.pop();
        if (c.equals(')') && openingBrace != '(') {
          return false;
        }
        else if (c.equals(']') && openingBrace != '[') {
          return false;
        }
        else if (c.equals('}') && openingBrace != '{') {
          return false;
        }
      }
    }
    if (!braceStack.isEmpty()) {
      return false;
    }
    return true;
  }
}
