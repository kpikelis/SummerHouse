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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kpikelis
 */
@Entity
@Table(name = "RESERVATIONS")
@NamedQueries({
    @NamedQuery(name = "Reservations.findAll", query = "SELECT r FROM Reservations r"),
    @NamedQuery(name = "Reservations.findById", query = "SELECT r FROM Reservations r WHERE r.id = :id"),
    @NamedQuery(name = "Reservations.findByReservationFromDate", query = "SELECT r FROM Reservations r WHERE r.reservationFromDate = :reservationFromDate"),
    @NamedQuery(name = "Reservations.findByReservationToDate", query = "SELECT r FROM Reservations r WHERE r.reservationToDate = :reservationToDate"),
    @NamedQuery(name = "Reservations.findByOptLockVersion", query = "SELECT r FROM Reservations r WHERE r.optLockVersion = :optLockVersion")})
public class Reservations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "RESERVATION_FROM_DATE")
    @Temporal(TemporalType.DATE)
    private Date reservationFromDate;
    @Column(name = "RESERVATION_TO_DATE")
    @Temporal(TemporalType.DATE)
    private Date reservationToDate;
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @OneToMany(mappedBy = "reservationId")
    private List<Payments> paymentsList;
    @JoinColumn(name = "ADDITIONAL_SERVICES_ID", nullable = true, referencedColumnName = "ID")
    @ManyToOne
    private AdditionalServices additionalServicesId;
    @JoinColumn(name = "MEMBERS_ID", nullable = true, referencedColumnName = "ID")
    @ManyToOne
    private Members membersId;
    @JoinColumn(name = "SUMMER_HOUSES_ID", referencedColumnName = "ID")
    @ManyToOne
    private SummerHouses summerHousesId;

    public Reservations() {
    }

    public Reservations(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReservationFromDate() {
        return reservationFromDate;
    }

    public void setReservationFromDate(Date reservationFromDate) {
        this.reservationFromDate = reservationFromDate;
    }

    public Date getReservationToDate() {
        return reservationToDate;
    }

    public void setReservationToDate(Date reservationToDate) {
        this.reservationToDate = reservationToDate;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Payments> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<Payments> paymentsList) {
        this.paymentsList = paymentsList;
    }

    public AdditionalServices getAdditionalServicesId() {
        return additionalServicesId;
    }

    public void setAdditionalServicesId(AdditionalServices additionalServicesId) {
        this.additionalServicesId = additionalServicesId;
    }

    public Members getMembersId() {
        return membersId;
    }

    public void setMembersId(Members membersId) {
        this.membersId = membersId;
    }

    public SummerHouses getSummerHousesId() {
        return summerHousesId;
    }

    public void setSummerHousesId(SummerHouses summerHousesId) {
        this.summerHousesId = summerHousesId;
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
        if (!(object instanceof Reservations)) {
            return false;
        }
        Reservations other = (Reservations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return membersId.getName() + " " + membersId.getSurname() + " " + reservationFromDate.toString();
    }
    
}
