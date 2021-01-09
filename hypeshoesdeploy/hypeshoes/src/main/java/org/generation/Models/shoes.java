package org.generation.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "tb_shoes")
public class shoes {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column
    @Size(min = 1, max = 25)
    private String shoeName;

    @NotBlank
    @Column
    @Size(min = 1, max = 25)
    private String shoeModel;

    @NotBlank
    @Column
    @NumberFormat
    @Size (min = 2, max =4)
    private String launchYear;

    
    @Min(1)
    private int size;

    @ManyToOne
    @JsonIgnoreProperties ("shoes")
    private brands brand;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public String getShoeModel() {
        return shoeModel;
    }

    public void setShoeModel(String shoeModel) {
        this.shoeModel = shoeModel;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public brands getBrand() {
        return brand;
    }

    public void setBrand(brands brand) {
        this.brand = brand;
    }
}
