package com.example.projetfacture.models;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice_product", schema = "projet-facture")
/*@IdClass(InvoiceProductEntityPK.class)*/

public class InvoiceProductEntity {

    @EmbeddedId
    private InvoiceProductEntityPK id;
  /*  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_invoice")
    private int idInvoice;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_product")
    private int idProduct;*/
    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_invoice", referencedColumnName = "id_invoice", insertable = false, updatable = false)
    private InvoiceEntity invoiceByIdInvoice;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", insertable = false, updatable = false)
    private ProductEntity productByIdProduct;



    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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


    public InvoiceProductEntityPK getId() {
        return id;
    }

    public void setId(InvoiceProductEntityPK id) {
        this.id = id;
    }
}
