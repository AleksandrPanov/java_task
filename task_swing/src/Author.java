import java.util.Objects;

public class Author {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;

    public Author(String firstName, String lastName, String email, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + firstName + " " + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return (Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName + lastName);
    }
}