class Animal{
    public void name(){
        System.out.println("I have no name");
    }
}

class Dog extends Animal{
    @Override
    public void name() {
        System.out.println("Pillu");
    }
}

class PracticeOOP{
    public static void main(String[] args){
        Dog dog = new Dog();
        dog.name();
    }
}