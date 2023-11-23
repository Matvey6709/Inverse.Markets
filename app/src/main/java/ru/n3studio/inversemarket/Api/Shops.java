package ru.n3studio.inversemarket.Api;

public class Shops{
    public int id;

    public Shops(int id, String cover, String name, Category category) {
        this.id = id;
        this.cover = cover;
        this.name = name;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String cover;
    public String name;
    public Category category;

    public static class Category{
        public Category(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int id;

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

        public String name;
    }
}


