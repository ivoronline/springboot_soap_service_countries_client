package com.ivoronline.springboot_soap_service_countries_client;

import com.ivoronline.soap.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

  //===============================================================================
  // RUN
  //===============================================================================
  @Override
  public void run(String... args) throws Exception {

    //POINTS TO GENERATED CLASSES
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
                    marshaller.setContextPath("com.ivoronline.soap");

    //CONFIGURE CLIENT
    CountryClient client = new CountryClient();
                  client.setDefaultUri  ("http://localhost:8080/ws");  //SERVICE URL
                  client.setMarshaller  (marshaller);
                  client.setUnmarshaller(marshaller);

    //SEND REQUEST
    GetCountryResponse response = client.getCountry("Spain");

    //PRINT RESPONSE
    System.err.println(response.getCountry().getName());
    System.err.println(response.getCountry().getPopulation());
    System.err.println(response.getCountry().getCapital());
    System.err.println(response.getCountry().getCurrency());

  }

}
