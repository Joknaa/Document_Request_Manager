package MVPPresenters;

import java.util.HashMap;

public class RequestPresenter {
    private static HashMap<String, Integer> requestsList = new HashMap<>();
    private static int requestCount = 0;

    public static void AddRequest(int id) { requestsList.put(GenerateRequestName(id), id); }
    public static void RemoveRequest(String name) {
        requestsList.remove(name);}

    public static String[] GetRequestsList() { return requestsList.keySet().toArray(new String[requestCount]);}
    public static void SetRequestsList(int[] ids){ for (int id : ids) { AddRequest(id);} }

    public static int GetRequestID(String name) {
        return requestsList.get(name);
    }

    private static String GenerateRequestName(int id) { return String.format("Request N°%02d", id); }
}