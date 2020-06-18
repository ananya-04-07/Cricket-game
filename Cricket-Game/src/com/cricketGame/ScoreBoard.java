package com.cricketGame;
import java.lang.reflect.Array;
import java.util.*;


public class ScoreBoard {
    static HashMap<String, Integer> score = new HashMap<String, Integer>();
    public static void runcount(String player, int run)
    {
        if(score.containsKey(player))
        {
            int Run  = score.get(player);
            Run = Run + run;
            score.put(player,Run);
        }
        else
            score.put(player,run);
    }
    public static void displayScore(String player1, String player2)
    {
            if(player2.equals("")) {
                System.out.println("===========================================");
                System.out.print("=========Final Score of " + player1 + "======>  ");
                System.out.println(score.get(player1));
            }
            else
            {
                System.out.println("===========================================");
                System.out.print("========= Score of " + player1 + " after over ======>  ");
                System.out.println(score.get(player1));
                System.out.print("========= Score of " + player2 + " after over ======>  ");
                System.out.println(score.get(player2));
            }
    }
    public static void insertData(String player1)
    {
        score.put(player1,0);
    }
    public static void getFinalScore()
    {
        int sum = 0;
        for (int f : score.values()) {
            sum += f;
        }
        System.out.println("total run of the team   "+ sum);

    }
}
