Feature: Brands

  Background:
    Given I am on the homepage

    Scenario: Select a Brand to view its list of products
When I select "Brands" category from the header
Then I should see the list of brands
And I select "DOLCE & GABBANA" brand from the list
Then I should see the list of products from "DOLCE & GABBANA"

