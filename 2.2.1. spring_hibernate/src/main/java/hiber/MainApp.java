package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        Car car1 =new Car("BMW",318);
        userService.add(user1.setCar(car1).setUser(user1));
        User user2 = new  User("User2", "Lastname2", "user2@mail.ru");
        Car car2 =new Car("Volvo",740);
        userService.add(user2.setCar(car2).setUser(user2));
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        Car car3 =new Car("Mercedes",600);
        userService.add(user3.setCar(car3).setUser(user3));
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        Car car4 =new Car("Газ",21);
        userService.add(user4.setCar(car4).setUser(user4));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user+""+user.getCar());
        }

        System.out.println(userService.getUserByCar("BMW",318));

        context.close();
    }
}
