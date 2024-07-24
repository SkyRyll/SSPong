import processing.core.*;
public class Ball {
    int ballWidth;
    int ballHeight;
    float ballStartX = 650;
    float ballStartY = 350;
    float ballPosX;
    float ballPosY;
    float speedX;
    float speedY;
    float startSpeedX = 2.5F;
    float startSpeedY = 2.5F;

    Ball(int ballWidth, int ballHeight) {
        this.ballPosX = ballStartX;
        this.ballPosY = ballStartY;
        this.ballWidth = ballWidth;
        this.ballHeight = ballHeight;
        this.speedX = startSpeedX;
        this.speedY = startSpeedY;
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
         this.startSpeedX *= -1;
         this.speedX = startSpeedX;
         this.speedY = startSpeedY;

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
        if (playerCollisionX(pl1) && playerCollisionY(pl1)) {
            this.speedX *= -1.1;
        }
        if (playerCollisionX(pl2) && playerCollisionY(pl2)) {
            this.speedX *= -1.1;
        }

    }
    public boolean playerCollisionX (Player pl) {
        if(
            ballPosX < pl.playerX + pl.plWidth + ballWidth/2 &&
            ballPosX + ballWidth > pl.playerX + ballWidth/2
        ) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean playerCollisionY (Player pl) {
        if(
            ballPosY < pl.playerY + pl.plHeight &&
            ballPosY + ballHeight > pl.playerY
        ) {
            return true;
        }
        else {
            return false;
        }
    }
}
