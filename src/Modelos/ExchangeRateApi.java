package Modelos;

import com.google.gson.JsonObject;

public record ExchangeRateApi(String base_code, JsonObject jsonConversionRate) {

}
