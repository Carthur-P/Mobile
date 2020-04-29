package pongp1.bit;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionSetup {
    ArrayList<Question> questionArray = new ArrayList<Question>();

    public QuestionSetup() {
        questionArray.add(new Question("Apfel (Apple)", R.drawable.der_apfel, "Der"));
        questionArray.add(new Question("Auto (Car)", R.drawable.das_auto, "Das"));
        questionArray.add(new Question("Baum (Tree)", R.drawable.der_baum, "Der"));
        questionArray.add(new Question("Ente (Duck)", R.drawable.die_ente, "Die"));
        questionArray.add(new Question("Haus (House)", R.drawable.das_haus, "Das"));
        questionArray.add(new Question("Hexe (Witch)", R.drawable.die_hexe, "Die"));
        questionArray.add(new Question("Kuh (Cow)", R.drawable.die_kuh, "Die"));
        questionArray.add(new Question("Milch (Milk)", R.drawable.die_milch, "Die"));
        questionArray.add(new Question("Schaf (Sheep)", R.drawable.das_schaf, "Das"));
        questionArray.add(new Question("Schloss (Castle)", R.drawable.der_schloss, "Der"));
        questionArray.add(new Question("Stuhl (Chair)", R.drawable.der_stuhl, "Der"));
    }

    public ArrayList<Question> getQuestionArray(){
        return questionArray;
    }
}
