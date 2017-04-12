package entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@NamedQueries( {
        @NamedQuery(name = "User.findAllUsers", query = "select o from User o"),
        @NamedQuery(name = "User.findByUsername", query = "select o from User o where o.username=:username"),
})

@Entity
@Table(name = "USER")
@XmlRootElement
public class User {

    String username;
    String password;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    @OneToOne
    private Admin admin;

    @OneToOne
    private Customer customer;


    @ManyToMany(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JoinTable(name = "User_products",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID") })
    Set<Admin> products = new HashSet<Admin>();


    public User( ) {

    }

    public User( String username, String password) {
        super();

        this.username = username;
        this.password = password;
    }


    @XmlElement
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}