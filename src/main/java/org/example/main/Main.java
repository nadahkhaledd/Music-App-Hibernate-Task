package org.example.main;

import org.example.view.Console;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


        Console console = context.getBean(Console.class);
        console.start();

    }
}
