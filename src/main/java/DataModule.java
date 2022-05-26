import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataModule {
    private final int[][] adjacencyMatrix;
    private final List<List<Integer>> successorsList;
    private final int numbers;
    private final int[][] adjacencyMatrix1;

    public DataModule(Scanner scanner){
        int w = scanner.nextInt();
        int n = scanner.nextInt();
        numbers=w;
        adjacencyMatrix=new int[n][n];
        adjacencyMatrix1=new int[n][n];
        successorsList=new ArrayList<>();
        for (int i=0;i<n;i++){
            successorsList.add(new ArrayList<>());
        }
        for (int i=0;i<w;i++){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            adjacencyMatrix[x-1][y-1]=1;
            adjacencyMatrix1[x-1][y-1]=1;
            adjacencyMatrix[y-1][x-1]=1;
            successorsList.get(x-1).add(y-1);

        }

    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public int getNumbers() {
        return numbers;
    }

    public List<List<Integer>> getSuccessorsList() {
        return successorsList;
    }

    public int[][] getAdjacencyMatrix1() {
        return adjacencyMatrix1;
    }
}
