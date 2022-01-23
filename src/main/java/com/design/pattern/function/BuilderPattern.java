package com.design.pattern.function;

import java.util.function.Consumer;

//Cascade pattern or Builder Pattern
public class BuilderPattern {
    public static void main(String[] args) {
        Mailer.send(mailer ->
                mailer.from("suraj.dey")
                        .to("atanu.mondal")
                        .subject("Code review")
                        .body("Please review my code"));
    }

}

class Mailer {
    public Mailer from(String from) {
        System.out.println("Send from : " + from);
        return this;
    }

    public Mailer to(String to) {
        System.out.println("Send to : " + to);
        return this;
    }

    public Mailer subject(String subject) {
        System.out.println("Send subject : " + subject);
        return this;
    }

    public Mailer body(String body) {
        System.out.println("Send body : " + body);
        return this;
    }

    public static void send(Consumer<Mailer> mailer) {
        Mailer mail = new Mailer();
        mailer.accept(mail);
        System.out.println("sending....");

    }

}
