/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbEntities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kpikelis
 */
@Entity
@Table(name = "PAYMENTS")
@NamedQueries({
    @NamedQuery(name = "Payments.findAll", query = "SELECT p FROM Payments p"),
    @NamedQuery(name = "Payments.findById", query = "SELECT p FROM Payments p WHERE p.id = :id"),
    @NamedQuery(name = "Payments.findByPaymentDate", query = "SELECT p FROM Payments p WHERE p.paymentDate = :paymentDate"),
    @NamedQuery(name = "Payments.findByPayedAmount", query = "SELECT p FROM Payments p WHERE p.payedAmount = :payedAmount"),
    @NamedQuery(name = "Payments.findByIsConfirmed", query = "SELECT p FROM Payments p WHERE p.isConfirmed = :isConfirmed"),
    @NamedQuery(name = "Payments.findByOptLockVersion", query = "SELECT p FROM Payments p WHERE p.optLockVersion = :optLockVersion")})
public class Payments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PAYMENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Column(name = "PAYED_AMOUNT")
    private Integer payedAmount;
    @Column(name = "IS_CONFIRMED")
    private Boolean isConfirmed;
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @JoinColumn(name = "MEMBERS_ID", referencedColumnName = "ID")
    @ManyToOne
    private Members membersId;
    @JoinColumn(name = "RESERVATION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Reservations reservationId;

    public Payments() {
    }

    public Payments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(Integer payedAmount) {
        this.payedAmount = payedAmount;
    }

    public Boolean getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public Members getMembersId() {
        return membersId;
    }

    public void setMembersId(Members membersId) {
        this.membersId = membersId;
    }

    public Reservations getReservationId() {
        return reservationId;
    }

    public void setReservationId(Reservations reservationId) {
        this.reservationId = reservationId;
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
        if (!(object instanceof Payments)) {
            return false;
        }
        Payments other = (Payments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return payedAmount.toString();
    }
    
}
