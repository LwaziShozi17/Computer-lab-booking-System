package za.ac.cput.Domain;

public class Lab {


    private Long labId;

    private String location;
    private int capacity;
    private String openingHours;
    private String closingHours;

    public Lab(Builder builder) {
        this.labId = builder.labId;
        this.location = builder.location;
        this.capacity = builder.capacity;
        this.openingHours = builder.openingHours;
        this.closingHours = builder.closingHours;
    }

    public Long getLabId() {
        return labId;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public String getClosingHours() {
        return closingHours;
    }

    public class Builder{
        private Long labId;

        private String location;
        private int capacity;
        private String openingHours;
        private String closingHours;

        public Builder setLabId(Long labId) {
            this.labId = labId;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder setOpeningHours(String openingHours) {
            this.openingHours = openingHours;
            return this;
        }

        public Builder setClosingHours(String closingHours) {
            this.closingHours = closingHours;
            return this;
        }

        public Builder copy(Lab lab) {
            this.labId = lab.labId;
            this.location = lab.location;
            this.capacity = lab.capacity;
            this.openingHours = lab.openingHours;
            this.closingHours = lab.closingHours;
            return this;

        }
        public Lab build(){
            return new Lab(this);
        }
    }



}

