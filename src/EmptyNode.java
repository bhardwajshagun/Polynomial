/**
 * This class represents an Empty Node. It represents the end of the Polynomial.
 */
public class EmptyNode implements ADTNode {

  /**
   * Adds a term to the polynomial by taking in a coefficient and power and inserting the node.
   *
   * @param c the coefficient of this the added Polynomial term
   * @param p the power of this the added Polynomial term
   * @return the first node of the polynomial
   */
  @Override
  public ADTNode addTerm(int c, int p) throws IllegalArgumentException {
    if (p < 0) {
      throw new IllegalArgumentException("Power cannot be negative.");
    }
    return new ElementNode(c, p, this);
  }

  /**
   * Removes all nodes of power from the polynomial.
   *
   * @param p the power of the terms to be removed
   * @return this
   */
  @Override
  public ADTNode removeTerm(int p) {
    return this;
  }

  /**
   * Returns 0.
   *
   * @return 0
   */
  @Override
  public int getDegree() {
    return 0;
  }

  /**
   * Returns 0.
   *
   * @param p the power of terms to get the coefficient
   * @return 0
   */
  @Override
  public int getCoefficient(int p) {
    return 0;
  }

  /**
   * Returns 0.
   *
   * @param num the number to plug into x
   * @return 0
   */
  @Override
  public double evaluate(double num) {
    return 0;
  }

  /**
   * Returns the other polynomial.
   *
   * @param other the other polynomial to add
   * @return the other polynomial
   */
  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof Polynomial)) {
      throw new IllegalArgumentException("Objects must be in the same class.");
    }
    return other;
  }

  /**
   * Returns empty string.
   *
   * @return empty string
   */
  @Override
  public String toString() {
    return "0";
  }

  /**
   * Returns 0.
   *
   * @return 0
   */
  @Override
  public int setCounter(int c) {
    return 0;
  }

  /**
   * Returns the accumulator for toString help.
   *
   * @return the accumulator for toString help
   */
  @Override
  public int emptyStringHelp(int acc) {
    return acc;
  }

}
