import java.util.Random;
import java.util.Scanner;

public class LoterryTicket {
    //双色球彩票系统
    //双色球由6个红球，1个蓝球组成
    //红球号码为1-33，蓝球号码为1-16
    private static Random r = new Random();
    private static Scanner sc = new Scanner(System.in);
    private static int redCount = 0;
    private static int blueCount = 0;

    public static void main(String[] args) {
        //生成中奖号码
        int[] arr = createNumber();
        System.out.println("开奖号码");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        //用户输入彩票号码
        int[] userArr = userNumber();
        System.out.println("购买的彩票号码");
        for (int i = 0; i < userArr.length; i++) {
            System.out.print(userArr[i] + " ");
        }
        System.out.println(" ");

        //计算红、蓝球中间个数
        Winning(userArr, arr);

        //根据红、蓝球个数判断中将结果
        WinningResult();

    }

    private static void WinningResult() {
        switch (redCount) {
            case 6:
                switch (blueCount) {
                    case 1:
                        System.out.println("一等奖");
                        break;
                    case 0:
                        System.out.println("二等奖");
                        break;
                }
                break;
            case 5:
                switch (blueCount) {
                    case 1:
                        System.out.println("三等奖");
                        break;
                    case 0:
                        System.out.println("四等奖");
                        break;
                }
                break;
            case 4:
                switch (blueCount) {
                    case 1:
                        System.out.println("四等奖");
                        break;
                    case 0:
                        System.out.println("五等奖");
                        break;
                }
                break;
            case 3:
                switch (blueCount) {
                    case 1:
                        System.out.println("五等奖");
                        break;
                    case 0:
                        System.out.println("未中奖");
                        break;
                }
                break;
            case 2:
                switch (blueCount) {
                    case 1:
                        System.out.println("六等奖");
                        break;
                    case 0:
                        System.out.println("未中奖");
                        break;
                }
                break;
            case 1:
                switch (blueCount) {
                    case 1:
                        System.out.println("六等奖");
                        break;
                    case 0:
                        System.out.println("未中奖");
                        break;
                }
                break;
            case 0:
                switch (blueCount) {
                    case 1:
                        System.out.println("六等奖");
                        break;
                    case 0:
                        System.out.println("未中奖");
                        break;
                }
                break;
            default:
                break;

        }
    }

    private static void Winning(int[] userArr, int[] arr) {
        //判断红、蓝球中奖情况
        //红球
        for (int i = 0; i < userArr.length - 1; i++) {
            int redNumber = userArr[i];
            for (int j = 0; j < arr.length - 1; j++) {
                if (redNumber == arr[j]) {
                    redCount++;
                    break;
                }
            }
        }
        //蓝球
        int blueNumber = userArr[userArr.length - 1];
        if (blueNumber == arr[arr.length - 1]) {
            blueCount++;
        }
    }

    //创建中奖号码
    public static int[] createNumber() {
        int arr[] = new int[7];

        //生成红球号码
        for (int i = 0; i < 6; ) {
            int redNumber = r.nextInt(33) + 1;
            if (!contains(arr, redNumber)) {
                arr[i] = redNumber;
                i++;
            }
        }
        //生成蓝球号码
        int blueNumber = r.nextInt(16) + 1;
        arr[arr.length - 1] = blueNumber;

        return arr;
    }

    //用户自己输入彩票号码
    public static int[] userNumber() {
        int arr[] = new int[7];

        //输入红球号码
        for (int i = 0; i < 6; ) {
            System.out.println("输入第" + (i + 1) + "个红球号码");
            int redNumber = sc.nextInt();
            //redNumber在1-33且不重复
            if (redNumber > 0 && redNumber < 34) {
                if (!contains(arr, redNumber)) {
                    arr[i] = redNumber;
                    i++;
                } else {
                    System.out.println("当前红球号码已经存在，重新输入");
                }
            } else {
                System.out.println("号码超出范围，重新输入");
            }
        }

        //输入蓝球号码
        System.out.println("输入蓝球号码");
        while (true) {
            int blueNumber = sc.nextInt();
            if (blueNumber > 0 && blueNumber < 17) {
                arr[arr.length - 1] = blueNumber;
                break;
            } else {
                System.out.println("号码超出范围,重新输入");
            }
        }

        return arr;
    }

    //判断号码是否在数组中存在
    public static boolean contains(int arr[], int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;

    }
}
