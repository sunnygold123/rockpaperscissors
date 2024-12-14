import java.util.Random;


public class SixthDharmapuramSaathvik implements Player {
    private static String name = "SixthDharmapuramSaathvik";
    private static String strategy = "Rock then all Scissors";

    
    public String move(String[] myMoves, String[] opponentMoves, int myScore, int opponentScore) {
        if (myMoves.length == 0) {
            return "s"; 
        } else {
            return "r"; 
        }
    }

    
    public String getName() {
        return name;
    }

    
    public String getStrategy() {
        return strategy;
    }

    // Main method for testing
    public static void main(String[] args) {
        SixthDharmapuramSaathvik player = new SixthDharmapuramSaathvik();
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};

        
        String[] myMoves = {};
        String[] opponentMoves = {};
        int myScore = 0;
        int opponentScore = 0;

        System.out.println("Player: " + player.getName());
        System.out.println("Strategy: " + player.getStrategy());

        
        for (int i = 0; i <= 100; i++) {
            String myMove = player.move(myMoves, opponentMoves, myScore, opponentScore);
            String opponentMove = moves[random.nextInt(3)]; 
            
            System.out.println("Round " + (i + 1) + ":");
            System.out.println("  Your move: " + convertMove(myMove));
            System.out.println("  Opponent move: " + opponentMove);

           
            myMoves = appendMove(myMoves, convertMove(myMove));
            opponentMoves = appendMove(opponentMoves, opponentMove);

            
            int result = compareMoves(convertMove(myMove), opponentMove);
            if (result == 1) {
                myScore++;
                System.out.println("  You win this round!");
            } else if (result == -1) {
                opponentScore++;
                System.out.println("  You lose this round!");
            } else {
                System.out.println("  It's a tie!");
            }

            System.out.println("  Current Score: You: " + myScore + " | Opponent: " + opponentScore);
            System.out.println();
        }

        
        System.out.println("Final Score: You: " + myScore + " | Opponent: " + opponentScore);
    }

    
    private static String convertMove(String move) {
        switch (move) {
            case "r":
                return "Rock";
            case "p":
                return "Paper";
            case "s":
                return "Scissors";
            default:
                return "Invalid";
        }
    }

    
    private static int compareMoves(String myMove, String opponentMove) {
        if (myMove.equals(opponentMove)) {
            return 0; // Tie
        } else if ((myMove.equals("Rock") && opponentMove.equals("Scissors")) ||
                   (myMove.equals("Paper") && opponentMove.equals("Rock")) ||
                   (myMove.equals("Scissors") && opponentMove.equals("Paper"))) {
            return 1; 
        } else {
            return -1; 
        }
    }

    
    private static String[] appendMove(String[] moves, String newMove) {
        String[] updatedMoves = new String[moves.length + 1];
        System.arraycopy(moves, 0, updatedMoves, 0, moves.length);
        updatedMoves[moves.length] = newMove;
        return updatedMoves;
    }
}
