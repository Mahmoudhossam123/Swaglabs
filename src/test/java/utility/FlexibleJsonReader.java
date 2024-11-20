package utility;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlexibleJsonReader {


    public static List<Map<String, String>> getAllData(String filePath) throws Exception {

        String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        JSONArray jsonArray = new JSONArray(content);


        List<Map<String, String>> dataList = new ArrayList<>();


        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Map<String, String> data = new HashMap<>();

            for (String key : jsonObject.keySet()) {
                data.put(key, jsonObject.getString(key));
            }
            dataList.add(data);
        }

        return dataList;
    }
}