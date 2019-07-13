Feature: Exercise 2

  @ex2
  Scenario: User Table Page test
    Given I am on the JDI index page
    And I log in as
      | userName | password |
      | epam     | 1234     |
    When I click on 'Service' subcategory in the header
    And I click on 'User Table' button in Service dropdown
    Then Browser title should be equal to 'User Table'
    And '6' NumberType Dropdowns are displayed on Users Table on User Table Page
    And '6' User names are displayed on Users Table on User Table Page
    And '6' Description images are displayed on Users Table on User Table Page
    And '6' Description texts under images are displayed on Users Table on User Table Page
    And '6' checkboxes are displayed on Users Table on User Table Page
    And User table contains following values:
      | Number | User             | Description     |
      | 1      | Roman            | Wolverine       |
      | 2      | Sergey Ivan      | Spider Man      |
      | 3      | Vladzimir        | Punisher        |
      | 4      | Helen Bennett    | Captain America |
      | 5      | Yoshi Tannamuri  | Cyclope         |
      | 6      | Giovanni Rovelli | Hulk            |
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then Log row should be displayed 'Vip' 'condition' 'true'
    When I click on dropdown in column Type for user 'Roman'
    Then Droplist contains values
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |
