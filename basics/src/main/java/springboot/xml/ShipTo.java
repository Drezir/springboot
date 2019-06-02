package springboot.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ShipTo {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "address")
    private String address;
    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "country")
    private String country;
}
