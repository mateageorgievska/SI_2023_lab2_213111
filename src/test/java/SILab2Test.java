import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class SILab2Test {


    @Test
    void everyBranchTesting() {
        //exception - test case 1
        RuntimeException exception;
        exception = assertThrows(RuntimeException.class, ()-> SILab2.function(null, null));
        assertTrue(exception.getMessage().contains("Mandatory information missing!"));

        //test case 2
        User newUser1  = new User(null, "user r","user0@gmail.com"); //original user
        User user0 = new User("username0", "user r", "user0@gmail.com");
        User user1 = new User("username1", "P@ss","user1@gmail.com");

        List<User> list1 = new ArrayList<>();
        list1.add(user0);
        list1.add(user1);

        assertFalse(SILab2.function(newUser1, list1));

        // test case 3
        User newUser2 = new User("username0", "P@ss word!", "user0gmail");
        User user2 = new User("username0", "user r", "user0@gmail.com");
        User user3 = new User("username1", "P@ss", "user1@gmail.com");

        List<User> list2 = new ArrayList<>();
        list2.add(user2);
        list2.add(user3);

        assertFalse(SILab2.function(newUser2, list2));

        //test case 4

        User newUser3 = new User("username", "Pаssword1", "user@gmail.com");
        User user4 = new User("username", "user@", "user0@gmail.com");
        User user5 = new User("username1", "P@ss", "user1@gmail.com");

        List<User> list3 = new ArrayList<>();
        list3.add(user4);
        list3.add(user5);

        assertFalse(SILab2.function(newUser3, list3));
        //test case 5

        User newUser4 = new User("username", "P@ssword!", "user@gmail.com");
        User user6 = new User("username0", "user@", "user0@gmail.com");
        User user7 = new User("username1", "P@ss", "user1@gmail.com");

        List<User> list4 = new ArrayList<>();
        list4.add(user6);
        list4.add(user7);

        assertTrue(SILab2.function(newUser4,list4));
    }

    @Test
    void multipleConditionTestingFunction() {
        User existingUser = new User("username1", "P@ss", "user1@gmail.com");
        List<User> users = new ArrayList<>();
        users.add(existingUser);

        //TXX - combination
        RuntimeException exception;
        exception = assertThrows(RuntimeException.class, ()-> SILab2.function(null, null));
        assertTrue(exception.getMessage().contains("Mandatory information missing!"));

        //FTX
        exception = assertThrows(RuntimeException.class, ()-> SILab2.function(new User("username", null, "user@gmail.com"), users));
        assertTrue(exception.getMessage().contains("Mandatory information missing!"));

        //FFT
        exception = assertThrows(RuntimeException.class, ()-> SILab2.function(new User("username", "P@ssword!", null), users));
        assertTrue(exception.getMessage().contains("Mandatory information missing!"));

        //FFF
        assertTrue(SILab2.function(new User("username", "P@ssword!", "user@gmail.com"), users));

    }
}
