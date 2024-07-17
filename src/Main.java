import processing.core.*;
public class Main extends PApplet {
    Player pl1 = new Player(1);
    Player pl2 = new Player(2);

    Ball ball = new Ball(35, 35);

    public static void main(String... args) {
        PApplet.main("Main");
    }

    float t = 0.0F;
    float speed = 0.005F;

    int score1 = 0;
    int score2 = 0;
    // Field playingField = new Field(1600, 900);

    public void setup() {

        textSize(40);
        noStroke();
        background(50, 50, 50);
        frameRate(120);

    }

    public void settings() {
        size(1300, 700);
    }

    public void draw() {

        background(50, 50, 50);
        drawPlayer(pl1);
        drawPlayer(pl2);
        drawBall(ball);
        ball.update();
        ball.checkCollision(pl1, pl2);

        fill(255);
        textAlign(LEFT);
        text(str(pl1.getScore()), 20, 45);
        textAlign(RIGHT);
        text(str(pl2.getScore()), 1300 - 20, 45);

        checkGoal();
    }

    public void keyPressed() {
        if (key == 'w') pl1.moveUp();
        if (key == 's') pl1.moveDown();
//        if (key == 'a')pl1.moveLeft();
//        if (key == 'd')pl1.moveRight();
        if (keyCode == UP) pl2.moveUp();
        if (keyCode == DOWN) pl2.moveDown();
//        if (keyCode == LEFT)pl2.moveLeft();
//        if (keyCode == RIGHT)pl2.moveRight();

    }

    public void drawPlayer(Player pl) {
        // Calculate color values using sine functions
        float playerc1 = (float) (127.5 + 127.5 * sin(t));
        float playerc2 = (float) (127.5 + 127.5 * sin(t + TWO_PI / 3));
        float playerc3 = (float) (127.5 + 127.5 * sin(t + 2 * TWO_PI / 3));

        fill(playerc1, playerc2, playerc3);

        // Increment the time variable
        t += speed;

        strokeWeight(2);
        stroke(255);
        rect(pl.playerX, pl.playerY, pl.plWidth, pl.plHeight);
    }

    public void drawBall(Ball ball) {
        fill(ball.getBallPosX() / 5, 50, ball.getBallPosY() / 3);
        strokeWeight(2);
        stroke(255);
        ellipse(ball.ballPosX, ball.ballPosY, ball.ballWidth, ball.ballHeight);
    }

    public void checkGoal() {
        if (ball.getBallPosX() <= 0 + ball.getBallWidth()) {
            scoreGoal(pl2);
        }
        if (ball.getBallPosX() >= 1300 - ball.getBallWidth()) {
            scoreGoal(pl1);
        }
    }

    public void scoreGoal(Player pl) {
        pl.score++;
        System.out.println("Player " + pl.PlayNr + " scores!");
        ball.reset();
    }
}