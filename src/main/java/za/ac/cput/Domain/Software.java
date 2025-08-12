package za.ac.cput.Domain;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * Software entity representing software available in the computer labs.
 */
@Entity
@Table(name = "software")
public class Software {

    @Id
    @Column(name = "software_id", nullable = false, unique = true)
    private String softwareId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "version", nullable = false)
    private String version;

    @Column(name = "license_type", nullable = false)
    private String licenseType;

    // Default constructor for JPA
    protected Software() {}

    // Private constructor for Builder
    private Software(Builder builder) {
        this.softwareId = builder.softwareId;
        this.name = builder.name;
        this.version = builder.version;
        this.licenseType = builder.licenseType;
    }

    // --- Getters ---
    public String getSoftwareId() {
        return softwareId;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getLicenseType() {
        return licenseType;
    }

    // --- Builder Pattern ---
    public static class Builder {
        private String softwareId;
        private String name;
        private String version;
        private String licenseType;

        public Builder setSoftwareId(String softwareId) {
            this.softwareId = softwareId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setVersion(String version) {
            this.version = version;
            return this;
        }

        public Builder setLicenseType(String licenseType) {
            this.licenseType = licenseType;
            return this;
        }

        public Builder copy(Software software) {
            this.softwareId = software.softwareId;
            this.name = software.name;
            this.version = software.version;
            this.licenseType = software.licenseType;
            return this;
        }

        public Software build() {
            return new Software(this);
        }
    }

    @Override
    public String toString() {
        return "Software{" +
                "softwareId='" + softwareId + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", licenseType='" + licenseType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Software)) return false;
        Software software = (Software) o;
        return Objects.equals(softwareId, software.softwareId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(softwareId);
    }
}
