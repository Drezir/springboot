package springboot.xml;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Set;

@Data
@XmlRootElement(name = "shiporder")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShipOrder {

    @XmlElement(name = "orderperson")
    private String orderPerson;

    @XmlAttribute(name = "orderid")
    private Integer orderId;

    @XmlElement(name = "shipto")
    private ShipTo shipTo;

    @XmlElement(name="item", type=Item.class)
    @XmlElementWrapper(name="items")
    private List<Item> items;

}
