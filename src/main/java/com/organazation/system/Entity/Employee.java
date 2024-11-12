package com.organazation.system.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Schema(description = "Details about the country")
@Table(name = "employee")
//@JsonInclude(JsonInclude.Include.ALWAYS)
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    @Schema(description = "Unique identifier for the employee", example = "1")
    private long id;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Schema(description = "Name of the employee", example = "John Doe")
    private String name;

    @Column(name = "status")
    @Schema(description = "Status of the employee", example = "Active")
    private String status;

    @Column(name = "department")
    @Schema(description = "Department of the employee", example = "IT")
    private String department;

    @NotNull(message = "Mobile number cannot be null")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid mobile number format")
    @Column(name = "mobileno", nullable = false, unique = true)
    @Schema(description = "Mobile number of the employee", example = "+1234567890")
    private String mobileno;

    @NotNull(message = "Email ID cannot be null")
    @Email(message = "Invalid email format")
    @Column(name = "emailid", nullable = false, unique = true)
    @Schema(description = "Email ID of the employee", example = "john.doe@example.com")
    private String emailid;

    @Column(name = "created_by")
    @Schema(description = "User who created the record", example = "admin")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    @Schema(description = "Date when the record was created", example = "2023-01-01T10:15:30")
    private Date createdDate;

    @Column(name = "updated_by")
    @Schema(description = "User who last updated the record", example = "editor")
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    @Schema(description = "Date when the record was last updated", example = "2023-02-01T12:00:00")
    private Date updatedDate;

    @Column(name = "salary")
    @Schema(description = "Salary of the employee", example = "75000")
    private double salary;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cid")
    @Schema(description = "Country associated with the employee")
    private Country country;


    public Employee() {

    }

    public Employee(@NonNull long id, String name, String status, String department, @NonNull String mobileno, @NonNull String emailid, String createdBy, Date createdDate, String updatedBy, Date updatedDate, double salary, Country country) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.department = department;
        this.mobileno = mobileno;
        this.emailid = emailid;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.salary = salary;
        this.country = country;
    }

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public @NonNull String getMobileno() {
        return mobileno;
    }

    public void setMobileno(@NonNull String mobileno) {
        this.mobileno = mobileno;
    }

    public @NonNull String getEmailid() {
        return emailid;
    }

    public void setEmailid(@NonNull String emailid) {
        this.emailid = emailid;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", department='" + department + '\'' +
                ", mobileno='" + mobileno + '\'' +
                ", emailid='" + emailid + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", salary=" + salary +
                ", country=" + country +
                '}';
    }
}
