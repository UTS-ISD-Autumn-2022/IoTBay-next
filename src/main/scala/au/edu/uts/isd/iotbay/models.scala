package au.edu.uts.isd.iotbay.models:

  import org.springframework.jdbc.core.JdbcTemplate
  import org.springframework.stereotype.Component

  import java.sql.{PreparedStatement, ResultSet}
  import scala.beans.BeanProperty
  import java.util.UUID
  import scala.util.Try

  class UserCredential (
    @BeanProperty
    val id: UUID,
    @BeanProperty
    var username: String,
    @BeanProperty
    var passwordHash: String,
    @BeanProperty
    var email: String,
    @BeanProperty
    var firstName: String,
    @BeanProperty
    var lastName: String,
  )

  /*
  @Component
  class QueryManager(val jdbcTemplate: JdbcTemplate):
    def fetchUserById (id: Int): Try[List[UserCredential]] =
      val sqlQuery = "SELECT * FROM user_credentials WHERE id = ?"
      val preparedStatement = (statement: PreparedStatement) => statement.setInt(id)
      val mapData = (resultSet: ResultSet, _) => {
        UUID id = UUID.fromString(resultSet.getString(1))
        return new UserCredential(id, resultSet.getString())
      }
      return Try(jdbcTemplate.query(sqlQuery, preparedStatement, mapData))
  */