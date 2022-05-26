import java.util.LinkedHashSet;
import java.util.Set;

public class Alg {
    private static final Set<Integer> set = new LinkedHashSet<>();

    public void nie_skierowany(int[][] matrix, int s) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[s][i] == 1) {
                matrix[s][i] = 0;
                matrix[i][s] = 0;
                nie_skierowany(matrix, i);
            }
        }
        set.add(s + 1);
    }

    public Set<Integer> getSet() {
        return set;
    }
}
