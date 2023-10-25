//B. Enter a Roman Number as input and convert it to an integer. (ex IX = 9)

import java.util.HashMap;
import java.util.Map;

public class Roman {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Create a map to store the values of Roman numerals
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = romanValues.get(s.charAt(s.length() - 1)); // Initialize result with the value of the last character

        for (int i = s.length() - 2; i >= 0; i--) {
            if (romanValues.get(s.charAt(i)) < romanValues.get(s.charAt(i + 1))) {
                result -= romanValues.get(s.charAt(i));
            } else {
                result += romanValues.get(s.charAt(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Roman converter = new Roman();
        String romanNumeral = "IX"; // Replace with your Roman numeral
        int result = converter.romanToInt(romanNumeral);
        System.out.println(romanNumeral + " = " + result);
    }
}
