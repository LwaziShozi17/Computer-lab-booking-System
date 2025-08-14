package za.ac.cput.Domain;

/* Sithandiwe Ntombela 221805265 */

import java.util.Objects;

public class Software {
    private String softwareId;
    private String name;
    private String version;
    private String licenseType;

    private Software(Builder builder) {
        this.softwareId = builder.softwareId;
        this.name = builder.name;
        this.version = builder.version;
        this.licenseType = builder.licenseType;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Software software = (Software) o;
        return Objects.equals(softwareId, software.softwareId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(softwareId);
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
}
