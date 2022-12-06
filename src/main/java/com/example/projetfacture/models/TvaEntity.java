package com.example.projetfacture.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "tva", schema = "projet-facture")
public class TvaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tva")
    private int idTva;
    @Basic
    @Column(name = "taux_tva")
    private BigDecimal tauxTva;
    @OneToMany(mappedBy = "tvaByIdTva")
    private Collection<ProductEntity> productsByIdTva;

    public int getIdTva() {
        return idTva;
    }

    public void setIdTva(int idTva) {
        this.idTva = idTva;
    }

    public BigDecimal getTauxTva() {
        return tauxTva;
    }

    public void setTauxTva(BigDecimal tauxTva) {
        this.tauxTva = tauxTva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TvaEntity tvaEntity = (TvaEntity) o;

        if (idTva != tvaEntity.idTva) return false;
        if (tauxTva != null ? !tauxTva.equals(tvaEntity.tauxTva) : tvaEntity.tauxTva != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTva;
        result = 31 * result + (tauxTva != null ? tauxTva.hashCode() : 0);
        return result;
    }

    public Collection<ProductEntity> getProductsByIdTva() {
        return productsByIdTva;
    }

    public void setProductsByIdTva(Collection<ProductEntity> productsByIdTva) {
        this.productsByIdTva = productsByIdTva;
    }
}
