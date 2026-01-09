# <u> OOPS Concepts</u>



### The Blueprint & The Building

Everything in Java starts with a definition (Class) and becomes a reality through creation (Object).



##### **Class vs. Object**

- **The Class (The Blueprint):** A logical template. It defines *what* data an entity will have and *how* it will behave, but it consumes no memory.

- **The Object (The Reality):** A physical instance of the class created in memory (RAM). You can build thousands of distinct objects from one class.
  
  
  
  ```java
  class Fruit  
  {  
  String name;  
  String tree;  
  }
  
  
  Fruit obj = new Fruit();
  ```
  
  

##### **Dynamic Memory Allocation (`new` keyword)**

When you create an object, you use the `new` keyword.

- **What it does:** It triggers **Dynamic Memory Allocation**. It finds free space in the **Heap Memory** at runtime and reserves it for your object.

- **Reference Variable:** The variable (e.g., `myCar`) lives in the **Stack** and holds the "remote control" (address) to the object in the Heap.



#### **Constructors (The "Birth" of an Object)**

A Constructor is a special block of code that runs **automatically** the moment an object is created. It is present inside the class. Its job is to initialize the object.

- **Rules:** Must have the **same name** as the Class and **no return type**.

- **Default Constructor:** If you don't write one, Java implicitly adds a blank one `ClassName() {}` just to allow object creation.

- **Constructor Overloading:** Creating multiple constructors with different parameters. This gives you flexibility to create objects in different ways.
  
  <u>e.g.</u>, creating a "User" with just a name, OR with a name and age.

- You can create a class and instantiate an obect even if you have not written any constructor ( *JAVA will provide you with a default constructor* ). But if you write one constructor, you cannot use the default constructors anymore.



```JAVA
class User 
{
    String name;
    int age;

    // 1. Default/No-Arg Constructor
    User(){
        this.name = "Guest";
        this.age = 18;
    }

    // 2. Parameterized Constructor (Overloading)
    User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


public class Main 
{
    public static void main(String[] args) 
    {
        User u1 = new User(); // Calls constructor 1
        User u2 = new User("John", 25); // Calls constructor 2
    }
}
```

---

### 

### **State & Scope Management**

Once objects exist, how do we manage their data?

##### **The `static` Keyword (Class Level vs. Object Level)**

In Java, normally when you create an object (e.g., `Car c1 = new Car()`), it gets its **own** storage for variables. `c1` has a color, `c2` has a color.

**`static` changes this rule.** If something is `static`, it does **not** belong to the object. It belongs to the **Class** itself.

- **Non-Static:** Every object gets a copy. (Personal Notebook)

- **Static:** There is only **ONE copy** shared by everyone. (Classroom Whiteboard)

### 

###### Static Variables (Shared Memory)

Use `static` for properties that should be common to all objects. If one object changes a static variable, **it changes for everyone**.

###### Static Methods (Helper Tools)

A `static` method is a tool that doesn't need to know about any specific object to work. It takes an input, processes it, and gives an output.

**The Golden Rule:** A static method can **ONLY** access other static variables or methods. It **cannot** touch instance variables (like `name` or `age`) because it doesn't know *which* object's name you are talking about.

```java
class Calculator 
{
    // Instance method: Needs an object to run
    void sayHello() {
        System.out.println("Hello User!");
    }

    // Static method: Independent tool
    static int add(int a, int b) {
        return a + b;
    }
}


public class Main {
    public static void main(String[] args) 
    {
        // Calling STATIC method: Use Class Name
        // No need to say "new Calculator()"
        int sum = Calculator.add(5, 10); 
        System.out.println(sum);


        // Calling INSTANCE method: Must create Object first
        // Calculator.sayHello(); // ERROR!
        Calculator calc = new Calculator();
        calc.sayHello(); // Works
    }
}
```



#### **2. The Singleton Pattern**

A **Singleton** is a design pattern that ensures a class has only **one instance** globally. It relies on `static`.

- **Recipe:** Private Constructor (stops `new`) + Static Instance Variable + Static Method to return that instance.



```java
class Database 
{
    private static Database instance = null; // The single copy

    private Database() {} // Private: No one can say "new Database()"

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database(); // Created only once
        }
        return instance;
    }
}
```

---

## **<u>The Four Pillars of OOP</u>**



These are the rules that govern how classes relate to one another.

##### **Pillar 1: Encapsulation (Security)**

Concept : Wrapping data and code together and restricting access. This prevents external classes from messing up internal data.

Tool: Access Modifiers.

- **Private:** Visible only within the **same class**. (Highest Security).

- **Default (no keyword):** Visible within the **same package**.

- **Protected:** Visible within the same package + **subclasses** (even if they are in different packages).

- **Public:** Visible **everywhere**.



```java
class BankAccount {
    private double balance; // Locked variable

    // Public gatekeeper (Setter)
    public void setBalance(double amount) 
    {
        if (amount > 0) { // Validation logic
            this.balance = amount;
        }
    }
}
```

#### **Pillar 2: Inheritance (Hierarchy)**

**Concept**: One class (Child) acquires properties of another (Parent). Promotes code reusability.

Keyword: extends.

The super Keyword: A reference to the immediate parent class. Used to call parent constructors or methods.

**Types of Inheritance in Java:**

1. **Single:** A $\rightarrow$ B.

2. **Multilevel:** A $\rightarrow$ B $\rightarrow$ C.

3. **Hierarchical:** A $\rightarrow$ B, A $\rightarrow$ C (One parent, multiple kids).

4. *Note: Java does **not** support Multiple Inheritance (A+B $\rightarrow$ C) with classes to avoid ambiguity.*



```java
// 1. The Parent Class (Base Class)
class Phone 
{
    // This method belongs to the Parent
    void makeCall() {
        System.out.println("Calling a number...");
    }
    
    void sendSMS() {
        System.out.println("Sending a text...");
    }
}


// 2. The Child Class (Derived Class)
// 'extends' keyword copies the functionality from Phone to SmartPhone
class SmartPhone extends Phone {
    // This is a new method specific ONLY to SmartPhone
    void browseInternet() {
        System.out.println("Browsing the web...");
    }
}


// 3. Execution
public class Main 
{
    public static void main(String[] args) 
    {
        SmartPhone myMobile = new SmartPhone();

        // INHERITED METHODS (Comes from Parent)
        // Notice: SmartPhone class didn't have code for makeCall(), 
        // but it works because it inherited it!
        myMobile.makeCall(); 
        myMobile.sendSMS();

        // OWN METHOD (Specific to Child)
        myMobile.browseInternet();
    }
}
```

#### 

#### **Pillar 3: Polymorphism (Flexibility)**

**Concept:** "Many Forms". The ability of a method to behave differently.

1. **Compile-Time (Overloading):** Same method name, different parameters. Solved during compilation.

2. **Run-Time (Overriding):** Child class provides a specific implementation of a Parent method. The JVM decides which one to call at runtime based on the object type.

```java
class Shape 
{
    void draw() { System.out.println("Drawing generic shape"); }
}


class Circle extends Shape 
{
    @Override // Annotation ensures we are actually overriding
    void draw() { System.out.println("Drawing Circle"); }
}
```



#### **Pillar 4: Abstraction (Hiding Complexity)**

Concept: Hiding how it works and showing only what it does.

Tools:

1. **Abstract Class:** A class that cannot be instantiated. It can have both normal methods and **abstract methods** (methods without a body).

2. **Interface:** A strict contract. All methods are abstract by default (pre-Java 8). A class can implement multiple interfaces.



```java
// Abstract Class
abstract class Car 
{
    abstract void drive(); // Idea only
    void playMusic() { System.out.println("Playing FM"); } // Concrete logic
}


class Tesla extends Car 
{
    void drive() { System.out.println("Electric Drive"); } // Must implement
}
```

---

### 

### **Critical Keyword Disambiguation**

These three words look similar but have completely different purposes.

| **Keyword**  | **Type** | **Purpose**                                                                                                                                                                               |
| ------------ | -------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **final**    | Modifier | **Restrictions.** <br>1. Variable: Value cannot change (Constant). <br>2. Method: Cannot be overridden. <br>3. Class: Cannot be inherited (e.g., String class).                           |
| **finally**  | Block    | **Cleanup.** Used in Exception Handling (`try-catch-finally`). This block **always** executes, regardless of whether an exception occurred or not. Used to close DB connections or files. |
| **finalize** | Method   | **Garbage Collection.** A method called by the Garbage Collector just before an object is destroyed. (Note: Deprecated in modern Java, but historically used for cleanup).                |



```java
// FINAL variable
final double PI = 3.14; 
// PI = 3.15; // Compiler Error!

// FINALLY block
try {
    int x = 10 / 0;
} catch (Exception e) {
    System.out.println("Error caught");
} finally {
    System.out.println("This runs no matter what.");
}
```
