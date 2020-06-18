package com.cricketGame;
import java.util.Random;


public class Toss {

    public static String TossWon(String Team1,String Team2)
    {
        Random rand = new Random();
        int rand_no = rand.nextInt(2);
        if (rand_no == 0)
            return Team1;
        else
            return Team2;
    }
    public static String TossForbat(String Team)
    {
        Random rand = new Random();
        int rand_no = rand.nextInt(2);
        if (rand_no == 0)
            return "Batting";
        else
            return "Bowling";
    }
}
