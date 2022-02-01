import java.io.*;
import java.util.Scanner;

public class Week04 {
    
    public void tutQuestion01(){
        double weightMetric, heightMetric;

        try{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter weight in pounds: ");
            weightMetric = input.nextDouble();

            System.out.print("Enter height in inches: ");
            heightMetric = input.nextDouble();
            input.close();
        }
        catch(Exception e){
            //Too lazy to implement error handling
            System.out.print("Error: Invalid input...");
            return;
        }

        BMI bmi = new BMI(weightMetric, heightMetric);

        System.out.println("BMI is " + bmi.getBMI());
        System.out.println(bmi.getBMIRange());
    }
    public void tutQuestion02() throws Exception{
        StackOfIntegers stack = new StackOfIntegers();

        for(int i = 0; i < 10; i++)
            stack.push(i);
        while(!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    public void tutChallengeQuestion() throws Exception{
        this.tutChallengeQuestion("GTC", getDynamicPath() + "\\data\\input.txt");
    }
    public void tutChallengeQuestion(String inputTargetSequence, String inputFilePath) throws Exception{
        int matchCounter = 0, currentCase = 0;
        char[] targetSequenceArr = inputTargetSequence.toCharArray();

        FileInputStream dataFileStream = null;
        Scanner dataFileScanner = null;
        try{
            dataFileStream = new FileInputStream(inputFilePath);
            dataFileScanner = new Scanner(dataFileStream, "UTF-8");
            while (dataFileScanner.hasNextLine()) {
                String line = dataFileScanner.nextLine();
                for(char c : line.toCharArray()){
                    if(currentCase > 0){
                        if(c == targetSequenceArr[currentCase]){
                            currentCase++;
                            if(currentCase == targetSequenceArr.length){
                                currentCase = 0;
                                matchCounter++;
                            }
                        }
                        else currentCase = 0;
                    }
                    if(currentCase == 0 && c == targetSequenceArr[0]) currentCase++;
                }
            }
        }
        catch(Exception e){
            //Ah Scheiße... Ich bin zu faul, um damit umzugehen
            throw e;
        }
        finally{
            if(dataFileStream != null) dataFileStream.close();
            if(dataFileScanner != null) dataFileScanner.close();
        }
        
        System.out.println("sequence \"GTC\" appeared " + matchCounter + " times");
    }
    
    //Acquire runtime directory
    private String getDynamicPath(){
        File dynamicDir = new File("");
        String localDir = dynamicDir.getAbsolutePath();
        return localDir;
    }
    
    //How to utilize stack
    public void tutBracketChecker(String inputData){
        boolean inputDataValidity = false;

        char[] inputDataChar = inputData.toCharArray();
        StackOfIntegers stack = new StackOfIntegers();
        try{
            for(int i = 0; i < inputDataChar.length; i++){
                int currentChar = charDictionary(inputDataChar[i]);
                if(currentChar == 0){
                    System.out.println("Invalid character...");
                    return;
                }
                else if(stack.empty())
                    stack.push(currentChar);
                else if(stack.peek() == currentChar - 1)
                    stack.pop();
                else
                    stack.push(currentChar);
            }
        }
        catch(Exception e){
        }
        inputDataValidity = stack.empty();

        System.out.println("Input is " + ((inputDataValidity)? "valid": "not valid"));
    }
    private int charDictionary(char inputChar){
        switch(inputChar){
            case '(': return 1;
            case ')': return 2;
            case '{': return 3;
            case '}': return 4;
            case '[': return 5;
            case ']': return 6;
            default: return 0;
        }
    }
}