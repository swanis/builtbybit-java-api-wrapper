# mcmarket-api-java-wrapper

This is a complete and easy-to-use Java Wrapper for the [MC-Market Ultimate API](https://www.mc-market.org/wiki/ultimate-api/).

# Send a request
```java
Client client = new Client(new Token("TOKEN STRING", Token.Type.PRIVATE));
Response<Member> response = client.sendOrWait(new RetrieveYourselfRequest());

//client.send(new RetrieveYourselfRequest()) also works, but in that case you'd have to handle eventual ratelimits yourself with the help of our built-in methods (response.isRatelimited() and response.getMillisecondsToWait()).

if (response.getError() == null) {
    Member member = response.getValue();
    System.out.println(member.getUsername());
} else {
    Error error = response.getError();
    System.out.println(error.getCode() + ": " + error.getMessage());
}
```
A list of requests along with their expected response types can be found [here](requests.md).

# Sorting
Sorting is possible by passing a SortOptions object into the constructor of supported requests (simply pass null if you don't care about sorting).
```java
//Example printing the 20 top-purchased resources.
Client client = new Client(new Token("TOKEN STRING", Token.Type.PRIVATE));
Response<Resource[]> response = client.sendOrWait(new ListPublicResourcesRequest(new SortOptions("purchase_count", Order.DESCENDING, 1)));

if (response.getError() == null) {
    Resource[] resources = response.getValue();

    for (Resource resource : resources) {
        System.out.println(resource.getTitle());
    }
} else {
    Error error = response.getError();
    System.out.println(error.getCode() + ": " + error.getMessage());
}
```
Sortable fields can be found at the official API documentation [here](https://www.mc-market.org/wiki/ultimate-api-v1/).
