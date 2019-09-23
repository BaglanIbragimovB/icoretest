package com.icore.icoretest.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ICORE_IDENTITY_CARD")
public class IdentityCard {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "тип документа обязательно")
    private String documentType;

    @NotBlank(message = "Орган выдавший документ обязательно")
    private String documentOrgan;

    @NotBlank(message = "Дата выдачи обязательно")
    private String dateIssue;

    @NotBlank(message = "Дата истечения срока обязательно")
    private String dateDue;

    public IdentityCard() {
    }

    public IdentityCard(String docType,
                        String organ,
                        String dtIssue,
                        String dtDue,
                        User usr
    ) {
        this.documentType = docType;
        this.documentOrgan = organ;
        this.dateIssue = dtIssue;
        this.dateDue = dtDue;
        this.user=usr;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentOrgan() {
        return documentOrgan;
    }

    public void setDocumentOrgan(String documentOrgan) {
        this.documentOrgan = documentOrgan;
    }

    public String getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(String dateIssue) {
        this.dateIssue = dateIssue;
    }

    public String getDateDue() {
        return dateDue;
    }

    public void setDateDue(String dateDue) {
        this.dateDue = dateDue;
    }

    //@OneToOne(fetch = FetchType.LAZY, optional = false)
    //@JoinColumn(name = "user_id", nullable = false)
    //@PrimaryKeyJoinColumn
    //private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "user_id")
    private User user;

    //@OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public User getUser()
    {
        return user;
    }
    public void setUser(User usr)
    {
        this.user=usr;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", docType=" + documentType + ", organ=" + documentOrgan + '}';
    }
}