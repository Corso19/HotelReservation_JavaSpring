package fts.intern.hotelmanager.model;

public enum RoomType {
    SINGLE(1),
    DOUBLE(2),
    SUITE(3),
    MATRIMONIAL(4);

    private Integer id;

    RoomType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
