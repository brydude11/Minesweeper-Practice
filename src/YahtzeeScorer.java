import java.util.*;

public class YahtzeeScorer {
    int[] dice;
    int[] scores = new int[]{0 ,0, 0, 0};

    public YahtzeeScorer(int[] rolled){
        dice = rolled;
    }

    public boolean contains(int number, int amount){
        int counter = 0;
        for (int j = 0; j < dice.length; j++){
            if (dice[j] == number) counter++;
        }
        if (amount <= counter) return true;
        else return false;
    }

    public boolean isYahtzee(){
        if (scores[0] != 0) return false;
        for (int i = 0; i < dice.length - 1; i++){
            if (contains( i, 5)) return true;
        }
        return false;
    }

    public void setYahtzee(){
        scores[0] = 50;
    }


    public boolean isLongStraight(){
        if (scores[1] != 0) return false;
        if (contains(1, 1)){
            for (int i = 2; i < 6; i++){
                if(!contains(i , 1)) return false;
            }
            scores[1] = 35;
            return true;
        }
        else if (contains(2, 1)){
            for (int i = 3; i < 7; i++){
                if(!contains(i, 1)) return false;
            }
            scores[1] = 35;
            return true;
        }
        else return false;
    }

    public void setLongStraight(){
        scores[1] = 35;
    }

    public boolean isThreeOfAKind(){
        if (scores[2] != 0) return false;
        for (int i = 0; i < dice.length; i++){
            if (contains(i, 3)) return true;
        }
        return false;
    }

    public void setThreeOfAKind(){
        int toAdd = 0;
        for (int i = 0; i < dice.length; i ++){
            toAdd += dice[i];
        }
        scores[2] = toAdd;
    }

    public boolean isFullHouse(){
        if (scores[3] != 0) return false;
        for (int i = 0; i < 6; i ++){
            if (contains(i, 3)){
                for (int j = 0; j < 6; j ++){
                    if (j != i) {
                        if (contains(j, 2)) return true;
                    }
                }
            }
        }
        return false;
    }

    public void setFullHouse(){
        scores[3] = 25;
    }


    public int returnScore(){
        int toReturn = 0;
        for (int i = 0; i < scores.length; i++){
            toReturn += scores[i];
        }
        return toReturn;
    }
}
