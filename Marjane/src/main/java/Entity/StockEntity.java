package Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stock", schema = "public", catalog = "mrjn")
public class StockEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "total")
    private Integer total;
    @Basic
    @Column(name = "idproduct")
    private int idproduct;
    @Basic
    @Column(name = "idresponsable")
    private Integer idresponsable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public Integer getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(Integer idresponsable) {
        this.idresponsable = idresponsable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockEntity that = (StockEntity) o;
        return id == that.id && idproduct == that.idproduct && Objects.equals(total, that.total) && Objects.equals(idresponsable, that.idresponsable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, idproduct, idresponsable);
    }
}
