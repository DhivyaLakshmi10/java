import java.lang.*;
import java.util.*;

public class ts3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of users: ");
        Integer noOfUsers = sc.nextInt();
        System.out.println("Enter the number of users per thread: ");
        Integer noOfUsersPerThread = sc.nextInt();
        System.out.println("Enter the user details: ");
        List<String> users = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        sc.nextLine();
        for(int i = 0; i < noOfUsers; i++) {
            users.add(sc.nextLine());
        }
        for(String s : users ){
            User u = new User(s.split(",")[0], s.split(",")[1]);
            userList.add(u);
        }

        Notify(noOfUsers, noOfUsersPerThread, userList);

    }

    public synchronized static void Notify(Integer noOfUsers, Integer noOfUsersPerThread, List<User> userList) {
        for(int i = 0; i < noOfUsers/noOfUsersPerThread; i++)
        {
            UserBO ub = new UserBO(userList.subList(i,i+noOfUsersPerThread));
            ub.start();
        }

    }
}

class User {
    private String username;
    private String mobileNumber;

    public User() {
    }

    public User(String username, String mobileNumber) {
        this.username = username;
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

class UserBO extends Thread {
    public List<User> userList;
    public static List<String> message;

    public UserBO(List<User> userList) {
        this.userList = userList;
        message = new ArrayList<>();
    }

    @Override
    public void run() {
        synchronized (this) {
            for(User u : userList)
            {
                 message.add("The message is sent to the user " + u.getUsername() + " at the mobile number " + u.getMobileNumber());
            }
            for(User s : userList)
            {
                System.out.println("The message is sent to the user " + s.getUsername() + " at the mobile number " + s.getMobileNumber());
            }
        }
    }
}