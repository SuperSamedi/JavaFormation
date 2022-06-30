package com.digitalcity.bases.heroes_and_monsters.advanced;


public class Board {
        private static Tile[][] board;
        private int monsterNumber = 10;

        public Board(int rows, int columns ){
                board = new Tile[rows][columns];
        }

        public static Tile[][] getBoard(){
                return board;
        }

        public void fill(){
                for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board[i].length; j++) {
                                board[i][j] = new Tile();
                        }
                }
        }

        public void generateMonsters(){
                for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board[i].length; j++) {
                                if (board[i+2][j].getContent() != null
                                        || board[i][j+2].getContent() != null
                                        || board[i+1][j+1].getContent() != null
                                        || board[i-1][j-1].getContent() != null
                                        || board[i-2][j].getContent() != null
                                        || board[i][j-2].getContent() != null){

                                        switch(Dice.roll(2)) {
                                                case 1 -> {}
//                                                case 2 -> board[i][j].setContent(Monster.getRandomMonster());
                                        }
                                }
                        }
                }
        }

        public static void displayState(){
                for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board[i].length; j++) {
                                if (j == board.length - 1){
                                        System.out.println(board[i][j]);
                                }
                                else{
                                        System.out.print(board[i][j]);
                                }
                        }
                }
        }

        public static void updateTileContent(ITileContent content, int x, int y){
                board[y][x].setContent(content);
        }


}

