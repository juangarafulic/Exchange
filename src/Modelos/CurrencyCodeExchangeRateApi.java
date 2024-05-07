package Modelos;

import com.google.gson.JsonObject;

public record CurrencyCodeExchangeRateApi(String base_code, JsonObject conversion_rates) {
}
