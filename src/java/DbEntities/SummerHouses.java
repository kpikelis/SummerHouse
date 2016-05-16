/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbEntities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author kpikelis
 */
@Entity
@Table(name = "SUMMER_HOUSES")
@NamedQueries({
    @NamedQuery(name = "SummerHouses.findAll", query = "SELECT s FROM SummerHouses s"),
    @NamedQuery(name = "SummerHouses.findById", query = "SELECT s FROM SummerHouses s WHERE s.id = :id"),
    @NamedQuery(name = "SummerHouses.findByName", query = "SELECT s FROM SummerHouses s WHERE s.name = :name"),
    @NamedQuery(name = "SummerHouses.findByNumber", query = "SELECT s FROM SummerHouses s WHERE s.number = :number"),
    @NamedQuery(name = "SummerHouses.findByMaxGuests", query = "SELECT s FROM SummerHouses s WHERE s.maxGuests = :maxGuests"),
    @NamedQuery(name = "SummerHouses.findByAvailableFrom", query = "SELECT s FROM SummerHouses s WHERE s.availableFrom = :availableFrom"),
    @NamedQuery(name = "SummerHouses.findByAvailableTo", query = "SELECT s FROM SummerHouses s WHERE s.availableTo = :availableTo"),
    @NamedQuery(name = "SummerHouses.findByPrice", query = "SELECT s FROM SummerHouses s WHERE s.price = :price"),
    @NamedQuery(name = "SummerHouses.findByOptLockVersion", query = "SELECT s FROM SummerHouses s WHERE s.optLockVersion = :optLockVersion")})
public class SummerHouses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 20)
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "MAX_GUESTS")
    private Integer maxGuests;
    @Column(name = "AVAILABLE_FROM")
    @Temporal(TemporalType.DATE)
    private Date availableFrom;
    @Column(name = "AVAILABLE_TO")
    @Temporal(TemporalType.DATE)
    private Date availableTo;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @OneToMany(mappedBy = "summerHousesId")
    private List<Reservations> reservationsList;

    public SummerHouses() {
    }

    public SummerHouses(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(Integer maxGuests) {
        this.maxGuests = maxGuests;
    }

    public Date getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(Date availableFrom) {
        this.availableFrom = availableFrom;
    }

    public Date getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(Date availableTo) {
        this.availableTo = availableTo;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Reservations> getReservationsList() {
        return reservationsList;
    }

    public void setReservationsList(List<Reservations> reservationsList) {
        this.reservationsList = reservationsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SummerHouses)) {
            return false;
        }
        SummerHouses other = (SummerHouses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " (" + maxGuests.toString() +  "}";
    }
    
}
