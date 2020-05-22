package learn.arrayandstring.string;

/**
 * @File    :   AddBinary.java
 * @Time    :   2020/05/22 22:19:42
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] ac = a.toCharArray(), bc = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = ac.length - 1, j = bc.length - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += ac[i--] - '0';
            if (j >= 0) sum += bc[j--] - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }
}