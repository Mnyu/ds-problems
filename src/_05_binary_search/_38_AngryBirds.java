package _05_binary_search;

import java.util.Arrays;

/**
 * Given : A long wire along a straight line which contain N bird nests at positions X1,X2,...XN.
 * There are B(<=N) birds, which become angry towards each other once put into a nest.
 * <p>
 * To put the birds from hurting each other you want to assign birds to nests
 * such that
 * minimum distance between any 2 birds is as large as possible.
 * What is the largest minimum distance.
 * <p>
 * Sample Input :
 * Birds B = 3
 * Nests = [1,2,4,8,9], N = 5
 * <p>
 * Sample Output :
 * 3
 */
public class _38_AngryBirds {

    public int largestMinDistance(int[] nests, int birds) {
        if (nests == null || nests.length == 0 || birds == 0)
            return -1;
        Arrays.sort(nests); // NlogN
        int start = 0;
        int end = nests[nests.length - 1] - nests[0];
        int largestMinDistance = -1;
        //Nlog(XN - X0)
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canPlace(nests, birds, mid)) {
                largestMinDistance = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return largestMinDistance;
    }

    // O(N)
    private boolean canPlace(int[] nests, int birds, int minSep) {
        int birdsPlaced = 1;
        int lastLocation = nests[0];
        for (int i = 1; i < nests.length; i++) {
            if (nests[i] - lastLocation >= minSep) {
                lastLocation = nests[i];
                birdsPlaced++;
                if (birdsPlaced == birds)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _38_AngryBirds obj = new _38_AngryBirds();
        System.out.println(obj.largestMinDistance(new int[]{8, 2, 4, 1, 9}, 3));
    }
}
