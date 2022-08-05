package brussels.digitalcity.maxdolmans.demorest.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(nullable = false)
    private String street;

    @Column(name = "building_number", nullable = false)
    private int buildingNumber;

    @Column(name = "apartment_code", nullable = true)
    private String apartmentCode;

    @Column(name = "city_code", nullable = false)
    private int cityCode;

    @Column(nullable = false)
    private String city;


    @Override
    public String toString() {
        return "Address{" +
                "\n" + street + ", " + buildingNumber + " " + apartmentCode +
                "\n" + cityCode + " " + city +
                '}';
    }
}
