package com.shatteredpixel.shatteredpixeldungeon.ui;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.Image;

public enum Icons_Gloomy {

    GPD;

    public Image get() { return get(this);}

    public static Image get( Icons_Gloomy type)
    {
        Image icon = new Image(Assets.ICONS_GLOOMY);

        switch (type){
            case GPD:
                icon.frame( icon.texture.uvRect(0,0, 16, 16) );
        }

        return icon;
    }

}
