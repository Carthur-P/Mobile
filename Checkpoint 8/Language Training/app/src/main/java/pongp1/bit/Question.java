package pongp1.bit;

public class Question {
    String word;
    int imageID;
    String answer;

    public Question(String word, int imageID, String answer){
        this.word = word;
        this.imageID = imageID;
        this.answer = answer;
    }

    public String getQuestion(){
        return word;
    }

    public int getImageID(){
        return imageID;
    }

    public String getAnswer(){
        return answer;
    }
}