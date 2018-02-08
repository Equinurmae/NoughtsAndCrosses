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
    
    Board(){
        this(3,3);
    }
    
    Board(int r, int c){
        rows = r;
        cols = c;
        Player[][] b = new Player[rows][cols];
        next = Player.X;
        for(Player[] i : b) {
            for(Player j : i) {
                j = Player.None;
            } 
        }
    }
    
    Position position(String s) {
        assert(s.length() == 2);
        char r = s.charAt(0);
        char c = s.charAt(1);
        if(!(c >= '1' && c <= '3')) {
            return null;
        }
        int x;
        switch (r){
            case 'a':
                x = 1;
                break;
            case 'b':
                x = 2;
                break;
            case 'c':
                x = 3;
                break;
            default:
                return null;
        }
        Position p = new Position(x, Character.getNumericValue(c));
        return p;
    }
    
    void move(Position p){
        b[p.row()][p.col()] = next;
        next = next.other();
    }
    
    Player winner(){        
        if (cols == rows){
            for(int i = 0; i < rows-2; i++) {
                if(b[i][i]==b[i+1][i+1]){
                    if(i+2 == rows) return b[i][i];
                } else break;
            }
            
            for(int i = rows-1; i > 1; i--) {
                if(b[i][i]==b[i-1][i-1]){
                    if(i-1 == 0) return b[i][i];
                } else break;
            }
        }
        
        for(Player[] row : b){
            for(int i = 0; i< cols - 2; i++){
                if(row[i] == row[i+1]) {
                    if ((i+2) == cols) return row[i];
                } else break;
            }
        }
        
        for(int j = 0; j < cols; j++){
            for(int i = 0; i < rows - 2; i++) {
               if(b[i][j] == b[i+1][j]) {
                   if(i+2 == rows) return b[i][j];
               } else break;
            }
        }
        if(blanks() == null) return Player.Both;
        else return Player.None;
    }
    
    Position[] blanks(){
        ArrayList<Position> empty = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (b[i][j] == Player.None) empty.add(new Position(i,j));
            }
        }
        if(empty.size() == 0) return null;
        else return (Position[])empty.toArray();
    }
    
    public String toString(){
        return null;
    }
    
    Position suggest() {
        return null;
    }
}
