package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().map(e -> e.toString() + ',').forEach(System.out::print);

        System.out.println();
        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(e -> e < 5).forEach(t -> System.out.printf("%s, ", t));

        System.out.println();
        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(e -> e > 5).skip(1).limit(2).forEach(t -> System.out.printf("%s, ", t));

        System.out.println();
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println(StreamSources.intNumbersStream().filter(e -> e > 5).findFirst().orElse(-1));

        // Print first names of all users in userStream
        StreamSources.userStream().map(User::getFirstName).forEach(t -> System.out.printf("%s, ", t));

        System.out.println();
        // Print first names in userStream for users that have IDs from number stream

        StreamSources.intNumbersStream().flatMap(
                id -> StreamSources.userStream().filter(user -> user.getId() == id)
        ).map(User::getFirstName).forEach(t -> System.out.printf("%s, ", t));

        System.out.println();
        StreamSources.userStream().filter(u -> StreamSources.intNumbersStream().anyMatch(i -> i == u.getId()))
                .forEach(u -> System.out.println(u));
    }

}
