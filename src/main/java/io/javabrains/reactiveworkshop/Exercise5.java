package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.intNumbersFluxWithException().subscribe(System.out::println,
//        ReactiveSources.intNumbersFlux().subscribe(System.out::println,
//                System.err::println, () -> System.out.println("Done"));
//        // TODO: Write code here

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here

//        Disposable subscribe = ReactiveSources.intNumbersFlux().subscribe(number -> System.out.println(number),
//                System.err::println, () -> System.out.println("Done"),
//                subscriber -> {
//
//                });


        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("hookOnSubscribe happended");
        request(1);
    }

    public void
    hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(1);
    }
}