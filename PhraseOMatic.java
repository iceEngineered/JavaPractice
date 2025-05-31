import java.util.Random;
public class PhraseOMatic {
public static void main(String[] args) {

String[] words1 = {"Pillow", "Couch", "Chair", "Blanket"};
String[] words2 = {"Burrito", "Pasta", "Cookie"};
String[] words3 = {"Game", "Pen", "Remote"};

Random rand = new Random();
String word1 = words1[rand.nextInt(words1.length)];
String word2 = words2[rand.nextInt(words2.length)];
String word3 = words3[rand.nextInt(words3.length)];
System.out.println(word1+" "+word2+" "+word3);
}
}