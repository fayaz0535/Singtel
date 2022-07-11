Feature: Manage ToDo List
  In order to remember the things I want to do, as a ToDo MVC user,
  I want to manage my todo list

  Scenario: Verify ToDo Item is added to the ToDo List
    Given I launch ToDo App
    When I Add TODO Item "watch tv"
    Then TODO Item "watch tv" should be displayed in the active TODO List

  Scenario: Verify ToDo Item is Completed
    Given I launch ToDo App
    When I Add TODO Item "watch tv"
    And I Complete a TODO Item "watch tv"
    Then TODO Item "watch tv" should be marked as completed in the TODO List

  Scenario: Verify ToDo Items Left - After Adding a ToDo Item
    Given I launch ToDo App
    When I Add TODO Item "watch tv"
    Then the count of ToDo Items left should be displayed "1"

  Scenario: Verify ToDo Items Left - After Completing a ToDo Item
    Given I launch ToDo App
    When I Add TODO Item "watch tv"
    And I Add TODO Item "take medicine"
    And I Complete a TODO Item "watch tv"
    Then the count of ToDo Items left should be displayed "1"

  Scenario: Verify ToDo Filter - For Active ToDo Items
    Given I launch ToDo App
    And I Add TODO Item "watch tv"
    And I Add TODO Item "take medicine"
    And I Complete a TODO Item "watch tv"
    When I Click on ToDo Filter "Active"
    Then TODO Item "take medicine" should be displayed in the active TODO List
    And TODO Item "watch tv" should not be displayed in the TODO List


  Scenario: Verify ToDo Filter - For All ToDo Items
    Given I launch ToDo App
    And I Add TODO Item "watch tv"
    And I Add TODO Item "take medicine"
    And I Complete a TODO Item "watch tv"
    When I Click on ToDo Filter "All"
    Then TODO Item "watch tv" should be marked as completed in the TODO List
    And TODO Item "take medicine" should be displayed in the active TODO List

  Scenario: Verify ToDo Filter - For Completed ToDo Items
    Given I launch ToDo App
    And I Add TODO Item "watch tv"
    And I Add TODO Item "take medicine"
    And I Complete a TODO Item "watch tv"
    When I Click on ToDo Filter "Completed"
    Then TODO Item "watch tv" should be marked as completed in the TODO List
    And TODO Item "take medicine" should not be displayed in the TODO List

  Scenario: Verify ToDo Filter - For Clear Completed ToDo Items
    Given I launch ToDo App
    And I Add TODO Item "watch tv"
    And I Add TODO Item "take medicine"
    And I Complete a TODO Item "watch tv"
    When I Click on ToDo Filter "All"
    And I Click on ToDo Filter "Clear Completed"
    Then TODO Item "watch tv" should be cleared from the TODO List
