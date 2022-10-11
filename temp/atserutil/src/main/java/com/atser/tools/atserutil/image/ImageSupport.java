package com.atser.tools.atserutil.image;

import com.atser.tools.atserutil.file.FileSupport;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

/**
 * Created by dropal on 18/08/2017.
 */
public class ImageSupport {

    public static byte[] extractBytes(File imgPath) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(imgPath);
        WritableRaster raster = bufferedImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
        return (data.getData());
    }

    public static BufferedImage convertByteArrayToBufferedImage(byte[] imgdata) throws IOException {
        InputStream in = new ByteArrayInputStream(imgdata);
        BufferedImage bImageFrom = ImageIO.read(in);
        return bImageFrom;
    }

    public static BufferedImage makeImageTransparence(BufferedImage source) throws IOException {
        int color = source.getRGB(0, 0);
        Image imageWithTransparency = makeColorTransparent(source, new Color(color));
        BufferedImage transparentImage = imageToBufferedImage(imageWithTransparency);
        return transparentImage;
    }

    public static void makeImageTransparence(String imgPath, String toFolderPath) throws IOException {
        File in = new File(imgPath);
        BufferedImage source = ImageIO.read(in);
        int color = source.getRGB(0, 0);
        Image imageWithTransparency = makeColorTransparent(source, new Color(color));
        BufferedImage transparentImage = imageToBufferedImage(imageWithTransparency);
        File out = new File(toFolderPath);
        ImageIO.write(transparentImage, "PNG", out);
    }

    /**
     * Convert Image to BufferedImage.
     *
     * @param image Image to be converted to BufferedImage.
     * @return BufferedImage corresponding to provided Image.
     */
    private static BufferedImage imageToBufferedImage(final Image image) {
        final BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return bufferedImage;
    }

    /**
     * Make provided image transparent wherever color matches the provided
     * color.
     *
     * @param im BufferedImage whose color will be made transparent.
     * @param color Color in provided image which will be made transparent.
     * @return Image with transparency applied.
     */
    private static Image makeColorTransparent(final BufferedImage im, final Color color) {
        final ImageFilter filter = new RGBImageFilter() {
            // the color we are looking for (white)... Alpha bits are set to opaque
            public int markerRGB = color.getRGB() | 0xFFFFFFFF;

            public final int filterRGB(final int x, final int y, final int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // nothing to do
                    return rgb;
                }
            }
        };

        final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }

    /**
     * Scalade Image.
     *
     * @param image Image to scale. The type can be Image or BufferedImage.
     * @param max Max with and height value.
     * @return Result BufferedImage object.
     */
    public static BufferedImage scalate(Image image, int max) {
        // Calculate scalation size.
        int width = image.getWidth(null);
        int height = image.getHeight(null);

        double rWidth = 0;
        double rHeight = 0;

        if (width == height) {
            rWidth = max;
            rHeight = max;
        } else if (width > height) {
            rWidth = max;
            rHeight = ((double) height / (double) width) * max;
        } else {
            rHeight = max;
            rWidth = ((double) width / (double) height) * max;
        }

        // Scale image.
        image = image.getScaledInstance((int) rWidth, (int) rHeight, Image.SCALE_SMOOTH);

        // Return buffer image.
        return imageToBuffered(image);
    }

    /**
     * Scalade Image.
     *
     * @param image Image to scale. The type can be Image or BufferedImage.
     * @param width Max width to scale.
     * @param height Max height to scale.
     * @return Result BufferedImage object.
     */
    public static BufferedImage scalate(Image image, int width, int height) {
        // Calculate scalation size.
        int orgWidth = image.getWidth(null);
        int orgHeight = image.getHeight(null);

        double rWidth = width;
        double rHeight = height;

        if (orgWidth > orgHeight) {
            rHeight = ((double) orgHeight / (double) orgWidth) * width;
        } else {
            rWidth = ((double) orgWidth / (double) orgHeight) * height;
        }

        // Scalate image.
        image = image.getScaledInstance((int) rWidth, (int) rHeight, Image.SCALE_SMOOTH);

        // Return buffer image.
        return imageToBuffered(image);
    }

    /**
     * Convert Image object to BufferedImage object.
     *
     * @param image Image object to convert.
     * @return BufferedImage object.
     */
    public static BufferedImage imageToBuffered(Image image) {
        BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(image, 0, 0, null);
        bGr.dispose();
        return bimage;
    }

    /**
    * Rotate image to the left.
    * 
    * @param inImgPath Input image path.
    * @param outImgPath Output image path.
    * @throws Exception 
    */
    public static void rotateImageToLeft(String inImgPath, String outImgPath) throws Exception {
        rotateImage(inImgPath, outImgPath, "LEFT");
    }
    
    /**
     * Rotate image to the right.
     * 
     * @param inImgPath Input image path.
     * @param outImgPath Output image path.
     * @throws Exception 
     */
    public static void rotateImageToRight(String inImgPath, String outImgPath) throws Exception {
        rotateImage(inImgPath, outImgPath, "RIGHT");
    }
    
    /**
     *  Rotate image.
     * 
     * @param inImgPath Input image path.
     * @param outImgPath Output image path.
     * @param side Side or direction to rotate the image.
     */
    public static void rotateImage(String inImgPath, String outImgPath, String side) throws Exception {
        try {
            BufferedImage source = ImageIO.read(new File(inImgPath));
            BufferedImage output = new BufferedImage(source.getHeight(), source.getWidth(), source.getType());

            AffineTransform transform = null;
            if(null == side) {
                throw new Exception("Wrong parameters - Parameter [side] is null.");
            } else switch (side.toUpperCase()) {
                case "LEFT":
                    transform = rotateCounterClockwise90(source);
                    break;
                case "RIGHT":
                    transform = rotateClockwise90(source);
                    break;
                default:
                    throw new Exception("Wrong parameters - Parameter [side] do not have a right format.");
            }
            
            AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
            op.filter(source, output);

            ImageIO.write(output, FileSupport.getFileExtension(outImgPath), new File(outImgPath));
        } catch (IOException ex) {

        }
    }

    /**
     * Rotates clockwise 90 degrees. Uses rotation on center and then translating it to origin.
     * 
     * @param source Image buffered.
     * @return 
     */
    private static AffineTransform rotateClockwise90(BufferedImage source) {
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.PI / 2, source.getWidth() / 2, source.getHeight() / 2);
        double offset = (source.getWidth() - source.getHeight()) / 2;
        transform.translate(offset, offset);
        return transform;
    }

    /**
     * Rotates counter clockwise 90 degrees. Uses rotation on center and then translating it to origin
     * @param source Image buffered.
     * @return 
     */
    private static AffineTransform rotateCounterClockwise90(BufferedImage source) {
        AffineTransform transform = new AffineTransform();
        transform.rotate(-Math.PI / 2, source.getWidth() / 2, source.getHeight() / 2);
        double offset = (source.getWidth() - source.getHeight()) / 2;
        transform.translate(-offset, -offset);
        return transform;
    }

}
