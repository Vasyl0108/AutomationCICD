
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given Logged In with username <username> and password <password>
    When I check for the <value> in step
    Then "Incorrect email or password." message is displayed

    Examples: 
     | name                 | password     | 
     | chukvasyl@gmail.com  | 4513213Chuck |
     