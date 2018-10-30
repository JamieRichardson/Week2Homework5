/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		List<String> alphaMovies = new ArrayList<>();
		if(movieRatings == null || movieRatings.isEmpty()) {
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
		if(movieRatings == null || movieRatings.isEmpty()) {
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
		/*given an input int rating, modify the TreeMap object that was passed as an argument so that you
		remove all ratings in the PriorityQueue that are below (but not equal to) rating for every movie in the Map.
		 If all ratings are removed from a movie’s PriorityQueue, then remove the mapping from the TreeMap.
		 Additionally, this method should return a new TreeMap that maps a movie title to the number of ratings
		 that were removed from its corresponding PriorityQueue; the TreeMap that is returned should only contain
		 movies that had ratings removed from its PriorityQueue.*/
		TreeMap<String, Integer> removedRatings = new TreeMap<>();
		if(movieRatings == null || movieRatings.isEmpty()) {
			return removedRatings;
		}
		
		return null; // this line is here only so this code will compile if you don't modify it
	}
}
