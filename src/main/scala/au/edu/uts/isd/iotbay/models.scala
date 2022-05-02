package au.edu.uts.isd.iotbay.models:

  import org.springframework.jdbc.core.JdbcTemplate
  import org.springframework.stereotype.Component

  import java.sql.{PreparedStatement, ResultSet}
  import scala.beans.BeanProperty
  import java.util.UUID
  import scala.util.Try

  /*
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
   */

  case class Role(
      id: UUID,
      name: String
  )

  case class UserCredential(
      id: UUID,
      username: String,
      passwordHash: String,
      role: Role,
      email: String,
      firstName: String,
      lastName: String
  )

  // @Component
  // class QueryManager(val jdbcTemplate: JdbcTemplate):
  // def createCustomer ()

  /*
    def fetchUserByUsername (username: String): Try[List[UserCredential]] =
      val sqlQuery = """
SELECT (C.id, C.username, C.password_hash, C.)
  FROM user_credentials AS C
  WHERE C.username = ?
  INNER JOIN roles
  ON user_credentials.role_id = roles.id
    """
      val preparedStatement = (statement: PreparedStatement) => statement.setString(username)
      val mapData = (resultSet: ResultSet, _) => {


        val id = UUID.fromString(resultSet.getString('id'))
        return UserCredential(id, username, )
      }
      return Try(jdbcTemplate.query(sqlQuery, preparedStatement, mapData))
   */
