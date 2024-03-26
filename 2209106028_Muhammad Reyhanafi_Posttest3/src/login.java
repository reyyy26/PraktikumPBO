import java.io.*;

public class login {
    private static String username = "reyy";
    private static String password = "2626";

    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);

    public static boolean authenticate() throws NumberFormatException , IOException {
        System.out.println("===== Login =====");
        System.out.print("Username : ");
        String Input_Username = input.readLine();
        System.out.print("Password : ");
        String Input_Password = input.readLine();

        return username.equals(Input_Username) && password.equals(Input_Password);
    }
}