package brussels.digitalcity.maxdolmans.models.entities;

import java.util.Objects;

public class Address {
    public Long id;
    public String street;
    public String number;
    public String postalCode;
    public String locality;


    public Address() {
    }

    public Address(Long id, String street, String number, String postalCode, String locality) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.locality = locality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) && number.equals(address.number) && postalCode.equals(address.postalCode) && locality.equals(address.locality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, postalCode, locality);
    }
}
