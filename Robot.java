package Robot_Fight;

import java.util.HashMap;
import java.util.Random;

public class Robot {

    private String robot_name;
    private int robot_health = 100;
    private int damage = 20;
    private String alphabet = "QWEASDZXC";
    int numberOfFightButtons = 5;



    public Robot(String robot_name) {
        this.robot_name = robot_name;
    }

    public String getRobot_name() {
        return robot_name;
    }

    public void setRobot_name(String robot_name) {
        this.robot_name = robot_name;
    }

    public int getRobot_health() {
        return robot_health;
    }

    public void setRobot_health(int robot_health) {
        this.robot_health = robot_health;
    }

    public void setDamage(int robot_health) {
        this.robot_health = (robot_health - damage);
    }

    char getRandomKey() {
        int randIdx = new Random().nextInt(alphabet.length());
        char randChar = alphabet.charAt(randIdx);
        alphabet = alphabet.replace(String.valueOf(randChar), "");
        return randChar;
    }

    public HashMap fightButtons() {
        HashMap<Character, Integer> fightButtons = new HashMap<>();
        for (int i = 0; i < numberOfFightButtons; i++) {
            fightButtons.put(getRandomKey(), 1);
        }
        return fightButtons;
    }

    public HashMap notFightButtons() {
        HashMap<Character, Integer> notFightButtons = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            notFightButtons.put(alphabet.toCharArray()[i], 2);
        }
        return notFightButtons;
    }

    HashMap<Character, Integer> fightHash = fightButtons();

    HashMap<Character, Integer> notFightHash = notFightButtons();

    HashMap<Character, Integer> usedButtons = new HashMap<>();
}
