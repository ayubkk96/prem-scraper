
package com.ayubkaoukaou.webscrapingproject.mavenproject1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="fixtures")
public class Fixtures implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "fixture_id")
    private int fixtureId;
    
    @Column(name = "fixture_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fixtureDate;
    
    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    private int id;

    public Fixtures() {
    }

    public int getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(int fixtureId) {
        this.fixtureId = fixtureId;
    }

    public Date getFixtureDate() {
        return fixtureDate;
    }

    public void setFixtureDate(Date fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    @Override
    public String toString() {
        return "Fixtures{" + "fixtureId=" + fixtureId + ", fixtureDate=" + fixtureDate + '}';
    }

   
    
   
}
