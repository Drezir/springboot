package springboot.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

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
