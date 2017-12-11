Feature: School Endpoint Features

  Scenario: GET Schools
    Given POST /schools with body {"name": "Bhuwan"} json
    Then ASSERT statusCode is 201
    When GET /schools
    Then ASSERT statusCode is 200
    Then ASSERT body with jsonPath [0].name is equal to Bhuwan
