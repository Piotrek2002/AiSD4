public class HamiltonianCycle {


    int V;

    int[] path;

    boolean isSafe(int v, int[][] graph, int[] path, int pos) {

        if (graph[path[pos - 1]][v] != 0) {
            for (int i = 0; i < pos; i++) {
                if (v != path[i]) {
                    continue;
                }
                return false;
            }


            return true;
        } else {
            return false;
        }

    }

    boolean hamCycleUtil(int[][] graph, int[] path, int pos) {

        if (pos == V) {


            return graph[path[pos - 1]][path[0]] == 1;

        }

        for (int v = 1; v < V; v++) {


            if (isSafe(v, graph, path, pos)) {

                path[pos] = v;

                if (!hamCycleUtil(graph, path, pos + 1)) {
                    path[pos] = -1;
                } else {
                    return true;
                }

            }

        }

        return false;

    }

    int hamCycle(int[][] graph) {


        V = graph.length;
        path = new int[V];

        for (int i = 0; i < V; i++)

            path[i] = -1;

        path[0] = 0;

        if (!hamCycleUtil(graph, path, 1)) {

            System.out.println("\nSolution does not exist");
            System.out.println();

            return 0;

        }
        printSolution(path);

        return 1;

    }


    void printSolution(int[] path) {

        System.out.println("Solution Exists: Following" +

                " is one Hamiltonian Cycle");

        for (int i = 0; i < V; i++)

            System.out.print(" " + (path[i] + 1) + " ");


        System.out.println(" " + (path[0] + 1) + " ");

    }


}


