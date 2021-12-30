package Fall2021;

import java.util.*;

public class Main {
    static Timer timer;
    static int interval;
    static String winner;

    public static void main(String[] args) {

        lottery();
    }
    public static void lottery(){

        int numberOfParticipants=0;
        Map<Integer, String> nameList = new HashMap<>();
        int rank = 1;

        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your name");
            String name = scan.nextLine();
            if (name.trim().equalsIgnoreCase("Get the winner")) {
                break;
            } else {

                if (!nameList.containsValue(name)) {

                    nameList.put(rank, name);
                    rank++;
                    numberOfParticipants++;

                } else {
                    System.out.println("You have already joined the lottery");
                }
            }
        } while (true);

        int random = (int) Math.floor(Math.random() * (numberOfParticipants + 1));
        winner = nameList.get(random);

        timer();
    }

    public static void timer() {

        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = 10;
        System.out.println(10);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                if (interval ==1){
                    timer.cancel();
                    System.out.println("The winner is "+winner);
                }

                System.out.println(--interval);
            }
        }, delay, period);
    }
}




