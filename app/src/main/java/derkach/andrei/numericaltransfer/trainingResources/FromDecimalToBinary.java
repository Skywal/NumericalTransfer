package derkach.andrei.numericaltransfer.trainingResources;

/**
 * Created by Bloom on 27.05.2017.
 * клас для переводу чисел із десяткової системи числення у двійкову
 */

public class FromDecimalToBinary {
    /**Десяткове число*/
    private int decimalNumber;
    /**двійкове число*/
    private String binaryNumber;

    public FromDecimalToBinary(){
        decimalNumber = 37;
        binaryNumber = "";
    }

    public void convertToBinary(int dec){
        int temp = dec;
        while (temp != 0){
            temp /= 2;
        }
    }

    public void setDecimalNumber(int decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public int getDecimalNumber() {
        return decimalNumber;
    }

    public void setBinaryNumber(String binaryNumber) {
        this.binaryNumber = binaryNumber;
    }

    public String getBinaryNumber() {
        return binaryNumber;
    }
}
