/**
 * This interface contains all operations that all Polynomials should support.
 */
public interface Polynomial {

  /**
   * Adds a term to the polynomial by taking in a coefficient and power.
   *
   * @param coefficient the coefficient of this the added Polynomial term
   * @param power       the power of this the added Polynomial term
   * @throws IllegalArgumentException if power is negative
   */
  void addTerm(int coefficient, int power) throws IllegalArgumentException;

  /**
   * Removes all terms of power from the Polynomial.
   *
   * @param power the power of the terms to be removed
   */
  void removeTerm(int power);

  /**
   * Returns the degree of this Polynomial.
   *
   * @return the degree of this Polynomial
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
   * @throws IllegalArgumentException if other Polynomial is of type Polynomial
   */
  Polynomial add(Polynomial other) throws IllegalArgumentException;

  /**
   * Returns the polynomial as a string.
   *
   * @return the polynomial as a string
   */
  String toString();
}
