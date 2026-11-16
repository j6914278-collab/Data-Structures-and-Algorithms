
import java.util.Scanner;

// Main Class
public class MainDFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        SubclassDFS graph = new SubclassDFS(v);

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("\nEnter connections:");

        for (int i = 1; i <= e; i++) {
            System.out.print("Edge " + i + " - Enter source: ");
            int s = sc.nextInt();

            System.out.print("Edge " + i + " - Enter destination: ");
            int d = sc.nextInt();

            graph.addEdge(s, d);
        }

        graph.displayMatrix();

        System.out.print("\nEnter starting vertex: ");
        int start = sc.nextInt();

        System.out.println("\nDFS Traversal:");
        graph.dfs(start, new boolean[v]);

        sc.close();
    }
}

// Abstract Class
abstract class AbstractClassDFS {
    abstract void dfs(int vertex, boolean[] visited);
}

// Subclass
class SubclassDFS extends AbstractClassDFS {
    int vertices;
    int[][] matrix;

    SubclassDFS(int v) {
        vertices = v;
        matrix = new int[v][v];
    }

    void addEdge(int s, int d) {
        matrix[s][d] = 1;
        matrix[d][s] = 1;
    }

    void displayMatrix() {
        System.out.println("\nAdjacency Matrix:");

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < vertices; i++) {
            if (matrix[vertex][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }
}
