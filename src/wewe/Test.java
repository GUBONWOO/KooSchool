package wewe;

public class Test {
    public static void main(String[] args) {
    Data dataA = new Data();
    dataA.value= 10;
        System.out.println(dataA.value);
        changeReference(dataA);
        System.out.println(dataA.value);}


    static void changeReference (Data dataX) {
        dataX.value =20;
        }
    }

