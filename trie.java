import java.util.*;

class Trie {

    static class Node {
        int count;
        Node[] child = new Node[2];

        Node() {
            count = 0;
            child[0] = child[1] = null;
        }
    }

    private static final int N = 30;
    private Node root;

    public Trie() {
        root = new Node();
    }

    /* INSERT */
    public void insert(int x) {
        insert(x, 1);
    }

    public void insert(int x, int y) {
        Node cur = root;
        for (int i = N; i >= 0; i--) {
            int bit = ((x & (1 << i)) != 0) ? 1 : 0;
            if (cur.child[bit] == null)
                cur.child[bit] = new Node();

            cur = cur.child[bit];
            cur.count += y;
        }
    }

    /* ERASE */
    public void erase(int x) {
        erase(x, 1);
    }

    public void erase(int x, int y) {
         int available = count(x); // implement a count method
         if (available < y) {
           y = available; // only erase what exists
         }


        Node cur = root;
        for (int i = N; i >= 0; i--) {
            int bit = ((x & (1 << i)) != 0) ? 1 : 0;
            cur = cur.child[bit];
            cur.count -= y;
        }
    }

    /* COUNT EXACT */
    public int count(int x) {
        Node cur = root;
        for (int i = N; i >= 0; i--) {
            int bit = ((x & (1 << i)) != 0) ? 1 : 0;
            if (cur.child[bit] == null) return 0;
            cur = cur.child[bit];
        }
        return cur.count;
    }

    /* KTH SMALLEST */
    public int findSmallest() {
        return findSmallest(1);
    }

    public int findSmallest(int k) {
        int ans = 0;
        Node cur = root;

        for (int i = N; i >= 0; i--) {
            int left = (cur.child[0] != null) ? cur.child[0].count : 0;
            if (left >= k) {
                cur = cur.child[0];
            } else {
                ans |= (1 << i);
                k -= left;
                cur = cur.child[1];
            }
        }
        return ans;
    }

    /* ERASE KTH SMALLEST */
    public void eraseSmallest() {
        eraseSmallest(1);
    }

    public void eraseSmallest(int k) {
        Node cur = root;
        for (int i = N; i >= 0; i--) {
            int left = (cur.child[0] != null) ? cur.child[0].count : 0;
            if (left >= k) {
                cur = cur.child[0];
            } else {
                k -= left;
                cur = cur.child[1];
            }
            cur.count--;
        }
    }

    /* KTH GREATEST */
    public int findGreatest() {
        return findGreatest(1);
    }

    public int findGreatest(int k) {
        int ans = 0;
        Node cur = root;

        for (int i = N; i >= 0; i--) {
            int right = (cur.child[1] != null) ? cur.child[1].count : 0;
            if (right < k) {
                k -= right;
                cur = cur.child[0];
            } else {
                ans |= (1 << i);
                cur = cur.child[1];
            }
        }
        return ans;
    }

    /* ERASE KTH GREATEST */
    public void eraseGreatest() {
        eraseGreatest(1);
    }

    public void eraseGreatest(int k) {
        Node cur = root;
        for (int i = N; i >= 0; i--) {
            int right = (cur.child[1] != null) ? cur.child[1].count : 0;
            if (right < k) {
                k -= right;
                cur = cur.child[0];
            } else {
                cur = cur.child[1];
            }
            cur.count--;
        }
    }

    /* COUNT SMALLER THAN X */
    public int countSmaller(int x) {
        return countSmaller(x, 0);
    }

    public int countSmaller(int x, int y) {
        int ans = 0;
        Node cur = root;

        for (int i = N; i >= 0; i--) {
            int bit = ((x & (1 << i)) != 0) ? 1 : 0;
            if (bit == 1 && cur.child[0] != null)
                ans += cur.child[0].count;

            if (cur.child[bit] == null) return ans;
            cur = cur.child[bit];
        }
        return ans + (y == 1 ? cur.count : 0);
    }

    /* COUNT GREATER THAN X */
    public int countGreater(int x) {
        return countGreater(x, 0);
    }

    public int countGreater(int x, int y) {
        int ans = 0;
        Node cur = root;

        for (int i = N; i >= 0; i--) {
            int bit = ((x & (1 << i)) != 0) ? 1 : 0;
            if (bit == 0 && cur.child[1] != null)
                ans += cur.child[1].count;

            if (cur.child[bit] == null) return ans;
            cur = cur.child[bit];
        }
        return ans + (y == 1 ? cur.count : 0);
    }

    /* MIN XOR */
    public int minXor(int x) {
        int ans = 0;
        Node cur = root;

        for (int i = N; i >= 0; i--) {
            int bit = ((x & (1 << i)) != 0) ? 1 : 0;
            if (cur.child[bit] != null && cur.child[bit].count > 0) {
                cur = cur.child[bit];
            } else {
                ans |= (1 << i);
                cur = cur.child[bit ^ 1];
            }
        }
        return ans;
    }

    /* MAX XOR */
    public int maxXor(int x) {
        int ans = 0;
        Node cur = root;

        for (int i = N; i >= 0; i--) {
            int bit = ((x & (1 << i)) != 0) ? 1 : 0;
            if (cur.child[bit ^ 1] != null && cur.child[bit ^ 1].count > 0) {
                ans |= (1 << i);
                cur = cur.child[bit ^ 1];
            } else {
                cur = cur.child[bit];
            }
        }
        return ans;
    }

    /* SORTED OUTPUT */
    private void dfs(Node cur, int bit, int num, List<Integer> res) {
        if (bit < 0) {
            res.add(num);
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (cur.child[i] != null) {
                dfs(cur.child[i], bit - 1, num | (i << bit), res);
            }
        }
    }

    public List<Integer> sorted() {
        List<Integer> res = new ArrayList<>();
        dfs(root, N, 0, res);
        return res;
    }
}
