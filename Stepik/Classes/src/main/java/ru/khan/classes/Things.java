package ru.khan.classes;

/**
 * это класс предок дял всех классов проекта
 */
public class Things {
    protected static int count = 0;
    protected String name;
    protected String description;
    protected double weight;

    public Things (String name, String description, double weight){
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.count++;
    }

    public Things (String name){
        this.name = name;
        this.count++;
    }

    public Things (){
        this.count++; // этот конструктор будет «дописываться» у потомков
    }

    /**
     * метод сеттер массы
     * @param weight
     */
    public void setWeigth(double weight) {
        this.weight = weight;
    }

    /**
     * метод геттер (возвращает полное описание)
     * @return
     */
    public String getDetails() {
        return this.name+" "+this.description+", масса - "+this.weight+" килограм";
    }

    public int getCount() {
        return this.count;
    }
}
