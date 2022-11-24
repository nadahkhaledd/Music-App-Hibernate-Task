package org.example.view.utility;

import org.example.model.Song;
import org.example.model.Writer;

import java.util.Scanner;

public class Utils {
    Scanner scanner = new Scanner(System.in);

    public String getStringInput(String message){
        System.out.println(message);
        String input = scanner.nextLine();
        return input;
    }

    public int getIntInput(String message){
        System.out.println(message);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }


}
