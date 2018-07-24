package com.currency.converter.json.mapper.nbp;

import com.currency.converter.json.mapper.JsonMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

@Service
public class NbpResponseMapper implements JsonMapper {

    private static final String RATES = "rates";
    private static final String EFFECTIVE_DATE = "effectiveDate";
    private static final String MID = "mid";
    private static final String CURRENCY = "currency";

    @Override
    public String processData(String json) {

        JsonObject jsonResultObject = new JsonObject();

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();

        JsonArray jsonRatesArray = jsonObject.getAsJsonArray(RATES);

        JsonArray jsonResultArray = new JsonArray();
        for (JsonElement jsonElement : jsonRatesArray) {

            JsonArray jsonArray = new JsonArray();
            jsonArray.add(jsonElement.getAsJsonObject().get(EFFECTIVE_DATE).getAsString());
            jsonArray.add(jsonElement.getAsJsonObject().get(MID).getAsDouble());

            jsonResultArray.add(jsonArray);
        }
        jsonResultObject.add(CURRENCY, jsonObject.get(CURRENCY));
        jsonResultObject.add(RATES, jsonResultArray);

        return jsonResultObject.toString();
    }
}
