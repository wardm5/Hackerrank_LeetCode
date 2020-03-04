//-------------------------------------------------------------------------------
//    Misha Ward
//-------------------------------------------------------------------------------

/*-------------------------------------------------------------------------------

Problem:
Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A
will call first(), thread B will call second(), and thread C will call third().
Design a mechanism and modify the program to ensure that second() is executed
after first(), and third() is executed after second().



Example 1:
Input: [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously. The input [1,2,3]
means thread A calls first(), thread B calls second(), and thread C calls third().
"firstsecondthird" is the correct output.

-------------------------------------------------------------------------------*/

//-------------------------------------------------------------------------------
//    Approach
//-------------------------------------------------------------------------------

/*
    1) create counter, run the initial Runnable, increment counter
    2) if the counter is not equal to 2, then loop, otherwise run the second runnable
    3) if the counter is not equal to 3, then loop, otherwise run the third runnable
*/

//-------------------------------------------------------------------------------
//    Soluton
//-------------------------------------------------------------------------------

class Foo {
    int counter = 0;
    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        counter++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (counter != 1) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        counter++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (counter != 2) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

/*
    Runtime: 7 ms, faster than 100.00% of Java online submissions for Print in Order.
    Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Print in Order.
*/
