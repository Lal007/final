package les1;

public class Person {
    private final String firsName;
    private final String lastName;
    private final String middleName;
    private final String country;
    private final String address;
    private final String phone;
    private final int age;
    private final String gender;

    private Person(PersonBuilder personBuilder) {
        this.firsName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
        this.middleName = personBuilder.middleName;
        this.country = personBuilder.country;
        this.address = personBuilder.address;
        this.phone = personBuilder.phone;
        this.age = personBuilder.age;
        this.gender = personBuilder.gender;
    }

    public static class PersonBuilder {
        private final String firstName;
        private final String phone;

        private String lastName = "";
        private String middleName = "";
        private String country = "";
        private String address = "";
        private int age = 0;
        private String gender ="";

        public PersonBuilder(String firstName, String phone) {
            this.firstName = firstName;
            this.phone = phone;
        }

        public PersonBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
