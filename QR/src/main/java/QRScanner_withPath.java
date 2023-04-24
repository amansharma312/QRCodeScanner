/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aman
 */
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import java.awt.image.BufferedImage;

public class QRScanner_withPath {
    public static void main(String[] args) {
        //File Load
        File file = new File("qr1.png");
        try {
            BufferedImage image = ImageIO.read(file);

            BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            // Decode QR code from image
            QRCodeReader reader = new QRCodeReader();
            try {
                Result result = reader.decode(bitmap);
                System.out.println("QR code content: " + result.getText());
            } catch (NotFoundException e) {
                System.out.println("QR code not found");
            } catch (ChecksumException | FormatException e) {
                System.out.println("QR code format error");
            }
        } catch (IOException e) {
            System.out.println("Error loading image file: " + e.getMessage());
        }
    }
}