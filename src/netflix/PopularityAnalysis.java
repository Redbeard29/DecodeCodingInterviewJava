package netflix;

import java.util.Arrays;

public class PopularityAnalysis {

    public static boolean isMonotonic(int[] ratings){
        boolean increasing = true;
        boolean decreasing = true;

        for(int x = 0; x < ratings.length - 1; x++){
            if(ratings[x] > ratings[x + 1]){
                increasing = false;
            }
            if(ratings[x] < ratings[x + 1]){
                decreasing = false;
            }
        }
        return (increasing || decreasing);
    }

    public static void main(String args[]){
        int[][] movieRatings = {
            {1, 2, 2, 3},
            {4, 5, 6, 3, 4},
            {8, 8, 7, 6, 5, 4, 4, 1}
        };
        for(int[] movieRating : movieRatings){
            if(!isMonotonic(movieRating)){
                System.out.println("Title score is fluctuating");
            }
            else{
                System.out.println("Title is strictly increasing or decreasing");
            }
        }
    }

}
