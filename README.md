# Change Runtime Properties

See https://www.baeldung.com/spring-boot-properties-dynamic-update

## To run:

$ curl "http://localhost:8080/properties/customProperty"
defaultValue

$ curl -X POST "http://localhost:8080/properties/update?key=my.custom.property&value=baeldungValue"
Property updated. 

$ curl "http://localhost:8080/properties/customProperty"
baeldungValue

