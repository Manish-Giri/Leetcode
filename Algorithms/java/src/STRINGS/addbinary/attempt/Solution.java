package STRINGS.addbinary.attempt;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
 class Solution {

     /**
      * Runtime
      * 8 ms
      * Beats
      * 8.29%
      * Memory
      * 43.1 MB
      * Beats
      * 18.67%
      * @param a
      * @param b
      * @return
      */
     String addBinary(String a, String b) {
        String[] num1 = a.split("");
        String[] num2 = b.split("");
        int first = num1.length-1, second = num2.length-1;
        int carry = 0, sum = 0;
        StringBuilder sb = new StringBuilder();
        while(first >= 0 && second >= 0) {
            // if both bits are 1
            if(num1[first].equals("1") && num2[second].equals("1")) {
                //int oldCarry = carry;
                if(carry == 0) {
                    sum = 0;
                    carry = 1;
                }
                else {
                    sum = 1;
                    carry = 1;
                }
                sb.append(sum);
                first--;
                second--;
            }
            else {
                sum = Integer.parseInt(num1[first]) + Integer.parseInt(num2[second]);
                if(carry == 1) {
                    if(sum == 1) {
                        sum = 0;
                        carry = 1;
                    }
                    else {
                        sum = sum + carry;
                        carry = 0;
                    }
                    sb.append(sum);
                    first--;
                    second--;
                }
                else {
                    sb.append(sum);
                    first--;
                    second--;
                }
            }
        }

        while(first >= 0) {
            if(num1[first].equals("1") && carry == 1) {
                sum = 0;
                carry = 1;
            }
            else {
                sum = Integer.parseInt(num1[first]) + carry;
                carry = 0;

            }
            sb.append(sum);
            first--;
        }

        while(second >= 0) {
            if(num2[second].equals("1") && carry == 1) {
                sum = 0;
                carry = 1;
            }
            else {
                sum = Integer.parseInt(num2[second]) + carry;
                carry = 0;

            }
            sb.append(sum);
            second--;
        }
        if(carry == 1) {
            sb.append(carry);
            carry = 0;
        }
        return sb.reverse().toString();
    }

     public static void main(String[] args) {
         String a = "1";
         String b = "111";
         System.out.println(new Solution().addBinary(a, b));
     }
}
