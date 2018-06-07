package com.currency.converter.json.editor;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;

public class JsonEditor implements Editor {

    private static final String RATES = "rates";
    private static final String EFFECTIVE_DATE = "effectiveDate";
    private static final String MID = "mid";

    @Autowired
    private JsonParser jsonParser;

    @Override

    public String processData(String json) {

        JsonArray jsonRatesArray = jsonParser.parse(json).getAsJsonObject().getAsJsonArray(RATES);

        JsonArray jsonResultArray = new JsonArray();
        for (JsonElement jsonElement : jsonRatesArray) {

            JsonArray jsonArray = new JsonArray();
            jsonArray.add(jsonElement.getAsJsonObject().get(EFFECTIVE_DATE).getAsString());
            jsonArray.add(jsonElement.getAsJsonObject().get(MID).getAsDouble());

            jsonResultArray.add(jsonArray);
        }

        return jsonResultArray.toString();
    }
}
