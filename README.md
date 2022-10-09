# AbstractusAPI

This project's goal is to provide an easier way to write API wrappers in Java. It abstracts away the implementation details of making calls to the API 
and allows you to retrieve the data in a simple and safe way.

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install 
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
TODO
```

### Gradle users

Add this dependency to your project's build file:

```groovy
TODO
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

TODO

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import abstractusAPI.http.request.RequestController;
import org.json.JSONObject;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RequestController requestController = new RequestController("https", "v2.jokeapi.dev");
        CompletableFuture<JSONObject> jsonObject = requestController.sendRequestAsync("joke/any");
        System.out.println(jsonObject.get());
    }
}

```

## Features

### Caching
This project supports automatic 15 minute caching using `OkHttp3` built in caching. To implement your own caching pass in a `OkHttpClient` into the
`RequestController` constructor with all configurations customized. To see more about implementing your own cache read more
<a href = "https://square.github.io/okhttp/3.x/okhttp/okhttp3/Cache.html"> here. </a> 

### Customized Error Handling
This project comes with a basic error handling process. It handles and throws 40+ custom exceptions depending on the status code returned from the API. 
If you would like to create your own validation process simply create a class the implements the `RequestValidator` interface pass it in as a parameter to 
the `RequestController` constructor.

### Adding Parameters
To add parameters to the request use the `RequestParameter` record. It takes in a key and value in it's constructor. Then, when calling the 
`sendRequestAsync` method of `RequestController` add the `RequestParameter` as a parameter.
``` Java
import abstractusAPI.http.request.RequestController;
import org.json.JSONObject;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RequestController requestController = new RequestController("https", "v2.jokeapi.dev");
        CompletableFuture<JSONObject> jsonObject = requestController.sendRequestAsync("joke/any", new RequestParameter("amount", "6");
        System.out.println(jsonObject.get());
    }
}

```

### Setting Permanent Parameters
This project also supports adding permanent parameters that will be added to each request. This can be useful when working with API keys. Simply call, 
`RequestController.addPermanentQueryParameter()` and pass in the `QueryParameter` that should be added. 

``` Java
import abstractusAPI.http.request.RequestController;
import org.json.JSONObject;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RequestController requestController = new RequestController("https", "v2.jokeapi.dev");
        requestController.addPermanentRequestParameter("key", UUID.randomUUID().toString());
        CompletableFuture<JSONObject> jsonObject = requestController.sendRequestAsync("joke/any", new RequestParameter("amount", "6");
        System.out.println(jsonObject.get());
    }
}

```

### Asynchronously Process Results

To asynchronously process the results there are many options since the `RequestController` returns a `CompletableFuture`. 
A simple way is to create a new thread and process the results in it. 

``` Java
import abstractusAPI.http.request.RequestController;
import org.json.JSONObject;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        RequestController requestController = new RequestController("https", "v2.jokeapi.dev");

        new Thread(() -> {
            try {
                CompletableFuture<JSONObject> future = requestController.sendRequestAsync("joke/any");
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
```


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.



<!-- CONTACT -->
## Contact

unpluggedsam - unpluggedsam990@gmail.com

Project Link: [https://github.com/unpluggedsam/abstractusAPI/](https://github.com/unpluggedsam/abstractusAPI/)







