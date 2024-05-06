import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrintPrimeTillInputNoWithJava8 {

    public static void main(String[] args) {

        int no = 10;

        LongStream longStream = printPrimSeries(10);

        System.out.println("Prime no from 1 till given no is "+no +" :");

        longStream.forEach(System.out::println);

    }

    public static boolean isPrimeNo(int no){
        return LongStream.range(1, no)
                .limit(no)
                .noneMatch(n->no%2==0);
    }

    public static LongStream printPrimSeries(int no){

        return LongStream.iterate(1, i->i+1)
                .filter(x->isPrimeNo((int) x))
                .limit(no);
    }
}
