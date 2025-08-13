public class Chifoumi {
    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
        return switch (chifoumiAction) {
            case ROCK -> ChifoumiAction.SCISSOR;
            case PAPER -> ChifoumiAction.ROCK;
            case SCISSOR -> ChifoumiAction.PAPER;
        };
    }
}

//Chifoumi (French for "Rock–Paper–Scissors"