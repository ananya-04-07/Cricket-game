package com.cricketGame;

import java.util.Random;

public class Inning {
    static int over;


    public static void setover(int over1)
    {
        over = over1;
    }


    public static void matchStart(String Team1, String[] player)
    {
        String opener1 = player[0];
        String opener2 = player[1];
        int j = 2;
        Random rand = new Random();
        int totalrun = over*6;
        int wicket = 0;
        String temp;
        String temp2;
        System.out.println("========================================================");
        System.out.println("============ "+ Team1 + " ready for batting ========");
        System.out.println("========================================================");
        System.out.println("============ " + opener1 + " " + opener2 + " is on pitch==");
        ScoreBoard.insertData(opener1);
        ScoreBoard.insertData(opener2);
        for(int i = 1;i<=totalrun;i++)
        {
            System.out.println("========================================================");
            System.out.println("========= "+opener1 + " is on strike ===============");
            int run = rand.nextInt(8);
            if(run == 7)
            {
                System.out.println("================================================");
                System.out.println("==============" + opener1 + " OUT! =========================");
                wicket = wicket + 1;
                ScoreBoard.displayScore(opener1,"");
                opener1 = opener2;
                System.out.println("================================================");
                if(wicket == (player.length)-1)
                    break;
                opener2 = player[wicket+1];
                ScoreBoard.insertData(opener2);
                System.out.println("============== " + opener2 + " =================");


            }
            else if(run == 0 || run == 2 || run == 4 || run == 6) {
                System.out.println("======"+opener1 + " hits "+run+ " runs");
                opener1 = opener1;
                ScoreBoard.runcount(opener1,run);
            }
            else if (run == 1 || run == 3 || run == 5) {
                ScoreBoard.runcount(opener1,run);
                System.out.println("======"+opener1 + " hits "+run+ " runs");
                temp = opener1;
                opener1 = opener2;
                opener2 = temp;

            }
            if(i%6 == 0){
                temp2 = opener1;
                opener1 = opener2;
                opener2 = temp2;
                System.out.println("=====" + i/6 + " over completed ================");
                ScoreBoard.displayScore(opener1,opener2);
            }


        }
    }



}
