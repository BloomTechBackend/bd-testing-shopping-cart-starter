# Test plan for ShoppingCart

## Expectations

Document your test cases in this document. Remember:
* Each test case should be clear and testable, specifying the relevant preconditions, invariants, and postconditions
* Cover the 'happy path' (typical input that isn't a tricky edge case) **and** less common cases that are easy to
  miss when implementing a class (e.g. off-by-one errors with arrays, `null`s, empty arrays, empty Strings...)

We'll follow these standards in our test cases here (which match the Unit 1 Project expectations as well, so it's
great practice!):

### Each test case includes:
* A name. Naming:
    * `methodUnderTest_testCondition_expectedBehavior()`, replacing each segment of the name with an appropriate
      camel-case (starting with lowercase letter) description of each. See the example below.
        * `methodUnderTest`: Copy the method name exactly for the method you're testing on ShoppingCart
        * `testCondition`: Briefly name the condition you're testing for, which might include information from
          the GIVEN and/or WHEN sections below.
        * `expectedBehavior`: Briefly explain what you'll be looking for after calling the method under test. This
          should correspond to the THEN section below.
* A short description (sentence or two)
* "GIVEN":
    * The pre-conditions required for the test to take place. A *bulleted list* of the state of the object that
      is relevant for this test. Describe what you're doing to the object under test (rather than list method calls)
      to set up the test case. This may be as simple as "An empty ShoppingCart". See the example below.
* "WHEN":
    * A *numbered list* of the actions you'll take that you're trying to verify the behavior of.
      This is most often the method that you're calling plus a description of the values you're passing in as
      arguments. See the example below.
* "THEN":
    * A *bulleted list* of the testable results you're going to verify in the test. State what you expect to be
      true after the method is called. This may include the method's return value, or the results of other calls
      you make to the object after the WHEN step. See the example below.

### Example

1. **updateQuantity_updateExistingItemWithZeroQuantity_removesItemFromShoppingCart**
    * **Description**: Start with a ShoppingCart with one item in it, and update the item's quantity with a quantity
      of zero; the ShoppingCart should then return an array that does not contain that item when `getItems()` is called.
    * GIVEN
        * A ShoppingCart with one type of item with a quantity of one.
    * WHEN
        1. Update the quantity by calling `updateQuantity()` for the item with a quantity of zero.
    * THEN
        * update is allowed and `getItems()` response does not contain the original item.
1. ... [next test case] ...

## Your Test Plan

Use the below as a template and create at least three test cases (not including the one above!) for the method that
you're responsible for testing. Be sure to include the "happy path" as one of your test cases. (replace anything in
brackets "[ ]" with the appropriate replacement--there should be no brackets in the test case name when you're done)

1. **[methodUnderTest]_[testCondition]_[expectedBehavior]**
    * **Description**: [short description of the test case]
    * GIVEN
        * [bulleted list of relevant pre-conditions for the test to run (usually data you're setting up to test)]
    * WHEN
        1. [ordered list of methods you will call with description of relevant arguments]
        1. [most of your test cases will have a single WHEN item, but if you want more than one keep this line]
    * THEN
        * [bulleted list of verifications that you will perform to see if the test case passes]
