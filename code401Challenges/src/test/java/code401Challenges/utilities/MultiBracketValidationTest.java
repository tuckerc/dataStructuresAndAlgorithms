package code401Challenges.utilities;

import org.junit.Before;
import org.junit.Test;

import static code401Challenges.utilities.MultiBracketValidation.multiBracketValidation;
import static org.junit.Assert.*;

public class MultiBracketValidationTest {

  String emptyCode = "";
  String noBracesCode;
  String trueCode;
  String falseCode;

  @Before
  public void setUp() throws Exception {
    noBracesCode = "this is a string without braces";
    trueCode = "{ asdlkj ( lkjlkj [lkj] lkjlk ) lkj { lk ( lkj ) lkj } lkj}";
    falseCode = "{ asdlkj ( lkjlkj [lkj lkjlk ) lkj { lk ( lkj ) lkj } lkj}";
  }

  @Test
  public void testEmptyCode() {
    assertTrue(multiBracketValidation(emptyCode));
  }

  @Test
  public void testNoBracesCode() {
    assertTrue(multiBracketValidation(noBracesCode));
  }

  @Test
  public void testTrueCode() {
    assertTrue(multiBracketValidation(trueCode));
  }

  @Test
  public void testFalseCode() {
    assertFalse(multiBracketValidation(falseCode));
  }
}