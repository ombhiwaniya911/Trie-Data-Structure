# Trie Data Structure

A Trie data structure that uses the **binary representation of integers** to efficiently handle multiple queries such as insertion, deletion, order statistics, and XOR operations.

---

## 🧩 Supported Java Versions

- Java 8+
- Java 11
- Java 17+

---

## ⚙️ Functionalities

This **Trie** data structure supports the following operations:

### ➤ `insert(x, y)`
- Inserts **`y` occurrences** of the integer `x`.
- Default value of `y` is **1**.

---

### ➤ `erase(x, y)`
- Erases **`y` occurrences** of the integer `x`.
- Default value of `y` is **1**.

---

### ➤ `count(x)`
- Returns the **number of occurrences** of integer `x`.

---

### ➤ `findSmallest(k)`
- Returns the **k-th smallest integer** in the Trie.
- Default value of `k` is **1**.

---

### ➤ `eraseSmallest(k)`
- Erases the **k-th smallest integer**.
- Default value of `k` is **1**.

---

### ➤ `findGreatest(k)`
- Returns the **k-th greatest integer** in the Trie.
- Default value of `k` is **1**.

---

### ➤ `eraseGreatest(k)`
- Erases the **k-th greatest integer**.
- Default value of `k` is **1**.

---

### ➤ `countSmaller(x, y)`
- If `y = 0` → Returns count of integers **strictly smaller** than `x`.
- If `y = 1` → Returns count of integers **smaller than or equal to** `x`.
- Default value of `y` is **0**.

---

### ➤ `countGreater(x, y)`
- If `y = 0` → Returns count of integers **strictly greater** than `x`.
- If `y = 1` → Returns count of integers **greater than or equal to** `x`.
- Default value of `y` is **0**.

---

### ➤ `minxor(x)`
- Returns the **minimum value of `x XOR y`**  
  where `y` is any integer present in the Trie.

---

### ➤ `maxxor(x)`
- Returns the **maximum value of `x XOR y`**  
  where `y` is any integer present in the Trie.

---

### ➤ `sorted()`
- Returns a vector containing **all integers in non-decreasing order**.

---

## 📌 Notes
- The Trie is implemented using **bitwise traversal**.
- Efficient for order statistics and XOR queries.
- Suitable for competitive programming and system-level problems.

---


Privacy
Security
