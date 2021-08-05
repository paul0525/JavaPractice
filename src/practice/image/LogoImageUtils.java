package practice.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *  LogoImageUtils.class，替换小程序菊花码中的logo
 */
public class LogoImageUtils {

    /**
     * 替换小程序菊花码中的logo
     * @param path：菊花码
     * @param logoPath logo of path
     * @param savePath  save of path
     * @return  save of path
     */
    public static String replaceLogo( String path, String logoPath,String savePath) {

        try{
            BufferedImage div = getBufferedImag(path);
            BufferedImage tmp = getBufferedImag(logoPath);
            BufferedImage zoomLogo = zoomImage(tmp,200,200);
            BufferedImage logo = setClip(zoomLogo,200);

            int x = div.getHeight()/2 -100;
            int y = div.getWidth()/2 -100;

            Graphics2D graphics2D = div.createGraphics();
            graphics2D.drawImage(logo,x,y,null);

            graphics2D.dispose();

            //保存图片
            int temp = savePath.lastIndexOf(".") + 1;
            File outFile = new File(savePath);
            if(!outFile.exists()){
                outFile.createNewFile();
            }

            ImageIO.write(div, savePath.substring(temp), outFile);

        }catch (Exception e){
            e.printStackTrace();
        }

        return savePath;
    }

    /**
     *  根据图片路径读取图片缓存并返回
     * @param path，path of image
     * @return  bufferedImag
     * @throws IOException
     */
    private static BufferedImage getBufferedImag(String path) throws IOException {
        File file = new File(path);
        return  ImageIO.read(file);
    }

    /**
     * 缩放图片
     * @param bufferedImage
     * @param w：width of image
     * @param h height of image
     * @return  zoom buffered  image
     * @throws IOException
     */
    private static BufferedImage  zoomImage(BufferedImage bufferedImage,int w,int h) throws IOException {


        Image image =  bufferedImage.getScaledInstance( w,h,BufferedImage.SCALE_SMOOTH);

        double wr=w*1.0/bufferedImage.getWidth();
        double hr=h*1.0 / bufferedImage.getHeight();

        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
        BufferedImage result = ato.filter(bufferedImage,null);
        return result;
    }


    /**
     * 图片裁剪
     * @param srcImage
     * @param radius 圆的直径
     * @return
     */
    private static BufferedImage setClip(BufferedImage srcImage, int radius){
        int width = srcImage.getWidth();
        int height = srcImage.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gs = image.createGraphics();

        gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gs.setClip(new RoundRectangle2D.Double(0, 0, width, height, radius, radius));
        gs.drawImage(srcImage, 0, 0, null);
        gs.dispose();
        return image;
    }


    public static void main(String[] args) {

    }


}
