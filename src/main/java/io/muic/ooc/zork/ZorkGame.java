package io.muic.ooc.zork;

import java.util.Scanner;

/**
 * Created by gigadot on 12-Jan-17.
 */
public class ZorkGame {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        System.out.println("Zork: Hello, I am Mr. Bot.");
        while (!quit) {
            System.out.print("You: ");
            String name = scanner.nextLine();
            quit = name.equals("quit");
            if (!quit) {
                System.out.println("Zork: " + name);
            }
        }
    }
}
