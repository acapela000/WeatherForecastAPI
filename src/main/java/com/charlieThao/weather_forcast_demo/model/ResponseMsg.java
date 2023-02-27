package com.charlieThao.weather_forcast_demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ResponseMsg {

   @JsonProperty
   private String msg;

   public ResponseMsg(String msg) {
      this.msg = msg;
   }


}
