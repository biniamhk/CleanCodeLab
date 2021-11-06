package se.cleancode.lab1;

public class MathRandomImplementation implements MathRandom {
    @Override
    public int mathRandom(int math) {
        return (int) (Math.random() * math);
    }


}

