public class Calculator {

  double nr1 = 5;
  double nr2 = 10;

  public Calculator(double nr1, double nr2) {
    this.nr1 = nr1;
    this.nr2 = nr2;
  }

  public double addNumbers() {
    double result = nr1 + nr2;
    return result;

  }

  public double subtractNumbers() {
    double result = nr1 - nr2;
    return result;
  }
}
