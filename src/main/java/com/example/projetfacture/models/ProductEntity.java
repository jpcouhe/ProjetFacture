package com.example.projetfacture.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "product", schema = "projet-facture")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_product")
    private int idProduct;
    @Basic
    @Column(name = "description_product")
    private String descriptionProduct;
    @Basic
    @Column(name = "price_ht_product")
    private Integer priceHtProduct;
    @Basic
    @Column(name = "id_tva")
    private Integer idTva;
    @OneToMany(mappedBy = "productByIdProduct")
    private Collection<InvoiceProductEntity> invoiceProductsByIdProduct;
    @ManyToOne
    @JoinColumn(name = "id_tva", referencedColumnName = "id_tva",insertable = false, updatable = false)
    private TvaEntity tvaByIdTva;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public Integer getPriceHtProduct() {
        return priceHtProduct;
    }

    public void setPriceHtProduct(Integer priceHtProduct) {
        this.priceHtProduct = priceHtProduct;
    }

    public Integer getIdTva() {
        return idTva;
    }

    public void setIdTva(Integer idTva) {
        this.idTva = idTva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (idProduct != that.idProduct) return false;
        if (descriptionProduct != null ? !descriptionProduct.equals(that.descriptionProduct) : that.descriptionProduct != null)
            return false;
        if (priceHtProduct != null ? !priceHtProduct.equals(that.priceHtProduct) : that.priceHtProduct != null)
            return false;
        if (idTva != null ? !idTva.equals(that.idTva) : that.idTva != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProduct;
        result = 31 * result + (descriptionProduct != null ? descriptionProduct.hashCode() : 0);
        result = 31 * result + (priceHtProduct != null ? priceHtProduct.hashCode() : 0);
        result = 31 * result + (idTva != null ? idTva.hashCode() : 0);
        return result;
    }

    public Collection<InvoiceProductEntity> getInvoiceProductsByIdProduct() {
        return invoiceProductsByIdProduct;
    }

    public void setInvoiceProductsByIdProduct(Collection<InvoiceProductEntity> invoiceProductsByIdProduct) {
        this.invoiceProductsByIdProduct = invoiceProductsByIdProduct;
    }

    public TvaEntity getTvaByIdTva() {
        return tvaByIdTva;
    }

    public void setTvaByIdTva(TvaEntity tvaByIdTva) {
        this.tvaByIdTva = tvaByIdTva;
    }
}
