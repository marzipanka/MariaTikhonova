Feature: Exercise 1

  @ex1
  Scenario: Check Home Page and Different Elements Page
    Given I am on the JDI index page
    Then URL should be 'https://epam.github.io/JDI/index.html'
    And Browser title should be equal to 'Home Page'
    When I log in as
      | userName | password |
      | epam     | 1234     |
    Then User name in the right-top side of screen should be 'PITER CHAILOVSKII'
    And Home Page should contain 4 pictures
    And Home Page should contain 4 texts under pictures
    And Home Page should contain headline
    And Home Page should contain description under headline
    When I click on 'Service' subcategory in the header
    Then Header Service dropdown should contain options
    When I click on 'Service' subcategory in the left section
    Then Left Service dropdown should contain options
    When I open through the header menu Service -> Different Elements Page
    Then URL should be 'https://epam.github.io/JDI/different-elements.html'
    And Different Elements Page should contain 4 checkboxes
    And Different Elements Page should contain 4 radios
    And Different Elements Page should contain 1 dropdown
    And Different Elements Page should contain 2 buttons
    And Right section should be displayed
    And Left section should be displayed
    When I select checkboxes
      | Water | Wind |
    Then Elements should be checked
      | Water | Wind |
    And Log row should be displayed 'Water' 'condition' 'true'
    And Log row should be displayed 'Wind' 'condition' 'true'
    When I select radio 'Selen'
    Then 'Selen' element should be checked
    And Log row should be displayed 'metal' 'value' ' Selen'
    When I select 'Yellow' in dropdown
    Then Log row should be displayed 'Colors' 'value' 'Yellow'
    When I unselect checkboxes
      | Water | Wind |
    Then Elements should be unselected
      | Water | Wind |
    And Log row should be displayed 'Water' 'condition' 'false'
    And Log row should be displayed 'Wind' 'condition' 'false'