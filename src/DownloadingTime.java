import java.util.Scanner;
import java.util.Calendar;

public class DownloadingTime {

    private static boolean run = true;

    public static double makeItKB(double whatValue, char whatUnit)
    {
        if (whatUnit == 'T')
        {
            run = false;
            return whatValue*1024*1024*1024;
        } else if (whatUnit == 'G')
        {
            run = false;
            return whatValue*1024*1024;
        } else if (whatUnit == 'M')
        {
            run = false;
            return whatValue*1024;
        } else if (whatUnit == 'K')
        {
            run = false;
            return whatValue;
        } else
        {
            System.out.println( "请以“4.3m”的格式再次输入");
            return whatValue;
        }
    }


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        while (run)
        {
            double valueDown = 0, valueSpeed = 0, result;
            System.out.println("输入剩余下载量：");
            String totalDown = keyboard.nextLine();
            totalDown = totalDown.toUpperCase();
            char unitDown = totalDown.charAt(totalDown.length()-1);
            totalDown = totalDown.substring(0, totalDown.length()-1);
            try
            {
                valueDown = makeItKB(Double.parseDouble(totalDown), unitDown);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                unitDown = 0;
            }
            System.out.println("输入每秒下载速度：");
            String totalSpeed = keyboard.nextLine();
            totalSpeed = totalSpeed.toUpperCase();
            char unitSpeed = totalSpeed.charAt(totalSpeed.length()-1);
            totalSpeed = totalSpeed.substring(0, totalSpeed.length()-1);
            try
            {
                valueSpeed = makeItKB(Double.parseDouble(totalSpeed), unitSpeed);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                unitSpeed = 0;
            }

            result = valueDown/valueSpeed;
            String xiaoShuDian = Double.toString(result);
            try
            {
                xiaoShuDian = xiaoShuDian.substring(xiaoShuDian.indexOf("."), xiaoShuDian.indexOf(".") + 3);
            } catch (IndexOutOfBoundsException a)
            {
                try
                {
                    xiaoShuDian = xiaoShuDian.substring(xiaoShuDian.indexOf("."), xiaoShuDian.indexOf(".") + 2);
                } catch (IndexOutOfBoundsException b)
                {
                    try
                    {
                        xiaoShuDian = xiaoShuDian.substring(xiaoShuDian.indexOf("."));
                    } catch (IndexOutOfBoundsException c)
                    {
                        a.printStackTrace();
                    }
                }
            }
            int sec = (int)result;

            int d = sec / 3600 / 24;
            int h = sec / 3600 % 24;
            int m = sec % 3600 / 60;
            int s = sec % 60;

            if (valueSpeed == 0)
            {
                System.out.println("你他妈永远也下载不完");
            }
            else if (d == 0 && h == 0 && m == 0 && s == 0)
            {
                System.out.println("下载已完成");
            } else if (d == 0 && h == 0 && m == 0)
            {
                System.out.println("下载将于" + s + xiaoShuDian + "秒后下载完成");
            } else if (d == 0 && h == 0)
            {
                System.out.println("下载将于" + m + "分钟" + s + xiaoShuDian + "秒后下载完成");
            } else if (d == 0)
            {
                System.out.println("下载将于" + h + "小时" + m + "分钟" + s + xiaoShuDian + "秒后下载完成");
            } else
            {
                System.out.println("下载将于" + d + "天" + h + "小时" + m + "分钟" + s + xiaoShuDian + "秒后下载完成");
            }

            System.out.println("是否需要再次计算？(Y/N)");
            String jiXU = keyboard.nextLine();
            jiXU = jiXU.toUpperCase();
            if (jiXU.equals("Y"))
            {
                run = true;
            }
        }
        System.out.println("程序结束");




    }


}
