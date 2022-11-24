package org.example.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {

    static List<String> menuOptions;

    public Menu() {

    }

    static {
        menuOptions = new ArrayList<>(Arrays.asList("1. show all writers", "2. show a writer by name",
                "3. delete writer", "4. show writer songs", "5. show all songs",
                "6. show a song by name", "7. delete song", "8. show songwriter"));
    }

     void showMenu(){
        menuOptions.forEach(System.out::println);
    }

}
