import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // skip players
    // create 8 teams
    // put this in a main class
    Team team1 = new Team("team 1");
    Team team2 = new Team("team 2");
    Team team3 = new Team("team 3");
    Team team4 = new Team("team 4");
    Team team5 = new Team("team 5");
    Team team6 = new Team("team 6");
    Team team7 = new Team("team 7");
    Team team8 = new Team("team 8");
    // create a list of teams
    // initialize teams into a list:
    List<Team> teamList =
        new ArrayList<>(Arrays.asList(team1, team2, team3, team4, team5, team6, team7, team8));
    Soccer_Tournament tournament = new Soccer_Tournament("Final Game", teamList);
    tournament.startTournament();
  }
}
