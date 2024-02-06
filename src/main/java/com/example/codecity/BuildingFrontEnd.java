    package com.example.codecityjavafx;

    import javafx.scene.paint.Color;

    /**
     * Class handling the attributes of the front-end graphical representations of the classes
     */

    public class BuildingFrontEnd  {
        private final int x;
        private final int y;
        private final Color color;
        private final int height;

        /**
         *  Class constructor
         * @param x X-position of building on canvas
         * @param y Y-position of building on canvas
         * @param c Color to draw building
         * @param height Height of building
         */

        public BuildingFrontEnd(int x, int y, Color c, int height) {
            this.x = x;
            this.y = y;
            this.color = c;
            this.height = height;
        }

        /**
         *
         * @return X position of building on screen
         */

        public int getX() {return x;}
        /**
         *
         * @return Y position of building on screen
         */
        public int getY() {return y;}
        /**
         *
         * @return Color of building on screen
         */
        public Color getColor() {return color;}
        /**
         *
         * @return Height of building on screen
         */

        public int getHeight() {return height;}
    }
