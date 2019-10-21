package com.zzm;

/**
 *   @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 *   给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 *   示例:
 *
 *   输入: 3
 *   输出:
 *   [
 *   [ 1, 2, 3 ],
 *   [ 8, 9, 4 ],
 *   [ 7, 6, 5 ]
 *   ]
 *
 *   来源：力扣（LeetCode）
 *   链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 *   著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * --------------------------------------------------
 * <p>
 * --------------------------------------------------
 * </pre>
 */
public class Algorithm {
    public static void main(String[] args) {
        System.out.println(generateMatrix(4));
    }
    public static int[][] generateMatrix(int n){

        //左边
        int left= 0;

        //最上边
        int top = 0;

        //右边
        int right = n -1 ;

        //底部
        int buttom = n -1;


        int[][] num = new int[n][n];
        int start = 1;
        int max = n * n;
        while (start <=max){

            //左边到右边
            for (int i = left ; i<= right ; i++){
                num[top][i] = start++;
            }
            top++;

            //右边到底部
            for (int i = top;i <= buttom;i++){
                num[i][right] = start++;
            }

            right--;

            //底部到左边
            for (int i = right;i >= left;i--){
                num[buttom][i] = start ++;
            }

            buttom--;
            //从底部向上
            for (int i= buttom;i >=top ; i--){
                num[i][left] = start ++;
            }
            left++;
        }
        return num;
    }
}
