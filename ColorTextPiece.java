/*
 * 
 * Directions for students:
 * 
 * If a method contains "*** complete this method ***" on the first line, complete
 * it where the comments direct you. Otherwise, the methods are already complete.
 */

/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board 
 * (http://www.collegeboard.com).
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
import java.awt.Color;

/**
 * A <code>ColorTextPiece</code> is the game piece placed in the Grid.
 * <p>
 * copyright&copy; 2007 Dave Wittry (http://apcomputerscience.com)
 * @author Dave Wittry
 * 
 * @author Susan King 2010 July 5  Added equals( ) and isBackGround( ) 
 *                                 based upon Dave Wittry's GamePiece
 *  
 * @author Karina Patel 
 * @version July 20, 2014
 */
public class ColorTextPiece
{
    private String text;
    private Color color;

    /**
     * Constructs a white game piece with a String.
     * 
     * @param str a String to be displayed for this piece
     */    
    public ColorTextPiece(String str) 
    { 
        this.text = str; 
        this.color = Color.BLUE;  // *** change this method for fun ***
    }

    /**
     * Retrieves the text for this piece.
     * 
     * @return text for this piece
     */    
    public String getText() 
    { 
        return text;    // *** complete this method ***
    }

    /**
     * Retrieves the color of this piece.
     * 
     * @return the color of this piece
     */    
    public Color getColor()
    {
        return color;      // *** complete this method ***
    }

    /**
     * Gets whether or not this piece is being used as 
     * an "empty" background cell for the GUI.  An "empty"
     * cell has text that is an empty String.
     * 
     * @return true if piece is being used as an "empty" 
     *              background cell for the GUI; otherwise,
     *         false
     */    
    public boolean isBackground() 
    { 
        if (text.equals(""))
        {
            return true;
        }
        return false;    // *** complete this method ***
    }

    /**
     * Determines if the text for one tile is the same 
     * as for the input parameter's tile.
     * 
     * @param obj  the ColorTextPiece object to which this piece's
     *             text is compared for equality
     * 
     * @return true if texts of both tiles are the same; otherwiser, 
     *         false
     */
    public boolean equals( Object obj)
    {
        return getText().equals(((ColorTextPiece)obj).getText()); 
           // *** complete this method ***
    }

    /**
     * Retrieves text information about this piece.
     * 
     * @return text of this piece.
     */
    public String toString() 
    {
        return getText();    // *** complete this method ***
    }
}