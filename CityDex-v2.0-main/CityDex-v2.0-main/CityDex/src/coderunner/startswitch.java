package coderunner;
import person.user.UserRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;


public class startswitch {

    public static <bool> void main() throws IOException, SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Simba@04");
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from adminprofiles");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        UserRunner q = new UserRunner();
        boolean istrue = true;

        do {
            System.out.println("Enter 1 if you are User (or) 2 if you are Admin  (or) 3 to Exit");
            int profile = Integer.parseInt(br.readLine());
            boolean real = true;

            switch (profile) {
                case 1:
                    do {
                        System.out.println("Enter 1 to Login (or) 2 to Sign Up 3.Exit");
                        int action = Integer.parseInt(br.readLine());
                        switch (action) {
                            case 1 -> {
                                UserRunner.main();
                                UserRunner.login();
                            }
                            case 2 -> {
                                System.out.println("You are trying to signup");
                                UserRunner.main();
                                UserRunner.signup();
                            }
                            case 3 -> real = false;
                        }
                    } while (real);

                    break;

                case 2: {
                    System.out.println("You are Admin...");
                    break;
                }
                case 3: {
                    istrue = false;
                    break;
                }

            }


        } while (istrue);
    }
}


