package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Process {
    Scanner x = new Scanner (System.in);
    Scanner input = new Scanner (new File("Data.txt"));//Access the data file
    String inputFromUser;//The input from user
    String encryptedOutputString="";//The output encrypted string
    String decryptedOutputString="";//The output decrypted string
    Process() throws FileNotFoundException
    {
    }
    void encrypt() throws FileNotFoundException, IOException
    {
        System.out.println("Enter the Plain text :");
        inputFromUser = x.nextLine();//The pain text from user with space handel
        FileInputStream fIn = new FileInputStream("Data.txt");//The data file
        BufferedReader reader = new BufferedReader(new InputStreamReader(fIn));//Read from the data file
        this.encryptedOutputString = encrOrDecrypt(fIn, reader, inputFromUser, false);//The encryption case
        System.out.print(this.encryptedOutputString);//Print the encrypted text
    }
    void decrypt() throws FileNotFoundException, IOException
    {
        System.out.println("Enter the Cypher text :");
        inputFromUser = x.nextLine();//The cypher text from user with space handel
        FileInputStream fIn = new FileInputStream("Data.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fIn));
        this.decryptedOutputString = encrOrDecrypt(fIn, reader, inputFromUser, true);//The decryption case
        System.out.print(this.decryptedOutputString);//Print the decrypted text
    }
    private String encrOrDecrypt(FileInputStream fIn, BufferedReader reader, String inputFromUser, Boolean type) throws IOException {//The main processing function
        short from=0, to=2;//file-> |(Something<0>) (,<1>) (Something<2>)|
        //If type == false then -> encrypt, else decrypt
        if(type){//True -> decrypt
            from=2;
            to=0;
        }
        String line="", outputString="";//Line -> The reading step from file
        for(int i = 0; i< inputFromUser.length(); i++)
        {
            while((line = reader.readLine())!=null)//Not reached till the end in the file
            {
                if(inputFromUser.charAt(i) - (line.charAt(from)) == 0)//Problem in Java compiler to equal the two sides | it means that the chosen character from the message equals the same character in the file
                {
                    outputString += line.charAt(to);//Add the equivalent character from the file
                    fIn.getChannel().position(0);//Because the file can't return to the 1st line again
                    reader = new BufferedReader(new InputStreamReader(fIn));//Because the file can't return to the 1st line again
                    break;//Search for the next character
                }
            }
        }
        return outputString;
    }
}
