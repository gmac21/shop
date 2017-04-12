package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;


@XmlRootElement
@Entity
public abstract class Admin extends User {


    boolean administrator;


    public Admin( ) {

    }

    public Admin(  boolean administrator) {
        super();


        this.administrator = administrator;
    }


    @XmlElement
    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }



}