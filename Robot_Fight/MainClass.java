package Robot_Fight;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {

        System.out.println("Enter Name of Robot_1:");
        Robot robot_1 = new Robot(MenuRobot.getStringFromConsole());

        System.out.println("Enter Name of Robot_2:");
        Robot robot_2 = new Robot(MenuRobot.getStringFromConsole());

        char currentButton = 0;
        char EXIT_CHAR = 'P';

        ArrayList<Robot> robots = new ArrayList<>();
        robots.add(robot_1);
        robots.add(robot_2);

        Robot currentRobot = null;
        Robot secondRobot = null;

        outerloop:
        do {
            for (int i = 0; i < robots.size(); i++) {
                currentRobot = robots.get(i);
                if (currentRobot == robot_1) {
                    secondRobot = robot_2;
                } else {
                    secondRobot = robot_1;
                }
                MenuRobot.printMenu(secondRobot);
                currentButton = Menu.getCharFromConsole();
                System.out.println(currentButton);
                if (currentButton == EXIT_CHAR) {
                    System.out.println("GoodBye");
                    break outerloop;
                } else if (MenuRobot.checkCurrentButton(currentButton)) {
                    while (MenuRobot.checkCurrentButton(currentButton)) {
                        System.out.println(currentButton + " - wrong enters. Use only key from QWEASDZXC keys!");
                        currentButton = Menu.getCharFromConsole();
                    }
                }
                if (currentRobot.fightHash.containsKey(currentButton)) {
                    currentRobot.setDamage(currentRobot.getRobot_health());
                    System.out.println("Babah. Nice shot! " + secondRobot.getRobot_name() + " lost 20 points of the health! :)");
                    currentRobot.usedButtons.put(currentButton, 0);
                    currentRobot.fightHash.remove(currentButton);
                } else if (currentRobot.notFightHash.containsKey(currentButton)) {
                    System.out.println("Bad Shot! No damage :(");
                } else if (currentRobot.usedButtons.containsKey(currentButton)) {
                    System.out.println("Key is already used -_-");
                }
                if (currentRobot.getRobot_health() == 0) {
                    break;
                }
            }
            MenuRobot.printCurrentHealth(robot_1, robot_2);
        } while (currentRobot.getRobot_health() != 0);
        if(currentRobot.getRobot_health() == 0) {
            System.out.println(currentRobot.getRobot_name() + " was killed");
            System.out.println(secondRobot.getRobot_name() + " Win!!! With " + secondRobot.getRobot_health() + " points of health");
        }
    }
}
