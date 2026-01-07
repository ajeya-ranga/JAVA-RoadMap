<u>What is a String in Java?</u>
=========================

In C or C++, a string is just a character array (`char[]`). In Java, `String` is a **Class**. This means every string you create is actually an Object.
Syntax:-> ``String name = "Gemini"``





### Internal Storage

Internally, a String is stored as a `byte[]` (or `char[]` in older Java versions) inside the wrapper object.

##### Memory Management: The String Constant Pool (SCP)

Java manages strings differently from other objects to save memory.

* **The Heap:** This is where all objects live.
* **String Constant Pool (SCP):** A special reserved area inside the Heap.

##### **How it works ?**

1. **Literal Assignment (`String s = "Hello"`):** Java checks the SCP. If "Hello" exists, it returns the *reference* to the existing one. It does **not** create a new object. This saves memory.
2. **Object Assignment (`String s = new String("Hello")`):** This forces Java to create a **new object** in the main Heap area, even if "Hello" is already in the Pool. (It is generally avoided for this reason).





### Immutability: What and Why?

**Immutable** means "unchangeable." Once a String object is created, its data cannot be modified.

* *Example:* If you do `String s = "Hello"; s = s + " World";`, you are NOT changing the original "Hello" string. Java creates a brand new string "Hello World" in memory and points `s` to it. The old "Hello" sits there until Garbage Collection cleans it up.

##### **Why did Java make Strings immutable? **

1. **Security:** Strings are used for database connections, usernames, and passwords. If strings were mutable, a hacker could change the reference to a file path or database after the security check but before the file is opened.
2. **Thread Safety:** Since the data can't change, multiple threads can access the same String variable without any risk of data corruption. You don't need synchronization.
3. **String Pool Efficiency:** If one reference changed the data (e.g., changed "Hello" to "Yello"), every other variable pointing to "Hello" in the pool would instantly become wrong. Immutability makes the Pool possible.



### Comparison: `==` vs `.equals()`

This is the most common bug source for beginners.

* **`==` (Reference Comparison):** Checks if two variables point to the **exact same address** in memory.
  * `"Hello" == "Hello"`  `true` (Both in Pool).
  * `new String("Hello") == "Hello"`  `false` (One in Heap, one in Pool).

* **`.equals()` (Content Comparison):** Checks if the **actual characters** inside the string are the same.
  
  
* <mark>*Rule:* Always use `.equals()` for checking string values.</mark>





### Important Methods & Features

* **`.charAt(index)`:** Returns the character at a specific position. `str.charAt(0)` gives the first letter.
* **`.toString()`:** Every class has this. For Strings, it just returns itself. For other objects (like Arrays), you often override this to print meaningful data instead of memory addresses.
* **Operator Overloading (`+`):** Java does not support user-defined operator overloading, but the `+` operator is "overloaded" internally for Strings to support concatenation. `("a" + "b")` becomes `"ab"`.
* **Pretty Printing (`printf`):** Similar to C, you can use format specifiers for cleaner output.
  
  ```java
  float num = 12.3456f;
  System.out.printf("Formatted number: %.2f", num); // Output: 12.35
  ```
-     **`.substring(int start, int end)`:** Extracts a portion of the string.
  
          *Note:* The range is **[inclusive, exclusive)**. `str.substring(0, 3)` gives                   indices 0, 1, and 2.

- **`.indexOf(String s)`:** Finds the index of the *first* occurrence of a substring. Returns `-1` if not found.

- **`.split(String regex)`:** Splits a string into an array based on a delimiter (e.g., spaces or commas).

            *Example:* `str.split(" ")` turns `"Hello World"` into `["Hello", "World"]`.

- **`.trim()` / `.strip()`:** Removes leading and trailing whitespace. (Vital for cleaning user input).

- **`.toCharArray()`:** Converts the String into a primitive `char[]`.

- *Why use it?* Iterating over a `char[]` is faster than calling `.charAt()` repeatedly in a loop.





### StringBuilder (The Mutable Alternative)

Because Strings are immutable, concatenating them in a loop is a **performance disaster**.

* *Bad Approach:* In a loop of 1000 items, `s = s + i` creates 1000 brand new String objects in memory, filling the Heap with garbage.

**Enter StringBuilder:**
`StringBuilder` is a mutable sequence of characters. When you modify it, it changes the existing object directly without creating new ones.

* **Use Case:** Always use `StringBuilder` when you need to manipulate text inside loops or perform frequent modifications.

| Feature          | String                 | StringBuilder                             |
| ---------------- | ---------------------- | ----------------------------------------- |
| **Mutability**   | Immutable              | Mutable                                   |
| **Storage**      | String Pool / Heap     | Heap Only                                 |
| **Performance**  | Slow for concatenation | Very Fast                                 |
| **Thread Safe?** | Yes                    | No (Use `StringBuffer` for thread safety) |





### The Third Player: `StringBuffer`

You know `String` (Immutable) and `StringBuilder` (Mutable, Fast). There is a third one: **`StringBuffer`**.

- **What is it?** It is exactly like StringBuilder (mutable), but it is **Thread-Safe** (Synchronized).
- **When to use it?** Only in multi-threaded environments where multiple threads might be modifying the same string text simultaneously.
- **Why not always use it?** Because the thread safety comes with a performance cost. It is slower than StringBuilder.

**Comparison Summary:**

- **String:** Immutable. Use for constants, parameters, map keys.
- **StringBuilder:** Mutable, Not Thread-Safe. Use for local string manipulation (loops). **(Default choice for coding)**.
- **StringBuffer:** Mutable, Thread-Safe. Use for shared string resources in multi-threading.###  





### The `intern()` Method (The Memory Trick)

This is an advanced concept but a favorite for "Gotcha" questions.

- **Scenario:** You created a string using `new String("Hello")`. This forces it into the Heap, not the Pool.

- **The Fix:** You can call `str.intern()`.

- **What it does:** It checks the String Constant Pool.

- If "Hello" is already there, it returns the reference to the Pool version.

- If "Hello" is *not* there, it moves your string into the Pool.

- *Use Case:* Used to save memory when you have thousands of duplicate strings loaded from a file/database.





### Edge Case: Comparison of `String` vs `StringBuilder`

Be careful: **StringBuilder does NOT override `.equals()**`.

- `sb1.equals(sb2)` checks for **reference equality** (like `==`), not content equality.
- *Correct way to compare:* You must convert them to strings first: `sb1.toString().equals(sb2.toString())`.





### ASCII / Unicode Values

In coding problems (especially "hashing" or "anagram" problems), you often need to treat characters as numbers.

- **'a'** = 97
- **'A'** = 65
- **'0'** = 48
- *Tip:* To find the alphabet index (0-25) of a lowercase character `c`, use: `int index = c - 'a';`. (e.g., 'c' - 'a' = 99 - 97 = 2).









### Important Coding Questions (Lab Practice)

These are standard questions you should be able to solve:

- [ ] **Palindrome Check:** Check if a string reads the same forward and backward (e.g., "madam", "racecar"). *Hint: Two pointers, start and end.*
- [ ] **Reverse a String:** Don't use the built-in `.reverse()`. Write the logic manually using a loop or pointers.
- [ ] **String Compression:** Convert "aaabbc" to "a3b2c1".
- [ ] **Largest/Shortest Word:** Find the largest word in a sentence string.
- [ ] **Remove Duplicates:** Remove duplicate characters from a string (e.g., "programming"  "progamin").



### 





### 
