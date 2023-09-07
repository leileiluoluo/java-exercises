import com.leileiluoluo.jooq.model.generated.tables.pojos.Student;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static com.leileiluoluo.jooq.model.generated.Tables.STUDENT;

public class JOOQSimpleQueryTest {

    public static void main(String[] args) {
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/school";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext context = DSL.using(conn, SQLDialect.MYSQL);

            List<Student> students = context.selectFrom(STUDENT)
                    .fetchInto(Student.class);

            students.forEach(student -> {
                System.out.printf("no: %s, name: %s, gender: %s, birthday: %s\n", student.getNo(), student.getName(), student.getGender(), student.getBirthday());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
