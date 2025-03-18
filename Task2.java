import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class RestClient {
    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        
        // Send a GET request
        sendGetRequest(url);

        // Send a POST request
        JSONObject postData = new JSONObject();
        postData.put("title", "foo");
        postData.put("body", "bar");
        postData.put("userId", 1);
        sendPostRequest(url, postData);
    }

    // Method to send a GET request
    public static void sendGetRequest(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print result
                System.out.println("GET Response: " + response.toString());
            else {
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to send a POST request
    public static void sendPostRequest(String urlString, JSONObject postData) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           -Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = postData.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

           URLConnection.HTTP_CREATED) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print result
                System.out.println("POST Response: " + response.toString());
            } else {
                System.out.println("POST request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
