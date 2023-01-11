package Robot_Fight;


public class MenuRobot extends Menu {
    public static void printMenu(Robot currentRobot) {
        System.out.println("");
        System.out.println("For exit press P");
        System.out.println("A shot at the robot: " + currentRobot.getRobot_name());
        System.out.println("Your step: press key (QWEASDZXC)");
    }

    public static void printCurrentHealth(Robot robot1, Robot robot2) {
        System.out.println("-------------");
        System.out.println(robot1.getRobot_name() + " , " + robot1.getRobot_health());
        System.out.println(robot2.getRobot_name() + " , " + robot2.getRobot_health());
        System.out.println("-------------");
    }

    public static boolean checkCurrentButton(Character currentButton) {
        String alphabet = "QWEASDZXC";
        if (alphabet.indexOf(currentButton) >= 0) {
            return false;
        } else
        return true;
    }

    public static void printFinalResult(Robot current, Robot second) {
        Robot temp = null;
        Robot temp2 = null;
        if (current.getRobot_health() == 0){
            temp = current;
            temp2 = second;
        }else{
            temp = second;
            temp2 = current;
        }
        System.out.println(temp.getRobot_name() + " was killed");
        System.out.println(temp.getRobot_name() + " Win!!!");
    }

}




