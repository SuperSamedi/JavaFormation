package com.bxl.javatym.hotel.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "booking")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "b_get_all", query = "SELECT b FROM Booking b"),
        @NamedQuery(name = "b_remove_one", query = "DELETE FROM Booking b WHERE b.id = :id")
})
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey())
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "room_id", foreignKey = @ForeignKey())
    private Room room;

    @Column(name = "date_begin")
    private LocalDate beginDate;

    @Column(name = "date_end")
    private LocalDate endDate;

    public Booking(Customer customer, Room room, LocalDate beginDate, LocalDate endDate) {
        this.customer = customer;
        this.room = room;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }
}
