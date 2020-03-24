package com.polaris.designModel.FactoryDesign;

/**
 * 工厂模式
 */
public class AnimalFactory {
    public static Animal getAnimal(String type) {
        switch (type) {
            case "cat":
                return new Cat();
            case "dog":
                return new Dog();
        }
        return null;
    }

    public static void main(String[] args) {
        Animal cat = getAnimal("cat");
        cat.eat();
        Animal dog = getAnimal("dog");
        dog.eat();
    }
}
