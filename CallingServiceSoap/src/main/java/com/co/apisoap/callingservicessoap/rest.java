package com.co.apisoap.callingservicessoap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.Request;

@RestController
@RequestMapping("comunity")
public class rest
{
    @Value("${WSDL.SOAPClient}")
    private String clientEndPoint;
   @Autowired
    public SOAPConnectClient cliete;

   private Jaxb2Marshaller marshaller;

    @GetMapping
    @RequestMapping("{id}")
    public Comunidad comunidad (@PathVariable String id){
        Request request = new Request();
        String respuesta = "";
        request.setId(id);
        cliete.callWebServices(clientEndPoint,request);

        boolean flag = false;
        Comunidad c = new Comunidad();
        switch (id){
            case "1":
                respuesta = "Comunidad Variables";
                flag = true;
                c.setComunidad(respuesta);
                c.setId(id);
                break;
            case "2":
                respuesta = "AnimeCol";
                flag = true;
                c.setComunidad(respuesta);
                c.setId(id);
                break;
            case "3":
                respuesta = "Comunidad Prueba";
                flag = true;
                c.setComunidad(respuesta);
                c.setId(id);
                break;
            case "4":
                respuesta = "Prueba";
                flag = true;
                c.setComunidad(respuesta);
                c.setId(id);
                break;
        }

        if (!flag){
            c.setComunidad("error");
        }
        return c;
    }
}
