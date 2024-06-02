package AbstractusAPI.http.query;

public record Endpoint(String... path) {

    public String getPath() {
        return "/" + String.join("/", path);
    }
}
