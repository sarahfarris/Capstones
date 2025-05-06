import java.util.ArrayList;
import java.util.List;

public class Soccer_Tournament {
    String name;
    private List<Team> teams;
    private Team winner;

    public Soccer_Tournament(String name, List<Team> teams) {
        this.name = name;
        this.teams = teams;
    }
  public void startTournament() {
      while(winner == null){
          Round r = createRound(teams);
          teams = r.playRound();
          if(teams.size() == 1) {
              winner = teams.getFirst();
          }
      }
      System.out.println("The winner is: " + winner.getTeamName());
  }
  public Round createRound(List<Team> teams) {
        List<Match> matches = new ArrayList<>();
        //create matches
      for(int i = 0; i <teams.size(); i = i + 2) {
            Match match = new Match(teams.get(i), teams.get(i + 1));
            matches.add(match);
      }
      return new Round(matches); //why, add them to the round
  }
}
