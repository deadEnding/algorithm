package custom.CC150.CH3;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 3:57 PM 12/27/16
 * @version: 1.0
 * @description: [P145] 3.7 实现动物队列，每次返回入队最早的动物、入队最早的狗、入队最早的猫
 */

abstract class Animal {
    private int order;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal animal) {
        return this.order < animal.order;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

public class AnimalQueue {
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Dog) {
            dogs.offer((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.offer((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (!dogs.isEmpty() && !cats.isEmpty()) {
            return dogs.peek().isOlderThan(cats.peek()) ? dogs.poll() : cats.poll();
        } else {
            return !dogs.isEmpty() ? dogs.poll() : cats.poll();
        }
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }
}
