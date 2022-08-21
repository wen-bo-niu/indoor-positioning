package KNN;

public class StrUtil {

    private static int min(int one, int two, int three) {

        return (one = one < two ? one : two) < three ? one : three;
    }

    private static int compare(String str, String target) {
        int d[][]; // 矩阵
        int n = str.length();
        int m = target.length();
        int i;
        int j;
        char ch1; // str
        char ch2; // target
        int temp; // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
        int sum = 0; //相同字符总数
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];
        // 初始化第一列
        for (i = 0; i <= n; i++) {
            d[i][0] = i;
        }
        // 初始化第一行
        for (j = 0; j <= m; j++) {
            d[0][j] = j;
        }
        // 遍历str
        for (i = 1; i <= n; i++) {
            ch1 = str.charAt(i - 1);
            // 去匹配target
            for (j = 1; j <= m; j++) {
                ch2 = target.charAt(j - 1);
                if (ch1 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                // 左边+1,上边+1, 左上角+temp取最小
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
                //d[i][j]=temp;
                //sum+=temp;
            }
        }
        return d[n][m];
    }
    public static Double similarityRatio(String strA, String strB) {
        return 1-(double) compare(strA, strB) / Math.max(strA.length(), strB.length());
    }

}
