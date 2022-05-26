import java.util.*;

public class EulerCircuit
{

    private int[][] adjacencyMatrix;
    private int numberOfNodes;
    private int start;
    private int numbers;
    private List<Integer> list=new ArrayList<>();

    public EulerCircuit (int numberOfNodes, int[][] adjacencyMatrix,int numbers)
    {
        this.numberOfNodes = numberOfNodes;
        this.adjacencyMatrix = adjacencyMatrix;
        this.numbers=numbers;

    }

    public int degree (int vertex)
    {
        int degree = 0;
        for (int destinationvertex = 0; destinationvertex < numberOfNodes ; destinationvertex++)
        {
            if (adjacencyMatrix[vertex][destinationvertex] == 1
                    || adjacencyMatrix[destinationvertex][vertex] == 1)
            {
                degree++;
            }
        }
        return degree;
    }

    public int oddDegreeVertex ()
    {
        int vertex = -1;
        for (int node = 0; node < numberOfNodes; node++)
        {
            if ((degree(node) % 2) != 0)
            {
                vertex = node;
                break;
            }
        }
        return vertex;
    }

    public void printEulerTourUtil (int vertex)
    {
        for (int destination = 0; destination < numberOfNodes; destination++)
        {
            if(adjacencyMatrix[vertex][destination] == 1 && isVaildNextEdge(vertex, destination))
            {
                list.add(vertex);
                list.add(destination);
                removeEdge(vertex, destination);
                printEulerTourUtil(destination);
            }
        }
    }

    public void printEulerTour ()
    {
        int vertex = 1;
        if (oddDegreeVertex() != -1)
        {
            vertex = oddDegreeVertex();
        }
        printEulerTourUtil(vertex);
        if (list.size()!=0 && Objects.equals(list.get(0), list.get(list.size() - 1)) && list.size()==2*numbers){
            System.out.println("Solution Exists: Following" +

                    " is one Euler Cycle");
            for (int i=0;i< list.size();i=i+2){
                System.out.print(" "+(list.get(i)+1)+" ");
            }
            System.out.println(" "+(list.get(0)+1));

        }else {
            System.out.println();
            System.out.println("Solution does not exist");
            System.out.println();
        }

        return;
    }

    public boolean isVaildNextEdge (int source, int destination)
    {
        int count = 0;
        for (int vertex = 0; vertex < numberOfNodes; vertex++)
        {
            if (adjacencyMatrix[source][vertex] == 1)
            {
                count++;
            }
        }

        if (count == 1 )
        {
            return true;
        }

        int visited[] = new int[numberOfNodes + 1];
        int count1 = DFSCount(source, visited);

        removeEdge(source, destination);
        for (int vertex = 1; vertex <= numberOfNodes; vertex++)
        {
            visited[vertex] = 0;
        }

        int count2 = DFSCount(source, visited);
        addEdge(source, destination);

        return (count1 > count2 ) ? false : true;
    }

    public int DFSCount (int source, int visited[])
    {
        visited[source] = 1;
        int count = 1;
        int destination = 1;

        while (destination < numberOfNodes)
        {
            if(adjacencyMatrix[source][destination] == 1 && visited[destination] == 0)
            {
                count += DFSCount(destination, visited);
            }
            destination++;
        }
        return count;
    }

    public void removeEdge (int source, int destination)
    {
        adjacencyMatrix[source][destination]  = 0;
        adjacencyMatrix[destination][source] = 0;
    }

    public void addEdge (int source, int destination)
    {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

}