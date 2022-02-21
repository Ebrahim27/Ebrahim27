//package com.eki.ee.realbank.domin;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Data;
//
//import java.io.Serializable;
//
//@Data
//public class AdvancedCriteria implements Serializable {
//
//    @JsonProperty("fieldName")
//    private String key;
//    private String operator;
//    private String value;
//
//
//    @JsonProperty(value = "_constructor")
//    private String constructor;
//
//    public AdvancedCriteria(String key, String operator, String value) {
//        this.key = key;
//        this.operator = operator;
//        this.value = value;
//    }
//
//    public String toCriteria()
//    {
//        return "{\"fieldName\":\""+ key +"\",\"operator\":\""+ operator +"\",\"value\":\""+value+"\"}";
//
//    }
//
//    public AdvancedCriteria() {
//    }
//}