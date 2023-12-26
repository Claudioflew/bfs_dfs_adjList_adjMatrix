import java.io.*;
import java.util.*;

public class MyGraph {
  private static boolean[] visited;
  // private static char[][] adjMatrix;
  private static Node[] adjList;
  private static int size;

  public MyGraph(String fileName) {
    Scanner file;
    String line;
    try {
      file = new Scanner(new File(fileName));
      size = Integer.parseInt(file.nextLine());
      visited = new boolean[size];
      // adjMatrix = new char[size][size];
      adjList = new Node[size];

      // for (int i = 0; i < size; i++) {
      //   line = file.nextLine();
      //   for (int j = 0; j < size; j++) {
      //     adjMatrix[i][j] = line.charAt(j);
      //   }
      // }

      // Making an adjacency list
      for (int i = 0; i < size; i++) {
        line = file.nextLine();
        adjList[i] = new Node(i);
        Node current = adjList[i]; // Iterator
        for (int j = 0; j < size; j++) {
          if (line.charAt(j) == '1') {
            current.next = new Node(j);
            current = current.next;
          }
        }
      }

    } catch (IOException ex) {
      System.out.println("File not found.");
    }
  }

  public void startDFS(int i) {
    System.out.print("DFS Path: ");
    dfs(i);
  }

  private void dfs(int v) {
    System.out.print(v + " ");
    visited[v] = true;

    Node current = adjList[v];
    while (current.next != null) {
      int num = current.next.data;
      if (!visited[num]) {
        dfs(num);
      }
      current = current.next;
    }
    // for (int j = 0; j < size; j++) {
    //   if (adjMatrix[v][j] == '1' && !visited[j]) {
    //     dfs(j);
    //   }
    // }
  }

  public void startBFS(int i) {
    System.out.print("BFS Path: ");
    bfs(i);
  }

  private void bfs(int v) {
    MyQueue queue = new MyQueue();
    queue.enqueue(v);
    visited[v] = true;

    while (!queue.empty()) {
      Node removed = queue.dequeue();
      System.out.print(removed.data + " ");

      Node current = adjList[removed.data];
      while (current.next != null) {
        int num = current.next.data;
        if (!visited[num]) {
          visited[num] = true;
          queue.enqueue(num);
        }
        current = current.next;
      }

      // for (int j = 0; j < size; j++) {
      //   if (adjMatrix[removed.data][j] == '1' && !visited[j]) {
      //     visited[j] = true;
      //     queue.enqueue(j);
      //   }
      // }
    }
  }

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