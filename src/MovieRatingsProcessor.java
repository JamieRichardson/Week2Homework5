/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;


public class MovieRatingsProcessor {

    public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
        List<String> alphaMovies = new ArrayList<>();
        if (movieRatings == null || movieRatings.isEmpty()) {
            return alphaMovies;
        }
        for (Object o : movieRatings.entrySet()) {
            Map.Entry movieToAdd = (Map.Entry) o;
            alphaMovies.add(movieToAdd.getKey().toString());
        }
        return alphaMovies;
    }

    public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        List<String> aboveRatingMovies = new ArrayList<>();
        if (movieRatings == null || movieRatings.isEmpty()) {
            return aboveRatingMovies;
        }
        for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
            PriorityQueue<Integer> ratings = entry.getValue();
            if (ratings.peek() > rating) {
                aboveRatingMovies.add(entry.getKey());
            }
        }
        return aboveRatingMovies;
    }

    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        TreeMap<String, Integer> removedRatings = new TreeMap<>();
        if (movieRatings == null || movieRatings.isEmpty()) {
            return removedRatings;
        }
        ArrayList<String> moviesToRemove = new ArrayList<>();
        for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
            PriorityQueue<Integer> preFilter = entry.getValue();
            PriorityQueue<Integer> filteredQueue = new PriorityQueue<>();
            for (Integer rate : preFilter) {
                if (rate < rating) {
                    filteredQueue.add(rate);
                }
            }
            if (preFilter.size() == filteredQueue.size()) {
                moviesToRemove.add(entry.getKey());
            }
            if (!filteredQueue.isEmpty()) {
                removedRatings.put(entry.getKey(), filteredQueue.size());
            }
        }
        for (String rmMovie : moviesToRemove) {
            if (movieRatings.containsKey(rmMovie)) {
                movieRatings.remove(rmMovie);
            }
        }
        return removedRatings;
    }
}
