package Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "responsable", schema = "public", catalog = "mrjn")
public class ResponsableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "rayon")
    private String rayon;
    @Basic
    @Column(name = "idadmin")
    private Integer idadmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public Integer getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Integer idadmin) {
        this.idadmin = idadmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsableEntity that = (ResponsableEntity) o;
        return id == that.id && Objects.equals(fullname, that.fullname) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(rayon, that.rayon) && Objects.equals(idadmin, that.idadmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, email, password, rayon, idadmin);
    }
}
