package com.ps.FoodDelivery.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class FileExporterXML implements FileExporter{

    @Override
    public String exportData(Object aux){
        String content = null;


        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(aux.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(aux,stringWriter);
            content = stringWriter.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return content;
    }
}
