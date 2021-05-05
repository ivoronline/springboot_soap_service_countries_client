package com.ivoronline.springboot_soap_service_countries_client;

import com.ivoronline.soap.GetCountryRequest;
import com.ivoronline.soap.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {

  //==========================================================================
  // GET PERSON
  //==========================================================================
  //Input Parameters are used to create Request Object
  public GetCountryResponse getCountry(String name) {

    //SPECIFY WSDL URL
    String wsdlURL  = "http://localhost:8080/ws/countries";

    //SPECIFY ENDPOINT
    String endpoint = "http://ivoronline.com/soap/GetCountryRequest"; //Namespace + localPart

    //CREATE REQUEST OBJECT
    GetCountryRequest getCountryRequest = new GetCountryRequest();
                     getCountryRequest.setName(name);

    //EXECUTE REQUEST. GET RESPONSE OBJECT
    GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
      .marshalSendAndReceive(wsdlURL, getCountryRequest, new SoapActionCallback(endpoint));

    //RETURN RESPONSE OBJECT
    return response;

  }

}