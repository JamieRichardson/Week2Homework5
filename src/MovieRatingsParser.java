/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.*;

public class MovieRatingsParser {

    public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
        TreeMap<String, PriorityQueue<Integer>> returnTree = new TreeMap<>();
        if (allUsersRatings == null || allUsersRatings.isEmpty()) {
            return returnTree;
        }
        for (UserMovieRating movie : allUsersRatings) {
            if (movie == null || movie.getMovie() == null || movie.getMovie().isEmpty() || movie.getUserRating() < 0) {
                continue;
            }
            String movieName = movie.getMovie().toLowerCase();
            if (!returnTree.containsKey(movieName)) {
                PriorityQueue<Integer> tempQue = new PriorityQueue<>();
                tempQue.add(movie.getUserRating());
                returnTree.put(movieName, tempQue);
            } else {
                PriorityQueue<Integer> queueToAddTo = returnTree.get(movieName);
                queueToAddTo.add(movie.getUserRating());
            }
        }
        return returnTree;
    }
}