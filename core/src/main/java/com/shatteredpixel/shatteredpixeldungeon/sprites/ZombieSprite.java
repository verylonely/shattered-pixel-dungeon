package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.MovieClip;
import com.watabou.noosa.TextureFilm;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class ZombieSprite extends MobSprite {

    private ArrayList<Integer> v = new ArrayList<Integer>();
    private Integer y_texture;


    public ZombieSprite(){

        super();

        v.add(0);
        v.add(21);
        v.add(42);
        v.add(63);

        y_texture = Random.element(v);

        texture(Assets.ZOMBIE);

        TextureFilm frame = new TextureFilm(texture, 12,16);

        idle = new Animation(2, true);
        idle.frames(frame, 0+y_texture, 0+y_texture, 1+y_texture, 0+y_texture);

        run = new MovieClip.Animation(12, true);
        run.frames(frame, 2+y_texture, 3+y_texture, 4+y_texture, 5+y_texture, 6+y_texture, 7+y_texture);

        attack = new MovieClip.Animation(15, false);
        attack.frames(frame, 4+y_texture, 7+y_texture);

        die = new MovieClip.Animation(10, false);
        die.frames(frame, 8+y_texture, 9+y_texture, 10+y_texture, 11+y_texture, 12+y_texture);

        play(idle);

    }

}
