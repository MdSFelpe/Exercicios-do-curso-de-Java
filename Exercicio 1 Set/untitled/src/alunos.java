import java.util.Objects;

public class alunos {
    private Integer username;

    public alunos(Integer username) {
        this.username = username;
    }

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        alunos alunos = (alunos) o;
        return Objects.equals(username, alunos.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

}
