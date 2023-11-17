package Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "superadmin", schema = "public", catalog = "mrjn")
public class SuperadminEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "fullname")
    private String fullname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperadminEntity that = (SuperadminEntity) o;
        return id == that.id && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(fullname, that.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, fullname);
    }
}
