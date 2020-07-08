import java.util.List;

public class Ride {
    enum eRideTag {
        Water,
        Children,
        Adventure,
        Family,
        Horror,
        Food,
        Extreme,
        ThemeBased
    }

    private int id;
    private String name;
    private String description;
    private List<eRideTag> tagsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return description;
    }

    public void setInfo(String info) {
        this.description = description;
    }

    public void addTag(eRideTag tag){
        tagsList.add(tag);
    }

    public void removeTag(eRideTag tag){
        tagsList.remove(tag);
    }

}


