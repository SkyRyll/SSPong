import processing.core.*;
public class Ball {
    int ballWidth;
    int ballHeight;
    int ballSpeed;
    float ballPosX;
    float ballPosY;
    float speedX;
    float speedY;

    Ball(float startX, float startY, int ballWidth, int ballHeight, int ballSpeed) {
        this.ballPosX = startX;
        this.ballPosY = startY;
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

}
