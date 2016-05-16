/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbEntities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author kpikelis
 */
@Entity
@Table(name = "ADDITIONAL_SERVICES")
@NamedQueries({
    @NamedQuery(name = "AdditionalServices.findAll", query = "SELECT a FROM AdditionalServices a"),
    @NamedQuery(name = "AdditionalServices.findById", query = "SELECT a FROM AdditionalServices a WHERE a.id = :id"),
    @NamedQuery(name = "AdditionalServices.findByTitle", query = "SELECT a FROM AdditionalServices a WHERE a.title = :title"),
    @NamedQuery(name = "AdditionalServices.findByPrice", query = "SELECT a FROM AdditionalServices a WHERE a.price = :price"),
    @NamedQuery(name = "AdditionalServices.findByOptLockVersion", query = "SELECT a FROM AdditionalServices a WHERE a.optLockVersion = :optLockVersion")})
public class AdditionalServices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @OneToMany(mappedBy = "additionalServicesId")
    private List<Reservations> reservationsList;

    public AdditionalServices() {
    }

    public AdditionalServices(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        if (!(object instanceof AdditionalServices)) {
            return false;
        }
        AdditionalServices other = (AdditionalServices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title;
    }
    
}
