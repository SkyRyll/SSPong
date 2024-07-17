public class Player {
    int plWidth = 40;
    int plHeight = 300;
    int x = 0;
    int y = 0;
    int PlayNr = 0;
    int plSpeed = 0;

    public Player(int PlayNr) {
        this.plSpeed = 60;
        switch(PlayNr) {
            case 1:
                this.x = 100;
                this.y = 100;
                break;
            case 2:
                this.x = 1600 - 100 - this.plWidth;
                this.y = 100;
                break;
            default:
                System.out.println("Error.");
                break;
        }
    }
    void moveUp(){
        if (this.y >= this.plWidth){
            this.y -= this.plSpeed;
        }
    }
    void moveDown(){
        if (this.y <= Field.getmFieldHeight() - this.plHeight){
            this.y += this.plSpeed;
        }
    }
//    void moveLeft(){
//        if (this.x >= this.plWidth){
//            this.x -= this.plSpeed;
//        }
//    }
//    void moveRight(){
//        if (this.x <= Field.getmFieldWidth() - this.plWidth){
//            this.x += this.plSpeed;
//        }
//    }
}

