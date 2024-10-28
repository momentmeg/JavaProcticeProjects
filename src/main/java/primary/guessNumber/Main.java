package primary.guessNumber;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @FileName Main
 * @Description
 * @Author fahrtwind
 * @date 2024-10-28
 **/


public class Main {

    public static void main(String[] args) {
        System.out.println("10次机会，你能否猜到1~100的数字呢！");
        Random r = new Random();
        int target = r.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        System.out.println(target);
        int turn = 10, min = 1, max = 100;
//        int num;

        LOOP:
        while ((turn--) > 0) {
//          //方法一
//            try {
//                num = sc.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.println("这是什么啊？我看不懂！数字在" + min + "~" + max + "之间哦");
//                sc.nextLine();
//                continue;
//            }

            //方法二
            String str = sc.nextLine();
            for (char c : str.toCharArray()) {
                if (c < '0' || c > '9') {
                    System.out.println("这是什么啊？我看不懂！数字在" + min + "~" + max + "之间哦");
                    continue LOOP;
                }
            }
            int num = Integer.parseInt(str);

            if (num > 100) {
                System.out.println("太大了，超出范围了！");
            } else if (num < 1) {
                System.out.println("太小了，超出范围了！");
            } else if (target > num) { //猜小了
                min = min < num ? num : min;
                System.out.println("比它大哦，在" + min + "~" + max + "之间");
            } else if (target < num) { //猜大了
                max = max > num ? num : max;
                System.out.println("比它小哦，在" + min + "~" + max + "之间");
            } else if (target == num) {
                System.out.println("恭喜你，猜到了");
                System.exit(1);
            }


        }
        System.out.println("很遗憾，你未能在10轮内猜到");
    }
}
