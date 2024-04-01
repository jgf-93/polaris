package com.polaris.common.demo.File;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class TSSS {
    static int h,w;
    public static void main(String[] args)throws Exception {
        String filename ="C:\\Users\\xiaojiang\\Desktop\\装修文件夹\\dc246c8d730ded9c17c101ec1e599c4.jpg";// separator是File里的一个常量,由于java历史遗留问题故为小写
        File file = new File(filename);
        BufferedImage bi = ImageIO.read(file);
        // 获取当前图片的高,宽,ARGB
        h = bi.getHeight();
        w = bi.getWidth();
        int arr[][] = new int[w][h];
        BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);//  构造一个类型为预定义图像类型之一的 BufferedImage，
        // 获取图片每一像素点的灰度值
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                // getRGB()返回默认的RGB颜色模型(十进制)
                boolean is_Blue = isBlueAvg(i,j,bi);//该点的灰度值
                //int hui=Integer.parseInt(Integer.toHexString(bi.getRGB(i, j)),16);
                if(is_Blue){
                    int white = new Color(255, 255, 255,255).getRGB();
                    bufferedImage.setRGB(i, j, white);
                }
                else{
                    bufferedImage.setRGB(i, j, bi.getRGB(i, j));
                }
            }

        }
        ImageIO.write(bufferedImage, "jpg", new File("\"C:\\\\Users\\\\xiaojiang\\\\Desktop\\\\装修文件夹\\\\dc246c8d730ded9c17c101ec1e599c41.jpg\""));
    }
    private static boolean isBlueAvg(int i,int j,BufferedImage bi) {
        boolean result=false;
        int r,g,b;
        String argb = Integer.toHexString(bi.getRGB(i,j));// 将十进制的颜色值转为十六进制
        // argb分别代表透明,红,绿,蓝 分别占16进制2位
        r= Integer.parseInt(argb.substring(2, 4),16);
        g =Integer.parseInt(argb.substring(4, 6),16);
        b= Integer.parseInt(argb.substring(6, 8),16);
        if(Math.abs(r-25)<=30&&Math.abs(g-112)<=30&&Math.abs(b-196)<=30){
            result=true;
        }
        return result;
    }
}
