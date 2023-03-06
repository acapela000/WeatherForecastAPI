# SQL

## Run

```bash
$ docker run -d \                                                                                                                                                                                                                                                                 11:18:46
    --name weatherdb \
    -e POSTGRES_PASSWORD=mysecretpassword \
    -e PGDATA=/var/lib/postgresql/data/pgdata \
    -p 5432:5432 \
    -v $(pwd)/db:/var/lib/postgresql/data \
    postgres
```

## Diagram

```mermaid
erDiagram
    LOCATION |o -- o{ WEATHER_FORECAST : "weatherForecastList"
    USER }o -- o{ LOCATION : "locationList"
    USER }| -- o{ ROLE : "roleList"
    
    WEATHER_FORECAST {
        int id PK
        string icon
        double temperature
        string condition
        boolean isPrecipitating
        double humidity
        Date lastUpdated "default to current date"
    }
    LOCATION {
        string name
        string state "default to empty string"
        string city PK
        string country PK
        WeatherForecast weatherForecastList "default to empty list"
    }
    USER {
        int id PK
        string username "unique"
        string email "unique"
        string password "hashed"
        Location locationList "default to empty list"
        Role roleList "default to Role with name 'guest'"
    }
    ROLE {
        enum name PK "unique 'admin', 'scientist', 'user', or 'guest'"
        string description "default to empty string"
    }
```
