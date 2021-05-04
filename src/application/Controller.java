package application;


import javafx.scene.shape.Rectangle;

public class Controller {
    //EFFECT: Get numbers and MESH from Tetris class
    public static final int MOVE = Tetris.MOVE;
    public static final int SIZE = Tetris.SIZE;
    public static final int XMAX = Tetris.XMAX;
    public static final int YMAX = Tetris.YMAX;
    public static int [][] MESH = Tetris.MESH;

    // EFFECT: Move the blocks right
    public static void MoveRight (Block block) {
        if (block.a.getX() + MOVE <= XMAX - SIZE && block.b.getX() + MOVE <= XMAX - SIZE
            && block.c.getX() + MOVE <= XMAX - SIZE && block.d.getX() + MOVE <= XMAX - SIZE) {
            int movea = MESH[((int) block.a.getX()/ SIZE) + 1][((int) block.a.getY()/SIZE)];
            int moveb = MESH[((int) block.b.getX()/ SIZE) + 1][((int) block.b.getY()/SIZE)];
            int movec = MESH[((int) block.c.getX()/ SIZE) + 1][((int) block.c.getY()/SIZE)];
            int moved = MESH[((int) block.d.getX()/ SIZE) + 1][((int) block.d.getY()/SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                block.a.setX(block.a.getX() + MOVE);
                block.b.setX(block.b.getX() + MOVE);
                block.c.setX(block.c.getX() + MOVE);
                block.d.setX(block.d.getX() + MOVE);
            }
        }
    }

    // EFFECT: Move the blocks left
    public static void MoveLeft (Block block) {
        if (block.a.getX() - MOVE >= 0 && block.b.getX() - MOVE >= 0
                && block.c.getX() - MOVE <= 0 && block.d.getX() - MOVE >= 0) {
            int movea = MESH[((int) block.a.getX()/ SIZE) - 1][((int) block.a.getY()/SIZE)];
            int moveb = MESH[((int) block.b.getX()/ SIZE) - 1][((int) block.b.getY()/SIZE)];
            int movec = MESH[((int) block.c.getX()/ SIZE) - 1][((int) block.c.getY()/SIZE)];
            int moved = MESH[((int) block.d.getX()/ SIZE) - 1][((int) block.d.getY()/SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                block.a.setX(block.a.getX() - MOVE);
                block.b.setX(block.b.getX() - MOVE);
                block.c.setX(block.c.getX() - MOVE);
                block.d.setX(block.d.getX() - MOVE);
            }
        }
    }

    // Effect: Creates random new pieces in typical tetris forms
    public static Block makeRect() {
        int piece = (int) (Math.random() * 100);
        String name;

        Rectangle a = new Rectangle(SIZE-1, SIZE-1);
        Rectangle b = new Rectangle(SIZE-1, SIZE-1);
        Rectangle c = new Rectangle(SIZE-1, SIZE-1);
        Rectangle d = new Rectangle(SIZE-1, SIZE-1);

        if (piece < 15) {
            a.setX(XMAX/2 - SIZE);
            b.setX(XMAX/2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX/2 + SIZE);
            d.setY(SIZE);
            name = "j";
        } else if (piece < 30) {
            a.setX(XMAX/2 + SIZE);
            b.setX(XMAX/2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX/2);
            c.setY(SIZE);
            d.setX(XMAX/2 + SIZE);
            d.setY(SIZE);
            name = "l";
        } else if (piece < 45) {
            a.setX(XMAX/2 - SIZE);
            b.setX(XMAX/2);
            b.setY(XMAX/2 - SIZE);
            c.setY(SIZE);
            d.setX(XMAX/2);
            d.setY(SIZE);
            name = "o";
        } else if (piece < 60) {
            a.setX(XMAX/2 + SIZE);
            b.setX(XMAX/2);
            c.setX(XMAX/2);
            c.setY(SIZE);
            d.setX(XMAX/2 - SIZE);
            d.setY(SIZE);
            name = "s";
        } else if (piece < 75) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            name = "t";
        } else if (piece < 90) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 + SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE + SIZE);
            d.setY(SIZE);
            name = "z";
        } else {
            a.setX(XMAX / 2 - SIZE - SIZE);
            b.setX(XMAX / 2 - SIZE);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + SIZE);
            name = "i";
        }

        return new Block(a, b, c, d, name);
    }
}
