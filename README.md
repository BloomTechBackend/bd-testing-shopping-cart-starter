# bd-writing-testing-functional-requirements-shopping-cart

This activity is an exercise for participants to create a test plan, and to implement them as ~test methods that get called in a DIY test harness (based on a main() method).

We're going to create a test plan for a class called `ShoppingCart`. You will write test cases for two of the class's methods:

- `addItem()`
- `updateQuantity()`

After creating the test plan, you'll go ahead and implement some tests from your test plans.

This package contains the `ShoppingCart` class, which is the class under test, as well as traditional JUnit automated tests to test the class's behavior. **You may not modify the `ShoppingCart` class, or anything under the `src` directory!**

To learn about the `ShoppingCart` class, locate the javadocs folder, right click `index.html` and open in a browser.

## Instructions

You are to create at least **three new test cases** for the `ShoppingCartTest` class. Open the `shopping_cart_test_cases.md` file under the `tst` directory for further instruction, and for example test cases.

## Running Your Tests

Type the following command into your terminal:

```text
./gradlew clean -q :test --tests "com.amazon.ata.shoppingcart*"
```
