# Soccer API

Provide sports reporting for key sports is done by recorded set of discrete actions in a CSV file.

## API Guide

### `Competitions` Resource

#### Get a list of `Competitions` ordered by name

`GET /api/competitions`

#### Get a list of `Matches` by Competition name

`GET /api/match?competition_name={competionName}`

#### Get a list of `Actions` by Match ID

`GET /api/match/{matchId}/actions`

#### Get a list of `Actions` by Match ID and Action Type

`GET /api/match/{matchId}/action?action_type={actionType}`

## Developing

### System Requirements

- Java 1.11+

### Configure

Edit the application.properties files, including the `file.path` pointing to the CSV file. Example:
`file.path = C:\\temp\\MatchActions_PremierLeague20182019_20190927.csv`

### Building

```
$ ./mvnw clean install
```
