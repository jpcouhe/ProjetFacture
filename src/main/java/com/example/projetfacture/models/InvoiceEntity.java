package com.example.projetfacture.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "invoice", schema = "projet-facture")
public class InvoiceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_invoice")
    private int idInvoice;
    @Basic
    @Column(name = "date_invoice")
    private Date dateInvoice;
    @Basic
    @Column(name = "montant_ht_invoice")
    private Integer montantHtInvoice;
    @Basic
    @Column(name = "montant_ttc_invoice")
    private Integer montantTtcInvoice;
    @Basic
    @Column(name = "id_client")
    private int idClient;
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_client", insertable = false, updatable = false)
    private ClientEntity clientByIdClient;
    @OneToMany(mappedBy = "invoiceByIdInvoice", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Collection<InvoiceProductEntity> invoiceProductsByIdInvoice;

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Date getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(Date dateInvoice) {
        this.dateInvoice = dateInvoice;
    }

    public Integer getMontantHtInvoice() {
        return montantHtInvoice;
    }

    public void setMontantHtInvoice(Integer montantHtInvoice) {
        this.montantHtInvoice = montantHtInvoice;
    }

    public Integer getMontantTtcInvoice() {
        return montantTtcInvoice;
    }

    public void setMontantTtcInvoice(Integer montantTtcInvoice) {
        this.montantTtcInvoice = montantTtcInvoice;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceEntity that = (InvoiceEntity) o;

        if (idInvoice != that.idInvoice) return false;
        if (idClient != that.idClient) return false;
        if (dateInvoice != null ? !dateInvoice.equals(that.dateInvoice) : that.dateInvoice != null) return false;
        if (montantHtInvoice != null ? !montantHtInvoice.equals(that.montantHtInvoice) : that.montantHtInvoice != null)
            return false;
        if (montantTtcInvoice != null ? !montantTtcInvoice.equals(that.montantTtcInvoice) : that.montantTtcInvoice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInvoice;
        result = 31 * result + (dateInvoice != null ? dateInvoice.hashCode() : 0);
        result = 31 * result + (montantHtInvoice != null ? montantHtInvoice.hashCode() : 0);
        result = 31 * result + (montantTtcInvoice != null ? montantTtcInvoice.hashCode() : 0);
        result = 31 * result + idClient;
        return result;
    }

    public ClientEntity getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(ClientEntity clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    public Collection<InvoiceProductEntity> getInvoiceProductsByIdInvoice() {
        return invoiceProductsByIdInvoice;
    }


    public void setInvoiceProductsByIdInvoice(Collection<InvoiceProductEntity> invoiceProductsByIdInvoice) {
        this.invoiceProductsByIdInvoice = invoiceProductsByIdInvoice;
    }
}
