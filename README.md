# Sikt programming task 3

This task is a simple TDD task used in interviews. There is no great pressure, both sides are getting to know each other and the point is to (a) reason about code and (b) have fun.

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
And the request returns data equivalent to:
```
{
  "id": "1",
  "name": "Smith, Sandy",
  "dob": "1992-03-07"
}
```
Then the data is transformed to something equivalent to this JSON structure:
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

The task is written in Java 21 and uses the Gradle build system.

Firstly build the existing project with the command `./gradlew build`.

From the build, you will see have set up the initial service with some passing and failing tests, it is our job to extend the service to fit the requirements.

