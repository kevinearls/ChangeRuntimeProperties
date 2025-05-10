# Change Runtime Properties

See https://www.baeldung.com/spring-boot-properties-dynamic-update

## To run:

$ curl "http://localhost:8080/properties/customProperty"
defaultValue

$ curl -X POST "http://localhost:8080/properties/update?key=my.custom.property&value=baeldungValue"
Property updated. Remember to call the actuator /actuator/refresh

$ curl -X POST http://localhost:8080/actuator/refresh -H "Content-Type: application/json"
[]

$ curl "http://localhost:8080/properties/customProperty"
baeldungValue

