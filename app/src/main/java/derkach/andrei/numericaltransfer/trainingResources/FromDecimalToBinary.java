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
        decimalNumber = 66;
        binaryNumber = "";
    }

    /**перевід числа із десяткової системи числення у двійкову*/
    public void convertToBinary(){

        int temp = decimalNumber;
        int temp2 = temp;

        /*переводимо число*/
        while (temp2 != 0){
            temp %= 2;
            if(temp != 0)
                binaryNumber += "1";
            else
                binaryNumber += "0";
            temp2 /=2;
            temp = temp2;
        }

        /*перевертаємо рядок*/
        reverseString();
    }

    /**переворіт рядка для того щоб відобразити правильне число*/
    private void reverseString(){
        /*є вбудований метод перевороту рядка*/
        StringBuilder tempString = new StringBuilder();

        tempString.append(binaryNumber);
        tempString.reverse();

        binaryNumber = "";

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
