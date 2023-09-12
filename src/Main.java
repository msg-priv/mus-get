import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static void main(String[] args) {
        // TODO: add token parameter to client GET request, "t"

        final String format = "json";
        final String filter = "2";
        final String[] startDate = {"9", "6", "2023"}; // month, day, year
        final String[] endDate = {"9", "7", "2023"}; // month, day, year
        final String persona = "2";
        // statuslist
        // sectionlist

        System.out.println("loading url");
        final String url = "https://musowls.myschoolapp.com/api/DataDirect/AssignmentCenterAssignments/?format=" + format + "&filter=" + filter + "+&dateStart=" + startDate[0] +"%2F"+ startDate[1] +"%2F" + startDate[2] + "&dateEnd=" + endDate[0] +"%2F"+ endDate[1] +"%2F" + endDate[2] + "&persona=" + persona + "&statusList=&sectionList=";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            // .setHeader("t", "6caab79a-ee94-b5e2-3c2c-f7036aaf2990") DOESNT WORK
            // .header("t", "6caab79a-ee94-b5e2-3c2c-f7036aaf2990") GRAHHH
            .uri(URI.create(url))
            .build();

        client.sendAsync(request, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println)
            .join();
    }
}