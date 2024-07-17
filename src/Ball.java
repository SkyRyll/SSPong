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
    float startSpeedX = 2;
    float startSpeedY = 2;

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
        if(this.ballPosX <= pl1.playerX + pl1.plWidth/2 || this.ballPosX >= pl2.playerX - pl2.plWidth/2) {
            if((pl1.playerY < this.ballPosY && this.ballPosY < pl1.playerY + pl1.plHeight) ||
            (pl2.playerY < this.ballPosY && this.ballPosY < pl2.playerY + pl2.plHeight)) {
                speedX *= -1.15;
            }
        }

    }
}
