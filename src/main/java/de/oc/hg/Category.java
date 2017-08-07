package de.oc.hg;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable {

    @Id
    @Column(name = "CTGR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Transient
    private List<Item> items = new ArrayList<Item>();

    public Category() {
        super();
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public Long getVersion() {
        return version;
    }



    public void setVersion(Long version) {
        this.version = version;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Zwei Category-Objekte sind genau dann gleich, wenn Name übereinstimmt.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Category))
            return false;
        Category rhs = (Category) obj;
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(this.name, rhs.getName());
        return builder.isEquals();
    }

    /**
     * @return Hashcode auf Basis von Name.
     */
    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder(1169, 4485);
        builder.append(this.name);
        return builder.toHashCode();
    }

    /**
     * Gibt ID, Version und Name aus.
     */
    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        builder.append("id", getId());
        builder.append("version", getVersion());
        builder.append("name", getName());
        return builder.toString();
    }

}
