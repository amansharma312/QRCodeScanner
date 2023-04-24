import jssc.SerialPort;
import jssc.SerialPortException;

public class QRCodeScanner {
    public static void main(String[] args) {
        // Connect to serial port
        String portName = "";
        SerialPort serialPort = new SerialPort(portName);
        
        try {
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
        } catch (SerialPortException e) {
            System.out.println("Error opening serial port: " + e.getMessage());
            return;
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Scanner initialization interrupted: " + e.getMessage());
            return;
        }
        try {
            while (true) {
                if (serialPort.getInputBufferBytesCount() > 0) {
                    byte[] buffer = serialPort.readBytes();
                    String barcode = new String(buffer);
                    System.out.println("Scanned barcode: " + barcode);
                }
            }
        } catch (SerialPortException e) {
            System.out.println("Error reading from serial port: " + e.getMessage());
        }
    }
}


