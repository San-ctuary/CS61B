import java.io.File;
import java.util.Scanner;


/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    
    public static void main(String[] args) throws Exception {
        int minLength = 4;
//        In in = new In("words.txt");
        File file = new java.io.File("words.txt");
//        System.out.println(file.exists());
//        System.out.println(file.getAbsolutePath());
        Scanner in = new Scanner(file);
        Palindrome palindrome = new Palindrome();
        while (in.hasNext()) {
            String word = in.next();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
    } 
//    Uncomment this class once you've written isPalindrome. */
}
