// 开始
// 声明准备使用扫描仪
import java.util.Scanner;

// 创建能够判定是否是数字的类
public class Calculator
{
    private static boolean isNumber(String str)
    {
        try
        {
        Double.parseDouble(str);
        return false;
        }catch(NumberFormatException e)
        {
        return true;
        }
    }
    public static void main(String[] args)
    {

        // 声明变量
        boolean wantContinue = true;
        double x1 = 0, y1 = 0, z1 = 0, x2 = 0, y2 = 0, z2 = 0, dotResult, resultX, resultY, resultZ;
        String the1, the2, the3, the4, the5, the6, continueOrNot;
        char ifDotOrCross = 0;
        String transToChar = "transToChar";
        Scanner input = new Scanner(System.in);

        // 进入循环，用户自行选择是否再次运行一遍
        while (wantContinue)
        {
            // 欢迎信息
            System.out.println("Welcome to the Dot/Cross Product Calculator! ");

            // 要求用户必须只能输入单个字母的D或C，大小写不限
            for (int i = 0; i < 1;i++)
            {
                System.out.println("Enter \"D\" or \"C\" to run Dot/Cross Product Calculator: ");
                transToChar = input.nextLine();
                transToChar = transToChar.toUpperCase();
                ifDotOrCross = transToChar.charAt(0);

                // 检测用户是否是输入了多于一个字母或者非D非C
                if (transToChar.length() != 1 || (ifDotOrCross != 'D' && ifDotOrCross != 'C'))
                {
                    System.out.println("Please enter ONE letter between D and C! ");
                    i--;
                }
            }

            // 要求用户输入两个向量，必须输入数字而不是其他字符
            for (int i = 0; i < 1; i++)
            {
                System.out.println("Please enter the first vector. ");
                System.out.println("What is x1? ");
                the1 = input.nextLine();
                x1 = Double.parseDouble(the1);
                System.out.println("What is y1? ");
                the2 = input.nextLine();
                y1 = Double.parseDouble(the2);
                System.out.println("What is z1? ");
                the3 = input.nextLine();
                z1 = Double.parseDouble(the3);
                System.out.println("Please enter the second vector. ");
                System.out.println("What is x2? ");
                the4 = input.nextLine();
                x2 = Double.parseDouble(the4);
                System.out.println("What is y2? ");
                the5 = input.nextLine();
                y2 = Double.parseDouble(the5);
                System.out.println("What is z2? ");
                the6 = input.nextLine();
                z2 = Double.parseDouble(the6);

                // 检测是否为数字，否则重新输入
                if (    isNumber(the1) ||
                        isNumber(the2) ||
                        isNumber(the3) ||
                        isNumber(the4) ||
                        isNumber(the5) ||
                        isNumber(the6))
                {
                    System.out.println("Please enter a number! ");
                    i--;
                }
            }

            // 当用户选择点乘或叉乘，开始计算
            //当选择点乘时
            if (ifDotOrCross == 'D')
            {
                System.out.println("You choose the Dot Product Calculator! ");
                dotResult = x1*x2 + y1*y2 + z1*z2;

                // 展示结果，结果保留小数点后三位
                System.out.println("The dot product is " + dotResult);

            }

            // 当选择叉乘时
            else if (ifDotOrCross == 'C')
            {
                System.out.println("You choose the Cross Product Calculator! ");
                resultX = y1*z2 - z1*y2;
                resultY = -(x1*z2 - z1*x2);
                resultZ = x1*y2 - y1*x2;

                // 展示结果，结果保留小数点后三位
                System.out.println( "The cross product is < " +
                        String.format("%.3f", resultX) +
                        " , " + String.format("%.3f", resultY) +
                        " , " + String.format("%.3f", resultZ) +
                        " >. "             );
            }

            // 询问用户是否需要重新再运行一遍
            System.out.println("Do you want to Calculate again? (Yes/No)");
            continueOrNot = input.nextLine();
            continueOrNot = continueOrNot.toUpperCase();

            // 如果答案为非YES则结束程序
            if (!continueOrNot.equals("YES"))
            {
                System.out.println("The program is end. ");
                wantContinue = false;
            }
        }
    }
}
