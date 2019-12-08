public class QuickUnionFind {

  private int[] roots;
  private int[] rank;
  private int count;

  public QuickUnionFind(int count) {
    this.roots = new int[count];
    this.rank = new int[count];
    this.count = count;

    for (int i = 0; i < count; i++) {
      roots[i] = i;
      rank[i] = 1;
    }
  }

  public int findRoot(int i) {
    while (i != roots[i]) {
      roots[i] = roots[roots[i]];
      i = roots[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    return findRoot(p) == findRoot(q);
  }

  public void union(int p, int q) {
    int p_root = findRoot(p);
    int q_root = findRoot(q);

    if (p_root == q_root) {
      return;
    }

    if (rank[p_root] > rank[q_root]) {
      roots[q_root] = p_root;
    } else if (rank[p_root] < rank[q_root]) {
      roots[p_root] = q_root;
    } else {
      roots[q_root] = p_root;
      rank[p_root] += 1;
    }

    count -= 1;
  }

  public int getCount() {
    return count;
  }
}
