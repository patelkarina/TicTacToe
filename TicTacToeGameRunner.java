/*
 * 
 * Directions for students: Look for comments that guide you,
 * but you will still need to think.
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
import info.gridworld.world.World;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

/**
 * The <code>TicTacToeGameRunner</code> is the main application that
 * allows you to play the game of TicTacToe.
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 * <p> 
 * copyright&copy; 2007 Dave Wittry (http://apcomputerscience.com)
 * @author Dave Wittry
 * 
 * @author Susan King 2010 July 5 Changed WuZiQi to TicTacToe
 * 
 * @author Karina Patel  
 * @version July 20, 2014
 */
public class TicTacToeGameRunner extends World<ColorTextPiece>
{
    private boolean isXTurn;
    private boolean winner;

    /**
     * Construct a TicTacToe Game
     */
    public TicTacToeGameRunner() 
    {
        isXTurn = true;
        winner = false;
        makeBoard();
        setMessage("Tic Tac Toe - X Goes First");
    }

    /**
     * Initializes the board to white, empty tiles.
     */
    private void makeBoard() 
    {
        setGrid( new BoundedGrid<ColorTextPiece>(3, 3) ); // gameboard size
        for (int r = 0; r < getGrid().getNumRows(); r++)
        {
            for (int c = 0; c < getGrid().getNumCols(); c++)
            {
                add(new Location(r, c), new ColorTextPiece(""));
                    /*
                     * Students, write nested for loops to set the text for all the tiles to an
                     * empty string and add them to the World/Grid.
                     */
            }
        }
    }

    /**
     * Determines if there is a winner. 
     * 
     * @param loc loacation of the last piece just played
     * @return true     if the piece just played at position <code>loc</code> completes
     *                  completes a win for the player who just move; otherwise
     *         false   
     */
    private boolean determineWinner(Location loc) 
    {
        // only need to check if 3 in a row from the current loc (last move made)
        int dir = Location.AHEAD, consecutive = 0;
        Location nextLoc;
        Grid<ColorTextPiece> gr = getGrid();
        
        /*
         * Students: There are 8 ways to check for 3-in-a-row in Tic-Tac-Toe.
         */
        for (int line = 0; line < 4; line++)
        {
            consecutive = 1;
            for (int i = 0; i < 2; i++)
            {   nextLoc = loc.getAdjacentLocation(dir);
                while (gr.isValid(nextLoc) && gr.get(loc).equals(gr.get(nextLoc)))
                {
                    consecutive++;
                    nextLoc = nextLoc.getAdjacentLocation(dir);
                }
                dir += Location.HALF_CIRCLE;
            }
            if (consecutive == 3)
            { return true;
            }
            dir += Location.HALF_RIGHT;
        }
        return false;
    }
    
                   
    /**
     * When the current player clicks and attempts to place a piece, this method
     * see whether it is a legal move and, if so, places a piece and calls determineWinner.
     * It switches whose turn it is.
     * 
     * @param loc location passed from the GUI where the use just clicked
     * @return <code>true</code> 
     */
    public boolean locationClicked(Location loc)
    {
        if ( winner )
            return true; 
        if ( getGrid().get(loc).isBackground() ) // player making a legal move
        {
            if ( isXTurn ) 
            {
                add(loc, new ColorTextPiece("X"));
                setMessage("O's Turn - X moved to " + loc);
            }
            else
            {
                add(loc, new ColorTextPiece("O"));
                setMessage("X's Turn - O moved to " + loc);
            }
            if ( determineWinner(loc) ) 
            {
                winner = true;
                if ( isXTurn )
                    setMessage("X WINS");
                else
                    setMessage("O WINS");
            }
            isXTurn = !isXTurn;
        }
        else // player making an illegal move
        {
            if ( isXTurn )
                setMessage("Occupied Cell - X, it's still your turn");
            else
                setMessage("Occupied Cell - O, it's still your turn");
        }
        return true;      
    }

    /**
     * Initializes and starts the TicTacToe game.
     * 
     * @param args   the list of information that may be passed from
     *               command line
     */
    public static void main(String[] args)
    {
        World ttt = new TicTacToeGameRunner();

        // get rid of focus indicator on the GUI
        System.setProperty("info.gridworld.gui.selection", "hide"); 
        ttt.show();
    }
}