package com.kylediaz.acsl.what_does_this_program_do_compiler.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    private static String inputFilePath, outputFilePath;
    private static boolean runFile;

    public static void main(String[] args) {
        if (args.length != 2) {
            promptForArgs();
        } else {
            parseArgs(args);
        }

        FileReader inputFile = new FileReader(inputFilePath);
        Scanner scanner = new Scanner(inputFile);
        StringBuilder inputBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            inputBuilder.append(scanner.nextLine());
            inputBuilder.append('\n');
        }
        
    }

    private static void promptForArgs() {
        Scanner stdin = new Scanner(System.in);
        System.out.println("File path:");
        inputFilePath = stdin.nextLine();

        String runFileInput;
        do {
            System.out.println("Run file? [Y/N]");
            runFileInput = stdin.nextLine().toUpperCase();
        } while (!runFileInput.equals("Y") && !runFileInput.equals("N"));
        runFile = runFileInput.equals("Y");

        if (!runFile) {
            System.out.println("Output folder path:");
            outputFilePath = stdin.nextLine();
        }
    }

    private static void parseArgs(String[] args) {
        inputFilePath = args[0];
        runFile = args[0].equals("--run");
        if (!runFile) {
            outputFilePath = args[0];
        }
    }

}
