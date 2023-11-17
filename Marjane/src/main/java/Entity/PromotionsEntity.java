package Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "promotions", schema = "public", catalog = "mrjn")
public class PromotionsEntity {
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "pourcentage")
    private Integer pourcentage;
    @Basic
    @Column(name = "comment")
    private String comment;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "idproduct")
    private Integer idproduct;
    @Basic
    @Column(name = "idcategory")
    private Integer idcategory;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Integer pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromotionsEntity that = (PromotionsEntity) o;
        return id == that.id && Objects.equals(status, that.status) && Objects.equals(pourcentage, that.pourcentage) && Objects.equals(comment, that.comment) && Objects.equals(idproduct, that.idproduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, pourcentage, comment, id, idproduct);
    }

    public Integer getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Integer idcategory) {
        this.idcategory = idcategory;
    }
}
