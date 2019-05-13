package observer;

import model.Sounds;

public class Sound implements ConversionObserver{


    @Override
    public void update(String s) {
        Sounds so = new Sounds();
        so.playSound(s);
    }



}
