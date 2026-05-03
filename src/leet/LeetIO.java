package leet;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class LeetIO {

    private final Scanner scanner;
    private final PrintStream out;

    public LeetIO() {
        this(System.in, System.out);
    }

    public LeetIO(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public LeetIO(String input) {
        this(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)), System.out);
    }

    // ============================================================
    // Read: primitives / single values
    // ============================================================

    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    public String nextRawLine() {
        return scanner.nextLine();
    }

    public int nextInt() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public long nextLong() {
        return Long.parseLong(scanner.nextLine().trim());
    }

    public double nextDouble() {
        return Double.parseDouble(scanner.nextLine().trim());
    }

    public boolean nextBoolean() {
        return Boolean.parseBoolean(scanner.nextLine().trim());
    }

    public char nextChar() {
        String line = scanner.nextLine().trim();
        if (line.length() >= 2) {
            char first = line.charAt(0);
            char last = line.charAt(line.length() - 1);
            if ((first == '"' && last == '"') || (first == '\'' && last == '\'')) {
                return line.charAt(1);
            }
        }
        return line.charAt(0);
    }

    public String nextString() {
        String line = scanner.nextLine();
        String trimmed = line.trim();
        if (trimmed.length() >= 2 && trimmed.charAt(0) == '"' && trimmed.charAt(trimmed.length() - 1) == '"') {
            return new Parser(trimmed).parseString();
        }
        return line;
    }

    // ============================================================
    // Read: 1D arrays
    // ============================================================

    public int[] nextIntArray() {
        Parser p = new Parser(scanner.nextLine());
        return parseIntArray(p);
    }

    public long[] nextLongArray() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<Long> list = new ArrayList<>();
        if (!p.eat(']')) {
            do { list.add(p.parseLong()); } while (p.eat(','));
            p.expect(']');
        }
        long[] r = new long[list.size()];
        for (int i = 0; i < r.length; i++) r[i] = list.get(i);
        return r;
    }

    public double[] nextDoubleArray() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<Double> list = new ArrayList<>();
        if (!p.eat(']')) {
            do { list.add(p.parseDouble()); } while (p.eat(','));
            p.expect(']');
        }
        double[] r = new double[list.size()];
        for (int i = 0; i < r.length; i++) r[i] = list.get(i);
        return r;
    }

    public boolean[] nextBooleanArray() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<Boolean> list = new ArrayList<>();
        if (!p.eat(']')) {
            do { list.add(p.parseBool()); } while (p.eat(','));
            p.expect(']');
        }
        boolean[] r = new boolean[list.size()];
        for (int i = 0; i < r.length; i++) r[i] = list.get(i);
        return r;
    }

    public char[] nextCharArray() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<Character> list = new ArrayList<>();
        if (!p.eat(']')) {
            do {
                String s = p.parseString();
                list.add(s.isEmpty() ? '\0' : s.charAt(0));
            } while (p.eat(','));
            p.expect(']');
        }
        char[] r = new char[list.size()];
        for (int i = 0; i < r.length; i++) r[i] = list.get(i);
        return r;
    }

    public String[] nextStringArray() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<String> list = new ArrayList<>();
        if (!p.eat(']')) {
            do { list.add(p.parseString()); } while (p.eat(','));
            p.expect(']');
        }
        return list.toArray(new String[0]);
    }

    // ============================================================
    // Read: 2D matrices
    // ============================================================

    public int[][] nextIntMatrix() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<int[]> rows = new ArrayList<>();
        if (!p.eat(']')) {
            do { rows.add(parseIntArray(p)); } while (p.eat(','));
            p.expect(']');
        }
        return rows.toArray(new int[0][]);
    }

    public long[][] nextLongMatrix() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<long[]> rows = new ArrayList<>();
        if (!p.eat(']')) {
            do {
                p.expect('[');
                List<Long> r = new ArrayList<>();
                if (!p.eat(']')) {
                    do { r.add(p.parseLong()); } while (p.eat(','));
                    p.expect(']');
                }
                long[] arr = new long[r.size()];
                for (int i = 0; i < arr.length; i++) arr[i] = r.get(i);
                rows.add(arr);
            } while (p.eat(','));
            p.expect(']');
        }
        return rows.toArray(new long[0][]);
    }

    public double[][] nextDoubleMatrix() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<double[]> rows = new ArrayList<>();
        if (!p.eat(']')) {
            do {
                p.expect('[');
                List<Double> r = new ArrayList<>();
                if (!p.eat(']')) {
                    do { r.add(p.parseDouble()); } while (p.eat(','));
                    p.expect(']');
                }
                double[] arr = new double[r.size()];
                for (int i = 0; i < arr.length; i++) arr[i] = r.get(i);
                rows.add(arr);
            } while (p.eat(','));
            p.expect(']');
        }
        return rows.toArray(new double[0][]);
    }

    public char[][] nextCharMatrix() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<char[]> rows = new ArrayList<>();
        if (!p.eat(']')) {
            do {
                p.expect('[');
                List<Character> r = new ArrayList<>();
                if (!p.eat(']')) {
                    do {
                        String s = p.parseString();
                        r.add(s.isEmpty() ? '\0' : s.charAt(0));
                    } while (p.eat(','));
                    p.expect(']');
                }
                char[] arr = new char[r.size()];
                for (int i = 0; i < arr.length; i++) arr[i] = r.get(i);
                rows.add(arr);
            } while (p.eat(','));
            p.expect(']');
        }
        return rows.toArray(new char[0][]);
    }

    public String[][] nextStringMatrix() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<String[]> rows = new ArrayList<>();
        if (!p.eat(']')) {
            do {
                p.expect('[');
                List<String> r = new ArrayList<>();
                if (!p.eat(']')) {
                    do { r.add(p.parseString()); } while (p.eat(','));
                    p.expect(']');
                }
                rows.add(r.toArray(new String[0]));
            } while (p.eat(','));
            p.expect(']');
        }
        return rows.toArray(new String[0][]);
    }

    // ============================================================
    // Read: List variants
    // ============================================================

    public List<Integer> nextIntList() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<Integer> list = new ArrayList<>();
        if (!p.eat(']')) {
            do { list.add(p.parseInt()); } while (p.eat(','));
            p.expect(']');
        }
        return list;
    }

    public List<Long> nextLongList() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<Long> list = new ArrayList<>();
        if (!p.eat(']')) {
            do { list.add(p.parseLong()); } while (p.eat(','));
            p.expect(']');
        }
        return list;
    }

    public List<String> nextStringList() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<String> list = new ArrayList<>();
        if (!p.eat(']')) {
            do { list.add(p.parseString()); } while (p.eat(','));
            p.expect(']');
        }
        return list;
    }

    public List<List<Integer>> nextIntListList() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<List<Integer>> rows = new ArrayList<>();
        if (!p.eat(']')) {
            do {
                p.expect('[');
                List<Integer> r = new ArrayList<>();
                if (!p.eat(']')) {
                    do { r.add(p.parseInt()); } while (p.eat(','));
                    p.expect(']');
                }
                rows.add(r);
            } while (p.eat(','));
            p.expect(']');
        }
        return rows;
    }

    public List<List<String>> nextStringListList() {
        Parser p = new Parser(scanner.nextLine());
        p.expect('[');
        List<List<String>> rows = new ArrayList<>();
        if (!p.eat(']')) {
            do {
                p.expect('[');
                List<String> r = new ArrayList<>();
                if (!p.eat(']')) {
                    do { r.add(p.parseString()); } while (p.eat(','));
                    p.expect(']');
                }
                rows.add(r);
            } while (p.eat(','));
            p.expect(']');
        }
        return rows;
    }

    // ============================================================
    // Read: LeetCode data structures
    // ============================================================

    public ListNode nextListNode() {
        Parser p = new Parser(scanner.nextLine());
        int[] vals = parseIntArray(p);
        if (vals.length == 0) return null;
        ListNode head = new ListNode(vals[0]);
        ListNode cur = head;
        for (int i = 1; i < vals.length; i++) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }
        return head;
    }

    public TreeNode nextTreeNode() {
        Parser p = new Parser(scanner.nextLine());
        List<Integer> vals = parseNullableIntList(p);
        if (vals.isEmpty() || vals.get(0) == null) return null;
        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < vals.size()) {
            TreeNode parent = q.poll();
            if (i < vals.size()) {
                Integer lv = vals.get(i++);
                if (lv != null) {
                    parent.left = new TreeNode(lv);
                    q.offer(parent.left);
                }
            }
            if (i < vals.size()) {
                Integer rv = vals.get(i++);
                if (rv != null) {
                    parent.right = new TreeNode(rv);
                    q.offer(parent.right);
                }
            }
        }
        return root;
    }

    public Node nextNAryNode() {
        Parser p = new Parser(scanner.nextLine());
        List<Integer> vals = parseNullableIntList(p);
        if (vals.isEmpty() || vals.get(0) == null) return null;
        Node root = new Node(vals.get(0));
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while (i < vals.size()) {
            if (vals.get(i) != null) { i++; continue; }
            i++; // consume null separator
            if (queue.isEmpty()) break;
            Node parent = queue.poll();
            while (i < vals.size() && vals.get(i) != null) {
                Node child = new Node(vals.get(i));
                parent.children.add(child);
                queue.offer(child);
                i++;
            }
        }
        return root;
    }

    public Node nextGraphNode() {
        int[][] adj = nextIntMatrix();
        if (adj.length == 0) return null;
        Node[] nodes = new Node[adj.length + 1];
        for (int i = 1; i <= adj.length; i++) nodes[i] = new Node(i);
        for (int i = 0; i < adj.length; i++) {
            for (int n : adj[i]) nodes[i + 1].neighbors.add(nodes[n]);
        }
        return nodes[1];
    }

    // ============================================================
    // Print: primitives
    // ============================================================

    public void println() { out.println(); }

    public void print(int v)     { out.print(v); }
    public void println(int v)   { out.println(v); }
    public void print(long v)    { out.print(v); }
    public void println(long v)  { out.println(v); }
    public void print(double v)  { out.print(v); }
    public void println(double v){ out.println(v); }
    public void print(boolean v) { out.print(v); }
    public void println(boolean v){ out.println(v); }

    public void print(char v) {
        out.print('"'); out.print(v); out.print('"');
    }
    public void println(char v) { print(v); out.println(); }

    public void print(String v) {
        if (v == null) { out.print("null"); return; }
        out.print('"'); out.print(escape(v)); out.print('"');
    }
    public void println(String v) { print(v); out.println(); }

    // ============================================================
    // Print: 1D arrays
    // ============================================================

    public void print(int[] a) {
        if (a == null) { out.print("null"); return; }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) { if (i > 0) sb.append(','); sb.append(a[i]); }
        sb.append(']');
        out.print(sb);
    }
    public void println(int[] a) { print(a); out.println(); }

    public void print(long[] a) {
        if (a == null) { out.print("null"); return; }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) { if (i > 0) sb.append(','); sb.append(a[i]); }
        sb.append(']');
        out.print(sb);
    }
    public void println(long[] a) { print(a); out.println(); }

    public void print(double[] a) {
        if (a == null) { out.print("null"); return; }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) { if (i > 0) sb.append(','); sb.append(a[i]); }
        sb.append(']');
        out.print(sb);
    }
    public void println(double[] a) { print(a); out.println(); }

    public void print(boolean[] a) {
        if (a == null) { out.print("null"); return; }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) { if (i > 0) sb.append(','); sb.append(a[i]); }
        sb.append(']');
        out.print(sb);
    }
    public void println(boolean[] a) { print(a); out.println(); }

    public void print(char[] a) {
        if (a == null) { out.print("null"); return; }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            if (i > 0) sb.append(',');
            sb.append('"').append(a[i]).append('"');
        }
        sb.append(']');
        out.print(sb);
    }
    public void println(char[] a) { print(a); out.println(); }

    public void print(String[] a) {
        if (a == null) { out.print("null"); return; }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            if (i > 0) sb.append(',');
            if (a[i] == null) sb.append("null");
            else sb.append('"').append(escape(a[i])).append('"');
        }
        sb.append(']');
        out.print(sb);
    }
    public void println(String[] a) { print(a); out.println(); }

    // ============================================================
    // Print: 2D matrices (compact, single line)
    // ============================================================

    public void print(int[][] m) {
        if (m == null) { out.print("null"); return; }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < m.length; i++) {
            if (i > 0) sb.append(',');
            sb.append('[');
            for (int j = 0; j < m[i].length; j++) {
                if (j > 0) sb.append(',');
                sb.append(m[i][j]);
            }
            sb.append(']');
        }
        sb.append(']');
        out.print(sb);
    }
    public void println(int[][] m) { print(m); out.println(); }

    public void print(long[][] m) {
        if (m == null) { out.print("null"); return; }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < m.length; i++) {
            if (i > 0) sb.append(',');
            sb.append('[');
            for (int j = 0; j < m[i].length; j++) {
                if (j > 0) sb.append(',');
                sb.append(m[i][j]);
            }
            sb.append(']');
        }
        sb.append(']');
        out.print(sb);
    }
    public void println(long[][] m) { print(m); out.println(); }

    public void print(double[][] m) {
        if (m == null) { out.print("null"); return; }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < m.length; i++) {
            if (i > 0) sb.append(',');
            sb.append('[');
            for (int j = 0; j < m[i].length; j++) {
                if (j > 0) sb.append(',');
                sb.append(m[i][j]);
            }
            sb.append(']');
        }
        sb.append(']');
        out.print(sb);
    }
    public void println(double[][] m) { print(m); out.println(); }

    public void print(char[][] m) {
        if (m == null) { out.print("null"); return; }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < m.length; i++) {
            if (i > 0) sb.append(',');
            sb.append('[');
            for (int j = 0; j < m[i].length; j++) {
                if (j > 0) sb.append(',');
                sb.append('"').append(m[i][j]).append('"');
            }
            sb.append(']');
        }
        sb.append(']');
        out.print(sb);
    }
    public void println(char[][] m) { print(m); out.println(); }

    public void print(String[][] m) {
        if (m == null) { out.print("null"); return; }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < m.length; i++) {
            if (i > 0) sb.append(',');
            sb.append('[');
            for (int j = 0; j < m[i].length; j++) {
                if (j > 0) sb.append(',');
                if (m[i][j] == null) sb.append("null");
                else sb.append('"').append(escape(m[i][j])).append('"');
            }
            sb.append(']');
        }
        sb.append(']');
        out.print(sb);
    }
    public void println(String[][] m) { print(m); out.println(); }

    /** Multi-line indented matrix output for visual debugging. */
    public void printPretty(int[][] m) {
        if (m == null) { out.print("null"); return; }
        out.print('[');
        for (int i = 0; i < m.length; i++) {
            if (i > 0) out.print(',');
            out.println();
            out.print("  [");
            for (int j = 0; j < m[i].length; j++) {
                if (j > 0) out.print(',');
                out.print(m[i][j]);
            }
            out.print(']');
        }
        if (m.length > 0) out.println();
        out.print(']');
    }
    public void printlnPretty(int[][] m) { printPretty(m); out.println(); }

    // ============================================================
    // Print: List (handles nesting / Strings / Chars recursively)
    // ============================================================

    public void print(List<?> list) {
        out.print(formatAny(list));
    }
    public void println(List<?> list) { print(list); out.println(); }

    private String formatAny(Object o) {
        if (o == null) return "null";
        if (o instanceof List<?>) {
            StringBuilder sb = new StringBuilder("[");
            List<?> list = (List<?>) o;
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) sb.append(',');
                sb.append(formatAny(list.get(i)));
            }
            sb.append(']');
            return sb.toString();
        }
        if (o instanceof String) return "\"" + escape((String) o) + "\"";
        if (o instanceof Character) return "\"" + o + "\"";
        return o.toString();
    }

    // ============================================================
    // Print: LeetCode data structures
    // ============================================================

    public void print(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (!first) sb.append(',');
            sb.append(cur.val);
            first = false;
        }
        sb.append(']');
        out.print(sb);
    }
    public void println(ListNode head) { print(head); out.println(); }

    public void print(TreeNode root) {
        if (root == null) { out.print("[]"); return; }
        List<String> tokens = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        tokens.add(String.valueOf(root.val));
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.left != null) {
                tokens.add(String.valueOf(n.left.val));
                q.offer(n.left);
            } else {
                tokens.add("null");
            }
            if (n.right != null) {
                tokens.add(String.valueOf(n.right.val));
                q.offer(n.right);
            } else {
                tokens.add("null");
            }
        }
        while (!tokens.isEmpty() && tokens.get(tokens.size() - 1).equals("null")) {
            tokens.remove(tokens.size() - 1);
        }
        out.print("[" + String.join(",", tokens) + "]");
    }
    public void println(TreeNode root) { print(root); out.println(); }

    public void printNAry(Node root) {
        if (root == null) { out.print("[]"); return; }
        List<String> tokens = new ArrayList<>();
        tokens.add(String.valueOf(root.val));
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            tokens.add("null");
            if (n.children != null) {
                for (Node c : n.children) {
                    tokens.add(String.valueOf(c.val));
                    q.offer(c);
                }
            }
        }
        while (!tokens.isEmpty() && tokens.get(tokens.size() - 1).equals("null")) {
            tokens.remove(tokens.size() - 1);
        }
        out.print("[" + String.join(",", tokens) + "]");
    }
    public void printlnNAry(Node root) { printNAry(root); out.println(); }

    public void printGraph(Node start) {
        if (start == null) { out.print("[]"); return; }
        Map<Integer, Node> byVal = new java.util.TreeMap<>();
        java.util.Set<Node> visited = new java.util.HashSet<>();
        Queue<Node> q = new ArrayDeque<>();
        visited.add(start);
        q.offer(start);
        while (!q.isEmpty()) {
            Node n = q.poll();
            byVal.put(n.val, n);
            if (n.neighbors == null) continue;
            for (Node nb : n.neighbors) {
                if (visited.add(nb)) q.offer(nb);
            }
        }
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;
        for (Node n : byVal.values()) {
            if (!first) sb.append(',');
            first = false;
            sb.append('[');
            if (n.neighbors != null) {
                for (int i = 0; i < n.neighbors.size(); i++) {
                    if (i > 0) sb.append(',');
                    sb.append(n.neighbors.get(i).val);
                }
            }
            sb.append(']');
        }
        sb.append(']');
        out.print(sb);
    }
    public void printlnGraph(Node start) { printGraph(start); out.println(); }

    // ============================================================
    // Internal helpers
    // ============================================================

    private static int[] parseIntArray(Parser p) {
        p.expect('[');
        List<Integer> list = new ArrayList<>();
        if (!p.eat(']')) {
            do { list.add(p.parseInt()); } while (p.eat(','));
            p.expect(']');
        }
        int[] r = new int[list.size()];
        for (int i = 0; i < r.length; i++) r[i] = list.get(i);
        return r;
    }

    private static List<Integer> parseNullableIntList(Parser p) {
        p.expect('[');
        List<Integer> list = new ArrayList<>();
        if (!p.eat(']')) {
            do {
                if (p.atNull()) list.add(null);
                else list.add(p.parseInt());
            } while (p.eat(','));
            p.expect(']');
        }
        return list;
    }

    private static String escape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '\\': sb.append("\\\\"); break;
                case '"':  sb.append("\\\""); break;
                case '\n': sb.append("\\n"); break;
                case '\t': sb.append("\\t"); break;
                case '\r': sb.append("\\r"); break;
                default: sb.append(c);
            }
        }
        return sb.toString();
    }

    /** Tiny position-based parser for LeetCode bracket notation. */
    private static class Parser {
        final String src;
        int pos;

        Parser(String s) { this.src = s == null ? "" : s; this.pos = 0; }

        void skipWs() {
            while (pos < src.length() && Character.isWhitespace(src.charAt(pos))) pos++;
        }

        char peek() {
            skipWs();
            return pos < src.length() ? src.charAt(pos) : '\0';
        }

        boolean eat(char c) {
            skipWs();
            if (pos < src.length() && src.charAt(pos) == c) { pos++; return true; }
            return false;
        }

        void expect(char c) {
            if (!eat(c)) {
                throw new IllegalArgumentException(
                    "Expected '" + c + "' at pos " + pos + " in: " + src);
            }
        }

        boolean atNull() {
            skipWs();
            if (pos + 4 <= src.length() && src.regionMatches(pos, "null", 0, 4)) {
                int after = pos + 4;
                if (after >= src.length() || !Character.isLetterOrDigit(src.charAt(after))) {
                    pos = after;
                    return true;
                }
            }
            return false;
        }

        boolean parseBool() {
            skipWs();
            if (src.regionMatches(pos, "true", 0, 4)) { pos += 4; return true; }
            if (src.regionMatches(pos, "false", 0, 5)) { pos += 5; return false; }
            throw new IllegalArgumentException("Expected boolean at pos " + pos + " in: " + src);
        }

        int parseInt() { return (int) parseLong(); }

        long parseLong() {
            skipWs();
            int start = pos;
            if (pos < src.length() && (src.charAt(pos) == '+' || src.charAt(pos) == '-')) pos++;
            while (pos < src.length() && Character.isDigit(src.charAt(pos))) pos++;
            if (start == pos || (pos == start + 1 && !Character.isDigit(src.charAt(start)))) {
                throw new IllegalArgumentException("Expected number at pos " + start + " in: " + src);
            }
            return Long.parseLong(src.substring(start, pos));
        }

        double parseDouble() {
            skipWs();
            int start = pos;
            if (pos < src.length() && (src.charAt(pos) == '+' || src.charAt(pos) == '-')) pos++;
            while (pos < src.length()) {
                char c = src.charAt(pos);
                if (Character.isDigit(c) || c == '.') {
                    pos++;
                } else if (c == 'e' || c == 'E') {
                    pos++;
                    if (pos < src.length() && (src.charAt(pos) == '+' || src.charAt(pos) == '-')) pos++;
                } else {
                    break;
                }
            }
            if (start == pos) {
                throw new IllegalArgumentException("Expected number at pos " + start + " in: " + src);
            }
            return Double.parseDouble(src.substring(start, pos));
        }

        /** Parse "..."-quoted string with escapes, OR bare token (until , ] [). */
        String parseString() {
            skipWs();
            if (peek() == '"') {
                pos++; // consume opening "
                StringBuilder sb = new StringBuilder();
                while (pos < src.length() && src.charAt(pos) != '"') {
                    char c = src.charAt(pos);
                    if (c == '\\' && pos + 1 < src.length()) {
                        char esc = src.charAt(pos + 1);
                        switch (esc) {
                            case 'n':  sb.append('\n'); break;
                            case 't':  sb.append('\t'); break;
                            case 'r':  sb.append('\r'); break;
                            case '\\': sb.append('\\'); break;
                            case '"':  sb.append('"');  break;
                            case '\'': sb.append('\''); break;
                            case '0':  sb.append('\0'); break;
                            default:   sb.append(esc);
                        }
                        pos += 2;
                    } else {
                        sb.append(c);
                        pos++;
                    }
                }
                if (pos < src.length()) pos++; // consume closing "
                return sb.toString();
            }
            // bare token until separator
            int start = pos;
            while (pos < src.length()) {
                char c = src.charAt(pos);
                if (c == ',' || c == '[' || c == ']') break;
                pos++;
            }
            return src.substring(start, pos).trim();
        }
    }
}
