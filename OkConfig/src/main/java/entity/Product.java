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
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@NamedQueries( {
        @NamedQuery(name = "Product.findAll", query = "select o from Product o"),
        @NamedQuery(name = "Product.findByTitle", query = "select o from Product o where o.title=:title"),
})

@Entity
@XmlRootElement
public class Product {

    String title;
    String manafactuer;
    double price;
    String category;
    String image;
    int stock;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    @ManyToMany(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JoinTable(name = "Product_users",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "USE_ID") })
    Set<Admin> users = new HashSet<Admin>();

    public Product( ) {

    }

    public Product( String title, String manafactuer, double price, String category, String image, int stock) {
        super();

        this.title = title;
        this.manafactuer = manafactuer;
        this.price = price;
        this.category = category;
        this.image = image;
        this.stock = stock;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getManafactuer() {
        return manafactuer;
    }

    public void setManafactuer(String manafactuer) {
        this.manafactuer = manafactuer;
    }

    @XmlElement
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlElement
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlElement
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlElement
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
