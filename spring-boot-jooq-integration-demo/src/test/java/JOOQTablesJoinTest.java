import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static com.leileiluoluo.jooq.model.generated.Tables.*;

public class JOOQTablesJoinTest {

    public static void main(String[] args) {
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/school";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            DSLContext context = DSL.using(conn, SQLDialect.MYSQL);

            List<Record3<String, String, BigDecimal>> studentCourseScores = context.select(
                            STUDENT.NAME,
                            COURSE.NAME,
                            SCORE.DEGREE
                    ).from(SCORE)
                    .join(STUDENT).on(SCORE.STUDENT_NO.eq(STUDENT.NO))
                    .join(COURSE).on(SCORE.COURSE_NO.eq(COURSE.NO))
                    .fetch();

            studentCourseScores.forEach(record -> {
                String studentName = record.getValue(STUDENT.NAME);
                String courseName = record.getValue(COURSE.NAME);
                BigDecimal degree = record.getValue(SCORE.DEGREE);
                System.out.printf("student: %s, course: %s, degree: %s\n", studentName, courseName, degree);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
