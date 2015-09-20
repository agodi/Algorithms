package chapter3;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
	
	private Queue<Animal> dogs = new LinkedList<Animal>();
	private Queue<Animal> cats = new LinkedList<Animal>();
	private int counter = 0;
	
	public void enqueue(Animal animal) {
		animal.order = ++counter;
		if (animal instanceof Dog) dogs.add(animal);
		if (animal instanceof Cat) cats.add(animal);
	}
	
	public Animal dequeueDog() {
		return dogs.poll();
	}
	
	public Animal dequeueCat() {
		return cats.poll();
	}
	
	public Animal dequeueAny() {
		if (dogs.peek().order < cats.peek().order)
			return dogs.poll();
		return cats.poll();
	}

	public static void main(String[] args) {
		Animal dog1 = new Dog("Fido");
		Animal dog2 = new Dog("Rocky");
		Animal dog3 = new Dog("Buddy");
		Animal dog4 = new Dog("Beto");
		Animal cat1 = new Cat("Loki");
		Animal cat2 = new Cat("Yeyo");
		Animal cat3 = new Cat("Misifus");
		
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(dog1);
		shelter.enqueue(cat1);
		shelter.enqueue(cat2);
		shelter.enqueue(dog2);
		shelter.enqueue(dog3);
		shelter.enqueue(dog4);
		shelter.enqueue(cat3);
		
		System.out.println(shelter.dequeueCat().name);
		System.out.println(shelter.dequeueAny().name);
		System.out.println(shelter.dequeueAny().name);
		System.out.println(shelter.dequeueDog().name);
	}
	
	static abstract class Animal {
		int order;
		String name;
		
		Animal(String name) {
			this.name = name;
		}
	}
	
	static class Dog extends Animal {
		Dog(String name) {
			super(name);
		}
	}

	static class Cat extends Animal { 
		Cat(String name) {
			super(name);
		}
	}

}
