package com.dexlan.charactersheet.models;

public class Race {

    private String name;
    private String miniature;
    private String ability;
    private String size;
    private String speed;
    private String age;
    private String alignment;
    private String proficiency;
    private String languages;
    private String description;

    public Race(String name, String miniature, String ability, String size, String speed, String age, String alignment, String proficiency, String languages, String description) {
        this.name = name;
        this.miniature = miniature;
        this.ability = ability;
        this.size = size;
        this.speed = speed;
        this.age = age;
        this.alignment = alignment;
        this.proficiency = proficiency;
        this.languages = languages;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiniature() {
        return miniature;
    }

    public void setMiniature(String miniature) {
        this.miniature = miniature;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
