package com.vpclub.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class QrcodeUtil {




    /**
     *  生成二维码，保存在内存中
     * @param content 内容
     * @param width  图像宽度
     * @param height  图像高度
     */
    public static BufferedImage encodeToBufferedImage(String content, int width, int height) throws WriterException {
        BitMatrix bitMatrix = encode(content, width, height);
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix, new MatrixToImageConfig(Color.BLACK.getRGB(), Color.WHITE.getRGB()));
        return bufferedImage;
    }


    /**
     *  生成二维码，返回base64图片
     * @param content 内容
     * @param width  图像宽度
     * @param height  图像高度
     * @param imgType 图片类型： png、jpg
     */
    public static String encodeToBase64Image(String content, int width, int height, String imgType) throws WriterException, IOException {
        BufferedImage bufferedImage = encodeToBufferedImage(content, width, height);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, imgType, outputStream);
        String base64Img = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(outputStream.toByteArray());
        return base64Img;
    }


    /**
     *  生成二维码，保存在文件中
     * @param content 内容
     * @param width  图像宽度
     * @param height  图像高度
     * @param imgType 图片类型： png、jpg
     */
    public static void encodeToFile(String content, int width, int height, String imgType, File dest) throws WriterException, IOException {
        BitMatrix bitMatrix = encode(content,width,height);
        MatrixToImageWriter.writeToPath(bitMatrix, imgType, dest.toPath());// 输出图像
    }

    /**
     *  生成二维码，保存在流中
     * @param content 内容
     * @param width  图像宽度
     * @param height  图像高度
     * @param imgType 图片类型： png、jpg
     */
    public static void encodeToStream(String content, int width, int height, String imgType, OutputStream stream) throws WriterException, IOException {
        BitMatrix bitMatrix = encode(content,width,height);
        MatrixToImageWriter.writeToStream(bitMatrix, imgType, stream);// 输出图像
    }




    /**
     *
     * @param content 内容
     * @param width  图像宽度
     * @param height  图像高度
     */
    private static BitMatrix encode(String content, int width, int height) throws WriterException {
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
        return bitMatrix;
        //
    }




}
