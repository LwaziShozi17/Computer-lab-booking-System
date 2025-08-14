package za.ac.cput.Factory;

/* Sithandiwe Ntombela 221805265 */


import za.ac.cput.Domain.Software;

public class SoftwareFactory {

    public static Software createSoftware(String softwareId, String name, String version, String licenseType) {
        return new Software.Builder()
                .setSoftwareId(softwareId)
                .setName(name)
                .setVersion(version)
                .setLicenseType(licenseType)
                .build();
    }
}