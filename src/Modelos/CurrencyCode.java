package Modelos;

import com.google.gson.JsonObject;

public class CurrencyCode {
    // Para convertir la respuesta json a nuestro objeto Java
    // Necesitamos cambiar los nombres del json por los de nuestro CurrencyCode
    // Para esto, creamos la clase ExchangeRateApi
    //    @SerializedName("base_code")
    //    private String code;
    private String baseCode;
    private JsonObject jsonConversionRate;

    public CurrencyCode (ExchangeRateApi exchangeRateApi) {
        this.baseCode = exchangeRateApi.base_code();
        this.jsonConversionRate = exchangeRateApi.jsonConversionRate();
    }

    public String getBaseCode() {
        return baseCode;
    }

    public JsonObject getJsonConversionRate() {
        return jsonConversionRate;
    }
}
