package Wrapper.src.com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LazyInvocation {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);

        numbers.stream().filter(n ->{
            System.out.println("filtering" + n);
            return n%2 ==0;
        }).map(n ->{
            System.out.println("mapping" + n);
            return n * n;
        }).limit(2)
                .collect(Collectors.toList());

    }
}
