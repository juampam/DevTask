// Projects model
package model;
public class Project{
	private int id;
	private String name;
	private String description;
	private String nom;
	private String owner;
	private User[] users = new User[5];	

	public Project(){
	
	}

	
	/**
	 * Get name.
	 *
	 * @return name as String.
	 */
	public String getName()
	{
	    return name;
	}
	
	/**
	 * Set name.
	 *
	 * @param name the value to set.
	 */
	public void setName(String name)
	{
	    this.name = name;
	}
	
	/**
	 * Get description.
	 *
	 * @return description as String.
	 */
	public String getDescription()
	{
	    return description;
	}
	
	/**
	 * Set description.
	 *
	 * @param description the value to set.
	 */
	public void setDescription(String description)
	{
	    this.description = description;
	}
	
	
	/**
	 * Get nom.
	 *
	 * @return nom as String.
	 */
	public String getNom()
	{
	    return nom;
	}
	
	/**
	 * Set nom.
	 *
	 * @param nom the value to set.
	 */
	public void setNom(String nom)
	{
	    this.nom = nom;
	}
	
	/**
	 * Get owner.
	 *
	 * @return owner as String.
	 */
	public String getOwner()
	{
	    return owner;
	}
	
	/**
	 * Set owner.
	 *
	 * @param owner the value to set.
	 */
	public void setOwner(String owner)
	{
	    this.owner = owner;
	}
	
	/**
	 * Get users.
	 *
	 * @return users as User[].
	 */
	public User[] getUsers()
	{
	    return users;
	}
	
	/**
	 * Get users element at specified index.
	 *
	 * @param index the index.
	 * @return users at index as User.
	 */
	public User getUsers(int index)
	{
	    return users[index];
	}
	
	/**
	 * Set users.
	 *
	 * @param users the value to set.
	 */
	public void setUsers(User[] users)
	{
	    this.users = users;
	}
	
	/**
	 * Set users at the specified index.
	 *
	 * @param users the value to set.
	 * @param index the index.
	 */
	public void setUsers(User users, int index)
	{
	    this.users[index] = users;
	}
	// Methods
	//
	//
		
}
