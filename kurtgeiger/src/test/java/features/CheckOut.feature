Feature:checkout page

  Scenario:I am able to select a product from men category and proceed to checkout page
    Given I select "men" category from the header
    And I am on PDP
    When I select colour "brown" and size "40" for the chosen men category
    And I add the product to the bag
    Then I can see the bag with single item
    And I click 'Proceed to Checkout'
    Then I should be on checkout page

  #Scenario:I am able to checkout as a guest user
    Given I checkout as a guest
    When I enter all the billing and delivery details
    And I click 'Continue to Payment'
    Then I should be on the payment summary page
    When I select to pay by card
    And I enter credit card "4929000000008" with "0821" expiry date
    And I enter "123" CVC code
    Then I should see "Your card number has failed our validity checks and appears to be incorrect Please check and re-enter”
