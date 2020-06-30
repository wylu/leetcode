package coffee.learn.arrays101.inplaceoperate;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        int i = arr.length - 1;
        int curMax = arr[i];
        arr[i--] = -1;
        while (i >= 0) {
            int tmp = arr[i];
            arr[i--] = curMax;
            if (tmp > curMax) curMax = tmp;
        }
        return arr;
    }
}