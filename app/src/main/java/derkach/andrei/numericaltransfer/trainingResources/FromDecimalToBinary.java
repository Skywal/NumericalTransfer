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
    /**верхня межа рандомного числа*/
    int bound;

    public FromDecimalToBinary(int bound){
        this.bound = bound;
        decimalNumber = Shared.random.nextInt(bound);
        binaryNumber = "";
    }

    /**перевід числа із десяткової системи числення у двійкову*/
    public void convertToBinary(){
        /*дробова частина числа*/
        int fractionalPartOfNum = decimalNumber;
        /*ціла частина числа*/
        int wholeOfNum = fractionalPartOfNum;
        /*витираємо рядок*/
        binaryNumber = "";

        /*переводимо число*/
        while (wholeOfNum != 0){
            fractionalPartOfNum %= 2;
            if(fractionalPartOfNum != 0)
                binaryNumber += "1";
            else
                binaryNumber += "0";
            wholeOfNum /=2;
            fractionalPartOfNum = wholeOfNum;
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
    /**просування по числах*/
    public void nextRandomNumber(){
        decimalNumber = Shared.random.nextInt(bound);
    }
    /**перевірка на правильність відповіді*/
    public boolean isRightAnswer(String answer) {
        if (binaryNumber.equals(answer))
            return true;
        else
        return false;
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
