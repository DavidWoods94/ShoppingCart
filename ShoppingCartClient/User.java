package ShoppingCartClient;

/**
 *
 * @author Group 31
 */
public abstract class User
{
    private final String username;
    private final String password;

    /**
     * Creates a new user
     * @param aName username 
     * @param pass password
     */
    public User(String aName, String pass)
    {
        username = aName;
        password = pass;
    }
    /**
     * Gives the username
     * @return username
     */
    public String getUsername()
    {
        return username;
    }
    /**
     * Gives the password
     * @return password
     */
    public String getPassword()
    {
        return password;
    }
    public abstract int getNewID();
}
