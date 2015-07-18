package chapter1;

/**
 * Class to compress a String
 * @author Arturo
 *
 */
public class StringCompression {

    /**
     * Compresses a string counting how many
     * equal characters are together.
     * Appends the character and its count
     * to form the compressed string
     *
     * @param string to compress
     * @return compressed string or original
     * input if the length of the compressed
     * string is larger than the original or it
     * is null or empty
     */
    public static String compress(String input) {
        if(input == null || input.length() == 0) return input;
        int count = 1;
        int index = 0;
        char c = '\u0000';
        StringBuilder sb = new StringBuilder();
        while(true) {
            if(index == input.length() - 1) {
                sb.append(input.charAt(index)).append(count);
                break;
            }
            c = input.charAt(index);
            if(c == input.charAt(index + 1)) {
                count++;
            } else {
                sb.append(c).append(count);
                count = 1;
            }
            index++;
        }
        return input.length() <= sb.length()? input : sb.toString();
    }

    public static void main (String[] args) {
        String str = "aabcccccaaa";
        System.out.println(compress(str));
    }

}