package main.others;

public class getDistance {
    /*
    通过得到的哈希向量，计算两个文本的海明距离并返回该值
     */
    public static int getHammingDistance(String simHash1, String simHash2) {
        int distance = 0;
        for (int i = 0; i < simHash1.length(); i++) {
            // 每一位进行比较，不同则距离加 1
            if (simHash1.charAt(i) != simHash2.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }
    //输入两个simHash值，返回相似度
    public static double getSimilarity(String simHash1, String simHash2) {
        // 获得它们的相似度
        int distance = getHammingDistance(simHash1, simHash2);
        return 1 - (double)distance/ 128;

    }
}
