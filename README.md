# Sikt programming task 3

This task is a simple TDD task used in interviews. There is no great pressure, both sides are getting to know each other and the point is to a) reason about code and b) have fun.

# Task definition

```
Scenario Outline:
    Given <Data> provided by a third party API <Uri>
    When the data is processed
    Then the result is returned in <Result>
      Examples:
        | Uri                          | Data                                                     | Result                                                                                                                                 |
        | https://example.org/person/1 | {"id": "1", "name": "Smith, Sandy", "dob": "1992-03-07"} | { "id": "https://example.org/person/1", "type": "Person", "name": { "type": "Name", "given": "Sandy", "family": "Smith" }, "age": 32 } |
```

## Task breakdown

Given an HTTP request GET https://example.org/person/1
And the request returns data:
```
{
  "id": "1",
  "name": "Smith, Sandy",
  "dob": "1992-03-07"
}
```
Then the data is transformed to:
```
{
  "id": "https://example.org/person/1",
  "type": "Person",
  "name": {
    "type": "Name",
    "given": "Sandy",
    "family": "Smith"
  },
  "age": 32
}
```

There are obviously a number of things to consider in this transformation.

## Programming

We have set up the initial service, it is your job to write the initial test for your extension of the service.

