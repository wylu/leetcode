package learn.binarysearch.template2;

/**
 * @File    :   FirstBadVersion.java
 * @Time    :   2020/05/27 22:22:34
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */

class VersionControl {
    public int version;

    public VersionControl(int version) {
        this.version = version;
    }

    public boolean isBadVersion(int version) {
        return version >= this.version;
    }
}

public class FirstBadVersion extends VersionControl {
    public FirstBadVersion(int version) {
        super(version);
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}