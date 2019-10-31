/**
 * This interface contains all operations that all all Polynomial nodes should support.
 */
public interface ADTNode {

  /**
   * Adds a term to the polynomial by taking in a coefficient and power and inserting the node.
   *
   * @param coefficient the coefficient of this the added Polynomial term
   * @param power       the power of this the added Polynomial term
   * @return the first node of the polynomial
   */
  ADTNode addTerm(int coefficient, int power) throws IllegalArgumentException;

  /**
   * Removes all nodes of power from the polynomial.
   *
   * @param power the power of the terms to be removed
   * @return the first node of the polynomial
   */
  ADTNode removeTerm(int power);

  /**
   * Returns the degree of this polynomial.
   *
   * @return the degree of this polynomial
   */
  int getDegree();

  /**
   * Returns the coefficient for the term with that power.
   *
   * @param power the power of terms to get the coefficient
   * @return the coefficient for the term with that power
   */
  int getCoefficient(int power);

  /**
   * Returns the total after plugging in a number for x in the polynomial.
   *
   * @param num the number to plug into x
   * @return the total after plugging in a number for x in the polynomial
   */
  double evaluate(double num);

  /**
   * Returns the sum of 2 polynomials as a new Polynomial.
   *
   * @param other the other polynomial to add
   * @return the sum of 2 polynomials as a new Polynomial
   */
  Polynomial add(Polynomial other) throws IllegalArgumentException;

  /**
   * Returns the polynomial as a string.
   *
   * @return the polynomial as a string
   */
  String toString();

  /**
   * Returns and sets the counter for toString.
   *
   * @return and set the counter for toString
   */
  int setCounter(int c);

  /**
   * Returns the accumulator for toString help.
   *
   * @return the accumulator for toString help
   */
  int emptyStringHelp(int counter);

}
