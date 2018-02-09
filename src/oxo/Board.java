/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oxo;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Board {
    int rows, cols;
    Player next;
    Player[][] b;
    
    public Board(){
        this(3,3);
    }
    
    public Board(int r, int c){
        rows = r;
        cols = c;
        b = new Player[rows][cols];
        next = Player.X;
        for(int i = 0; i < rows; i++/*Player[] i : b*/) {
            for(int j = 0; j < cols; j++/*Player j : i*/) {
                b[i][j] = Player.None;
            } 
        }
    }
    
    public Position position(String s) {
        assert(s.length() == 2);
        char r = s.charAt(0);
        char c = s.charAt(1);
        if(!(c >= '1' && c <= '3')) {
            return null;
        }
        int x;
        switch (r){
            case 'a':
                x = 0;
                break;
            case 'b':
                x = 1;
                break;
            case 'c':
                x = 2;
                break;
            default:
                return null;
        }
        Position p = new Position(x, Character.getNumericValue(c) - 1);
        return p;
    }
    
    public void move(Position p){
        b[p.row()][p.col()] = next;
        next = next.other();
    }
    
    public Player winner(){        
        if (cols == rows){
            for(int i = 0; i <= rows - 2; i++) {
                
                if(b[i][i] == b[i+1][i+1]){
                    if(i+2 == rows) return b[i][i];
                } 
                else break;
                
            }
            
            for(int i = rows - 1, j = 0; i >= 1; i--, j++) {
                
                if(b[i][j] == b[i-1][j+1]){
                    if(i-1 == 0) return b[i][j];
                } 
                else break;
            }
        }
        
        for(Player[] row : b){
            for(int i = 0; i <= cols - 2; i++){
                
                if(row[i] == row[i+1]) {
                    if ((i+2) == cols) return row[i];
                } 
                else break;
                
            }
        }
        
        for(int j = 0; j < cols; j++){
            
            for(int i = 0; i <= rows - 2; i++) {
               
                if(b[i][j] == b[i+1][j]) {
                   if(i+2 == rows) return b[i][j];
                } 
                else break;
                
            }
        }
        
        if(blanks() == null) return Player.Both;
        else return Player.None;
    }
    
    public Position[] blanks(){
        ArrayList<Position> empty = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (b[i][j] == Player.None) empty.add(new Position(i,j));
            }
        }
        if(empty.size() == 0) return null;
        else return empty.toArray(new Position[0]);
    }
    
    public String toString(){
        String print = "";
        for(Player[] row : b) {
            for(Player column : row) {
                switch (column) {
                    case X:
                        print += "X";
                        break;
                    case O:
                        print += "O";
                        break;
                    default:
                        print += ".";                  
                }              
            }
            print += "\n";
        }
        return print;
    }
    
    public Position suggest() {
        return null;
    }
}
