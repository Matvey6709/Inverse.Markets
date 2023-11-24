package ru.n3studio.inversemarket.Api;

public class Products {
    int id;
    String cover;
    String name;
    String description;
    Categories categories;
    int weight;
    int start_price;
    int current_price;
    int amount;

    public Products(int id, String cover, String name, String description, Categories categories, int weight, int start_price, int current_price, int amount) {
        this.id = id;
        this.cover = cover;
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.weight = weight;
        this.start_price = start_price;
        this.current_price = current_price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStart_price() {
        return start_price;
    }

    public void setStart_price(int start_price) {
        this.start_price = start_price;
    }

    public int getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(int current_price) {
        this.current_price = current_price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
