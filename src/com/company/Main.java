package com.company;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Process P = new Process();
        P.encrypt();
        System.out.println();
        P.decrypt();
    }
    
}