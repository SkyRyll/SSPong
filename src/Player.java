public class Player {
    int plWidth = 40;
    int plHeight = 200;
    float playerX;
    float playerY;
    int PlayNr;
    int plSpeed;
    int score = 0;

    public Player(int PlayNr) {
        this.plSpeed = 50;
        this.PlayNr = PlayNr;

        switch(PlayNr) {
            case 1:
                this.playerX = 100;
                this.playerY = 100;
                break;
            case 2:
                this.playerX = 1300 - 100 - this.plWidth;
                this.playerY = 100;
                break;
            default:
                System.err.println("Error.");
                break;
        }
    }
    void moveUp() {
        if (this.playerY >= this.plSpeed) {
            this.playerY -= this.plSpeed;
        }
    }

    void moveDown() {
        if (this.playerY <= 700 - this.plHeight - this.plSpeed) {
            this.playerY += this.plSpeed;
        }
    }

    public int getScore() {
        return this.score;
    }


}

