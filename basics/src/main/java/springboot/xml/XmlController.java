package springboot.xml;

import java.io.IOException;
import java.util.Arrays;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xml")
@RequiredArgsConstructor
public class XmlController {

    @Value("classpath:/xml/example.xml")
    private Resource resource;

    @GetMapping("/")
    public ShipOrder getShipOrder() {
        ShipOrder shipOrder = new ShipOrder();
        shipOrder.setOrderId(1);
        shipOrder.setOrderPerson("Person");

        ShipTo shipTo = new ShipTo();
        shipTo.setAddress("Address");
        shipTo.setCity("city");
        shipTo.setCountry("country");
        shipTo.setName("name");

        Item item = new Item();
        item.setNote("note");
        item.setPrice(1d);
        item.setQuantity(2);
        item.setTitle("title");

        Item item1 = new Item();
        item1.setNote("note1");
        item1.setPrice(2d);
        item1.setQuantity(3);
        item1.setTitle("title1");

        shipOrder.setShipTo(shipTo);
        shipOrder.setItems(Arrays.asList(item, item1));

        return shipOrder;
    }

    @GetMapping("/read")
    public ShipOrder readXmlFromFile() throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ShipOrder.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (ShipOrder) unmarshaller.unmarshal(resource.getFile());
    }

}
