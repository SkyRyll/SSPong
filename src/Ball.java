import processing.core.*;
public class Ball {
    int ballWidth;
    int ballHeight;
    int ballSpeed;
    float ballStartX = 650;
    float ballStartY= 350;
    float ballPosX;
    float ballPosY;
    float speedX;
    float speedY;

    Ball(int ballWidth, int ballHeight, int ballSpeed) {
        this.ballPosX = ballStartX;
        this.ballPosY = ballStartY;
        this.ballWidth = ballWidth;
        this.ballHeight = ballHeight;
        this.ballSpeed = ballSpeed;
        this.speedX = ballSpeed;
        this.speedY = ballSpeed;
    }

    public void update() {
        ballPosX += speedX;
        ballPosY += speedY;

        if (ballPosY - ballHeight <= 0 || ballPosY + ballHeight >= 700) {
            speedY *= -1;
        }
        if (ballPosX - ballWidth <= 0 || ballPosX + ballWidth >= 1300) {
            speedX *= -1;
        }

    }

    public void reset() {
         this.ballPosX = ballStartX;
         this.ballPosY = ballStartY;

    }

    public float getBallPosX() {
        return ballPosX;
    }
    public float getBallPosY() {
        return ballPosY;
    }

    public int getBallWidth() {
        return ballWidth;
    }
    public void checkCollision(Player pl1, Player pl2){
        float deltaXSquared1 = (ballPosX - pl1.playerX) * (ballPosX - pl1.playerX);
        float deltaYSquared1 = (ballPosY - pl1.playerY) * (ballPosY - pl1.playerX);
        float distanz1 = (float) Math.sqrt(deltaXSquared1 + deltaYSquared1);

        float deltaXSquared2 = (ballPosX - pl2.playerX) * (ballPosX - pl2.playerX);
        float deltaYSquared2 = (ballPosY - pl2.playerY) * (ballPosY - pl2.playerX);
        float distanz2 = (float) Math.sqrt(deltaXSquared2 + deltaYSquared2);


        if ((distanz1 <= ballWidth/2) || (distanz2 <= ballWidth/2)){
            speedX *= -1;
        }

    }
}
