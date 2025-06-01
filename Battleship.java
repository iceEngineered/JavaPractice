import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
class Battleship {
  String outerLine = ("------------------------");
  List<String> gridLines = Arrays.asList("| A0 A1 A2 A3 A4 A5 A6 |", "| B0 B1 B2 B3 B4 B5 B6 |", "| C0 C1 C2 C3 C4 C5 C6 |", "| D0 D1 D2 D3 D4 D5 D6 |", "| E0 E1 E2 E3 E4 E5 E6 |", "| F0 F1 F2 F3 F4 F5 F6 |", "| G0 G1 G2 G3 G4 G5 G6 |");
  public void printGrid() {
    System.out.println(outerLine);
    for (String line : gridLines){
      System.out.println(line);
    }
    System.out.println(outerLine);
  }
  public void playGame() {
      Random rand = new Random();
      String[] letterCodes = {"A","B","C","D","E","F","G"};

      int ship1StartX = rand.nextInt(5); // horizontal ship
      int ship1StartY = rand.nextInt(6);
      List<String> ship1Locations = new ArrayList<>(Arrays.asList(
          letterCodes[ship1StartY] + ship1StartX,
          letterCodes[ship1StartY] + (ship1StartX + 1),
          letterCodes[ship1StartY] + (ship1StartX + 2)
      ));

      int ship2StartX = rand.nextInt(6); // vertical ship
      int ship2StartY = rand.nextInt(5);
      List<String> ship2Locations = new ArrayList<>(Arrays.asList(
          letterCodes[ship2StartY] + ship2StartX,
          letterCodes[ship2StartY + 1] + ship2StartX,
          letterCodes[ship2StartY + 2] + ship2StartX
      ));

      Scanner s = new Scanner(System.in);

      while (!ship1Locations.isEmpty() || !ship2Locations.isEmpty()) {
          this.printGrid();
          System.out.print("Where do you want to shoot? ");
          String target = s.nextLine().trim().toUpperCase(); // make input more reliable
          boolean hit = false;

          // Check ship 1
          Iterator<String> it1 = ship1Locations.iterator();
          while (it1.hasNext()) {
              String pos = it1.next();
              if (pos.equals(target)) {
                  System.out.println("Hit on Ship 1!");
                  it1.remove();
                  updateGrid(target, "XX");
                  if (ship1Locations.isEmpty()) {
                      System.out.println("Ship 1 Sunk!");
                  }
                  hit = true;
                  break;
              }
          }

          // Check ship 2
          Iterator<String> it2 = ship2Locations.iterator();
          while (it2.hasNext()) {
              String pos = it2.next();
              if (pos.equals(target)) {
                  System.out.println("Hit on Ship 2!");
                  it2.remove();
                  updateGrid(target, "XX");
                  if (ship2Locations.isEmpty()) {
                      System.out.println("Ship 2 Sunk!");
                  }
                  hit = true;
                  break;
              }
          }

          // If no hit, mark as miss
          if (!hit) {
              System.out.println("Miss.");
              updateGrid(target, "  ");
          }
      }

      System.out.println("You won!");
  }
  private void updateGrid(String target, String replacement) {
    for (int i = 0; i < gridLines.size(); i++) {
        String line = gridLines.get(i);
        if (line.contains(" " + target + " ")) {
            gridLines.set(i, line.replace(" " + target + " ", " " + replacement + " "));
        }
    }
}
  public static void main(String[] args) {
    Battleship bs = new Battleship();
    bs.playGame();
  }
}
