/**
 * This class represents a Polynomial. A Polynomial has a head term.
 */
public class PolynomialImpl implements Polynomial {

  /**
   * The head term of this Polynomial.
   */
  private ADTNode head;

  /**
   * Constructs an empty PolynomialImpl.
   */
  public PolynomialImpl() {
    head = new EmptyNode();
  }

  /**
   * Constructs an PolynomialImpl using a string input.
   *
   * @param input the string input of the Polynomial
   */
  public PolynomialImpl(String input) {
    head = new EmptyNode();
    String[] term = input.split("\\s+");
    for (String a : term) {
      String[] b = a.split("x\\^");
      if (b.length > 1) {
        addTerm(Integer.parseInt(b[0]), Integer.parseInt(b[1]));
      } else if (b.length == 1) {
        addTerm(Integer.parseInt(b[0]), 0);
      }
    }
  }

  /**
   * Adds a term to the polynomial by taking in a coefficient and power.
   *
   * @param coefficient the coefficient of this the added Polynomial term
   * @param power       the power of this the added Polynomial term
   * @throws IllegalArgumentException if power is negative
   */
  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative.");
    }
    if (coefficient != 0) {
      head = head.addTerm(coefficient, power);
    }
  }

  /**
   * Removes all terms of power from the Polynomial.
   *
   * @param power the power of the terms to be removed
   */
  @Override
  public void removeTerm(int power) {
    head = head.removeTerm(power);
  }

  /**
   * Returns the degree of this Polynomial.
   *
   * @return the degree of this Polynomial
   */
  @Override
  public int getDegree() {
    return head.getDegree();
  }

  /**
   * Returns the coefficient for the term with that power.
   *
   * @param power the power of terms to get the coefficient
   * @return the coefficient for the term with that power
   */
  @Override
  public int getCoefficient(int power) {
    return head.getCoefficient(power);
  }

  /**
   * Returns the total after plugging in a number for x in the polynomial.
   *
   * @param num the number to plug into x
   * @return the total after plugging in a number for x in the polynomial
   */
  @Override
  public double evaluate(double num) {
    return head.evaluate(num);
  }

  /**
   * Returns the sum of 2 polynomials as a new Polynomial.
   *
   * @param other the other polynomial to add
   * @return the sum of 2 polynomials as a new Polynomial
   * @throws IllegalArgumentException if other Polynomial is of type Polynomial
   */
  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof Polynomial)) {
      throw new IllegalArgumentException("Objects must be in the same class.");
    }
    Polynomial poly = new PolynomialImpl();
    head.add(poly);
    PolynomialImpl cOther = (PolynomialImpl) other;
    cOther.head.add(poly);
    return poly;
  }

  /**
   * Returns the polynomial as a string.
   *
   * @return the polynomial as a string
   */
  @Override
  public String toString() {
    return head.toString();
  }

}
