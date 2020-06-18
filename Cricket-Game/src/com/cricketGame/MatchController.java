package com.cricketGame;

import java.util.Arrays;
import java.util.Random;

public class MatchController {
  public enum TeamName{The_Sons_of_Pitches,Bloodbath_and_Beyond,The_Master_Batter,Ball_Busters;}
  String Team1;
  String Team2;
  private static MatchController matchController = null;
  public static MatchController get_instance()
  {
      if(matchController == null)
          matchController = new MatchController();
      return matchController;
  }
  public void getTeam()
  {
      Random rand = new Random();
      int t1 = rand.nextInt(TeamName.values().length);
      int t2;

      while(true)
      {
          t2 = rand.nextInt(TeamName.values().length);
          if (t2==t1)
              continue;
          else
              break;
      }

      Team1 = TeamName.values()[t1].name();
      Team2 = TeamName.values()[t2].name();
      String TosswinTean = Toss.TossWon(Team1,Team2);
      String player[];
      String winningTeam;
      Inning.setover(6);
      if (TosswinTean.equals(Team1)) {
          player = Player.playerName(Team1, Team2);
          String result = Toss.TossForbat(Team1);
          System.out.println("======================================================");
          System.out.println(Team1 + " won the toss and opted " + " " + result );
          System.out.println("======================================================");
          System.out.println("============Match Started=============================");
          if(result.equals("Batting"))
              Inning.matchStart(Team1, Arrays.copyOfRange(player,0,(player.length)/2));
          else
              Inning.matchStart(Team2, Arrays.copyOfRange(player,((player.length)/2),(player.length)));
      }
      else {
          player = Player.playerName(Team2, Team1);
          String result = Toss.TossForbat(Team1);
          System.out.println("======================================================");
          System.out.println(Team1 + " won the toss and opted " + " " + result );
          System.out.println("======================================================");
          System.out.println("============Match Started=============================");
          System.out.println("======================================================");
          if(result.equals("batting"))
              Inning.matchStart(Team2, Arrays.copyOfRange(player,0,(player.length)/2));
          else
              Inning.matchStart(Team1, Arrays.copyOfRange(player,((player.length)/2),(player.length)));

      }
      ScoreBoard.getFinalScore();

  }

    public static void main(String[] args) {
        MatchController m1 = get_instance();
        m1.getTeam();
        System.out.println(m1.Team1);
        System.out.println(m1.Team2);
    }
}
