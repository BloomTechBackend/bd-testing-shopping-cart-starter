package com.amazon.ata.shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test class that runs through tests for the ShoppingCart class. Prints out results of tests to
 * the console.
 * <p>
 * Run the tests by running from the command line via RDE workflow, or directly in IntelliJ.
 */
public class ShoppingCartTest {
    /**
     * Calls the test methods, keeping track of whether each ShoppingCart method passes all of its tests or not.
     * Prints a summary of results. Note that some tests may not run if earlier tests fail.
     *
     * PARTICIPANTS: ADD CALLS IN THIS METHOD TO YOUR TEST METHODS THAT YOU WRITE BELOW.
     *
     * The {@code @Test} annotation here marks this as a unit test, so that JUnit runs the tests when the Brazil package
     * is built. We'll cover this in the Unit Testing lesson.
     */
    @Test
    void runAllTests() {
        ShoppingCartTest tester = new ShoppingCartTest();
        boolean pass = true;

        // addItem() tests

        System.out.println("\nTesting addItem()...");
        //Test Names: method_descriptivePhrase4Test_expectedResult
        pass = tester.addItem_itemNameEmptyString_doesntAddItem() && pass;
        // PARTICIPANTS: uncomment the following lines, replacing [your test case method name] with calls to
        //               your actual test methods
        // pass = tester.[your test case 1 method name]() && pass;
        // pass = tester.[your test case 2 method name]() && pass;

        if (!pass) {
            String errorMessage = "\n/!\\ /!\\ /!\\ The addItem() method tests failed. Test aborted. /!\\ /!\\ /!\\";
            System.out.println(errorMessage);
            fail(errorMessage);
        } else {
            System.out.println("The addItem() method tests passed!");
        }


        // updateQuantity() tests

        System.out.println("\nTesting updateQuantity()...");
        pass = tester.updateQuantity_updateExistingItemWithZeroQuantity_removesItemFromShoppingCart() && pass;
        // PARTICIPANTS: uncomment the following lines, replacing [your test case method name] with calls to
        //               your actual test methods
        // pass = tester.[your test case 1 method name]() && pass;
        // pass = tester.[your test case 2 method name]() && pass;

        if (!pass) {
            String errorMessage = "\n/!\\ /!\\ /!\\ The updateQuantity() method tests failed. Test aborted. "
                    + "/!\\ /!\\ /!\\";
            System.out.println(errorMessage);
            fail(errorMessage);
        } else {
            System.out.println("The updateQuantity() method tests passed!");
        }


        System.out.println("\nAll tests passed!");
    }


    // addItem() test cases:  -------------------------------

    private boolean addItem_itemNameEmptyString_doesntAddItem() {
        // GIVEN - set up the data for the test
        // GIVEN - an empty ShoppingCart
        ShoppingCart cart = new ShoppingCart();  // Instantiate an object containing method to test

        // WHEN - condition of the data for the test
        // WHEN - add an item with empty string for name
        boolean result = cart.addItem("", 1);  // Note: quantity doesn't for  this test

        // THEN - Run the test and check for expected result
        // THEN - add to cart should have failed, and ShoppingCart should be empty

        // Verify the expected result - false because an empty itemName should not be added
        if (result) {
            System.out.println("  FAIL: Adding item '' should not have succeeded");
            return false;
        }

        // Additional verification that the cart is empty - item should not have been added
        if (cart.getItems().length > 0) {  // Cart not empty - test failed
            System.out.println(
                    String.format("  FAIL: Adding item '' should keep ShoppingCart empty, but contains %s",
                            Arrays.toString(cart.getItems())
                    )
            );
            return false;
        }

        System.out.println("  PASS: Adding '' to ShoppingCart was rejected, as was expected.");
        return true;
    }

    // PARTICIPANTS: ADD YOUR addItem() tests here

    // Test for click to add an item and it's successfully placed in  the cart
    // Test Names: method_descriptivePhrase4Test_expectedResult
    public boolean addItem_ValidItemNameWithValidQuantity_AddedToTheCart() {
        // GIVEN - Set up the data
        ShoppingCart shoppingCart = new ShoppingCart();  // Instantiate an object with the method to test

        // WHEN - execute the method with data for test
        boolean jinkies = shoppingCart.addItem("Banana",3);

        // THEN - Check to see if test worked based on the result
        if (jinkies == true) {
            System.out.println("  PASS: Adding 'Banana' to ShoppingCart was successful, as was expected.");
            return true;
        }
        else {
            System.out.println("FAILED: failed to add item to cart");
            return false;
        }

    }


    // updateQuantity() test cases:  ------------------------

    private boolean updateQuantity_updateExistingItemWithZeroQuantity_removesItemFromShoppingCart() {
        // GIVEN - A ShoppingCart with one type of item with a quantity of one.
        String itemName = "Instant Pot";
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(itemName, 1);

        // WHEN - Update the quantity by calling `updateQuantity()` for the item with a quantity of zero.
        boolean result = cart.updateQuantity(itemName, 0);

        // THEN - update is allowed and `getItems()` response does not contain the original item.
        if (!result) {
            System.out.println(String.format("  FAIL: Failed to update quantity on item \"%s\"", itemName));
            return false;
        }
        if (cartContainsItemAndQuantity(cart, itemName, 0)) {
            System.out.println(
                    String.format("  FAIL: After setting quantity to 0, did not expect to find item \"%s\" in ShoppingCart",
                            itemName)
            );
            return false;
        }

        System.out.println(
                String.format("  PASS: After setting quantity to 0, ShoppingCart no longer contains item \"%s\"",
                        itemName)
        );
        return true;
    }

    // PARTICIPANTS: ADD YOUR updateQuantity() tests here


    /**
     * The entry point, which results in calls to all test methods. We'll talk about this soon, but if you want to
     * understand a little more about the significance of the main() method, Google "public static void main".
     *
     * @param args Command line arguments (ignored).
     */
    public static void main(String[] args) {
        ShoppingCartTest tester = new ShoppingCartTest();
        tester.runAllTests();
    }

    /**
     * Helper method for checking that an expected item/quantity was found in the ShoppingCart. Feel free to use this
     * in your tests as well!
     *
     * @param cart the {@code ShoppingCart} to test
     * @param itemName the name of the item expected to be in {@code cart}
     * @param quantity the expected quantity for the item to be in {@code cart}
     * @return {@code true} if the item is found with the specified quantity, {@code false} otherwise.
     */
    private boolean cartContainsItemAndQuantity(ShoppingCart cart, String itemName, int quantity) {
        boolean foundItemWithQuantity = false;
        for (ShoppingCartItem item : cart.getItems()) {
            if (item.getItemName().equals(itemName) && item.getQuantity() == quantity) {
                foundItemWithQuantity = true;
            }
        }

        return foundItemWithQuantity;
    }
}