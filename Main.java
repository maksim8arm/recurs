package com.company;

public class Main {

    static char matrix10[][] = new char[10][10];

    public static void main(String[] args) {
        matrix();

    }


    String find_path(field, int x0, int y0) {
        String path[][] = new String[10][10];
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                path[i][j] = "нет";
            }
        }
        int x = x0;
        int y = y0;

        while (x != 0 && y != 0) {
            char direction = where_from(field, x, y);
            if (direction == 'N') {
                return "Нет такого пути";
            } else if (direction == 'U') {
                path[x][y] = "да";
                y -= 1;
            } else if (direction == 'L') {
                path[x][y] = "да";
                x -= 1;
            }
            for (int y = 0; y < 10; y++) {
                for (int x = 0; y < 10; x++) {
                    if (x == x0 && y == y0) {
                        печатаем 'Ч'
                    } else if (path[x][y]) {
                        печатаем 'x'
                    } else {
                        печатаем field[ x][y]
                    }
                }
            }
        }
    }

    where_from(String field[][], int x, int y, char memory[][]) {
        if (memory[x][y] != '?') {
            return memory[x][y];
        }
        if (x > 0) {
            int left_x = x - 1;
            int left_y = y;
        }
        if ( int left_x ==0 && int left_y ==0){
            memory[x][y] = 'L';
            return 'L';
        }
        if (field[left_x][left_y] != '*') {
            if (where_from(field, left_x, left_y, memory) != 'N') {
                memory[x][y] = 'L';
                return 'L';
            }
        }
        if (y > 0) {
            int up_x = x;
            int up_y = y - 1;
            if (up_x == 0 && up_y == 0) {
                memory[x][y] = 'U';
                return 'U';
                if (field[up_x][up_y] != '*') {
                    if (where_from(field, up_x, up_y, memory) != 'N') {
                        memory[x][y] = 'U';
                        return 'U';

                    }

                }

            }

        }
        memory[x][y] = 'N';
        return 'N';
    }


    //
    public static void matrix() {
        for (int i = 0; i < matrix10.length; i++) {
            for (int j = 0; j < matrix10.length; j++) {
                matrix10[i][j] = '-';
            }
        }
        matrix10[0][0] = 'Щ';
        matrix10[0][3] = '*';
        matrix10[0][4] = '*';
        matrix10[1][4] = '*';
        matrix10[1][6] = '*';
        matrix10[1][7] = '*';
        matrix10[2][3] = '*';
        matrix10[2][5] = '*';
        matrix10[2][9] = '*';
        matrix10[3][1] = '*';
        matrix10[3][8] = 'Ч';
        matrix10[4][6] = '*';
        matrix10[5][2] = '*';
        matrix10[5][5] = '*';
        matrix10[6][3] = '*';
        matrix10[6][6] = '*';
        matrix10[6][7] = '*';
        matrix10[6][8] = '*';
        matrix10[7][7] = '*';
        matrix10[8][7] = '*';
        matrix10[9][6] = '*';
        matrix10[9][5] = '*';
        for (int i = 0; i < matrix10.length; i++) {
            for (int j = 0; j < matrix10.length; j++) {
                System.out.print(matrix10[i][j] + " ");
            }
            System.out.println();
        }
    }
}
