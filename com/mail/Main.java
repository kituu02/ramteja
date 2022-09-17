package com.mail;

import com.mail.Home;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Main {
    static Scanner sc=new Scanner(System.in);

    static Stream<User> stream=Stream.of(
            new User("Sahil","sahil@gmail.com","abc123"),
            new User("soumya","soumya@gmail.com","gfh123"),
            new User("Ram","ram@gmail.com","ram123")

    );

    static Map<String,String> Inbox=new HashMap<>();

    static Map<String,String> Drafts=new HashMap<>();

    static Map<String,ArrayList<String>> Outbox=new HashMap<>();


    static boolean validEmail(String email)
    {
        if(userMap.containsKey(email))
        {
            return false;
        }
        return true;
    }
    static Map<String, User> userMap=stream.collect(Collectors.toMap(User::getEmail, Function.identity()));

    static int subject_id=1;

    static Map<String,String> composeDetails=new HashMap<>();
    private static void signUp()
    {
        System.out.println("Enter emailID");
        String em= sc.next();


        boolean flag=validEmail(em);
        while(true) {
            if (flag) {


                System.out.println("Enter your name: ");
                String un = sc.next();
                System.out.println("Set password");
                String pwd = sc.next();
                User user = new User(un, em, pwd);
                userMap.put(em, user);
                System.out.println("Account created successfully");
                break;
            } else {
                System.out.println("EMail exists. Enter new mail");
                em = sc.next();
                flag = validEmail(em);

            }
        }



    }

    public static void main(String[] args) {

        System.out.println("Welcome to Gmail");
        while(true)
        {
            System.out.println("Enter your choice");
            System.out.println("1.Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            int choice=sc.nextInt();
            switch (choice)
            {
                case 1 -> {
                    signUp();

                }

                case 2 -> {
                    signIn();
                }

                default -> System.exit(0);
            }
        }

    }

    private static void signIn() {
        System.out.println("Enter email: ");
        String email=sc.next();
        System.out.println("Enter password: ");
        String pwd=sc.next();
        validUSer(email,pwd);

    }

    private static void validUSer(String email,String pwd)
    {
        if(userMap.containsKey(email))
        {
            User user=userMap.get(email);
            if(Objects.equals(user.getPwd(), pwd))
            {

              homePage.features(user);

            }else{

                System.out.println("Invalid password");

            }
        }else {
            System.out.println("Invalid username");
        }


    }

    static class homePage{


        public static void features(User user) {

            while(true)
            {


                System.out.println("1. Compose mail");
                System.out.println("2. Inbox");
                System.out.println("3. Outbox");
                System.out.println("4. Draft");
                System.out.println("5. sign out");
                System.out.println("Enter choice");
                int ch=sc.nextInt();
                switch (ch)
                {
                    case 1 -> {
                        composeMail(user);
                    }

                    case 2 ->{
                        checkInbox(user);
                    }

                    case 3 ->{
                        checkOutbox(user);
                    }

                    case 4 ->{
                        checkDrafts(user);
                    }

                    case 5 -> System.exit(0);
                }

            }
        }

        private static void checkDrafts(User user) {
        }

        private static void checkOutbox(User user) {

        }

        private static void checkInbox(User user) {
        }

        private static void composeMail(User user) {


            System.out.println("Enter receiver mail: ");
            String rm=sc.next();

            while (true) {
                if (userMap.containsKey(rm)) {

                    {
                        System.out.println("Enter subject: ");
                        String sub = sc.next();
                        System.out.println("Enter the message: ");
                        String msg = sc.next();
                        System.out.println("1.Send mail");
                        System.out.println("2.Save as Draft");
                        System.out.println("3. Exit");
                        int choice = sc.nextInt();
                        String details=rm+"\n"+sub+"\n"+msg;
                        switch (choice) {
                            case 1 -> {

                                composeDetails.put(user.email, details);
                                System.out.println("Mail sent successfully");



                            }
                            case 2 -> {
                                Drafts.put(user.email, details);
                                System.out.println("Saved draft");
                            }
                            default -> System.exit(0);
                        }

                    }

                } else {
                    System.out.println("Receiver mail doesnt exist");
                    break;

                }
            }


        }
    }

    static class SenderDetails
    {
        String receiverMail;
        String subject;
        String message;
        String SenderMail;

        public SenderDetails(String receiverMail, String subject, String message, String senderMail) {
            this.receiverMail = receiverMail;
            this.subject = subject;
            this.message = message;
            SenderMail = senderMail;
        }
    }


}


