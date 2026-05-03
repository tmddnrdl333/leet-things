# leet-things

Personal LeetCode practice repo. Solutions in Java 21.

To make problems runnable straight from the IDE, this repo includes a small
helper (`LeetIO`) that parses LeetCode-style bracket inputs
(`[2,7,11,15]`, `[[1,2],[3,4]]`, `"hello"`) directly from `System.in`, and
pretty-prints results in the same notation LeetCode uses for expected outputs.
Just paste the example block from the problem page into the run console and
hit enter.

---

## Project layout

```
src/
├── leet/
│   ├── LeetIO.java     input parser + pretty printer
│   ├── ListNode.java   LeetCode-standard singly linked list node
│   ├── TreeNode.java   LeetCode-standard binary tree node
│   └── Node.java       unified N-ary tree / graph node
└── solutions/
    └── TwoSum.java     usage pattern / template
```

Each problem lives in its own file under `solutions/`, with a `main` method
that reads input via `LeetIO`, calls the solution method, and prints the result.

## LeetIO

A `Scanner(System.in)` wrapper. Each `next*` call consumes one line and parses
it as the requested LeetCode bracket form.

### Read

| Category | Methods | Example input |
|---|---|---|
| Scalar | `nextInt`, `nextLong`, `nextDouble`, `nextBoolean`, `nextChar`, `nextString` | `42`, `3.14`, `true`, `"hello"` |
| 1D array | `nextIntArray`, `nextLongArray`, `nextDoubleArray`, `nextBooleanArray`, `nextCharArray`, `nextStringArray` | `[1,2,3]`, `["a","b"]` |
| 2D matrix | `nextIntMatrix`, `nextLongMatrix`, `nextDoubleMatrix`, `nextCharMatrix`, `nextStringMatrix` | `[[1,2],[3,4]]` |
| List | `nextIntList`, `nextLongList`, `nextStringList`, `nextIntListList`, `nextStringListList` | `[1,2,3]`, `[[1,2],[3]]` |
| Structures | `nextListNode`, `nextTreeNode`, `nextNAryNode`, `nextGraphNode` | `[1,2,3]`, `[1,2,3,null,4]`, `[1,null,3,2,4,null,5,6]`, `[[2,4],[1,3]]` |

Empty arrays (`[]`), negatives, whitespace, and string escapes (`\n`, `\t`,
`\"`) are all accepted.

### Print

`print(...)` / `println(...)` overloads cover every input type and emit
LeetCode-style notation:

- Arrays / matrices / Lists: `[1,2,3]`, `[[1,2],[3,4]]` (compact, single line)
- `ListNode`: walked to end → `[1,2,3]`
- `TreeNode`: BFS level order with `null`, trailing nulls trimmed → `[1,2,3,null,4]`
- N-ary `Node`: `printNAry()` → `[1,null,3,2,4,null,5,6]`
- Graph `Node`: `printGraph()` → adjacency list `[[2,4],[1,3],...]`
- Debug helper: `printPretty(int[][])` — multi-line indented matrix

## Adding a solution

1. Create a new file under `src/solutions/` (e.g. `Solution001.java`)
2. Write the solution method
3. In `main`, read input with `LeetIO`, call the method, print with `io.println(...)`
4. Run the class in IntelliJ (`Ctrl+Shift+F10` on the file)
5. Paste the LeetCode example into the run console

[`solutions/TwoSum.java`](src/solutions/TwoSum.java) is the template:

```java
package solutions;

import leet.LeetIO;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) { /* ... */ }

    public static void main(String[] args) {
        LeetIO io = new LeetIO();
        int[] nums = io.nextIntArray();
        int target = io.nextInt();
        io.println(new TwoSum().twoSum(nums, target));
    }
}
```

Input:
```
[2,7,11,15]
9
```
Output:
```
[0,1]
```

## Environment

- Java 21 (Temurin)
- IntelliJ IDEA
- No build tool — `src/` is the source root, zero dependencies
