package com.example.projetfacture.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "users", schema = "projet-facture")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_users")
    private int idUsers;
    @Basic
    @Column(name = "pseudo_users")
    private String pseudoUsers;
    @Basic
    @Column(name = "mdp_users")
    private String mdpUsers;
    @OneToMany(mappedBy = "usersByIdUsers")
    private Collection<ClientEntity> clientsByIdUsers;

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getPseudoUsers() {
        return pseudoUsers;
    }

    public void setPseudoUsers(String pseudoUsers) {
        this.pseudoUsers = pseudoUsers;
    }

    public String getMdpUsers() {
        return mdpUsers;
    }

    public void setMdpUsers(String mdpUsers) {
        this.mdpUsers = mdpUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (idUsers != that.idUsers) return false;
        if (pseudoUsers != null ? !pseudoUsers.equals(that.pseudoUsers) : that.pseudoUsers != null) return false;
        if (mdpUsers != null ? !mdpUsers.equals(that.mdpUsers) : that.mdpUsers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUsers;
        result = 31 * result + (pseudoUsers != null ? pseudoUsers.hashCode() : 0);
        result = 31 * result + (mdpUsers != null ? mdpUsers.hashCode() : 0);
        return result;
    }

    public Collection<ClientEntity> getClientsByIdUsers() {
        return clientsByIdUsers;
    }

    public void setClientsByIdUsers(Collection<ClientEntity> clientsByIdUsers) {
        this.clientsByIdUsers = clientsByIdUsers;
    }
}
