package world;

public abstract class Building {
    private String location;

    protected Building(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
