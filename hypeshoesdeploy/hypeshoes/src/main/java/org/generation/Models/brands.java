package org.generation.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_brands")
public class brands {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column
    @Size(min = 2, max = 15)
    private String brandName;

    @OneToMany (mappedBy = "brand", cascade = CascadeType.ALL)
    @JsonIgnoreProperties ("brand")
    private List<shoes> shoes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<shoes> getShoes() {
        return shoes;
    }

    public void setShoes(List<shoes> shoes) {
        this.shoes = shoes;
    }

}
