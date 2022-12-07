package com.example.projetfacture.models;

import jakarta.persistence.*;

import java.io.Serializable;
@Embeddable
public class InvoiceProductEntityPK implements Serializable {
    @Column(name = "id_invoice")

    private int idInvoice;
    @Column(name = "id_product")



    private int idProduct;

    public InvoiceProductEntityPK() {
    }

    public InvoiceProductEntityPK(int idInvoice, int idProduct) {
        this.idInvoice = idInvoice;
        this.idProduct = idProduct;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceProductEntityPK that = (InvoiceProductEntityPK) o;

        if (idInvoice != that.idInvoice) return false;
        if (idProduct != that.idProduct) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInvoice;
        result = 31 * result + idProduct;
        return result;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
}
