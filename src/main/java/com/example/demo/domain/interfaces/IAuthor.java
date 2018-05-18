package com.example.demo.domain.interfaces;

/**
 * This interface encapsulates Author object
 * @author Sohrab Azami Ghadim
 * @version 1.0
 * @since 2018-05-12
 *
 */
public interface IAuthor {
	/**
	 * This method return an author with
	 * @return : returns id of the author
	 */
	int getId();
	String getName();
	String getDateOfBirth();
}
