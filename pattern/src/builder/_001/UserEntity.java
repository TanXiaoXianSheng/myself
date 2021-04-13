package builder._001;

public class UserEntity {

    private String username;
    private Integer age;
    private String sex;

    public UserEntity(Builder builder) {
        this.username = builder.username;
        this.age = builder.age;
        this.sex = builder.sex;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public final static class Builder {

        private String username;
        private Integer age;
        private String sex;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public UserEntity builder() {
            return new UserEntity(this);
        }
    }
}
