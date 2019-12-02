import java.util.Scanner;

public class DownloadingTimeCount {

    private static boolean run = true;

    public static double makeItKB(double whatValue, char whatUnit)
    {
        if (whatUnit == 'T')
        {
            return whatValue*1024*1024*1024;
        } else if (whatUnit == 'G')
        {
            return whatValue*1024*1024;
        } else if (whatUnit == 'M')
        {
            return whatValue*1024;
        } else if (whatUnit == 'K')
        {
            return whatValue;
        } else
        {
            System.out.println( "请以“4.3m”的格式再次输入");
            return whatValue;
        }
    }


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);


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


        while (run)
        {
            result = valueDown/valueSpeed;

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
                System.out.println("下载将于" + s + "秒后下载完成");
            } else if (d == 0 && h == 0)
            {
                System.out.println("下载将于" + m + "分钟" + s + "秒后下载完成");
            } else if (d == 0)
            {
                System.out.println("下载将于" + h + "小时" + m + "分钟" + s + "秒后下载完成");
            } else
            {
                System.out.println("下载将于" + d + "天" + h + "小时" + m + "分钟" + s + "秒后下载完成");
            }
            valueDown-=valueSpeed/480000;
            run = true;
            if (d == 0 && h == 0 && m == 0 && s == 0)
            {
                run = false;
            }

        }
        System.out.println("程序结束");




    }


}
