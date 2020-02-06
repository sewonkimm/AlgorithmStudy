import java.io.*;
import java.util.*;

class Main {
    static int[][] nums;
    static boolean[][] isCombined;
    static int answer;

    static void resetIsCombined() {
        for (int i = 0; i < isCombined.length; i++) {
            for (int j = 0; j < isCombined[i].length; j++) {
                isCombined[i][j] = false;
            }
        }
    }

    static int getMaxValue(int[][] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                max = nums[i][j] > max ? nums[i][j] : max;
            }
        }
        return max;
    }

    static void move(int[][] priorNums, int dir, int count) {
        if (count == 5) {
            int curMaxVal = getMaxValue(priorNums);
            if (curMaxVal > answer)
                answer = curMaxVal;
            return;
        }
        int[][] curNums = new int[priorNums.length][priorNums.length];
        for (int i = 0; i < priorNums.length; i++) {
            for (int j = 0; j < priorNums[i].length; j++) {
                curNums[i][j] = priorNums[i][j];
            }
        }
        if (dir == 0) {
            for (int i = 0; i < curNums.length; i++) {
                for (int j = 0; j < curNums.length; j++) {
                    if (curNums[j][i] != 0) {
                        for (int k = 0; k < j; k++) {
                            if (curNums[k][i] != 0) {
                                if (!isCombined[k][i] && curNums[k][i] == curNums[j][i]
                                        && (curNums[k + 1][i] == 0 || k + 1 == j)) {
                                    curNums[k][i] *= 2;
                                    isCombined[k][i] = true;
                                    curNums[j][i] = 0;
                                    break;
                                }
                            } else {
                                curNums[k][i] = curNums[j][i];
                                curNums[j][i] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        } else if (dir == 1) {
            for (int i = 0; i < curNums.length; i++) {
                for (int j = curNums.length - 1; j >= 0; j--) {
                    if (curNums[j][i] != 0) {
                        for (int k = curNums.length - 1; k > j; k--) {
                            if (curNums[k][i] != 0) {
                                if (!isCombined[k][i] && curNums[k][i] == curNums[j][i]
                                        && (curNums[k - 1][i] == 0 || k - 1 == j)) {
                                    curNums[k][i] *= 2;
                                    isCombined[k][i] = true;
                                    curNums[j][i] = 0;
                                    break;
                                }
                            } else {
                                curNums[k][i] = curNums[j][i];
                                curNums[j][i] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        } else if (dir == 2) {
            for (int i = 0; i < curNums.length; i++) {
                for (int j = 0; j < curNums.length; j++) {
                    if (curNums[i][j] != 0) {
                        for (int k = 0; k < j; k++) {
                            if (curNums[i][k] != 0) {
                                if (!isCombined[i][k] && curNums[i][k] == curNums[i][j]
                                        && (curNums[i][k + 1] == 0 || k + 1 == j)) {
                                    curNums[i][k] *= 2;
                                    isCombined[i][k] = true;
                                    curNums[i][j] = 0;
                                    break;
                                }
                            } else {
                                curNums[i][k] = curNums[i][j];
                                curNums[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        } else if (dir == 3) {
            for (int i = 0; i < curNums.length; i++) {
                for (int j = curNums.length - 1; j >= 0; j--) {
                    if (curNums[i][j] != 0) {
                        for (int k = curNums.length - 1; k > j; k--) {
                            if (curNums[i][k] != 0) {
                                if (!isCombined[i][k] && curNums[i][k] == curNums[i][j]
                                        && (curNums[i][k - 1] == 0 || k - 1 == j)) {
                                    curNums[i][k] *= 2;
                                    isCombined[i][k] = true;
                                    curNums[i][j] = 0;
                                    break;
                                }
                            } else {
                                curNums[i][k] = curNums[i][j];
                                curNums[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        resetIsCombined();
        move(curNums, 0, count + 1);
        move(curNums, 1, count + 1);
        move(curNums, 2, count + 1);
        move(curNums, 3, count + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n][n];
        isCombined = new boolean[n][n];
        answer = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move(nums, 0, 0);
        move(nums, 1, 0);
        move(nums, 2, 0);
        move(nums, 3, 0);
        System.out.print(answer);
    }
}