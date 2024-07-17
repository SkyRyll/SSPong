import processing.core.*;
public class Main extends PApplet {
    Player pl1 = new Player(1);
    Player pl2 = new Player(2);
    int score1 = 0;
    int score2 = 0;
    // Field playingField = new Field(1600, 900);

    public void setup(){

        textSize(25);
        noStroke();
        background(50, 50, 50);
        frameRate(30);

    }
    public void settings() {
        size(1600, 900);
    }
    public void draw(){

        background(50, 50, 50);
        drawPlayer(pl1);
        drawPlayer(pl2);

        text(str(score1), 10, 25);
        text(str(score2), 10, 25);

    }
    public void keyPressed() {
        if (key == 'w')pl1.moveUp();
        if (key == 's')pl1.moveDown();
//        if (key == 'a')pl1.moveLeft();
//        if (key == 'd')pl1.moveRight();
        if (keyCode == UP)pl2.moveUp();
        if (keyCode == DOWN)pl2.moveDown();
//        if (keyCode == LEFT)pl2.moveLeft();
//        if (keyCode == RIGHT)pl2.moveRight();

    }
    public void drawPlayer(Player pl) {
        fill(255);
        rect(pl.x, pl.y, pl. plWidth, pl.plHeight);
    }
    public static void main(String... args){
        PApplet.main("Main");
    }
}