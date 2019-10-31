/**
 * This class represents an Element Node. This contains a coefficient, power, the rest, and the
 * counter.
 */
public class ElementNode implements ADTNode {

  private int coefficient;
  private int power;
  private ADTNode rest;
  private int counter;

  /**
   * Constructs an ElementNode and initializes it to the coefficient, power, rest, and counter.
   *
   * @param c    the coefficient of this ElementNode
   * @param p    the power of this ElementNode
   * @param rest the next node
   */
  public ElementNode(int c, int p, ADTNode rest) {
    coefficient = c;
    power = p;
    this.rest = rest;
    counter = 0;
  }

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
    if (c == 0) {
      return this;
    }
    if (p > power) {
      return new ElementNode(c, p, this);
    } else if (p == power) {
      coefficient += c;
      return this;
    } else {
      rest = rest.addTerm(c, p);
      return this;
    }
  }

  /**
   * Removes all nodes of power from the polynomial.
   *
   * @param p the power of the terms to be removed
   * @return the first node of the polynomial
   */
  @Override
  public ADTNode removeTerm(int p) {
    if (p == power) {
      return rest.removeTerm(p);
    } else {
      rest = rest.removeTerm(p);
      return this;
    }
  }

  /**
   * Returns the degree of this polynomial.
   *
   * @return the degree of this polynomial
   */
  @Override
  public int getDegree() {
    if (power > rest.getDegree()) {
      return power;
    } else {
      return rest.getDegree();
    }
  }

  /**
   * Returns the coefficient for the term with that power.
   *
   * @param p the power of terms to get the coefficient
   * @return the coefficient for the term with that power
   */
  @Override
  public int getCoefficient(int p) {
    if (p == power) {
      return coefficient + rest.getCoefficient(p);
    } else {
      return rest.getCoefficient(p);
    }
  }

  /**
   * Returns the total after plugging in a number for x in the polynomial.
   *
   * @param num the number to plug into x
   * @return the total after plugging in a number for x in the polynomial
   */
  @Override
  public double evaluate(double num) {
    double total = coefficient * Math.pow(num, power);
    return total + rest.evaluate(num);
  }

  /**
   * Returns the sum of 2 polynomials as a new Polynomial.
   *
   * @param other the other polynomial to add
   * @return the sum of 2 polynomials as a new Polynomial
   */
  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof Polynomial)) {
      throw new IllegalArgumentException("Objects must be in the same class.");
    }
    other.addTerm(coefficient, power);
    rest.add(other);
    return other;
  }

  /**
   * Returns the polynomial as a string.
   *
   * @return the polynomial as a string
   */
  @Override
  public String toString() {
    if (coefficient == 0) {
      counter++;
      rest.setCounter(counter);
      return rest.toString();
    }
    int acc = rest.emptyStringHelp(0);
    counter++;
    rest.setCounter(counter);
    if (counter == 1) {
      if (power == 0) {
        counter = 0;
        rest.setCounter(0);
        if (acc != 0) {
          return coefficient + rest.toString();
        } else {
          return coefficient + "";
        }
      } else {
        counter = 0;
        if (acc != 0) {
          return coefficient + "x^" + power + rest.toString();
        } else {
          return coefficient + "x^" + power;
        }
      }
    } else {
      if (coefficient < 0) {
        if (power == 0) {
          counter = 0;
          if (acc != 0) {
            return " " + coefficient + rest.toString();
          } else {
            return " " + coefficient;
          }
        } else {
          counter = 0;
          if (acc != 0) {
            return " " + coefficient + "x^" + power + rest.toString();
          } else {
            return " " + coefficient + "x^" + power;
          }
        }
      } else {
        if (power == 0) {
          counter = 0;
          if (acc != 0) {
            return " +" + coefficient + rest.toString();
          } else {
            return " +" + coefficient;
          }
        } else {
          counter = 0;
          if (acc != 0) {
            return " +" + coefficient + "x^" + power + rest.toString();
          } else {
            return " +" + coefficient + "x^" + power;
          }
        }
      }
    }
  }

  /**
   * Returns and sets the counter for toString.
   *
   * @return and set the counter for toString
   */
  @Override
  public int setCounter(int c) {
    counter = c;
    return counter;
  }

  /**
   * Returns the accumulator for toString help.
   *
   * @return the accumulator for toString help
   */
  @Override
  public int emptyStringHelp(int acc) {
    return rest.emptyStringHelp(1 + acc);
  }

}
