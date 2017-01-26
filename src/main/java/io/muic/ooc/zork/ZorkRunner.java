package io.muic.ooc.zork;

import io.muic.ooc.zork.ZorkGame;

import java.util.Scanner;

/**
 * This is the main class.
 *
 * @author gigadot
 */
public class ZorkRunner {

    public static void main(String[] args) {
        ZorkGame zorkGame = new ZorkGame();
        zorkGame.start();
    }

}
