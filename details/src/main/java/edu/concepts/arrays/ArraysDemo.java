package edu.concepts.arrays;


/**
 * int[][] arr = new int[5][4];
 * <p>
 * int[] ar0 = arr[0];
 * int[] ar1 = arr[1];
 * int[] ar2 = arr[2];
 * int[] ar3 = arr[3];
 * int[] ar4 = arr[4];
 */
public class ArraysDemo {
    public static void main(String... args) {

        //forS();

        String[] ar111 = {"www", "222", "1111"};
        String s = ar111[0];

        int[][] ar = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(ar[0][1]);

        int[][] arr = new int[4][4];

        //5x4
        // 0     1      2     3
        // 4     5      6     7
        // 8     9      10    11
        //.....

        int t = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = t;
                t++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // System.out.print("i:" + i + "  j:" + j + " arr:" + arr[i][j] + "  ");
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("change starts");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i <= j) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }
        System.out.println("change finishes");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // System.out.print("i:" + i + "  j:" + j + " arr:" + arr[i][j] + "  ");
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

        int finalSum=0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               finalSum = finalSum + arr[i][j];
            }
        }

        System.out.println(finalSum);



    }


    private static void forS() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(i + ":" + j + "  ");
            }
            System.out.println();
        }
    }
}
