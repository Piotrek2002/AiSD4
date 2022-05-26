import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HamiltonianCycle hamiltonian = new HamiltonianCycle();
        HamiltonianCycleList hamiltonianCycleList=new HamiltonianCycleList();

        Alg alg=new Alg();
        DataModule dataModule=new DataModule(new Scanner(System.in));

        int[][] graph1= dataModule.getAdjacencyMatrix();
        int[][] graph3= dataModule.getAdjacencyMatrix1();
        EulerCircuit eulerCircuit=new EulerCircuit(graph1.length,graph1.clone(),dataModule.getNumbers());
        EulerCircuit eulerCircuit1=new EulerCircuit(graph3.length,graph1.clone(),dataModule.getNumbers());
        List<List<Integer>> graph2=dataModule.getSuccessorsList();
        long start=System.nanoTime();

        long stop=System.nanoTime();


        System.out.println("Hamilton nieskierowany");
        start=System.nanoTime();
        hamiltonian.hamCycle(graph1);
        stop=System.nanoTime();
        System.out.println(stop-start);
        System.out.println("Hamilton skierowany");
        start=System.nanoTime();
        hamiltonianCycleList.hamCycle(graph2);
        stop=System.nanoTime();
        System.out.println(stop-start);
        System.out.println("Euler nieskierowany");
        start=System.nanoTime();
        eulerCircuit.printEulerTour();
        stop=System.nanoTime();
        System.out.println(stop-start);
        System.out.println("Euler skierowany");
        start=System.nanoTime();
        eulerCircuit.printEulerTour();
        stop=System.nanoTime();
        System.out.println(stop-start);


    }
}
