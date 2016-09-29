package com.crewguru.bean;

import org.hibernate.validator.constraints.NotBlank;

public  class Payload {
    //@NotBlank
    String clientId;

    //@NotBlank
    String redirectUri;

   // @NotBlank
    String code;

    public String getClientId() {
      return clientId;
    }

    public String getRedirectUri() {
      return redirectUri;
    }

    public String getCode() {
      return code;
    }
  }
