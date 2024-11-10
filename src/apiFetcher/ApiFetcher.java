package apiFetcher;

//Importing necessary classes from the Java standard library:
//- URI: represents a Uniform Resource Identifier, typically used for web addresses.
//- HttpClient, HttpRequest, and HttpResponse: classes from java.net.http to send HTTP requests and handle responses.
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//The ApiFetcher class is a simple example of how to make an HTTP GET request in Java.
public class ApiFetcher {

 // The main method is the entry point of our program. It runs when the program starts.
 public static void main(String[] args) {
     try {
         // 1. Creating an HttpClient instance:
         //    HttpClient is a modern, asynchronous HTTP client introduced in Java 11, 
         //    allowing us to easily make HTTP requests.
         HttpClient client = HttpClient.newHttpClient();

         // 2. Building an HTTP GET Request:
         //    Using HttpRequest to specify the request type and the URI (Uniform Resource Identifier) we want to access.
         HttpRequest request = HttpRequest.newBuilder()
                 .uri(new URI("https://jsonplaceholder.typicode.com/posts/1"))  // Target URL
                 .build();

         // 3. Sending the Request and Capturing the Response:
         //    HttpResponse.BodyHandlers.ofString() specifies that we want the response body as a String.
         //    The send() method sends the request and waits for a response.
         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

         // 4. Displaying the Response
         //    Printing the status code (e.g., 200 for success) and the response body content to the console.
         System.out.println("Response status code: " + response.statusCode());
         System.out.println("Response body: " + response.body());

     } 
     // Catching and handling any exceptions that occur during the request process.
     // This includes URISyntaxException if the URI is invalid, and IOException or InterruptedException from the send() method.
     catch (Exception e) {
         e.printStackTrace();  // Prints the exception's details, useful for debugging.
     }
 }
}
