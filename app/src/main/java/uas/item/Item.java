package uas.item;

public abstract class Item {
    private String name;
    private int jumlah;

    public Item() {
        jumlah = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void addJumlah() {
        jumlah = jumlah +1;
    }

}
