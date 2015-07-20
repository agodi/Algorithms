package chapter1;

/**
 * Class that validates if a string is a rotation of another string
 * @author arturogomez
 */
public class StringRotationValidator {

  /**
   * Checks if the second string is a rotation of the first one
   * @param str1 original string
   * @param str2 string to validate
   * @return true if the second string is a rotation of the first one
   *         false otherwise
   */
  public static boolean validate(String str1, String str2 ) {
    return (str2 + str2).contains(str1);
  }


  public static void main(String[] args) {
    String str1 = "waterbottle";
    String str2 = "erbottlewat";
    System.out.println(validate(str1, str2)); 
  }
}

