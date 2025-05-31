import java.util.Scanner;
import java.util.Random;
 class GuessGameLauncher {
  public static void main(String[] args) {
    GuessGame game1 = new GuessGame();
    game1.StartGame();
  }
}
 class GuessGame {
  Player p1 = new Player("1");
  Player p2 = new Player("2");
  Player p3 = new Player("3");
  Scanner scanner = new Scanner(System.in);

  public void StartGame() {
    var rand = new Random();
    int selectedNum = rand.nextInt(9)+1;
    p1.Guess(scanner);
    p2.Guess(scanner);
    p3.Guess(scanner);
    if (p1.guess == selectedNum) {
      System.out.println(p1.name+" wins!");
    } else if (p2.guess == selectedNum) {
      System.out.println(p2.name+" wins!");
    } else if (p3.guess == selectedNum) {
      System.out.println(p3.name+" wins!");
    } else {
      System.out.println("No one wins, the number was "+selectedNum);
    }

  }
}
 class Player {
  String name;
  int guess;
  public Player(String name) {
    this.name = name;
  }
  public void Guess(Scanner s) {
    System.out.println(name+" guess?");
    guess = s.nextInt();
  }
}
