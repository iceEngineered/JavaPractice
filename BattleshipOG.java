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
    int ship1StartX = rand.nextInt(5);// this is the leftmost point of the ship, this one will be horizontal
    int ship1StartY = rand.nextInt(6);
    List<String> ship1Locations = new ArrayList<>(Arrays.asList(letterCodes[ship1StartY] + ship1StartX, letterCodes[ship1StartY] + (ship1StartX + 1), letterCodes[ship1StartY] + (ship1StartX + 2)));
  /*  for (String x : ship1Locations) {
      System.out.println(x);
    }*/
    int ship2StartX = rand.nextInt(6);// this is the topmost part of the ship, this one will be vertical going downward
    int ship2StartY = rand.nextInt(5);
    //System.out.println(letterCodes[ship2StartY]+ship2StartX);
    List<String> ship2Locations = new ArrayList<>(Arrays.asList((letterCodes[ship2StartY]+ship2StartX),(letterCodes[ship2StartY+1]+(ship2StartX)),(letterCodes[ship2StartY+2]+(ship2StartX))));
    for (String x : ship2Locations) {
    System.out.println(x);
  }
  Scanner s = new Scanner(System.in);
  while (ship1Locations.size() > 0 || ship2Locations.size() > 0) {
    this.printGrid();
    System.out.println("Where do you want to shoot?");
    String target = new String(s.nextLine());
      Iterator<String> iterator = ship1Locations.iterator();
      while (iterator.hasNext()) {
          String x = iterator.next();
          if (x.contains(target)) {
              System.out.println("Hit on Ship 1!");
              iterator.remove();
              if (ship1Locations.size() == 0) {
                  System.out.println("Ship 1 Sunk!");
              }
              for (int i = 0; i < gridLines.size(); i++) {
           String line = gridLines.get(i);
           if (line.contains(" " + x + " ")) {
       gridLines.set(i, line.replace(" " + x + " ", " XX "));
   }
       }
     } else {
       for (int i = 0; i < gridLines.size(); i++) {
    String line = gridLines.get(i);
    if (line.contains(target)) {
        gridLines.set(i, line.replace(target, "  "));
    }
}
     }
     iterator = ship2Locations.iterator();
     while (iterator.hasNext()) {
          x = iterator.next();
         if (x.equals(target)) {
             System.out.println("Hit on Ship 2!");
             iterator.remove();
             if (ship2Locations.size() == 0) {
                 System.out.println("Ship 2 Sunk!");
             }
             for (int i = 0; i < gridLines.size(); i++) {
          String line = gridLines.get(i);
          if (line.contains(" " + x + " ")) {
         gridLines.set(i, line.replace(" " + x + " ", " XX "));
     }
      }
    } else {
      for (int i = 0; i < gridLines.size(); i++) {
      String line = gridLines.get(i);
      if (line.contains(" " + target + " ")) {
          gridLines.set(i, line.replace(" " + target + " ", "    ")); // 2 spaces for alignment
      }
  }
    }
      }

}}
System.out.println("You won!");

  }
  public static void main(String[] args) {
    Battleship bs = new Battleship();
    bs.playGame();
  }
}
