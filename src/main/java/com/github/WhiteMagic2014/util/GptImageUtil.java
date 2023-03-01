package com.github.WhiteMagic2014.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description: util for image
 * @author: magic chen
 * @date: 2023/3/1 10:00
 **/
public class GptImageUtil {


    /**
     * Verify that the image is less than 4mb
     *
     * @param image
     * @return
     */
    public static Boolean validateSize(File image) {
        if (image.length() <= 4 * 1024 * 1024) {
            return true;
        }
        return false;
    }


    /**
     * Verify that the image is a png file
     *
     * @param image
     * @return
     */
    public static Boolean validatePng(File image) {
        byte[] header = new byte[8];
        try (FileInputStream inputStream = new FileInputStream(image)) {
            if (inputStream.read(header) == 8) {
                if (header[0] == (byte) 0x89 &&
                        header[1] == (byte) 0x50 &&
                        header[2] == (byte) 0x4E &&
                        header[3] == (byte) 0x47 &&
                        header[4] == (byte) 0x0D &&
                        header[5] == (byte) 0x0A &&
                        header[6] == (byte) 0x1A &&
                        header[7] == (byte) 0x0A) {
                    return true;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }

    /**
     * Verify that the image is square
     *
     * @param image
     * @return
     */
    public static Boolean validateSquare(File image) {
        try {
            BufferedImage bufferedImage = ImageIO.read(image);
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            return width == height;
        } catch (IOException e) {
            return false;
        }
    }


    /**
     * Verify that the mask have the same dimensions as image
     *
     * @param image
     * @param mask
     * @return
     */
    public static Boolean validateMaskDimensions(File image, File mask) {
        try {
            BufferedImage bufferedImage = ImageIO.read(image);
            BufferedImage bufferedMask = ImageIO.read(mask);
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            return (width == height) && (width == bufferedMask.getWidth());
        } catch (IOException e) {
            return false;
        }
    }

}
