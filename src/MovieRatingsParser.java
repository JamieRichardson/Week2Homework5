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

    public static void main(String[] args) {
        List<UserMovieRating> movieRatingList = new ArrayList<>();
        UserMovieRating userMovieRating1 = new UserMovieRating("BAss face", 5);
        UserMovieRating userMovieRating2 = new UserMovieRating("Zed face", 6);
        UserMovieRating userMovieRating3 = new UserMovieRating("ass head", 5);
        UserMovieRating userMovieRating4 = new UserMovieRating("Cock face", 4);
        UserMovieRating userMovieRating5 = new UserMovieRating("bass face", 3);
        movieRatingList.add(userMovieRating1);
        movieRatingList.add(userMovieRating2);
        movieRatingList.add(userMovieRating3);
        movieRatingList.add(userMovieRating4);
        movieRatingList.add(userMovieRating5);
        parseMovieRatings(movieRatingList);
        System.out.println("Movie List parsed");
        TreeMap<String, PriorityQueue<Integer>> alphabeticalTree = parseMovieRatings(movieRatingList);
        List banana = MovieRatingsProcessor.getAlphabeticalMovies(alphabeticalTree);
        System.out.println("Alphabetical Movies: ");
        Iterator iterator = banana.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
