import java.util.Scanner;
import java.util.ArrayList;
class Theater {
  ArrayList<Movie> movies = new ArrayList<>();
  ArrayList<Screening> screenings = new ArrayList<>();

  void listAllScreenings() {
    for (Movie movie: movies) {
      System.out.println(movie.title);
      for (Screening screening: screenings) {
        if (movie.title==screening.movie.title) {
          System.out.println(screening.time+" with "+screening.seatsLeft+" seats left");
        }
      }
    }
  }
  void listScreeningsForMovie(String movieTitle) {
    System.out.println("Screenings for "+movieTitle);
    for (Screening screening : screenings) {
      if (movieTitle == screening.movie.title) {
        System.out.println(screening.time+" with "+screening.seatsLeft+" seats left");
      }
    }
  }
  void bookTickets(String time, String movieTitle, int seatsWanted) {
    for (Screening screening : screenings) {
      if (movieTitle == screening.movie.title && time == screening.time) {
        if (seatsWanted <= screening.seatsLeft) {
          screening.seatsLeft-=seatsWanted;
          System.out.println(seatsWanted+" seats booked.");
        } else {
          System.out.println("Not enough seats left.");
        }
      }
    }
  }
  public static void main(String[] args) {
    Theater theater = new Theater();
    Movie movie0 = new Movie("Thunderbolts", 100, "PG-13");
    theater.movies.add(movie0);
    Screening screening0 = new Screening("1:00PM", movie0);
    theater.screenings.add(screening0);
    Screening screening1 = new Screening("5:00PM", movie0);
    theater.screenings.add(screening1);
    Screening screening2 = new Screening("7:00PM", movie0);
    theater.screenings.add(screening2);
    Movie movie1 = new Movie("Sinners", 120, "R");
    theater.movies.add(movie1);
    Screening screening3 = new Screening("1:00PM", movie1);
    theater.screenings.add(screening3);
    Screening screening4 = new Screening("5:00PM", movie1);
    theater.screenings.add(screening4);
    Screening screening5 = new Screening("7:00PM", movie1);
    theater.screenings.add(screening5);

    theater.listAllScreenings();
    System.out.println();
    theater.listScreeningsForMovie("Thunderbolts");
      System.out.println();
      theater.bookTickets("1:00PM","Thunderbolts",30);
        theater.bookTickets("1:00PM","Thunderbolts",30);
  }
}

class Screening {
  String time;
  int seatsLeft;
  Movie movie;
  Screening(String time, Movie movie) {
    this.seatsLeft=30;
    this.time=time;
    this.movie=movie;
  }
}
class Movie {
  String title;
  int duration; //minutes
  String rating;
  Movie(String title, int duration, String rating) {
    this.title=title;
    this.duration=duration;
    this.rating=rating;
  }
}
