package brussels.digitalcity.maxdolmans.demorest.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(name = "building_number", nullable = false)
    private int buildingNumber;

    @Column(name = "apartment_code")
    private String apartmentCode;

    @Column(name = "city_code", nullable = false)
    private int cityCode;

    @Column(nullable = false)
    private String city;


    public Address(String street, int buildingNumber, int cityCode, String city) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.cityCode = cityCode;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "\n" + street + ", " + buildingNumber + " " + apartmentCode +
                "\n" + cityCode + " " + city +
                '}';
    }
}
