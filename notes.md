<div align="center">

# Java Notes

</div>

## _this_ keyword :

- Used to reference the current object in java.

**Shadowing** : When the input parameter shares the same name as that of the instance variable, the shadow of the input parameter falls on the instance variable and the instance variable remains unchanged, this concept is known as shadowing.

- Due to shadowing, _JVM_ is unable to distinguish between variable and instance variable.
- To get rid of Shadowing, we use _this_.

### Example :

```java
class account{
    String name = "Bharath";
    void newname(String name){
        this.name = name; //this refers to reference variable rather than parameter.
    }
}
```

## Types of Constructors:

2 types of constructors :

- Default Constructor

```java
public class BankAccount {
    int balance;
    BankAccount(){
        balance = 5000;
    }
}
//BankAccount Ram = new BankAccount();
```

- Parametric Constructor

```java
public class BankAccount {
    int balance;
    BankAccount(int bal){
        balance = bal;
    }
}
//BankAccount Ram = new BankAccount(1000);
```

Can Object have multiple states at the time of its creation? If yes, how is it achieved?

> Yes, an object can have multiple states while creation. It can be created by _Default Constructor_ or _Parametric Constructor_. We can also have multiple constructors. See the example [here](./BankAccount.java)

## Constructor:

- A constructor is a **code block** that is used to initialize a object.
- It has the same name as the class in which it resides.
- It is syntactically same as a method. But it is **not** a method. Because we can not call a constructor again and again in a single lifetime of a object. We can call a method as many times as we want.
- Constructor is automatically invoked whenever an object of class is created. you cannot invoke a constructor.
- It is called an executed only once per object.
- Default Constructors are the ones which are created without parameters.

There are 2 types of constructors. They are

- Implicit Constructor
- Explicit Constructor

> The _Implicit Constructor_ only works when there is **no** constructor declared.
>
> If we have one or more constructors defined, JVM will not invoke a _Implicit Constructor_. We have to declare a _Explicit Constructor_.

If there are two constructors with same number of parameters, JVM chooses a constructor only when

---

When we create a instance variable, it gets created for every object. But incase of methods they don't get copied like instance variables, they belong to the class. Similarly, if we want a variable to be same for all objects (be wrt to the class) then we make it a static variable.

## Static Variable

A variable which belongs to the class is called as a static variable.

- **Perm gen** is a area which stores the _static variables_.

- **Heap** is where the objects are stored.

```Java
class Book{
    static int stock; // same for all objects.
    String bookName;
    double bookPrice;
    Book(String name,double price){
        stock++; // Keeps track of how many books are there.
        bookName = name;
        bookPrice = price;
    }
}
```

- We don't need to create a instance of the class ( _a.k.a object_ ) to access a Static Variable.

```java
System.out.println(Book.stock); // works.
Book book1 = new Book("name1",2000)
System.out.println(book1.stock); // works here too.
book1.stock = 20; // Will change the original stock.
```

- Static Variables are created when the class is loaded and they die when the class is unloaded.

- Static Variables are created because of **Memory Efficiency**.

#### What is a Static Method?

To invoke a static method, we don't have to create a object, but whereas the regular methods need to be invoked only after creating a object. But both the methods aren't copied for every method.

### Why is the _main_ method Static?

JVM invokes main without creating the filename-object. It directly invokes `filename.main()`. If we made it just `public void main()` instead of `public static void main()` then the JVM will not be able to invoke main directly. This is the reason for it being static.

**Deepa mam Answer:**

Whenever a method is declared as static, it can be directly invoked without creating an object. Static methods belong to class. So, as soon as the class is loaded into JVM, the static method is available to be invoked.

### Whenever you declare a method as static, instance variables cannot be used in this context. Why?

- Static variables can't use instance variables. They can, however, use local/static variables.

- This is also the reason for not being able to use non static methods in a static context.

- Memory for static members is allocated only once at class loading.

- Cannot use [**_this_**](#this-keyword-) or [**_super_**]()

> Can a reference variable be declared as Static? [Single ton designing pattern.]

## Initializers

> Read Initializers from the Internet.

```java
class Bank{
    int balance;
    static String BankName;
    Bank(int b){
        balance = b;
    }
    {
        BankName = "1";
        System.out.println("Initializer 1 Called "+BankName);
    }
    static {
        BankName = "something";
        System.out.println("Static Initializer Called "+BankName);
    }
    {
        BankName = "2";
        System.out.println("Initializer 2 Called "+BankName);
    }

    public static void main(String[] args){
        Bank b1 = new Bank(2);
        System.out.println(b1.balance);
    }
}
```

`{ ... }` is called **Instance Initializer**, its called by JVM automatically before anything else, and if there are multiple then they are called in the order they are defined.

### Output :

```
Static Initializer Called something
Initializer 1 Called 1
Initializer 2 Called 2
2
```

#### Anything that is instance can use static but anything that is instance cannot use static.

### Why do we need Initializers?

- **Static Initializer :** In order to initialize static variables or to execute any piece of code when a class is loaded, we use static initializers.

- **Instance Initializer :** If we write a code and we need that to be executed when a instance is created, we use Instance Initializer.

- Initializers are executed before constructors.

### What is Constructor Chaining?

In a class, there can be several constructors present (overloaded constructors) and all these constructors should be invoked while creating a single object. Then we used the concept of constructor chaining.

We do this with `this(args);`

### Why do we need constructor chains?

Depending on the data available, different constructors are invoked, resulting in different states of the object. But, if all the objects need to come together and have the same state, then we need to chain these constructors.

## Order of execution

1. Class loaded
2. Static Variables load
3. Static Initializers load
4. Static methods load
5. `Bank SBI = ...` when this happens its called a instance being created.
   - `... = new Bank(args)` is where object is constructed.
6. Instance Variables load
7. Instance Initializers load
8. Constructors called
9. methods load
