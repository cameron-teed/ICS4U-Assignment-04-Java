/*
* This class creates a triangle and finds its properties.
*
* @author  Cameron Teed
* @version 1.0
* @since   2021-05-30
*/

public class Triangle {
  /**
   * Initializing the 1st length.
   */
  private double sideLength1;
  /**
   * Initializing the 2nd length.
   */
  private double sideLength2;
  /**
   * Initializing the 3rd length.
   */
  private double sideLength3;
  /**
   * Initializing the 1st angle.
   */
  private double angle1;
  /**
   * Initializing the 2nd angle.
   */
  private double angle2;
  /**
   * Initializing the 3rd angle.
   */
  private double angle3;
  /**
   * Initializing the semiperimeter.
   */
  private double semiPerimeter;
  /**
   * Initializing the area.
   */
  private double area;
  /**
   * Initializing the mathconstant.
   */
  private final double mathConst = 4;
   /**
   * Initializing the math constant.
   */
  private final double mathConst2 = 1000;

  /**
   * Setting values with a constructor.
   *
   * @param firstInput
   * @param secondInput
   * @param thirdInput
   */
  public Triangle(final double firstInput, final double secondInput,
                  final double thirdInput) {
    this.sideLength1 = firstInput;
    this.sideLength2 = secondInput;
    this.sideLength3 = thirdInput;

    // Initializing the first angle
    this.angle1 = Math.acos((Math.pow(this.sideLength2, 2)
                             + Math.pow(this.sideLength3, 2)
                             - Math.pow(this.sideLength1, 2))
                             / (2 * this.sideLength2 * this.sideLength3));

    // Initializing the second angle
    this.angle2 = Math.acos((Math.pow(this.sideLength3, 2)
                             + Math.pow(this.sideLength1, 2)
                             - Math.pow(this.sideLength2, 2))
                             / (2 * this.sideLength3 * this.sideLength1));

    // Initializing the third angle
    this.angle3 = Math.acos((Math.pow(this.sideLength1, 2)
                             + Math.pow(this.sideLength2, 2)
                             - Math.pow(this.sideLength3, 2))
                             / (2 * this.sideLength1 * this.sideLength2));

    // Initializing the semiperimeter of the triangle
    this.semiPerimeter = (this.sideLength1 + this.sideLength2
                          + this.sideLength3) / 2;

    // Initializing the area of the triangle
    this.area = Math.sqrt(this.semiPerimeter
                          * (this.semiPerimeter - this.sideLength1)
                          * (this.semiPerimeter - this.sideLength2)
                          * (this.semiPerimeter - this.sideLength3));

    // Ensuring the triangle the user created is valid
    isTriangleValid();
  }

  /**
   * This method shows a string containing all the angle measurements.
   *
   * @return angleString
   */
  public String getAngles() {
    // Making a string with the angle values
    String angleString = this.angle1 + " radians, " + this.angle2 + " radians, "
                         + this.angle3 + " radians";

    // Returning the string with the angle values
    return angleString;
  }

  /**
   * Getter for the area.
   *
   * @return area
   */
  public double getArea() {
    // Returning the area of the triangle
    return this.area;
  }

  /**
   * This method shows the area of the circumcircle of the triangle.
   *
   * @return circumcircleArea
   */
  public double getCircumcircle() {
    // Calculating circumcircle radius
    double circumcircleRadius = (this.sideLength1 * this.sideLength2
                                 * this.sideLength3) / (mathConst * this.area);

    // Calculating circumcircle area
    double circumcircleArea = Math.PI * Math.pow(circumcircleRadius, 2);

    // Returning circumcircle area
    return circumcircleArea;
  }

  /**
   * This method finds the height of the triangle.
   *
   * @return height
   */
  public double getHeight() {
    // Calculating the height of the triangle
    double height = (2 * this.area) / this.sideLength1;

    // Returning the height
    return height;
  }

  /**
   * This method finds the incircle radius of the triangle.
   *
   * @return radius
   */
  public double getIncircleRadius() {
    // Calculating the incircle radius
    double radius = this.area / this.semiPerimeter;

    // Returning the incircle radius
    return radius;
  }

  /**
   * This method tells the user what kind of triangle they created.
   *
   * @return string
   */
  public String getName() {
    // Checking if triangal is an equilateral
    if (this.sideLength1 == this.sideLength2
        && this.sideLength2 == this.sideLength3
        && this.sideLength1 == this.sideLength3) {
      // Returns that its an equilateral
      return "Equilateral Triangle";
    // Checking if its an icosceles
    } else if (this.sideLength1 == this.sideLength2
               || this.sideLength2 == this.sideLength3
               || this.sideLength1 == this.sideLength3) {
      // Returns that its an icosceles
      return "Isosceles Triangle";
      // Checking if its a right triangle
    } else if (this.angle1 == Math.PI / 2
               || this.angle2 == Math.PI / 2 || this.angle3 == Math.PI / 2) {
      // Returns that its a right triangle
      return "Right Triangle";
      // If its none of those, its scalene
    } else {
      // Returns that its scalene
      return "Scalene Triangle";
    }
  }

  /**
   * This method finds the perimeter of the triangle.
   *
   * @return perimeter
   */
  public double getPerimeter() {
    // Calculating the perimeter of the triangle
    double perimeter = this.sideLength1 + this.sideLength2 + this.sideLength3;

    // Returning the perimeter
    return perimeter;
  }

  /**
   * This method shows the semiperimeter of the triangle.
   *
   * @return semiPerimeter
   */
  public double getSemiperimeter() {
    // Returning the semiperimeter of the triangle
    return this.semiPerimeter;
  }

  /**
   * This method shows a string containing all the side length measurements.
   *
   * @return sideString
   */
  public String getSideLengths() {
    // Making a string with the side length values
    String sideString = this.sideLength1 + " CM, " + this.sideLength2 + " CM, "
                        + this.sideLength3 + " CM";

    // Returning the string with the side length values
    return sideString;
  }

  /**
   * This method figures out whether or not the triangle can exist.
   *
   * @return boolean
   */
  protected Boolean isTriangleValid() {
    // Calculating variables for future use in method
    double roundedAngle = Math.floor((this.angle1 + this.angle2 + this.angle3)
                                     * mathConst2) / mathConst2;
    double roundedPi = Math.floor(Math.PI * mathConst2) / mathConst2;

    if (this.sideLength1 <= 0 || this.sideLength2 <= 0
        || this.sideLength3 <= 0) {
      // Throwing that triangle cannot exist
      throw null;
    } else if (roundedAngle != roundedPi) {
      // Throwing that triangle cannot exist
      throw null;
    } else {
      // Returning that triangle can exist
      System.out.println("Triangle is Valid");
      return true;
    }
  }
}
