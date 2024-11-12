package com.organazation.system.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Schema(description = "Details about the country")
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", updatable = false)
    @Schema(description = "Unique identifier for the country", example = "101")
    private long cid;

    @Column(name = "cname")
    @NotNull(message = "Country name cannot be null")
    @Size(min = 2, max = 100, message = "Country name must be between 2 and 100 characters")
    @Schema(description = "Name of the country", example = "United States")
    private String cname;

    public Country() {
        super();
    }

    public Country(long cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public @NotNull(message = "Country name cannot be null") @Size(min = 2, max = 100, message = "Country name must be between 2 and 100 characters") String getCname() {
        return cname;
    }

    public void setCname(@NotNull(message = "Country name cannot be null") @Size(min = 2, max = 100, message = "Country name must be between 2 and 100 characters") String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
