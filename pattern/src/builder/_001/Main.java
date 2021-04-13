package builder._001;

public class Main {

    public static void main(String[] args) {
        UserEntity user = new UserEntity.Builder()
                .setUsername("张三")
                .setAge(19)
                .setSex("男")
                .builder();
        System.out.println(user);
    }

}
