/*
* This program allows the user to enter in the sides of a triangle and the
* program will tell the user certain properties of the triangle.
*
* @author  Cameron Teed
* @version 1.0
* @since   2021-05-30
*/

// Import the Scanner class
import java.util.Scanner;

final class TriangleMain {

  private TriangleMain() {
    // Prevent instantiation
    // Optional: throw an exception e.g. AssertionError
    // if this ever *is* called
    throw new IllegalStateException("Cannot be instantiated");
  }

  /**
   * This function allows the user to enter in the sides of a triangle and the
   * program will tell the user certain properties of the triangle.
   *
   * @param args
   */
  public static void main(final String[] args) {
    try {
      // Initializing the scanner for the triangle side lengths
      Scanner lengthInput = new Scanner(System.in);

      // User input for the first side length
      System.out.print("Enter the base length (CM): ");
      double userInput1 = lengthInput.nextDouble();

      // User input for the second side length
      System.out.print("Enter the second side length (CM): ");
      double userInput2 = lengthInput.nextDouble();

      // User input for the third side length
      System.out.print("Enter the third side length (CM): ");
      double userInput3 = lengthInput.nextDouble();

      System.out.println("");
      // Initializing the triangle  
      Triangle userTriangle = new Triangle(userInput1, userInput2, userInput3);

      // Telling the user the kind of triangle they created
      System.out.println("");
      System.out.println("Type of Triangle: " + userTriangle.getName());

      // Telling the user the side length measurements of the triangle
      System.out.println("Side Length Measurements: "
                         + userTriangle.getSideLengths());

      // Telling the user the angle measurements of the triangle
      System.out.println("Angle Measurements: " + userTriangle.getAngles());

      // Telling the user the height of the triangle
      System.out.println("Height: " + userTriangle.getHeight() + " CM");

      // Telling the user the semiperimeter of the triangle
      System.out.println("Semiperimeter: "
                         + userTriangle.getSemiperimeter() + " CM");

      // Telling the user the perimeter of the triangle
      System.out.println("Perimeter: " + userTriangle.getPerimeter() + " CM");

      // Telling the user the area of the triangle
      System.out.println("Area: " + userTriangle.getArea() + " CM^2");

      // Telling the user the radius of the incircle of the triangle
      System.out.println("Inscribed circle Radius: "
                         + userTriangle.getIncircleRadius() + " CM");

      // Telling the user the area of the circumcircle of the triangle
      System.out.println("Circumcircle Area: "
                         + userTriangle.getCircumcircle() + " CM^2");

      // Prints done
      System.out.println("\nDone.");

      // Catches and tells the user what error occured
    } catch (NullPointerException e) {
      System.out.println("");
      System.out.println("ERROR, Specified parameters are unable to create "
                         + "a real triangle");
    } catch (Exception e) {
      System.out.println("");
      System.out.println("ERROR, Invalid Input");
    }
  }
}
