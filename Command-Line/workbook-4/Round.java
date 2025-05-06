import java.util.ArrayList;
import java.util.List;

public class Round {
    private List<Match> matches;
    List<Team> roundWinners = new ArrayList<>();

    public Round(List<Match> matches) {
        this.matches = matches;
    }
    public Round(){
        //leave empty
    }

    //declaration and initialization
//private List<Match> matches = new ArrayList<>();

public List<Team> playRound() {
    //create a method where you implement to play all matches in a round
    //What happens in a round? matches are played and a winner wins a round
    //winner of the round goes to the tournament
    System.out.println("Starting Round");
    for(Match match: matches) {
        roundWinners.add(match.playMatch());
    }
    System.out.println("Round complete");
    return roundWinners;
}
}

