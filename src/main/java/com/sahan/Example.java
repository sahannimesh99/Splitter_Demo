//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.util.ArrayList;
//
//public class Example {
//    public static void main(String[] args) throws Exception {
//        String json = "{\"stringArray\":\"{\\\"first\\\",\\\"second\\\",\\\"third\\\"}\"}";
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonStringArray = mapper.readValue(json, Example.class).getStringArray();
//        ArrayList<String> arrayList = new ArrayList<>();
//        String[] stringArray = jsonStringArray.substring(1, jsonStringArray.length() - 1).split(",");
//        for (String str : stringArray) {
//            arrayList.add(str.trim().replaceAll("\\\"", ""));
//        }
//        System.out.println(arrayList);
//    }
//
//    private String stringArray;
//
//    public String getStringArray() {
//        return stringArray;
//    }
//
//    public void setStringArray(String stringArray) {
//        this.stringArray = stringArray;
//    }
//}