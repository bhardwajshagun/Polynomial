import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Polynomial class.
 */
public class PolynomialTest {

  @Test
  public void testConstructor() {
    Polynomial test1 = new PolynomialImpl("4x^3 +3x^1 -5");
    assertEquals("4x^3 +3x^1 -5", test1.toString());
    Polynomial test2 = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    assertEquals("-2x^5 -3x^4 +11x^1 -5", test2.toString());
    Polynomial test3 = new PolynomialImpl("5x^7 +0x^2 -4");
    assertEquals("5x^7 -4", test3.toString());
    Polynomial test4 = new PolynomialImpl("4 +0x^7 -0x^3");
    assertEquals("4", test4.toString());
  }

  @Test
  public void testEmptyPolynomial() {
    Polynomial test1 = new PolynomialImpl();
    assertEquals("0", test1.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddTermIllegal1() {
    Polynomial test1 = new PolynomialImpl();
    test1.addTerm(4, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddTermIllegal2() {
    Polynomial test1 = new PolynomialImpl();
    test1.addTerm(0, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddTermIllegal3() {
    Polynomial test1 = new PolynomialImpl();
    test1.addTerm(-7, -2);
  }


  @Test
  public void testAddTerm1() {
    Polynomial test1 = new PolynomialImpl();
    test1.addTerm(5, 2);
    assertEquals("5x^2", test1.toString());
    Polynomial test2 = new PolynomialImpl();
    test2.addTerm(-7, 4);
    assertEquals("-7x^4", test2.toString());
    Polynomial test3 = new PolynomialImpl();
    test3.addTerm(6, 0);
    assertEquals("6", test3.toString());
    Polynomial test4 = new PolynomialImpl();
    test4.addTerm(-11, 0);
    assertEquals("-11", test4.toString());
  }

  @Test
  public void testAddTerm2() {
    Polynomial test1 = new PolynomialImpl();
    test1.addTerm(4, 7);
    test1.addTerm(-2, 8);
    assertEquals("-2x^8 +4x^7", test1.toString());
    Polynomial test2 = new PolynomialImpl();
    test2.addTerm(9, 2);
    test2.addTerm(-7, 0);
    assertEquals("9x^2 -7", test2.toString());
    test2.addTerm(0, 6);
    assertEquals("9x^2 -7", test2.toString());
  }

  @Test
  public void testAddTerm3() {
    Polynomial test1 = new PolynomialImpl();
    test1.addTerm(4, 0);
    assertEquals("4", test1.toString());
    test1.addTerm(-7, 0);
    assertEquals("-3", test1.toString());
    test1.addTerm(0, 5);
    assertEquals("-3", test1.toString());
    test1.addTerm(2, 5);
    assertEquals("2x^5 -3", test1.toString());
    test1.addTerm(4, 5);
    assertEquals("6x^5 -3", test1.toString());
  }

  @Test
  public void testRemoveTerm() {
    Polynomial test1 = new PolynomialImpl("3x^4 -6x^8 +1");
    assertEquals("-6x^8 +3x^4 +1", test1.toString());
    test1.removeTerm(4);
    assertEquals("-6x^8 +1", test1.toString());
    test1.removeTerm(5);
    assertEquals("-6x^8 +1", test1.toString());
    test1.removeTerm(8);
    assertEquals("1", test1.toString());
    test1.removeTerm(0);
    assertEquals("0", test1.toString());
    Polynomial test2 = new PolynomialImpl("-3x^2 +2x^3 +8x^1 -6x^7");
    assertEquals("-6x^7 +2x^3 -3x^2 +8x^1", test2.toString());
    test2.removeTerm(7);
    assertEquals("2x^3 -3x^2 +8x^1", test2.toString());
    test2.removeTerm(2);
    assertEquals("2x^3 +8x^1", test2.toString());
    test2.removeTerm(3);
    assertEquals("8x^1", test2.toString());
    test2.removeTerm(1);
    assertEquals("0", test2.toString());
  }

  @Test
  public void testGetDegree() {
    Polynomial test1 = new PolynomialImpl("3x^4 -6x^8 +1");
    assertEquals("-6x^8 +3x^4 +1", test1.toString());
    assertEquals(8, test1.getDegree());
    Polynomial test2 = new PolynomialImpl("-6");
    assertEquals("-6", test2.toString());
    assertEquals(0, test2.getDegree());
    Polynomial test3 = new PolynomialImpl("-7x^2 +12x^11 +6x^1");
    assertEquals("12x^11 -7x^2 +6x^1", test3.toString());
    assertEquals(11, test3.getDegree());
  }

  @Test
  public void testGetCoefficient() {
    Polynomial test1 = new PolynomialImpl("5x^2 -2x^4 +7x^5");
    assertEquals("7x^5 -2x^4 +5x^2", test1.toString());
    assertEquals(5, test1.getCoefficient(2));
    assertEquals(-2, test1.getCoefficient(4));
    assertEquals(7, test1.getCoefficient(5));
    Polynomial test2 = new PolynomialImpl("-7x^3 -11x^2 +3x^3 +7");
    assertEquals("-4x^3 -11x^2 +7", test2.toString());
    assertEquals(-4, test2.getCoefficient(3));
    assertEquals(-11, test2.getCoefficient(2));
    assertEquals(0, test2.getCoefficient(7));
  }

  @Test
  public void testEvaluate() {
    Polynomial test1 = new PolynomialImpl();
    test1.addTerm(2, 4);
    assertEquals("2x^4", test1.toString());
    assertEquals(32, test1.evaluate(2), 0.01);
    assertEquals(237.18, test1.evaluate(3.3), 0.01);
    test1.addTerm(3, 2);
    assertEquals("2x^4 +3x^2", test1.toString());
    assertEquals(44, test1.evaluate(2), 0.01);
    assertEquals(269.85, test1.evaluate(3.3), 0.01);
    assertEquals(0, test1.evaluate(0), 0.01);
    test1.addTerm(-6, 7);
    assertEquals("-6x^7 +2x^4 +3x^2", test1.toString());
    assertEquals(470075, test1.evaluate(-5), 0.01);
    assertEquals(-8002536.33, test1.evaluate(7.5), 0.01);
    Polynomial test2 = new PolynomialImpl("-5");
    assertEquals("-5", test2.toString());
    assertEquals(-5, test2.evaluate(12), 0.01);
  }

  @Test
  public void testAdd() {
    Polynomial test1 = new PolynomialImpl("19x^7 +4x^3 +6x^2 +9x^1");
    assertEquals("19x^7 +4x^3 +6x^2 +9x^1", test1.toString());
    Polynomial test2 = new PolynomialImpl("-5x^7 +3x^10 -4x^2 -12");
    assertEquals("3x^10 -5x^7 -4x^2 -12", test2.toString());
    Polynomial testadd1_2 = test1.add(test2);
    Polynomial testadd2_1 = test2.add(test1);
    assertEquals("3x^10 +14x^7 +4x^3 +2x^2 +9x^1 -12", testadd1_2.toString());
    assertEquals("3x^10 +14x^7 +4x^3 +2x^2 +9x^1 -12", testadd2_1.toString());
    assertEquals("19x^7 +4x^3 +6x^2 +9x^1", test1.toString());
    assertEquals("3x^10 -5x^7 -4x^2 -12", test2.toString());
    Polynomial test3 = new PolynomialImpl("3x^6 -2x^1 +2x^6 -4");
    assertEquals("5x^6 -2x^1 -4", test3.toString());
    Polynomial test4 = new PolynomialImpl("-5x^6 +4 +2x^1");
    assertEquals("-5x^6 +2x^1 +4", test4.toString());
    Polynomial testadd3_4 = test3.add(test4);
    Polynomial testadd4_3 = test4.add(test3);
    assertEquals("0", testadd3_4.toString());
    assertEquals("0", testadd4_3.toString());
    assertEquals("5x^6 -2x^1 -4", test3.toString());
    assertEquals("-5x^6 +2x^1 +4", test4.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddIllegal() {
    Polynomial test4 = new PolynomialImpl("-5x^6 +4 +2x^1");
    assertEquals("-5x^6 +2x^1 +4", test4.toString());
    Polynomial addtest4 = test4.add(null);
  }

  @Test
  public void testToString() {
    Polynomial test1 = new PolynomialImpl("5x^2 +4x^1 -2");
    assertEquals("5x^2 +4x^1 -2", test1.toString());
    Polynomial test2 = new PolynomialImpl("-50x^3 +1x^2 +3");
    assertEquals("-50x^3 +1x^2 +3", test2.toString());
    Polynomial test3 = new PolynomialImpl("4x^1 +2x^5 -3x^2 -10");
    assertEquals("2x^5 -3x^2 +4x^1 -10", test3.toString());
  }

  @Test
  public void testEqual() {
    Polynomial test1 = new PolynomialImpl("5x^2 +4x^1 -2x^0");
    Polynomial test2 = new PolynomialImpl("4x^1 +5x^2 -2");
    assertEquals(test1.toString(), test2.toString());
  }

}
