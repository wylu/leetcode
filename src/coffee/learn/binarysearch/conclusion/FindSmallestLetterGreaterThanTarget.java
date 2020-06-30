package coffee.learn.binarysearch.conclusion;

/**
 * @File    :   FindSmallestLetterGreaterThanTarget.java
 * @Time    :   2020/05/30 11:01:45
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        if (target >= letters[right]) return letters[0];
        while (left < right) {
            int mid = (left + right) / 2;
            if (letters[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return letters[left];
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget finder = new FindSmallestLetterGreaterThanTarget();
        char[] letters = "cfj".toCharArray();
        System.out.println(finder.nextGreatestLetter(letters, 'a'));
        System.out.println(finder.nextGreatestLetter(letters, 'c'));
        System.out.println(finder.nextGreatestLetter(letters, 'd'));
        System.out.println(finder.nextGreatestLetter(letters, 'g'));
        System.out.println(finder.nextGreatestLetter(letters, 'j'));
        System.out.println(finder.nextGreatestLetter(letters, 'k'));

        letters = "ceeefffjj".toCharArray();
        System.out.println(finder.nextGreatestLetter(letters, 'e'));
    }
}