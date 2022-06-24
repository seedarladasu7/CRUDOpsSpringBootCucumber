Feature: Test CRUD methods with Employee REST API testing

Scenario: Save Employee record
    Given I Set POST employee service api endpoint for save employee
	When I Set request HEADER for save employee
	And Send a POST HTTP request for save employee
	Then I receive valid Response for save employee
	
Scenario: Get Employee record
    Given I Set GET employee service api endpoint for get employee
	When I Set request HEADER for get employee
	And Send a GET HTTP request for get employee
	Then I receive valid Response for get employee
	
Scenario: Get list of Employee records
    Given I Set GET employee service api endpoint for get all employees
	When I Set request HEADER for get all employees
	And Send a GET HTTP request for get all employees
	Then I receive valid Response for get all employees
	
Scenario: Update Employee record
    Given I Set PUT employee service api endpoint for update employee 
	When I Set request HEADER for update employee
	And Send a PUT HTTP request for update employee
	Then I receive valid Response for update employee
	
Scenario: Delete Employee record
    Given I Set DELETE employee service api endpoint for delete employee
	When I Set request HEADER for delete employee
	And Send a DELETE HTTP request for delete employee
	Then I receive valid Response for delete employee