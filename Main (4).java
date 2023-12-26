import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    String type, fileName;
    int number;
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter the file name: ");
    fileName = keyboard.nextLine();
    System.out.print("Enter search type: ");
    type = keyboard.nextLine();
    System.out.print("Enter the initial vertex number: ");
    number = keyboard.nextInt();
  
    MyGraph graph = new MyGraph(fileName);
  
    if (type.equals("dfs")) {
      graph.startDFS(number);
    } else if (type.equals("bfs")) {
      graph.startBFS(number);
    }
    keyboard.close();
  }
}