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
        int temp2 = temp;
        while (temp2 != 0){
            temp %= 2;
            if(temp != 0)
                binaryNumber += "1";
            else
                binaryNumber += "0";
            temp2 /=2;
            temp = temp2;
        }
        reverseString();
    }
    private void reverseString(){
        StringBuilder tempString = new StringBuilder();
        tempString.append(binaryNumber);
        tempString.reverse();
        for (int i=0; i < tempString.length(); i++)
            binaryNumber += tempString.charAt(i);
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
