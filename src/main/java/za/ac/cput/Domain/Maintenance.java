package za.ac.cput.Domain;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * Sithandiwe Ntombela 221805265
 * Maintenance entity representing maintenance activities for software in the computer labs.
 */


@Entity
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @Column(name = "maintenance_id", nullable = false, unique = true)
    private String maintenanceId;

    @Column(name = "software_id", nullable = false)
    private String softwareId;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "description", nullable = false)
    private String description;

    // Default constructor for JPA
    protected Maintenance() {}

    // Private constructor for Builder
    private Maintenance(Builder builder) {
        this.maintenanceId = builder.maintenanceId;
        this.softwareId = builder.softwareId;
        this.date = builder.date;
        this.description = builder.description;
    }

    // --- Getters ---
    public String getMaintenanceId() {
        return maintenanceId;
    }

    public String getSoftwareId() {
        return softwareId;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    // --- Builder Pattern ---
    public static class Builder {
        private String maintenanceId;
        private String softwareId;
        private String date;
        private String description;

        public Builder setMaintenanceId(String maintenanceId) {
            this.maintenanceId = maintenanceId;
            return this;
        }

        public Builder setSoftwareId(String softwareId) {
            this.softwareId = softwareId;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Maintenance maintenance) {
            this.maintenanceId = maintenance.maintenanceId;
            this.softwareId = maintenance.softwareId;
            this.date = maintenance.date;
            this.description = maintenance.description;
            return this;
        }

        public Maintenance build() {
            return new Maintenance(this);
        }
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "maintenanceId='" + maintenanceId + '\'' +
                ", softwareId='" + softwareId + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Maintenance)) return false;
        Maintenance maintenance = (Maintenance) o;
        return Objects.equals(maintenanceId, maintenance.maintenanceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maintenanceId);
    }
}