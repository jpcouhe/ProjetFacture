package com.example.projetfacture.models;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice_product", schema = "projet-facture")
@IdClass(InvoiceProductEntityPK.class)
public class InvoiceProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_invoice")
    private int idInvoice;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_product")
    private int idProduct;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "id_invoice", referencedColumnName = "id_invoice", insertable = false, updatable = false)
    private InvoiceEntity invoiceByIdInvoice;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", insertable = false, updatable = false)
    private ProductEntity productByIdProduct;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceProductEntity that = (InvoiceProductEntity) o;

        if (idInvoice != that.idInvoice) return false;
        if (idProduct != that.idProduct) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInvoice;
        result = 31 * result + idProduct;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    public InvoiceEntity getInvoiceByIdInvoice() {
        return invoiceByIdInvoice;
    }

    public void setInvoiceByIdInvoice(InvoiceEntity invoiceByIdInvoice) {
        this.invoiceByIdInvoice = invoiceByIdInvoice;
    }

    public ProductEntity getProductByIdProduct() {
        return productByIdProduct;
    }

    public void setProductByIdProduct(ProductEntity productByIdProduct) {
        this.productByIdProduct = productByIdProduct;
    }
}
