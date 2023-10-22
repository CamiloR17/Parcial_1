package src;

import src.singleton.Menu;

public class main {

    private static final Menu menu = Menu.getInstance();
    public static void main(String[] args) {menu.showMenu();}

}
